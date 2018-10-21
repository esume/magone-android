package com.xoul.ru.magone.view.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xoul.ru.magone.view.player.control.CastButton;
import com.xoul.ru.magone.view.player.control.TextLabel;

public class BackButton extends RelativeLayout implements View.OnClickListener {
    private static final String TEXT = "BACK";
    private static final int MARGIN_DP = 5;

    private LayoutParams params;

    private TextLabel textLabel;
    private CastButton background;
    private OnClickListener listener;

    public BackButton(Context context) {
        super(context);
        init(context);
    }

    public BackButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textLabel = new TextLabel(context);
        textLabel.setText(TEXT);
        background = new CastButton(context);
        background.setOnClickListener(this);
        addView(background, params);
        int margin = Utils.dpPx(context, MARGIN_DP);
        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(margin, margin, margin, margin);
        addView(textLabel, params);
    }

    @Override
    public void onClick(View v) {
        performClick();
    }
}
