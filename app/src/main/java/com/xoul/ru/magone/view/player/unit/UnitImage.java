package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class UnitImage extends View {
    private static final float BORDER_MULTIPLIER = 1 / 20f;
    private static final int BORDER_COLOR = 0xff000000;
    private static final int COLOR = 0xffffffff;

    private RectF outsideRect;
    protected RectF insideRect;
    protected Paint paint;

    public UnitImage(Context context) {
        super(context);
        init();
    }

    public UnitImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        outsideRect = new RectF(0, 0, 0, 0);
        insideRect = new RectF(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        int border = (w < h) ? w : h; // min(w, h);
        border *= BORDER_MULTIPLIER;
        insideRect.set(border, border, w - border, h - border);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(BORDER_COLOR);
        canvas.drawOval(outsideRect, paint);
        paint.setColor(COLOR);
        canvas.drawOval(insideRect, paint);
    }
}
