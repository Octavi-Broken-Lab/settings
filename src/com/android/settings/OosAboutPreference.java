package com.android.settings;

import android.os.Build;
import android.os.SystemProperties;
import com.android.settingslib.DeviceInfoUtils;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.android.settings.PhoneData;

import androidx.core.content.ContextCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class OosAboutPreference extends Preference implements View.OnTouchListener {

    Context context;
    List<AboutPhoneData> data = PhoneData.getData();

    public OosAboutPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutResource(R.layout.oos_about);
        this.context = context;
    }

    public OosAboutPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayoutResource(R.layout.oos_about);
        this.context = context;
    }

    public OosAboutPreference(Context context) {
        super(context);
        setLayoutResource(R.layout.oos_about);
        this.context = context;
    }

    private static int findIndex(
            String name) {

        for (AboutPhoneData phoneData : PhoneData.data) {
            if (phoneData.getCodename().equals(name)) {
                return phoneData.getIndex();
            }
        }
        return 0;
    }

    public static void setInfo(String prop, TextView textview) {
        if (TextUtils.isEmpty(SystemProperties.get(prop))) {
            textview.setText("Unknown");
        } else {

            textview.setText(SystemProperties.get(prop));
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        final double totalInt = (statFs.getBlockSizeLong() * statFs.getBlockCountLong() / Math.pow(1024, 3));
        int total = 0;
        if (totalInt > 0 && totalInt < 17)
            total = 16;
        else if (totalInt > 16 && totalInt < 33)
            total = 32;
        else if (totalInt > 32 && totalInt < 65)
            total = 64;
        else if (totalInt > 64 && totalInt < 129)
            total = 128;
        else if (totalInt > 128 && totalInt < 257)
            total = 256;
        else if (totalInt > 256 && totalInt < 513)
            total = 512;

        View root = holder.itemView;
        int index = findIndex(SystemProperties.get("ro.product.device").toLowerCase());

        TextView display = null, cpu = null, battery = null, soc = null, cam = null, img = null,
                device, deviceSec, octaviVer, octaviStatus,
                kernel, maintainer, rom;

        View octaviLogo, leftMini, rightMini;

        leftMini = root.findViewById(R.id.leftFinalDetail);
        rightMini = root.findViewById(R.id.righFinalDetail);
        octaviLogo = root.findViewById(R.id.octaviLogo);
        rom = root.findViewById(R.id.rom_about);
        device = root.findViewById(R.id.device_name);
        deviceSec = root.findViewById(R.id.security_update);
        kernel = root.findViewById(R.id.kernel_version);
        maintainer = root.findViewById(R.id.octavi_maintainer);
        octaviVer = root.findViewById(R.id.octaviVer);
	octaviStatus = root.findViewById(R.id.octaviStatus);

        TextView[] var = {display, cpu, battery, soc, cam, img};
        int[] ids = {R.id.display_about, R.id.cpu_about, R.id.battery_about, R.id.soc_about, R.id.camera_about, R.id.device_about};
        final String[] texts = {
                data.get(index).getDisplay(), data.get(index).getCpu(),
                data.get(index).getBattery(), data.get(index).getSoc(),
                data.get(index).getCamera(), String.valueOf(data.get(index).getImg()),
        };

        for (int i = 0; i < var.length; i++) {
            var[i] = root.findViewById(ids[i]);
            if (var[i]!=null && texts[i]!=null && var[i].getId() == R.id.device_about && !texts[i].equals("0")) {
                var[i].setBackground(ContextCompat.getDrawable(context, Integer.parseInt(texts[i])));
            } else {
                if (var[i].getId() == R.id.camera_about && texts[i].length() > 16)
                    var[i].setTextSize(12);
                if (!texts[i].equals("0"))
                    var[i].setText(texts[i]);
		else var[i].setText(texts[0]);
            }
        }

	octaviStatus.setText(String.format(" OctaviOS %s", SystemProperties.get("ro.octavi.branding.version")));
        setInfo("ro.octavi.status", octaviVer);
        setInfo("ro.octavi.maintainer", maintainer);
        deviceSec.setText(DeviceInfoUtils.getSecurityPatch());
        kernel.setText(DeviceInfoUtils.getFormattedKernelVersion(context));
	device.setText(Build.MODEL);

        if (index != 0)
            rom.setText(String.format(Locale.ENGLISH, "%dGB RAM + %dGB ROM", Math.round(Float.parseFloat(getMem()) / Math.pow(1000, 2)), total));
        else rom.setText(texts[0]);

        leftMini.setOnTouchListener(this);
        rightMini.setOnTouchListener(this);

        logoFading(octaviLogo);
    }

    private String getMem() {
        if (getMemInfoMap().containsKey("MemTotal")) {
            String s = getMemInfoMap().get("MemTotal");
            return s.split(" ")[0];
        }
        return "Unknown";
    }

    private Map<String, String> getMemInfoMap() {
        Map<String, String> map = new HashMap<>();
        try {
            Scanner s = new Scanner(new File("/proc/meminfo"));
            while (s.hasNextLine()) {
                String[] vals = s.nextLine().split(": ");
                if (vals.length > 1)
                    map.put(vals[0].trim(), vals[1].trim());
            }
        } catch (Exception e) {
            Log.e("getMemInfoMap", Log.getStackTraceString(e));
        }
        return map;
    }

    private void logoFading(View octaviLogo) {
        AlphaAnimation animation2 = new AlphaAnimation(0f, 1f);
        animation2.setDuration(1500);
        animation2.setInterpolator(new LinearInterpolator());

        AlphaAnimation animation = new AlphaAnimation(1f, 0f);
        animation.setDuration(1500);
        animation.setInterpolator(new LinearInterpolator());

        octaviLogo.setVisibility(View.VISIBLE);
        octaviLogo.startAnimation(animation2);

        new Handler().postDelayed(() -> {
            octaviLogo.startAnimation(animation);
            octaviLogo.setVisibility(View.GONE);
        }, 3000);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            v.animate().scaleX(.97f).setDuration(300).start();
            v.animate().scaleY(.97f).setDuration(300).start();
            return true;
        } else if (action == MotionEvent.ACTION_UP) {
            v.animate().cancel();
            v.animate().scaleX(1f).setDuration(500).start();
            v.animate().scaleY(1f).setDuration(500).start();
            return true;
        }
        return false;
    }
}
