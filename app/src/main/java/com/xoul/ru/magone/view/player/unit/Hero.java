package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.xoul.ru.magone.model.Effect;
import com.xoul.ru.magone.view.other.Utils;

import java.util.List;

public class Hero extends Unit {
    protected EffectField effects;

    private LayoutParams params;

    public Hero(Context context) {
        super(context);
        initSubViews(context);
        init(context);
    }

    public Hero(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSubViews(context);
        init(context);
    }

    private void init(Context context) {
        effects = new EffectField(context);
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.dpPx(context, HP_BAR_HEIGHT_DP));
        addView(effects, params);
        effects.setVisibility(INVISIBLE);
    }

    public void setEffects(List<Effect> effects) {
        if (effects == null || effects.size() < 1) {
            this.effects.setVisibility(INVISIBLE);
        } else {
            this.effects.setVisibility(VISIBLE);
            this.effects.setEffects(effects);
        }
    }
}
