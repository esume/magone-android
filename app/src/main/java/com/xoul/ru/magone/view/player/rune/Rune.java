package com.xoul.ru.magone.view.player.rune;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.xoul.ru.magone.R;

public class Rune extends View {
    private static final float BORDER_MULTIPLIER = 1 / 10f;
    private Paint paint;
    private RuneStyle style;

    private float x;
    private float y;
    private float radius;
    private float insideRadius;

    public Rune(Context context) {
        super(context);
        style = RuneStyle.values()[0];
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Rune(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Rune, 0, 0);
        int runeIndex = typedArray.getInteger(R.styleable.Rune_type, 0);
        style = RuneStyle.values()[runeIndex];
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public void setStyle(RuneStyle style) {
        this.style = style;
    }

    public RuneStyle getStyle() {
        return style;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        x = w / 2f;
        y = h / 2f;
        radius = (h < w) ? h : w; // min(h, w);
        radius /= 2f;
        insideRadius = radius - 2 * radius * BORDER_MULTIPLIER;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(style.getBorderColor());
        canvas.drawCircle(x, y, radius, paint);
        if (isPressed()) {
            paint.setColor(style.getPressedColor());
        } else {
            paint.setColor(style.getColor());
        }
        canvas.drawCircle(x, y, insideRadius, paint);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        invalidate();
    }

    private boolean isInsideCircle(float x, float y) {
        return Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) <= Math.pow(radius, 2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                if (isInsideCircle(x, y)) {
                    setPressed(true);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                if (isPressed() && isInsideCircle(x, y)) {
                    performClick();
                }
                setPressed(false);
                break;
            case MotionEvent.ACTION_MOVE:
                if (isPressed() && !isInsideCircle(x, y)) {
                    setPressed(false);
                }
                break;
        }
        return true;
    }

    // using order of attrs.xml type enum
    public enum RuneStyle {
        FIRE(0xffff0000, 0xffaa0000),
        WATER(0xff0000ff, 0xff0000aa),
        LIFE(0xff00ff00, 0xff00aa00),
        DEATH(0xff000000, 0xff555555);

        private int color;
        private int borderColor;

        RuneStyle(int color, int borderColor) {
            this.color = color;
            this.borderColor = borderColor;
        }

        public int getColor() {
            return color;
        }

        public int getBorderColor() {
            return borderColor;
        }

        public int getPressedColor() {
            return borderColor;
        }
    }
}
