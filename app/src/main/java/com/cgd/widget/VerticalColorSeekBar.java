package com.cgd.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.cgd.R;

/**
 * Created by cgd on 2016/10/21.
 */
public class VerticalColorSeekBar extends View{

	private Paint mFinishPaint;// 画笔
	private float progress;// 进度值

	private float max;// 进度值
	private int width;// 宽度值
	private int height;// 高度值
	private final int default_finished_color = Color.rgb(252, 152, 12);
	private final int default_unfinished_color = Color.rgb(204, 204, 204);
	private int mFinishColor;
	private int mUnFinishColor;
	private int mTextColor;
	private float default_max = 100;
	private Paint mUnFinishPaint;
	private boolean mHasLine;
	private boolean mHasText;
	private Paint mTextPaint;


	public VerticalColorSeekBar(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		initPaint();
	}

	public VerticalColorSeekBar(Context context) {
		this(context, null);
		initPaint();
	}

	public VerticalColorSeekBar(Context context, AttributeSet attrs,
								int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		final TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.VerticalColorSeekBar, defStyleAttr, 0);
		initByAttributes(attributes);
		attributes.recycle();
		initPaint();
	}

	/**
	 * @desc 初始化自定义属性
	 * */
	private void initByAttributes(TypedArray attributes) {
		//设置完成进度条颜色
		mFinishColor = attributes.getColor(R.styleable.VerticalColorSeekBar_vp_finished_color, default_finished_color);
		//设置未完成进度条颜色
		mUnFinishColor = attributes.getColor(R.styleable.VerticalColorSeekBar_vp_unfinished_color, default_unfinished_color);
		//设置字体颜色
		mTextColor = attributes.getColor(R.styleable.VerticalColorSeekBar_vp_text_color, default_unfinished_color);
		//设置是否有边框
		mHasLine = attributes.getBoolean(R.styleable.VerticalColorSeekBar_vp_hasline, false);
		//设置是否有字体
		mHasText = attributes.getBoolean(R.styleable.VerticalColorSeekBar_vp_hasText, false);
		setMax(attributes.getFloat(R.styleable.VerticalColorSeekBar_vp_max, default_max));
		setProgress(attributes.getFloat(R.styleable.VerticalColorSeekBar_vp_progress, 0));

	}

	private void initPaint() {
		mFinishPaint = new Paint();
		mFinishPaint.setColor(mFinishColor);// 设置完成进度画笔颜色

		mUnFinishPaint = new Paint();
		mUnFinishPaint.setColor(mUnFinishColor);// 设置未完成进度画笔颜色

		mTextPaint = new Paint();
		mTextPaint.setColor(mTextColor);// 设置文字画笔颜色
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		width = getMeasuredWidth() - 1;// 宽度值
		height = getMeasuredHeight() - 1;// 高度值
	}

	@Override
	protected void onDraw(Canvas canvas) {


		canvas.drawRect(0, 0, width, height,
				mUnFinishPaint);// 画未完成矩形
		canvas.drawRect(0, height - progress / max * height, width, height,
				mFinishPaint);// 画完成矩形

		if (mHasLine) {

			canvas.drawLine(0, 0, width, 0, mFinishPaint);// 画顶边
			canvas.drawLine(0, 0, 0, height, mFinishPaint);// 画左边
			canvas.drawLine(width, 0, width, height, mFinishPaint);// 画右边
			canvas.drawLine(0, height, width, height, mFinishPaint);// 画底边
		}


		if (mHasText) {

			mTextPaint.setTextSize(width / 3);// 设置文字大小
			canvas.drawText((int)(progress/max*default_max) + "%",
					(width - getTextWidth((int)(progress/max*default_max) + "%")) /2, height / 2, mTextPaint);// 画文字
		}
		super.onDraw(canvas);
	}

	/**
	 * 拿到文字宽度
	 *
	 * @param str 传进来的字符串
	 *            return 宽度
	 */
	private int getTextWidth(String str) {
		// 计算文字所在矩形，可以得到宽高
		Rect rect = new Rect();
		mTextPaint.getTextBounds(str, 0, str.length(), rect);
		return rect.width();
	}

	public float getMax() {
		return max;
	}

	/**
	 * 设置progressbar进度最大值
	 */
	public void setMax(float max) {
		if (max > 0) {
			this.max = max;
			postInvalidate();
		}
	}

	/**
	 * 设置progressbar进度
	 */
	public void setProgress(float progress) {
		this.progress = progress;
		if (this.progress > getMax()) {
			this.progress %= getMax();
		}
		postInvalidate();
	}
	/**
	 * 设置是否有边框
	 * */
	public void setHasLine(boolean hasLine) {
		mHasLine = hasLine;
		postInvalidate();
	}
}