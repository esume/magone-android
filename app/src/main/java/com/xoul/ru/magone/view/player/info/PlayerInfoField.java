package com.xoul.ru.magone.view.player.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.other.Utils;

public class PlayerInfoField extends LinearLayout {
    private static final int MANA_BAR_HEIGHT_DP = 25;
    private LayoutParams params;

    private ManaBar manaBar;

    public PlayerInfoField(Context context) {
        super(context);
        initViews(context);
    }

    public PlayerInfoField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        manaBar = new ManaBar(context, 6, 10);

        int height = Utils.dpPx(context, MANA_BAR_HEIGHT_DP);
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        addView(manaBar, params);
    }

    public int getMp() {
        return manaBar.getValue();
    }

    public void setMp(int mp) {
        manaBar.setValue(mp);
    }

    public int getMaxMp() {
        return manaBar.getMaxValue();
    }

    public void setMaxMp(int maxMp) {
        manaBar.setMaxValue(maxMp);
    }
}
