package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class Unit extends RelativeLayout {
    protected static final int HP_BAR_HEIGHT_DP = 25;

    protected UnitImage unitImage;
    protected HealthBar healthBar;

    public Unit(Context context) {
        super(context);
        initSubViews(context);
    }

    public Unit(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSubViews(context);
    }

    protected void initSubViews(Context context) {
        unitImage = new UnitImage(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(unitImage, params);

        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, HP_BAR_HEIGHT_DP, getResources().getDisplayMetrics());
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        params.addRule(ALIGN_PARENT_BOTTOM);
        healthBar = new HealthBar(context);
        addView(healthBar, params);
    }

    public int getHp() {
        return healthBar.getValue();
    }

    public int getMaxHp() {
        return healthBar.getMaxValue();
    }

    public void setHp(int hp) {
        healthBar.setValue(hp);
    }

    public void setMaxHp(int hp) {
        healthBar.setMaxValue(hp);
    }
}
