package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.player.rune.Rune;

import java.util.List;

public class CastButtonLayout extends LinearLayout {
    private LayoutParams params;
    private TextLabel textLabel;
    private SpellField spellField;

    public CastButtonLayout(Context context) {
        super(context);
        initLayout(context);
    }

    public CastButtonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    private void initLayout(Context context) {
        setOrientation(VERTICAL);
        spellField = new SpellField(context);
        textLabel = new TextLabel(context);
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.weight = 0.5f;
    }

    public void addRune(Rune.RuneStyle style) {
        spellField.addRune(style);
        spellField.setVisibility(VISIBLE);
    }

    public List<Rune.RuneStyle> getRunes() {
        return spellField.getRunes();
    }

    public void clear() {
        spellField.clear();
        spellField.setVisibility(GONE);
    }

    public void setText(String text) {
        textLabel.setText(text);
    }

    public void setSpellFieldVisible(boolean visible) {
        if (visible) {
            spellField.setVisibility(VISIBLE);
        } else {
            spellField.setVisibility(GONE);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        removeAllViews();
        addView(textLabel, params);
        addView(spellField, params);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
