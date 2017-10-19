package com.mohit.calculatorAssignment.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

/**
 * Created by mohit on 2017-10-19.
 */
class LinearLayoutAspectRatio extends LinearLayoutCompat {


    public LinearLayoutAspectRatio(Context context) {
        super(context, null);
    }

    public LinearLayoutAspectRatio(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        double aspectRatio = 4.0/5.0;
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int newWidth = (int) Math.min(w, aspectRatio * h);
        int newHeight = (int) (1.0 * newWidth / aspectRatio);

        super.onMeasure(MeasureSpec.makeMeasureSpec(newWidth, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(newHeight, MeasureSpec.EXACTLY));
    }
}
