package com.octavi.lab;

import android.content.ContentResolver;
import android.content.Context;
import com.android.internal.logging.nano.MetricsProto;
import android.util.AttributeSet;

import androidx.preference.Preference;
import android.provider.Settings;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.SettingsPreferenceFragment;

import hearsilent.discreteslider.DiscreteSlider;
import com.android.settings.R;

public class SeekbarPreference extends Preference  {
    Context context;

    public SeekbarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setLayoutResource(R.layout.das);
    }

    public SeekbarPreference(Context context) {
        super(context);
        this.context = context;
        setLayoutResource(R.layout.das);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        final boolean selectable = false;

	holder.itemView.setFocusable(selectable);
        holder.itemView.setClickable(selectable);
	if (context==null)
	context = getContext();
	ContentResolver cr = context.getContentResolver();
	DiscreteSlider slider = holder.itemView.findViewById(R.id.discreteSlider);

        switch (getKey().toLowerCase()) {
            case "global_actions_max_columns":
		slider.setProgressOffset(3);
	        slider.setCount(8);
		slider.setProgress(3);
                break;
	    case "network_traffic_autohide_threshold":
	    default:
                slider.setProgressOffset(0);
		slider.setCount(10);
                break;
        }

	slider.setProgress(Settings.System.getInt(cr, getKey(), (int) slider.getMinProgress()));

        slider.setOnValueChangedListener(new DiscreteSlider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int progress, boolean fromUser) {
		Settings.System.putInt(cr, getKey(), progress);
            }
        });
    }
}

