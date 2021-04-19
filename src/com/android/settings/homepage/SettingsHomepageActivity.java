
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

import android.animation.LayoutTransition;
import android.app.ActivityManager;
import android.app.settings.SettingsEnums;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.Toolbar;
import android.widget.TextView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;

import androidx.preference.Preference;

import com.android.settings.Sequent;
import com.android.settings.Direction;
import com.android.settings.CustomAnimation;

import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.appbar.AppBarLayout;

import com.android.settings.R;
import com.android.settings.accounts.AvatarViewMixin;
import com.android.settings.core.HideNonSystemOverlayMixin;
import com.android.settings.homepage.contextualcards.ContextualCardsFragment;
import com.android.settings.overlay.FeatureFactory;

import com.android.internal.util.UserIcons;
import com.android.settingslib.drawable.CircleFramedDrawable;
import java.util.ArrayList;

import android.os.UserHandle;
import android.os.UserManager;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

public class SettingsHomepageActivity extends FragmentActivity {

    UserManager mUserManager;
    ImageView avatarView;
    Context context;
    static ArrayList<String> text=new ArrayList<>();
    static {
        text.add("Thanks, for choosing Octavi!");
	text.add("I wonder how many rejections you had");
	text.add("Always remember that you're unique");
        text.add("Constipated people don’t give a crap");
        text.add("Unicorns ARE real, we call them rhinos");
        text.add("If there is a *WILL*, there are 500 relatives");
        text.add("Those who throw dirt only lose ground");
        text.add("I’d like to help you out");
        text.add("Age is a question of mind over matter");
        text.add("I’m an excellent housekeeper");
        text.add("Change is good, but dollars are better");
        text.add("If you cannot convince them, confuse them");
        text.add("This sentence is a lie");
        text.add("Two wrongs don't make a right, for ex. your parents");
        text.add("Stupidity is not a crime so you are free to go.");
        text.add("I'm not insulting you. I'm describing you");
        text.add("You're so fake, Barbie is jealous");
        text.add("There's only one problem with your face, I can see it");
	text.add("If I had a face like yours, I'd sue my parents");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_homepage_container);
        final View root = findViewById(R.id.settings_homepage_container);
        root.setSystemUiVisibility(
               View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

//        setHomepageContainerPaddingTop();
	TextView random = root.findViewById(R.id.random_settings);
        final Toolbar toolbar = root.findViewById(R.id.search_action_bar);
        FeatureFactory.getFactory(this).getSearchFeatureProvider()
                .initSearchToolbar(this /* activity */, toolbar, SettingsEnums.SETTINGS_HOMEPAGE);

	final TextView label = root.findViewById(R.id.settings_label);

	context = getApplicationContext();
	random.setText(text.get(randomNum(0, text.size()-1)));
        mUserManager = context.getSystemService(UserManager.class);
	

	/*Sequent.origin((ViewGroup)root.findViewById(R.id.shit))
                .delay(0)
                .offset(200)
                .anim(context, CustomAnimation.FADE_IN_UP)
                .flow(Direction.FORWARD).start();*/

        avatarView = root.findViewById(R.id.account_avatar_mirror);

        //final AvatarViewMixin avatarViewMixin = new AvatarViewMixin(this, avatarView);
        avatarView.setImageDrawable(getCircularUserIcon(context));
        avatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("com.android.settings","com.android.settings.Settings$UserSettingsActivity"));
                startActivity(intent);
            }
        });
	LinearLayout lin = findViewById(R.id.homepage_container);
        for (int i = 0; i < lin.getChildCount(); i++) {
            if (lin.getChildAt(i) instanceof View) {
                View a = lin.getChildAt(i);
                a.setAlpha(0f);
                ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
                animator.setDuration((long) (500 * (i + 1) * .3));
                animator.setStartDelay((long) (100 * (i + 1) * 1.25));
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.addUpdateListener(animation -> a.setAlpha(((Float) animation.getAnimatedValue())));
                animator.start();
            }
        }

//        final ImageView avatarView = findViewById(R.id.account_avatar);
//        getLifecycle().addObserver(new AvatarViewMixin(this, avatarView));
        getLifecycle().addObserver(new HideNonSystemOverlayMixin(this));
	String name = mUserManager.getUserName();
	label.setText(name!=null?name:"User");
//        if (!getSystemService(ActivityManager.class).isLowRamDevice()) {
            // Only allow contextual feature on high ram devices.
//            showFragment(new ContextualCardsFragment(), R.id.contextual_cards_content);
//        }
        showFragment(new TopLevelSettings(), R.id.main_content);
        ((FrameLayout) findViewById(R.id.main_content))
                .getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

    }

    private void showFragment(Fragment fragment, int id) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        final Fragment showFragment = fragmentManager.findFragmentById(id);

        if (showFragment == null) {
            fragmentTransaction.add(id, fragment);
        } else {
            fragmentTransaction.show(showFragment);
        }
        fragmentTransaction.commit();
    }

    private static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    @VisibleForTesting
    void setHomepageContainerPaddingTop() {
        final View view = this.findViewById(R.id.homepage_container);

        final int searchBarHeight = getResources().getDimensionPixelSize(R.dimen.search_bar_height);
        final int searchBarMargin = getResources().getDimensionPixelSize(R.dimen.search_bar_margin);

        // The top padding is the height of action bar(48dp) + top/bottom margins(16dp)
        final int paddingTop = searchBarHeight + searchBarMargin * 2;

        // Prevent inner RecyclerView gets focus and invokes scrolling.
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    private Drawable getCircularUserIcon(Context context) {
        Bitmap bitmapUserIcon = mUserManager.getUserIcon(UserHandle.myUserId());

        if (bitmapUserIcon == null) {
            // get default user icon.
            final Drawable defaultUserIcon = UserIcons.getDefaultUserIcon(
                    context.getResources(), UserHandle.myUserId(), false);
            bitmapUserIcon = UserIcons.convertToBitmap(defaultUserIcon);
        }
        Drawable drawableUserIcon = new CircleFramedDrawable(bitmapUserIcon,
                (int) context.getResources().getDimension(R.dimen.circle_avatar_size));

        return drawableUserIcon;
    }

    @Override
    public void onResume() {
        super.onResume();
        avatarView.setImageDrawable(getCircularUserIcon(getApplicationContext()));

    }

    private int randomNum(int min , int max) {
	int r = (max - min) + 1;
	return (int)(Math.random() * r) + min;
    }
}
