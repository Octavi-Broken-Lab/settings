package com.android.settings;
import com.android.settings.R;

public enum CustomAnimation {
    FADE_IN_UP(R.anim.fade_in_up),;

    private int animId;

    CustomAnimation(int animId) {
        this.animId = animId;
    }

    public int getAnimId() {
        return this.animId;
    }
}
