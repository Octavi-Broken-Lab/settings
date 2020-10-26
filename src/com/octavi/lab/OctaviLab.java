/*
 * Copyright (C) 2016 The Pure Nexus Project
 * used for Nitrogen OS
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

package com.octavi.lab;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settingslib.Utils;
import com.android.settings.R;

import com.airbnb.lottie.LottieAnimationView;
import nl.joery.animatedbottombar.AnimatedBottomBar;

import com.octavi.lab.fragments.StatusBarSettings;
import com.octavi.lab.fragments.LockScreenSettings;
import com.octavi.lab.fragments.ButtonSettings;
import com.octavi.lab.fragments.SystemSettings;
import com.octavi.lab.fragments.MiscSettings;

public class OctaviLab extends SettingsPreferenceFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.octavi_lab, container, false);

        Context context = getActivity();
        Resources res = getResources();

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.lottieWelcome);
        TextView textView = view.findViewById(R.id.welcomeTextview);

        AnimatedBottomBar animatedBottomBar = view.findViewById(R.id.animatedBottomBar);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new LinearInterpolator());
        fadeIn.setDuration(500);

        Window win = getActivity().getWindow();

        win.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        win.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        win.setNavigationBarColor(Utils.getColorAttrDefaultColor(context, android.R.attr.colorAccent));

        ActionBar actionBar = getActivity().getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Octavi Lab");
        }

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new LinearInterpolator());
        fadeOut.setDuration(1000);

        Fragment system = new SystemSettings();
        Fragment lockscreen = new LockScreenSettings();
        Fragment buttons = new ButtonSettings();
        Fragment statusbar = new StatusBarSettings();
        Fragment misc = new MiscSettings();

        Fragment fragment = (Fragment) getFragmentManager().findFragmentById(R.id.child_view_oct);
        if (fragment == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.child_view_oct, system);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        doMagic(lottieAnimationView, textView, fadeIn, fadeOut);

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NonNull AnimatedBottomBar.Tab tab1) {
                switch (i1) {
		    default:
                    case 0:
                        launchFragment(system);
                        break;
                    case 1:
                        launchFragment(lockscreen);
                        break;
                    case 2:
                        launchFragment(buttons);
                        break;
                    case 3:
                        launchFragment(statusbar);
                        break;
                    case 4:
                        launchFragment(misc);
                        break;
                }
            }

            @Override
            public void onTabReselected(int i, @NonNull AnimatedBottomBar.Tab tab) {

            }
        });
      return view;
    }

    private void doMagic(LottieAnimationView lottieAnimationView, TextView textView, Animation fadeIn, Animation fadeOut) {
        new Handler().postDelayed(() -> {
            lottieAnimationView.playAnimation();
            lottieAnimationView.setVisibility(View.VISIBLE);
            lottieAnimationView.startAnimation(fadeIn);

            textView.setVisibility(View.VISIBLE);
            textView.startAnimation(fadeIn);
        }, 250);

        new Handler().postDelayed(() -> {
            lottieAnimationView.startAnimation(fadeOut);
            lottieAnimationView.setVisibility(View.GONE);

            textView.startAnimation(fadeOut);
            textView.setVisibility(View.GONE);
            lottieAnimationView.cancelAnimation();
        }, 2500);
    }

    private void launchFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.child_view_oct, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.OCTAVI;
    }
}
