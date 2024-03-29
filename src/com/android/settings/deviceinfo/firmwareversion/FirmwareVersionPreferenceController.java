/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.android.settings.deviceinfo.firmwareversion;

import com.android.settingslib.Utils;
import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.android.settings.core.BasePreferenceController;

public class FirmwareVersionPreferenceController extends BasePreferenceController {

    Context context;

    public FirmwareVersionPreferenceController(Context context, String key) {
        super(context, key);
	this.context=context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
	String s = Build.VERSION.RELEASE_OR_CODENAME;
	Spannable spannable = new SpannableStringBuilder(s);
        spannable.setSpan(new ForegroundColorSpan(Utils.getColorAttrDefaultColor(context, android.R.attr.colorAccent)), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}
