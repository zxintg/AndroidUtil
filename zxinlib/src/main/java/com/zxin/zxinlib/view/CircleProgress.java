package com.zxin.zxinlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import com.zxin.zxinlib.glide.base.BaseBuilder;
import com.zxin.zxinlib.glide.base.BaseProgress;

/**
 * Created by peng on 16-10-18. The CircleProgress class extends BaseProgress
 */
public class CircleProgress extends BaseProgress {
	// The Paint of the Ring
	private Paint mCirclePaint;
	// The Size of the Ring
	// The progress Color for the Ring
	private int mCircleProgressColor;
	// the radius of the Ring
	private int mCircleRadius;

	/*
	 * initCircleProgress
	 */
	@Override
	public void initProperty() {
		super.initProperty();
		// init mCircleproerty
		mCirclePaint = new Paint();
		mCirclePaint.setAntiAlias(true);
		//mCirclePaint.setStrokeWidth(25);
		mCirclePaint.setStrokeCap(Paint.Cap.ROUND);
		mCircleProgressColor = 0xffffff;
		mCircleRadius = 50;
	}

	@Override
	public void DrawOther(Canvas canvas) {
		drawCircle(canvas);
		drawArc(canvas);
	}

	/*
	 * draw the circle background
	 */
	private void drawCircle(Canvas canvas) {
		//设置画笔模式：填充
		mCirclePaint.setStyle(Paint.Style.STROKE);
		Rect bounds = getBounds();
		int xpos = bounds.left + bounds.width() / 2;
		int ypos = bounds.bottom - bounds.height() / 2;
		mCirclePaint.setColor(mCircleProgressColor);
		canvas.drawCircle(xpos, ypos,mCircleRadius+3, mCirclePaint);
	}

	/*
	 * draw the arc for the progress
	 */
	private void drawArc(Canvas canvas) {
		//设置画笔模式：填充
		mCirclePaint.setStyle(Paint.Style.FILL);
		mCirclePaint.setAlpha(100);
		Rect bounds = getBounds();
		int xpos = bounds.left + bounds.width() / 2;
		int ypos = bounds.bottom - bounds.height() / 2;
		RectF rectF = new RectF(xpos - mCircleRadius, ypos - mCircleRadius, xpos + mCircleRadius, ypos + mCircleRadius);
		float degree = (float) mProgress / (float) mMaxValue * 360;
		mCirclePaint.setColor(mCircleProgressColor);
		canvas.drawArc(rectF, 270, degree, true, mCirclePaint);
	}

	public static class Builder extends BaseBuilder<CircleProgress, Builder> {
		public Builder() {
			mProgress = new CircleProgress();
		}

		/*
		* set the Circle radius
		 */
		public Builder setCircleRadius(int Radius) {
			mProgress.mCircleRadius = Radius;

			return this;
		}

		/*
		* set the Progress Circle Color
		*/
		public Builder setProgressColor(@ColorInt int Color) {
			mProgress.mCircleProgressColor = Color;

			return this;
		}

		/*
    	* set the Progress Circle Color
     	*/

		public Builder setProgressColorRes(@ColorRes int ColorRes, Context context) {
			mProgress.mCircleProgressColor = context.getResources().getColor(ColorRes);
			return this;
		}

	}

}
