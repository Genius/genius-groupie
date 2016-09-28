package com.genius.groupie.example;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class SquareView extends FrameLayout {
    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);

        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY));
    }
}
