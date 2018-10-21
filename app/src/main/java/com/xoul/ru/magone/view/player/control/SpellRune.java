package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xoul.ru.magone.R;
import com.xoul.ru.magone.view.player.rune.Rune.RuneStyle;

public class SpellRune extends View {
    private Paint paint;
    private RuneStyle style;

    private float x;
    private float y;
    private float radius;

    public SpellRune(Context context) {
        super(context);
        paint = new Paint();
    }

    public SpellRune(Context context, RuneStyle style) {
        super(context);
        this.style = style;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public SpellRune(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Rune, 0, 0);
        int runeIndex = typedArray.getInteger(R.styleable.Rune_type, 0);
        this.style = RuneStyle.values()[runeIndex];
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
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
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(style.getColor());
        canvas.drawCircle(x, y, radius, paint);
    }
}
