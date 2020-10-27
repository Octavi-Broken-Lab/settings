package com.octavi.lab;

import android.content.Context;
import com.android.internal.logging.nano.MetricsProto;
import android.util.AttributeSet;

import androidx.preference.Preference;
import android.provider.Settings;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.SettingsPreferenceFragment;

import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;

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

        RangeSeekBar rangeSeekBar = holder.itemView.findViewById(R.id.range);
        rangeSeekBar.setProgress(Settings.Global.getInt(context.getContentResolver(), "GLOBAL_ACTIONS_MAX_COLUMNS", 0));

        rangeSeekBar.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {

            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {
                Settings.Global.putInt(context.getContentResolver(), "GLOBAL_ACTIONS_MAX_COLUMNS", (int) view.getLeftSeekBar().getProgress());
            }
        });
    }
}

