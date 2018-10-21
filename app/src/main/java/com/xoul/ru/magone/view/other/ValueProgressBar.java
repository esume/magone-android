package com.xoul.ru.magone.view.other;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.xoul.ru.magone.R;

public class ValueProgressBar extends View implements ValueAnimator.AnimatorUpdateListener {
    protected float borderMultiplier = 1 / 10f;
    protected int borderColor = 0xff0000aa;
    protected int backgroundColor = 0xff111111;
    protected int color = 0xff0000ff;
    protected int textColor = 0xffffffff;
    protected float textSize;
    protected long animationDuration = 250;

    private Rect outsideRect;
    private Rect insideRect;
    private Rect filledRect;
    private Paint paint;
    private Rect bounds;

    private int value;
    private int maxValue;

    public ValueProgressBar(Context context) {
        super(context);
        value = 1;
        maxValue = 1;
        init();
    }

    public ValueProgressBar(Context context, int value, int maxValue) {
        super(context);
        this.value = value;
        this.maxValue = maxValue;
        init();
    }

    public ValueProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ValueProgressBar, 0, 0);
        value = typedArray.getInteger(R.styleable.ValueProgressBar_value, 0);
        maxValue = typedArray.getInteger(R.styleable.ValueProgressBar_maxValue, 1);
        init();
    }

    private void init() {
        outsideRect = new Rect(0, 0, 0, 0);
        insideRect = new Rect(0, 0, 0, 0);
        filledRect = new Rect(0, 0, 0, 0);
        bounds = new Rect(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value > maxValue) {
            this.value = maxValue;
        } else if (value < 0) {
            this.value = 0;
        } else  {
            this.value = value;
        }
        onValueChanged();
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        if (maxValue < 1) {
            this.maxValue = 1;
        } else {
            this.maxValue = maxValue;
        }
        onValueChanged();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        textSize = h;
        paint.setTextSize(textSize);
        int border = (w < h) ? w : h; // min(w, h);
        border *= borderMultiplier;
        insideRect.set(border, border, w - border, h - border);
        makeValueMeasurements();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(borderColor);
        canvas.drawRect(outsideRect, paint);
        paint.setColor(backgroundColor);
        canvas.drawRect(insideRect, paint);
        paint.setColor(color);
        canvas.drawRect(filledRect, paint);
        paint.setColor(textColor);
        makeTextMeasurements();
        canvas.drawText(getText(),
                outsideRect.centerX(),
                outsideRect.centerY() - bounds.centerY(),
                paint
        );
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        filledRect.right = (Integer) animation.getAnimatedValue();
        invalidate();
    }

    private void onValueChanged() {
        int currentRight = filledRect.right;
        makeValueMeasurements();
        int newRight = filledRect.right;
        ValueAnimator animator = ValueAnimator.ofInt(currentRight, newRight);
        animator.setDuration(animationDuration);
        animator.addUpdateListener(this);
        animator.start();
    }

    private String getText() {
        return Integer.toString(value) + "/" + Integer.toString(maxValue);
    }

    private void makeTextMeasurements() {
        String text = getText();
        paint.getTextBounds(text, 0, text.length(), bounds);
    }

    private void makeValueMeasurements() {
        float percent = value / (float) maxValue;
        int right = (int) (insideRect.right * percent);
        filledRect.set(insideRect.left, insideRect.top, right, insideRect.bottom);
    }
}
