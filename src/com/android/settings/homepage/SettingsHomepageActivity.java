/*
 * Copyright (C) 2018 The Android Open Source Project
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

package com.android.settings.homepage;

import android.content.Intent;
import android.os.Bundle;
import com.android.settings.R;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import android.provider.Settings;

public class SettingsHomepageActivity extends FragmentActivity {

    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //setContentView(R.layout.activity_start);

        int icon_pos = Settings.System.getInt(getApplicationContext().getContentResolver(), Settings.System.ICON_LEFT_ENABLED, 0);

        if (icon_pos == 0) {
            startActivity(new Intent(SettingsHomepageActivity.this, SettingsHomepageOctaviActivity.class));
            finish();
        } else if (icon_pos == 1) {
            startActivity(new Intent(SettingsHomepageActivity.this, SettingsHomepageOOSActivity.class));
            finish();
        }
    }
}
