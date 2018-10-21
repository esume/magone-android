package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class EffectBackground extends View {
    protected float borderMultiplier = 1 / 10f;
    protected int borderColor = 0xffe0e0e0;
    protected int color = 0xffffffff;

    private Rect outsideRect;
    private Rect insideRect;
    private Paint paint;

    public EffectBackground(Context context) {
        super(context);
        init();
    }

    public EffectBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        outsideRect = new Rect();
        insideRect = new Rect();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
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
    }
}
