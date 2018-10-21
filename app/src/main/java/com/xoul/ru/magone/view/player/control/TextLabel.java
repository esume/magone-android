package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class TextLabel extends View {
    protected int textColor = 0xff000000;
    protected float textSize = 70f;

    private Rect outsideRect;
    private Rect bounds;
    private Paint paint;
    protected String text;

    public TextLabel(Context context) {
        super(context);
        init();
    }

    public TextLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        text = "CAST";
        outsideRect = new Rect();
        bounds = new Rect(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        paint.setTextSize(h);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(textColor);
        makeTextMeasurements();
        canvas.drawText(text, outsideRect.centerX(), outsideRect.centerY() - bounds.centerY(), paint);
    }

    private void makeTextMeasurements() {
        paint.getTextBounds(text, 0, text.length(), bounds);
    }
}
