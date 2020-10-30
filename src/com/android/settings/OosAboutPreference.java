package com.android.settings;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.airbnb.lottie.LottieAnimationView;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class OosAboutPreference extends Preference {

    Context context;
    StatFs statFs;

    public OosAboutPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setLayoutResource(R.layout.oos_about);
    }

    public  String getSystemProperty(String key) {
        String value = null;

        try {
            value = (String) Class.forName("android.os.SystemProperties")
                    .getMethod("get", String.class).invoke(null, key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    private  void setInfo(String prop, TextView textview) {
        if (TextUtils.isEmpty(getSystemProperty(prop))) {
            textview.setText("Unknown");
	} else {
            if (prop.equals("ro.octavi.maintainer")) {
	        String str = getSystemProperty(prop);
		if (str.contains("_"))
                    str = str.replace("_", " ");
		textview.setText(str);
	    }
            textview.setText(getSystemProperty(prop));
        }
    }

    private  void setInfo(String prop, String prop2, TextView textview) {
        if (TextUtils.isEmpty(getSystemProperty(prop)) && TextUtils.isEmpty(getSystemProperty(prop2))) {
            textview.setText("Unknown");
	} else {
            textview.setText(String.format("v%s %s", getSystemProperty(prop), getSystemProperty(prop2)));
        }
    }

    private  Map<String, String> getMemInfoMap() {
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

    private  Map<String, String> getCpuInfoMap() {
        Map<String, String> map = new HashMap<>();
        try {
            Scanner s = new Scanner(new File("/proc/cpuinfo"));
            while (s.hasNextLine()) {
                String[] vals = s.nextLine().split(": ");
                if (vals.length > 1)
                    map.put(vals[0].trim(), vals[1].trim());
            }
        } catch (Exception e) {
            Log.e("getCpuInfoMap", Log.getStackTraceString(e));
        }
        return map;
    }

    private String getHwName(String soc) {

        Map<String, String> map = new HashMap<>();
        map.put("msm8952", "617");
        map.put("msm8953", "625");
        map.put("msm8953 pro", "626");
        map.put("msm8956", "650");
        map.put("msm8976", "652");
        map.put("msm8956 pro", "653");
        map.put("sm6125", "665");
        map.put("sm6150", "675");
        map.put("sm6350", "690");
        map.put("msm8992", "808");
        map.put("msm8994", "810");
        map.put("msm8996", "820");
        map.put("msm8998", "835");
        map.put("sm8150", "855");
        map.put("sm8150-AC", "855+");
        map.put("sm8250", "865");
        map.put("sm8250-AC", "865+");

        if (map.containsKey(soc)) {
            for (String key : map.keySet()) {
                if (key.equals(soc))
                    return map.get(soc);
            }
        } else if (soc.startsWith("sdm"))
            return soc.substring(3);
        return "Unknown";
    }
    private String getCpuName() {
        int cores;
        String string = "";
        if (getCpuInfoMap().containsKey("Hardware"))
            if (getCpuInfoMap().containsKey("processor")) {
                cores = Integer.parseInt(getCpuInfoMap().get("processor")) + 1;
                switch (cores) {
                    case 2:
                        string = "Dual Core";
                        break;
                    case 4:
                        string = "Quad Core";
                        break;
                    case 8:
                        string = "Octa Core";
                        break;
                    case 10:
                        string = "Deca Core";
                        break;
                    default:
                        string = string + cores;
                        break;
                }
                return String.format(Locale.ENGLISH, "Qualcomm Snapdragon%s %s\n%s processor", context.getString(R.string.trademark), getHwName(getSystemProperty("ro.board.platform").toLowerCase()), string);
            } else
                return getCpuInfoMap().get("Hardware");
        else {
            if (getCpuInfoMap().containsKey("model name"))
                return getCpuInfoMap().get("model name");
        }
        return "Unknown";
    }

    private String getMem() {
        if (getMemInfoMap().containsKey("MemTotal")) {
            String s = getMemInfoMap().get("MemTotal");
            return s.split(" ")[0];
        }
        return "Unknown";
    }

    private void doMagic(ImageView deviceIcon, LottieAnimationView lottie, LinearLayout details, TextView textDare) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new LinearInterpolator());
        fadeIn.setDuration(1500);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new LinearInterpolator());
        fadeOut.setDuration(1500);

        deviceIcon.setOnClickListener(view -> {
            deviceIcon.setClickable(false);
            details.startAnimation(fadeOut);
            details.setVisibility(View.GONE);
            deviceIcon.startAnimation(fadeOut);
            deviceIcon.setVisibility(View.GONE);
            lottie.playAnimation();
            lottie.setVisibility(View.VISIBLE);
            lottie.startAnimation(fadeIn);
            textDare.setVisibility(View.VISIBLE);
            textDare.startAnimation(fadeIn);
            new Handler().postDelayed(() -> {
                lottie.startAnimation(fadeOut);
                lottie.setVisibility(View.GONE);
                textDare.startAnimation(fadeOut);
                textDare.setVisibility(View.GONE);
                lottie.cancelAnimation();

                details.setVisibility(View.VISIBLE);
                details.startAnimation(fadeIn);
                deviceIcon.setVisibility(View.VISIBLE);
                deviceIcon.startAnimation(fadeIn);
                deviceIcon.setClickable(true);
            }, 3000);
        });
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        final boolean selectable = false;

	statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());

        holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);

        ImageView deviceIcon = holder.itemView.findViewById(R.id.device_icon);
        TextView deviceProc = holder.itemView.findViewById(R.id.device_procc_model);
        TextView octStage = holder.itemView.findViewById(R.id.octavi_stage);
        TextView octMaintainer = holder.itemView.findViewById(R.id.octavi_maintainer);
        TextView deviceStorage = holder.itemView.findViewById(R.id.device_storage);

        LottieAnimationView lottie = holder.itemView.findViewById(R.id.lottie);
        LinearLayout details = holder.itemView.findViewById(R.id.details);
        TextView textDare = holder.itemView.findViewById(R.id.textDare);

        setInfo("ro.octavi.status", "ro.octavi.branding.version", octStage);
        setInfo("ro.octavi.maintainer", octMaintainer);

	int total = 0;
	double totalInt = (statFs.getBlockSizeLong() * statFs.getBlockCountLong() / Math.pow(1024, 3));
        deviceProc.setText(String.format(Locale.ENGLISH, "%s", getCpuName()));
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

        deviceStorage.setText(String.format(Locale.ENGLISH, "%dGB RAM + %dGB ROM", Math.round(Float.parseFloat(getMem()) / Math.pow(1000, 2)), total));
        deviceProc.setText(String.format(Locale.ENGLISH, "%s", getCpuName()));

        doMagic(deviceIcon, lottie, details, textDare);

	String sq = getSystemProperty("ro.octavi.branding.version");
	if (sq.equals("OFFICIAL") || sq.equals("Official")){
        switch (getSystemProperty("ro.product.device").toLowerCase()) {
            case "x00td":
                deviceIcon.setImageResource(R.drawable.ic_device_x00td);
                break;
            case "violet":
                deviceIcon.setImageResource(R.drawable.ic_device_violet);
                break;
            case "tulip":
                deviceIcon.setImageResource(R.drawable.ic_device_tulip);
                break;
            case "rmx1921":
                deviceIcon.setImageResource(R.drawable.ic_device_rmx1921);
                break;
            case "rmx1901":
                deviceIcon.setImageResource(R.drawable.ic_device_rmx1901);
                break;
            case "rmx1801":
                deviceIcon.setImageResource(R.drawable.ic_device_rmx1801);
                break;
            case "mido":
                deviceIcon.setImageResource(R.drawable.ic_device_mido);
                break;
            case "phoenix":
                deviceIcon.setImageResource(R.drawable.ic_device_phoenix);
                break;
            case "sanders":
                deviceIcon.setImageResource(R.drawable.ic_device_sanders);
                break;
            case "tissot":
                deviceIcon.setImageResource(R.drawable.ic_device_tissot);
                break;
	    case "ginkgo":
		deviceIcon.setImageResource(R.drawable.ic_device_ginkgo);
		break;
            case "whyred":
                deviceIcon.setImageResource(R.drawable.ic_device_whyred);
                break;
            case "vince":
                deviceIcon.setImageResource(R.drawable.ic_device_vince);
                break;
            case "raphael":
                deviceIcon.setImageResource(R.drawable.ic_device_raphael);
                break;
           case "raphaelin":
                deviceIcon.setImageResource(R.drawable.ic_device_raphael);
                break;
            case "beryllium":
                deviceIcon.setImageResource(R.drawable.ic_device_beryllium);
                break;
            case "davinci":
		deviceIcon.setImageResource(R.drawable.ic_device_davinci);
		break;
	    case "davinciin":
                deviceIcon.setImageResource(R.drawable.ic_device_davinci);
                break;
            case "surya":
                deviceIcon.setImageResource(R.drawable.ic_device_surya);
                break;
	    case "miatoll":
                deviceIcon.setImageResource(R.drawable.ic_device_miatoll);
                break;
	    case "ysl":
                deviceIcon.setImageResource(R.drawable.ic_device_ysl);
                break;
	    case "sakura":
                deviceIcon.setImageResource(R.drawable.ic_device_sakura);
		break;
            default:
		deviceIcon.setImageResource(R.drawable.ic_default_device);
                break;
        }
	} else deviceIcon.setImageResource(R.drawable.ic_default_device);

        holder.setDividerAllowedAbove(false);
        holder.setDividerAllowedBelow(false);
    }
}
