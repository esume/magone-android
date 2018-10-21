package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class Effect extends View {
    protected int textColor = 0xffffffff;

    private EffectType style;
    private Paint paint;
    private Rect outsideRect;
    private Rect bounds;

    private String text;

    public Effect(Context context) {
        super(context);
        init();
    }

    public Effect(Context context, EffectType style, int duration) {
        super(context);
        init();
        this.style = style;
        this.text = Integer.toString(duration);
    }

    public Effect(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
        outsideRect = new Rect();
        bounds = new Rect();
        style = EffectType.FIRE;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        paint.setTextSize(h * 11 / 9f);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth();
        int h = getHeight();
        paint.setColor(style.getColor());
        canvas.drawRect(0, 0, w, h, paint);
        paint.setColor(textColor);
        makeTextMeasurements();
        canvas.drawText(text, outsideRect.centerX(), outsideRect.centerY() - bounds.centerY(), paint);
    }

    private void makeTextMeasurements() {
        paint.getTextBounds(text, 0, text.length(), bounds);
    }

    public enum EffectType {
        FIRE(0xffff0000),
        WET(0xff0000ff),
        HEAL(0xff00ff00),
        SHIELD(0xffffff00),
        DEATH(0xff000000);

        private int color;

        EffectType(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }
    }
}
