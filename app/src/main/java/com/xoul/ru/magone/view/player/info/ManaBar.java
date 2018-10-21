package com.xoul.ru.magone.view.player.info;

import android.content.Context;
import android.util.AttributeSet;

import com.xoul.ru.magone.view.other.ValueProgressBar;

public class ManaBar extends ValueProgressBar {

    public ManaBar(Context context) {
        super(context);
    }

    public ManaBar(Context context, int mp, int maxMp) {
        super(context, mp, maxMp);
    }

    public ManaBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
