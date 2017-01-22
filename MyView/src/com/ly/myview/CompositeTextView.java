package com.ly.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompositeTextView extends LinearLayout {

	private TextView mTv_left;
	private TextView mTv_mid;
	private TextView mTv_right;

	private static float LEFT_TEXT_SIZE;
	private static float MID_TEXT_SIZE;
	private static float RIGHT_TEXT_SIZE;
	private static float TEXT_SIZE;

	private static int LEFT_TEXT_COLOR;
	private static int MID_TEXT_COLOR;
	private static int RIGHT_TEXT_COLOR;
	private static int TEXT_COLOR;

	private static String LEFT_TEXT_STRING = "";
	private static String MID_TEXT_STRING = "";
	private static String RIGHT_TEXT_STRING = "";

	private static int LEFT_TEXT_WIDTH;
	private static int MID_TEXT_WIDTH;
	private static int RIGHT_TEXT_WIDTH;

	public CompositeTextView(Context context) {
		super(context);
	}

	public CompositeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context, attrs);
	}

	public CompositeTextView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context, attrs);
	}

	// 顺序：字体大小 -> 字体颜色 -> 文本内容 -> 文本宽度
	private void initView(Context context, AttributeSet attrs) {
		View view = null;

		if (view == null) {
			// 初始化View
			view = LayoutInflater.from(context).inflate(
					R.layout.composite_view, this);
			mTv_left = (TextView) view.findViewById(R.id.tv_left);
			mTv_mid = (TextView) view.findViewById(R.id.tv_mid);
			mTv_right = (TextView) view.findViewById(R.id.tv_right);

			// 获取属性集合
			TypedArray typedArray = context.obtainStyledAttributes(attrs,
					R.styleable.CompositeTextView);

			// 设置字体大小--begin
			LEFT_TEXT_SIZE = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_leftTextSize, 0);
			MID_TEXT_SIZE = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_midTextSize, 0);
			RIGHT_TEXT_SIZE = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_rightTextSize, 0);
			TEXT_SIZE = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_textSize, 0);

			if (LEFT_TEXT_SIZE != 0)
				mTv_left.setTextSize(LEFT_TEXT_SIZE);
			if (MID_TEXT_SIZE != 0)
				mTv_mid.setTextSize(MID_TEXT_SIZE);
			if (RIGHT_TEXT_SIZE != 0)
				mTv_right.setTextSize(RIGHT_TEXT_SIZE);

			if (TEXT_SIZE != 0) {
				mTv_left.setTextSize(TEXT_SIZE);
				mTv_mid.setTextSize(TEXT_SIZE);
				mTv_right.setTextSize(TEXT_SIZE);
			}
			// 设置字体大小--end

			// 设置字体颜色--begin
			LEFT_TEXT_COLOR = typedArray.getInt(
					R.styleable.CompositeTextView_leftTextColor, 0);
			MID_TEXT_COLOR = typedArray.getInt(
					R.styleable.CompositeTextView_midTextColor, 0);
			RIGHT_TEXT_COLOR = typedArray.getInt(
					R.styleable.CompositeTextView_rightTextColor, 0);
			TEXT_COLOR = typedArray.getInt(
					R.styleable.CompositeTextView_textColor, 0);

			if (LEFT_TEXT_COLOR != 0)
				mTv_left.setTextColor(LEFT_TEXT_COLOR);
			if (MID_TEXT_COLOR != 0)
				mTv_mid.setTextColor(MID_TEXT_COLOR);
			if (RIGHT_TEXT_COLOR != 0)
				mTv_right.setTextColor(RIGHT_TEXT_COLOR);

			if (TEXT_COLOR != 0) {
				mTv_left.setTextColor(TEXT_COLOR);
				mTv_mid.setTextColor(TEXT_COLOR);
				mTv_right.setTextColor(TEXT_COLOR);
			}
			// 设置字体颜色--end

			// 设置文字内容--begin
			LEFT_TEXT_STRING = typedArray
					.getString(R.styleable.CompositeTextView_leftTextStr);
			MID_TEXT_STRING = typedArray
					.getString(R.styleable.CompositeTextView_midTextStr);
			RIGHT_TEXT_STRING = typedArray
					.getString(R.styleable.CompositeTextView_rightTextStr);

			LEFT_TEXT_STRING = (null == LEFT_TEXT_STRING) ? ""
					: LEFT_TEXT_STRING;
			mTv_left.setText(LEFT_TEXT_STRING);

			MID_TEXT_STRING = (null == MID_TEXT_STRING) ? "" : MID_TEXT_STRING;
			mTv_mid.setText(MID_TEXT_STRING);

			RIGHT_TEXT_STRING = (null == RIGHT_TEXT_STRING) ? ""
					: RIGHT_TEXT_STRING;
			mTv_right.setText(RIGHT_TEXT_STRING);
			// 设置文字内容--end

			// 设置宽度--begin
			LEFT_TEXT_WIDTH = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_leftTextWidth, 0);
			MID_TEXT_WIDTH = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_midTextWidth, 0);
			RIGHT_TEXT_WIDTH = typedArray.getDimensionPixelSize(
					R.styleable.CompositeTextView_rightTextWidth, 0);

			if (LEFT_TEXT_WIDTH != 0)
				mTv_left.setWidth(LEFT_TEXT_WIDTH);
			if (MID_TEXT_WIDTH != 0)
				mTv_mid.setWidth(MID_TEXT_WIDTH);
			if (RIGHT_TEXT_WIDTH != 0)
				mTv_right.setWidth(RIGHT_TEXT_WIDTH);
			// 设置宽度--end
			typedArray.recycle();

		}
	}

	public void setLeftText(String text) {
		mTv_left.setText(text);
	}

	public void setLeftTextColor(int color) {
		mTv_left.setText(color);
	}

	public void setLeftTextSize(float size) {
		mTv_left.setTextSize(size);
	}

	public String getLeftText() {
		return mTv_left.getText() + "";
	}

	public void setMidText(String text) {
		mTv_mid.setText(text);
	}

	public void setMidTextColor(int color) {
		mTv_mid.setText(color);
	}

	public void setMidTextSize(float size) {
		mTv_mid.setTextSize(size);
	}

	public String getMidText() {
		return mTv_mid.getText() + "";
	}

	public void setRightText(String text) {
		mTv_right.setText(text);
	}

	public void setRightTextColor(int color) {
		mTv_right.setText(color);
	}

	public void setRightTextSize(float size) {
		mTv_right.setTextSize(size);
	}

	public String getRightText() {
		return mTv_right.getText() + "";
	}

}
