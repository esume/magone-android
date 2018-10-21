package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;

public class ClearButton extends NextTurn {
    private static final String CLEAR = "✘";
    private static final String QUESTION = "?";
    private boolean question;

    public ClearButton(Context context) {
        super(context);
        init();
    }

    public ClearButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        text = QUESTION;
    }

    public boolean isQuestion() {
        return question;
    }

    public void setQuestion(boolean question) {
        this.question = question;
        if (question) {
            text = QUESTION;
        } else {
            text = CLEAR;
        }
        invalidate();
    }
}
