package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xoul.ru.magone.R;
import com.xoul.ru.magone.view.other.Utils;
import com.xoul.ru.magone.view.player.rune.Rune;

import java.util.List;

public class CastSpellButton extends RelativeLayout {
    private static final int MARGIN_DP = 5;
    private CastButton background;
    private CastButtonLayout button;

    private LayoutParams params;

    private String chooseUnitString;
    private String castString;

    public CastSpellButton(Context context) {
        super(context);
        init(context);
    }

    public CastSpellButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        chooseUnitString = context.getString(R.string.choose_unit);
        castString = context.getString(R.string.cast);
        int margin = Utils.dpPx(context, MARGIN_DP);
        background = new CastButton(context);
        button = new CastButtonLayout(context);
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(background, params);
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(margin, margin, margin, margin);
        addView(button, params);
        clear();
    }

    public void addRune(Rune.RuneStyle style) {
        button.addRune(style);
    }

    public void clear() {
        button.clear();
        button.setText(castString);
        background.setAlwaysPressed(false);
    }

    public List<Rune.RuneStyle> getRunes() {
        return button.getRunes();
    }

    public void setChooseUnit() {
        button.setText(chooseUnitString);
        button.setSpellFieldVisible(true);
        background.setAlwaysPressed(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return background.onTouchEvent(event);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        background.setOnClickListener(l);
    }
}
