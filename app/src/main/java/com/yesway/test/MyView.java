package com.yesway.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Trace;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description: <><br>
 * Author:      gxl<br>
 * Date:        2018/10/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MyView extends View {
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.STROKE);
        //canvas.drawText("爱上发顺丰三阿沙发沙发上",0,50, paint);
//
        Trace.beginSection("DrawTrace start");
        for(int i = 0; i < 100; i ++){
            canvas.drawText(String.valueOf(i),0,50, paint);
        }
        Trace.endSection();
        Trace.beginSection("DrawTrace1 start");
        for(int i = 0; i < 100;i ++){
            canvas.drawText(String.valueOf(i),0,50, paint);
        }
        Trace.endSection();
    }

}
