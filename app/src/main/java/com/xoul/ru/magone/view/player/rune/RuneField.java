package com.xoul.ru.magone.view.player.rune;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

public class RuneField extends LinearLayout implements View.OnClickListener {
    private OnRuneClickedListener listener;

    public RuneField(Context context) {
        super(context);
        initViews(context);
    }

    public RuneField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        for (Rune.RuneStyle runeStyle : Rune.RuneStyle.values()) {
            Rune rune = new Rune(context);
            rune.setStyle(runeStyle);
            rune.setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
            rune.setOnClickListener(this);
            addView(rune);
        }
    }

    public void setOnRuneClickedListener(OnRuneClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        Rune rune = (Rune) v;
        if (listener != null) {
            listener.onRuneClicked(rune.getStyle());
        }
    }

    public interface OnRuneClickedListener {
        void onRuneClicked(Rune.RuneStyle runeStyle);
    }
}
