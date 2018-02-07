package com.aoben.qproj.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.util.DisplayUtils;
import com.aoben.qproj.util.LogUtils;

/**
 * Created by kenway on 18/2/5 16:04
 * Email : xiaokai090704@126.com
 * 根据比例画圆
 */

public class CirclePercentUI extends View {
    private Context mContext;

    /**
     * 背景圆的画笔
     */
    private Paint mPaint_bg_circle;

    /**
     * 百分比画笔
     */
    private Paint mPaint_percent;


    /**
     * 色带的宽带
     */
    private float strokeWidth;

    /**
     * 背景圆的颜色
     */
    private int mBigColor;
    /**
     * 背景圆的颜色
     */
    private int mSmallColor;

    /**
     * 半径size
     */
    private int mRadius;

    /**
     * 圆的圆心
     */
    private int x, y;
    /**
     * 控件的大小
     */
    private int mWidth, mHeight;

    private int  mPercent;

    /**
     * 要画的弧度
     */
    private int mEndAngle;

    public CirclePercentUI(Context context) {
        super(context, null);

    }



    public CirclePercentUI(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CirclePercentUI);
//        TypedArray a =context.obtainStyledAttributes(attrs, R.styleable.CirclePercentUI,defStyleAttr,0);
        strokeWidth=  a.getDimension(R.styleable.CirclePercentUI_stripeWidth,DisplayUtils.dp2px(context,30));
        //获取当前百分比
        mPercent=a.getInteger(R.styleable.CirclePercentUI_percent,0);
        //获取小圆的颜色
        mSmallColor =a.getColor(R.styleable.CirclePercentUI_smallColor,0xffafb4);
        //获取大圆的颜色
        mBigColor=a.getColor(R.styleable.CirclePercentUI_bigColor,0xff6950a1);
        //获取圆的半径
        mRadius =a.getDimensionPixelSize(R.styleable.CirclePercentUI_radius, DisplayUtils.dp2px(context,100));
        mContext = context;

        LogUtils.e("strokeWidth="+strokeWidth+",mPercent="+mPercent+",mSmallColor="+mSmallColor+",bigColor="+mBigColor+",radius="+mRadius);
        init();

    }



    @Override
    protected void onDraw(Canvas canvas) {
        mEndAngle= (int) (mPercent*3.6);
        //绘制大圆


        canvas.drawCircle(300,300,mRadius,mPaint_bg_circle);

    }
    private void init() {
        //背景圆画笔参数
        mPaint_bg_circle = new Paint();
        mPaint_bg_circle.setAntiAlias(true);
        mPaint_bg_circle.setStrokeWidth(strokeWidth);
        mPaint_bg_circle.setColor(mBigColor);
        mPaint_bg_circle.setStyle(Paint.Style.STROKE);

        //百分比圆画笔参数
        mPaint_percent = new Paint();
        mPaint_percent.setAntiAlias(false);
        mPaint_percent.setStrokeWidth(strokeWidth);
        mPaint_percent.setColor(mSmallColor);
        mPaint_percent.setStyle(Paint.Style.STROKE);


    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //设置视图的大小
        setMeasuredDimension(measureView(widthMeasureSpec), measureView(heightMeasureSpec));
    }

    private int  measureView(int measureSpec ){
        int result ;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);

        if (specMode==MeasureSpec.EXACTLY){
            result=specSize;
        }else {
            result=mRadius*2;
            if (specMode==MeasureSpec.AT_MOST){
                result=Math.min(result,specSize);
            }

        }
        return  result;
    }
}
