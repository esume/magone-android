package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.xoul.ru.magone.view.other.Utils;
import com.xoul.ru.magone.view.player.rune.Rune;

import java.util.List;

public class ControlField extends RelativeLayout implements View.OnClickListener {
    private LayoutParams params;
    private ClearButton clearButton;
    private CastSpellButton castSpellButton;
    private NextTurn nextTurn;

    private OnControlClickedListener listener;

    public ControlField(Context context) {
        super(context);
        initViews(context);
    }

    public ControlField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        params = new LayoutParams(Utils.dpPx(context, 50), Utils.dpPx(context, 50));
        params.addRule(ALIGN_PARENT_LEFT);
        clearButton = new ClearButton(context);
        clearButton.setOnClickListener(this);
        addView(clearButton, params);
        params = new LayoutParams(Utils.dpPx(context, 175), Utils.dpPx(context, 50));
        params.addRule(CENTER_IN_PARENT);
        castSpellButton = new CastSpellButton(context);
        castSpellButton.setOnClickListener(this);
        addView(castSpellButton, params);
        params = new LayoutParams(Utils.dpPx(context, 50), Utils.dpPx(context, 50));
        params.addRule(ALIGN_PARENT_RIGHT);
        nextTurn = new NextTurn(context);
        nextTurn.setOnClickListener(this);
        addView(nextTurn, params);
    }

    public void setOnControlClickedListener(OnControlClickedListener listener) {
        this.listener = listener;
    }

    public void addRune(Rune.RuneStyle style) {
        castSpellButton.addRune(style);
        clearButton.setQuestion(false);
    }

    public List<Rune.RuneStyle> getRunes() {
        return castSpellButton.getRunes();
    }

    public void setChooseUnit() {
        castSpellButton.setChooseUnit();
    }

    public void clear() {
        castSpellButton.clear();
        clearButton.setQuestion(true);
    }

    public void setNextTurnVisible(boolean visible) {
        nextTurn.setVisibility(visible ? VISIBLE : INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            if (v == nextTurn) {
                listener.onNextTurnClicked();
            } else if (v == clearButton) {
                if (clearButton.isQuestion()) {
                    listener.onHelpClicked();
                } else {
                    clear();
                    listener.onClearClicked();
                }
            } else {
                listener.onCastClicked();
            }
        }
    }

    public interface OnControlClickedListener {
        void onCastClicked();
        void onClearClicked();
        void onHelpClicked();
        void onNextTurnClicked();
    }
}
