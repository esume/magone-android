package com.xoul.ru.magone.view.other;

import android.content.Context;
import android.util.TypedValue;

public class Utils {
    public static int dpPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
