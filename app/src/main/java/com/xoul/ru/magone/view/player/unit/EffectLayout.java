package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

public class EffectLayout extends LinearLayout {
    private Context context;
    private LayoutParams params;

    public EffectLayout(Context context) {
        super(context);
        this.context = context;
        init(context);
    }

    public EffectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
    }

    private void init(Context context) {
        setOrientation(HORIZONTAL);
        params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        initEffects(context);
    }

    private void initEffects(Context context) {
        List<com.xoul.ru.magone.model.Effect> effects = new LinkedList<>();
    }

    public void setEffects(List<com.xoul.ru.magone.model.Effect> effects) {
        removeAllViews();
        for (com.xoul.ru.magone.model.Effect effect : effects) {
            int index = effect.type.ordinal();
            Effect effectView = new Effect(context, Effect.EffectType.values()[index], effect.getTimeleft());
            addView(effectView, params);
        }
    }
}
