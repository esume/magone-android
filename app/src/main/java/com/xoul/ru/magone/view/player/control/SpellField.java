package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.other.Utils;
import com.xoul.ru.magone.view.player.rune.Rune;

import java.util.LinkedList;
import java.util.List;

public class SpellField extends LinearLayout {
    private static final int MARGIN_DP = 5;
    private List<SpellRune> runes;
    private LayoutParams params;

    public SpellField(Context context) {
        super(context);
        init();
    }

    public SpellField(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = Utils.dpPx(getContext(), MARGIN_DP);
        params.setMargins(margin / 2, 0, margin / 2, 0);

        runes = new LinkedList<>();
    }

    public void addRune(Rune.RuneStyle style) {
        SpellRune rune = new SpellRune(getContext(), style);
        runes.add(rune);
        addView(rune, params);
    }

    public List<Rune.RuneStyle> getRunes() {
        List<Rune.RuneStyle> runes = new LinkedList<>();
        for (SpellRune rune : this.runes) {
            runes.add(rune.getStyle());
        }
        return runes;
    }

    public void clear() {
        runes.clear();
        removeAllViews();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        int min = (h < w) ? h : w; // min(h, w);
        params.width = min;
        params.height = min;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
