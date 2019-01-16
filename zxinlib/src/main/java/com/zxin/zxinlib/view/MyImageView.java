package com.zxin.zxinlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.zxin.zxinlib.R;

/*****
 * 自定义图片
 *
 * liukui
 *
 */
public class MyImageView extends ImageView {
    //<!--背景颜色-->
    private int image_bgcolor;
    //<!--圆半径-->
    private float circleRadius;
    //<!--圆环宽度-->
    private float circleWidth;
    // <!--权重-->
    private float image_weight;
    //<!--高-->
    private float image_Height;
    //  <!--宽-->
    private float image_Width;
    //<!--类型-->
    private float iamge_Type;

    //外圆的颜色
    private int outCircleColor = Color.WHITE;

    //画笔
    private Paint paint;

    //view的宽度和高度
    private int viewWidth;
    private int viewHeigth;

    private Bitmap image;

    public MyImageView(Context context) {
        this(context, null);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**获取属性值*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyImageView);

        image_bgcolor = typedArray.getColor(R.styleable.MyImageView_image_bgcolor, Color.WHITE);
        outCircleColor = typedArray.getColor(R.styleable.MyImageView_outCircleColor, Color.WHITE);
        circleRadius = typedArray.getDimension(R.styleable.MyImageView_circleRadius, 0);
        circleWidth = typedArray.getDimension(R.styleable.MyImageView_circleWidth, 0);
        image_weight = typedArray.getDimension(R.styleable.MyImageView_image_weight, 0);
        image_Height = typedArray.getDimension(R.styleable.MyImageView_image_Height, 0);
        image_Width = typedArray.getDimension(R.styleable.MyImageView_image_Width, 0);
        iamge_Type = typedArray.getDimension(R.styleable.MyImageView_iamge_Type, 0);

        typedArray.recycle();  //回收
    }

    /**
     * 初始化资源文件
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {

        paint = new Paint();
        paint.setColor(outCircleColor);//颜色
        paint.setAntiAlias(true);//设置抗锯齿
    }

    /**
     * view的测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWith(widthMeasureSpec);
        int height = measureWith(heightMeasureSpec);
        viewWidth = width - (int)circleRadius * 2;
        viewHeigth = height - (int)circleRadius * 2;
        //调用该方法将测量后的宽和高设置进去，完成测量工作，
        setMeasuredDimension(width, height);
    }

    /**
     * 测量宽和高，这一块可以是一个模板代码(Android群英传)
     * @param widthMeasureSpec
     * @return
     */
    private int measureWith(int widthMeasureSpec) {
        int result = 0;
        //从MeasureSpec对象中提取出来具体的测量模式和大小
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            //测量的模式，精确
            result = size;
        } else {
            result = viewWidth;
        }
        return result;
    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        //加载图片
        loadImage();
        if (image != null) {
            //拿到最小的值(这里我们要去到最小的)
            int min = Math.min(viewWidth, viewHeigth);
            int circleCenter = min / 2;
            image = Bitmap.createScaledBitmap(image, min, min, false);
            //画圆
            canvas.drawCircle(circleCenter + (int)circleRadius, circleCenter + (int)circleRadius, circleCenter + outCircleColor, paint);

            //画图像
            canvas.drawBitmap(createCircleBitmap(image, min), (int)circleRadius, (int)circleRadius, null);
        }


    }

    /**
     * 创建一个圆形的bitmap
     *
     * @param image  传入的image
     * @param min
     * @return
     */
    private Bitmap createCircleBitmap(Bitmap image, int min) {
        Bitmap bitmap = null;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        bitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        //画一个和图片大小相等的画布
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(image, 0, 0, paint);
        return bitmap;
    }

    /**
     * 加载Image
     */
    private void loadImage() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.getDrawable();

        if (bitmapDrawable != null) {
            image = bitmapDrawable.getBitmap();
        }
    }
}