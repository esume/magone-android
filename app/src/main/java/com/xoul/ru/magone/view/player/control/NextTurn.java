package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.xoul.ru.magone.view.other.Utils;

public class NextTurn extends View {
    protected float borderMultiplier = 1 / 10f;
    protected int borderColor = 0xffe0e0e0;
    protected int color = 0xffffffff;
    protected int textColor = 0xff000000;
    protected float textSize = 70f;

    private Rect outsideRect;
    private Rect insideRect;
    private Rect bounds;
    private Paint paint;

    protected String text;

    public NextTurn(Context context) {
        super(context);
        init();
    }

    public NextTurn(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        text = "➡";
        outsideRect = new Rect();
        insideRect = new Rect();
        bounds = new Rect(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        textSize = h * 8 / 10;
        paint.setTextSize(textSize);
        int border = (w < h) ? w : h; // min(w, h);
        border *= borderMultiplier;
        insideRect.set(border, border, w - border, h - border);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(borderColor);
        canvas.drawRect(outsideRect, paint);
        if (isPressed()) {
            paint.setColor(borderColor);
        } else {
            paint.setColor(color);
        }
        canvas.drawRect(insideRect, paint);
        paint.setColor(textColor);
        makeTextMeasurements();
        canvas.drawText(text, outsideRect.centerX(), outsideRect.centerY() - bounds.centerY(), paint);
    }

    private void makeTextMeasurements() {
        paint.getTextBounds(text, 0, text.length(), bounds);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                setPressed(true);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                if (isPressed()) {
                    performClick();
                }
                setPressed(false);
                break;
            case MotionEvent.ACTION_MOVE:
                if (isPressed() && !outsideRect.contains(x, y)) {
                    setPressed(false);
                }
                break;
        }
        return true;
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        invalidate();
    }
}
