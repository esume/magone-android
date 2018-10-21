package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xoul.ru.magone.model.Effect;

import java.util.List;

public class EffectField extends RelativeLayout {
    protected float borderMultiplier = 1 / 10f;

    private LayoutParams params;
    private LayoutParams paramsBackground;
    private Rect insideRect;

    private EffectBackground background;
    private EffectLayout effectLayout;

    public EffectField(Context context) {
        super(context);
        init(context);
    }

    public EffectField(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(CENTER_IN_PARENT);
        paramsBackground = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        insideRect = new Rect();
        background = new EffectBackground(context);
        effectLayout = new EffectLayout(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int border = (w < h) ? w : h; // min(w, h);
        border *= borderMultiplier;
        insideRect.set(border, border, w - border, h - border);
        params.width = w - 2 * border;
        params.height = h - 2 * border;
        initViews();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initViews() {
        removeAllViews();
        addView(background, paramsBackground);
        addView(effectLayout, params);
    }

    public void setEffects(List<Effect> effects) {
        effectLayout.setEffects(effects);
    }
}
