/*
 * Copyright (C) 2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.display;

import static android.provider.Settings.System.MIN_REFRESH_RATE;
import static android.provider.Settings.System.PEAK_REFRESH_RATE;

import android.content.Context;
import android.provider.Settings;
import android.view.Display;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

import java.util.ArrayList;
import java.util.List;

public class MinRefreshRatePreferenceController extends BasePreferenceController implements
        Preference.OnPreferenceChangeListener {

    private static final String KEY_MIN_REFRESH_RATE = "min_refresh_rate";

    private ListPreference mListPreference;

    public MinRefreshRatePreferenceController(Context context) {
        super(context, KEY_MIN_REFRESH_RATE);
    }

    @Override
    public int getAvailabilityStatus() {
        return mContext.getResources().getBoolean(R.bool.config_show_min_refresh_rate_switch) &&
                mListPreference != null && mListPreference.getEntries().length > 1
                        ? AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_MIN_REFRESH_RATE;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        mListPreference = screen.findPreference(getPreferenceKey());

        List<String> entries = new ArrayList<>(), values = new ArrayList<>();
        Display.Mode mode = mContext.getDisplay().getMode();
        Display.Mode[] modes = mContext.getDisplay().getSupportedModes();
        for (Display.Mode m : modes) {
            if (m.getPhysicalWidth() == mode.getPhysicalWidth() &&
                    m.getPhysicalHeight() == mode.getPhysicalHeight()) {
                      entries.add(String.format("%dHz", Math.round(m.getRefreshRate())));
		      values.add(String.format("%d", Math.round(m.getRefreshRate())));
            }
        }
        mListPreference.setEntries(entries.toArray(new String[entries.size()]));
        mListPreference.setEntryValues(values.toArray(new String[values.size()]));

        super.displayPreference(screen);
    }

    @Override
    public void updateState(Preference preference) {
        final int defaultRefreshRate = (int) mContext.getResources().getInteger(
					 com.android.internal.R.integer.config_defaultRefreshRate);
        final int currentValue = Settings.System.getInt(mContext.getContentResolver(),
				   MIN_REFRESH_RATE, defaultRefreshRate);
        int index = mListPreference.findIndexOfValue(Integer.toString(currentValue));
        if (index < 0) index = 0;
        mListPreference.setValueIndex(index);
        mListPreference.setSummary(mListPreference.getEntries()[index]);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
          int newRefreshRate = Integer.valueOf((String) newValue);
	    Settings.System.putInt(mContext.getContentResolver(), MIN_REFRESH_RATE, newRefreshRate);
	    Settings.System.putInt(mContext.getContentResolver(), PEAK_REFRESH_RATE, newRefreshRate);
	    updateState(preference);
        return true;
    }
}
