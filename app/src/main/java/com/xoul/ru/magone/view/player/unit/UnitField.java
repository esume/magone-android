package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.other.Utils;

public class UnitField extends LinearLayout implements View.OnClickListener {
    private static final int UNIT_MARGIN_DP = 5;
    private int unitWidthPx;
    private LayoutParams layoutParams;

    private Unit[] units;
    private OnUnitClickListener listener;

    public UnitField(Context context) {
        super(context);
        initLayout();
        initUnits(context);
    }

    public UnitField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
        initUnits(context);
    }

    private void initLayout() {
        units = new Unit[Slot.values().length];
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);

        int margin = Utils.dpPx(getContext(), UNIT_MARGIN_DP);
        layoutParams = new LayoutParams(unitWidthPx, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(margin, margin, margin, margin);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        unitWidthPx = (int) (h / 1.5);
        layoutParams.width = unitWidthPx;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initUnits(Context context) {
        addUnit(new Hero(context), Slot.HERO);
    }

    public void setListener(OnUnitClickListener listener) {
        this.listener = listener;
    }

    public void addUnit(Unit unit, Slot slot) {
        if (units[slot.ordinal()] != null) {
            removeUnit(slot);
        }
        units[slot.ordinal()] = unit;
        removeAllUnitViews();
        for (Unit item : units) {
            if (item != null) {
                addView(item, layoutParams);
                item.setOnClickListener(this);
            }
        }
    }

    public Unit getUnit(Slot slot) {
        return units[slot.ordinal()];
    }

    public void removeUnit(Slot slot) {
        removeView(units[slot.ordinal()]);
        units[slot.ordinal()] = null;
    }

    public void removeAllUnits() {
        for (int i = 0; i < units.length; i++) {
            if (units[i] != null) {
                removeView(units[i]);
                units[i] = null;
            }
        }
    }

    private void removeAllUnitViews() {
        for (Unit unit : units) {
            if (unit != null) {
                removeView(unit);
            }
        }
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < Slot.values().length; i++) {
            if (units[i] == v) {
                if (listener != null) {
                    listener.onUnitClick(units[i], Slot.values()[i]);
                }
                return;
            }
        }
    }

    public enum Slot {
        WARRIOR,
        HERO,
        SUPPORT
    }
}
