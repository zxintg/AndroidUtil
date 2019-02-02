package com.zxin.zxinlib.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.bumptech.glide.util.LruCache;
import com.mbg.library.RefreshRelativeLayout;
import com.tencent.smtt.sdk.WebView;
import com.zxin.zxinlib.R;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.view.RefreshCommonView;
import com.zxin.zxinlib.view.dialog.BaseNiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialog;
import com.zxin.zxinlib.view.dialog.NiceDialogViewHolder;
import com.zxin.zxinlib.view.dialog.ProgressBarDialog;
import com.zxin.zxinlib.view.dialog.ViewConvertListener;

import java.util.ArrayList;
import java.util.List;

/*****
 * 长图操作
 */
public class LongPictureUtil {
    private int viewHeight = 0;
    private int pagerIndex;
    private Bitmap extroyBitmap;
    private Context context;
    private List<Bitmap> bitmapList = new ArrayList<>();
    private String mesg;

    public LongPictureUtil(Context context){
        viewHeight = 0;
        bitmapList.clear();
        this.context = context;
    }

    /**
     * 简单的截屏
     *
     * @param view
     * @return
     */
    public Bitmap screenShot(View view) {
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        view.destroyDrawingCache();
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public void setMesgFrom(String mesg){
        this.mesg = mesg;
    }

    public void setViewPageIndex(int pagerIndex) {
        this.pagerIndex = pagerIndex;
    }

    private View view;
    private ProgressBarDialog progressDialog;
    public void getLongViewPicture(ProgressBarDialog mDialog) {
        this.progressDialog = mDialog;
        AppManager.getAppManager().currentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view = SystemInfoUtil.getCurrentView();
                getItemBitmap(view);
                if (isRecyclerView) {
                    if(progressDialog!=null&&progressDialog.isShowing()){
                        progressDialog.closeProgress();
                    }
                    return;
                }
                resultPicture();
            }
        });
    }

    private void resultPicture(){
        if (bitmapList == null || bitmapList.isEmpty()) {
            if (listener!=null)
                listener.onCutLongPictureResult(null,mesg);
            return;
        }
        viewHeight += extroyBitmap != null?extroyBitmap.getHeight():0;

        // 创建对应大小的bitmap
        Bitmap result = Bitmap.createBitmap(view.getWidth(), viewHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        //canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);//绘制透明色
        canvas.drawColor(Color.parseColor("#ffffff"), PorterDuff.Mode.SCREEN);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);//设置填满
        int height = 0;
        for (Bitmap bitmap : bitmapList) {
            canvas.drawBitmap(bitmap, 0, height, paint);
            height += bitmap.getHeight();
        }

        if (extroyBitmap != null) {
            canvas.drawBitmap(extroyBitmap, (view.getWidth()-extroyBitmap.getWidth())/2, height, paint);
        }

        if (listener!=null)
            listener.onCutLongPictureResult(result,mesg);
    }

    private boolean isRecyclerView = false;
    private void getItemBitmap(View view) {
        isRecyclerView = false;
        if (view instanceof ScrollView) {
            getScrollViewBitmap((ScrollView) view);
        } else if (view instanceof NestedScrollView) {

            getNestedScrollViewBitmap((NestedScrollView) view);
        } else if (view instanceof ListView) {

            getListViewBitmap((ListView) view);
        } else if (view instanceof RecyclerView) {
            isRecyclerView = true;
            //getRecyclerViewBitmap((RecyclerView) view);
            sharePopupRecyclerView(((RecyclerView) view).getAdapter());
        } else if (view instanceof RefreshCommonView) {

            getItemBitmap(((RefreshCommonView) view).getCurrentView());
        } else if (view instanceof CoordinatorLayout) {

            getCoordinatorViewBitmap((CoordinatorLayout) view);
        } else if (view instanceof WebView) {

            getWX5ViewBitmap((WebView) view);
        } else if (view instanceof ViewPager) {

            getItemBitmap(((ViewPager) view).getChildAt(pagerIndex));
        } else if(view instanceof LinearLayout){

            getLinearLayoutView((LinearLayout)view);
        } else if(view instanceof RelativeLayout){

            getRelativeLayoutView((RelativeLayout)view);
        } else if(view instanceof RefreshRelativeLayout){

            getRefreshRelativeLayoutView((RefreshRelativeLayout)view);
        } else {

            getViewBitmap(view);
        }
    }

    /****
     * 获取View
     * @param view
     */
    private void getViewBitmap(View view) {
        int height = view.getMeasuredHeight();
        viewHeight += height;
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        //canvas.drawColor(Color.parseColor("#f5f5f5"));
        view.draw(canvas);
        bitmapList.add(bitmap);
    }

    private void getLinearLayoutView(LinearLayout view) {
        for (int i=0;i<view.getChildCount();i++){
            getItemBitmap(view.getChildAt(i));
        }
    }

    private void getRelativeLayoutView(RelativeLayout view) {
        for (int i=0;i<view.getChildCount();i++){
            getItemBitmap(view.getChildAt(i));
        }
    }

    private void getRefreshRelativeLayoutView(RelativeLayout view) {
        for (int i=0;i<view.getChildCount();i++){
            if (view.getChildAt(i).getVisibility() == View.VISIBLE){
                getItemBitmap(view.getChildAt(i));
                return;
            }
        }
    }

    /****
     * 获取ScrollView
     * @param view
     */
    private void getScrollViewBitmap(ScrollView view) {
        if (view == null) {
            return;
        }
        int height = 0;
        // 获取scrollview实际高度
        for (int i = 0; i < view.getChildCount(); i++) {
            height += view.getChildAt(i).getHeight();
        }
        viewHeight += height;
        // 创建对应大小的bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.parseColor("#f5f5f5"));
        view.draw(canvas);
        bitmapList.add(bitmap);
    }

    private void getNestedScrollViewBitmap(NestedScrollView view) {
        if (view == null) {
            return;
        }
        int height = 0;
        // 获取scrollview实际高度
        for (int i = 0; i < view.getChildCount(); i++) {
            height += view.getChildAt(i).getHeight();
        }
        viewHeight += height;
        // 创建对应大小的bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.parseColor("#f5f5f5"));
        view.draw(canvas);
        bitmapList.add(bitmap);
    }

    /****
     * 获取CoordinatorView
     * @param view
     */
    private void getCoordinatorViewBitmap(CoordinatorLayout view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            getItemBitmap(view.getChildAt(i));
        }
    }

    /****
     * 获取ListView
     * @param view
     */
    private void getListViewBitmap(ListView view) {
        int height = 0;
        int listItemNum;
        List<View> childViews = null;
        int width = view.getWidth();//宽度等于屏幕宽

        ListAdapter listAdapter = view.getAdapter();
        listItemNum = listAdapter.getCount();
        childViews = new ArrayList<>(listItemNum);
        //计算整体高度:
        for (int pos = 0; pos < listItemNum; ++pos) {
            View itemView = listAdapter.getView(pos, null, view);
            //measure过程
            itemView.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            childViews.add(itemView);
            height += itemView.getMeasuredHeight();
        }
        viewHeight += height;
        // 创建对应大小的bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        int yPos = 0;
        //把每个ItemView生成图片，并画到背景画布上
        for (int pos = 0; pos < childViews.size(); ++pos) {
            View itemView = childViews.get(pos);
            int childHeight = itemView.getMeasuredHeight();
            Bitmap itemBitmap = viewToBitmap(itemView, width, childHeight);
            if (itemBitmap != null) {
                canvas.drawBitmap(itemBitmap, 0, yPos, null);
            }
            yPos = childHeight + yPos;
        }
        //canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.restore();
        bitmapList.add(bitmap);
    }

    /****
     * 获取RecyclerView
     * @param view
     */
    private void getRecyclerViewBitmap(RecyclerView view) {
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter != null) {
            int height = 0;
            int size = adapter.getItemCount();
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            final int cacheSize = maxMemory / 8;
            LruCache<String, Bitmap> bitmaCache = new LruCache<>(cacheSize);
            for (int i = 0; i < size; i++) {
                TrdViewHolder holder = (TrdViewHolder) adapter.createViewHolder(view, adapter.getItemViewType(i));
                adapter.onBindViewHolder(holder, i);
                holder.itemView.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                holder.itemView.layout(0, 0, holder.itemView.getMeasuredWidth(), holder.itemView.getMeasuredHeight());
                //开启绘图缓存
                holder.itemView.setDrawingCacheEnabled(true);
                holder.itemView.buildDrawingCache();
                Bitmap drawingCache = holder.itemView.getDrawingCache();
                if (drawingCache != null) {
                    bitmaCache.put(String.valueOf(i), drawingCache);
                }
                height += holder.itemView.getMeasuredHeight();
            }
            viewHeight += height;
            Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            int iHeight = 0;
            for (int i = 0; i < size; i++) {
                Bitmap child = bitmaCache.get(String.valueOf(i));
                canvas.drawBitmap(child, 0f, iHeight, null);
                iHeight += child.getHeight();
                child.recycle();
            }
            bitmapList.add(bitmap);
        }
    }

    /****
     * 获取WX5View
     * @param view
     */
    private void getWX5ViewBitmap(WebView view) {
        if (view == null) {
            return;
        }
        int width = view.getContentWidth();
        int height = view.getContentHeight();
        viewHeight += height;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        view.getX5WebViewExtension().snapshotWholePage(canvas, false, false);
        bitmapList.add(bitmap);
    }

    private Bitmap viewToBitmap(View view, int viewWidth, int viewHeight) {
        view.layout(0, 0, viewWidth, viewHeight);
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    private NiceDialog niceDialog;
    private void sharePopupRecyclerView(final RecyclerView.Adapter adapter){
        if (niceDialog == null)
            niceDialog = NiceDialog.init();
        niceDialog.setLayoutId(R.layout.popup_sharecontent)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(NiceDialogViewHolder holder, final BaseNiceDialog dialog) {
                        final NestedScrollView scrollView = holder.getView(R.id.share_scrollView);
                        LinearLayout titleLayout = holder.getView(R.id.share_title);
                        titleLayout.removeAllViews();
                        for (Bitmap bitmap : bitmapList){
                            ImageView imageView = new ImageView(context);
                            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            imageView.setScaleType(ImageView.ScaleType.CENTER);
                            imageView.setImageBitmap(bitmap);
                            titleLayout.addView(imageView);
                        }
                        RecyclerView recyclerView = holder.getView(R.id.share_content);
                        recyclerView.setLayoutManager(UiUtils.getLayoutManager(UiUtils.LayoutManager.VERTICAL));
                        recyclerView.setNestedScrollingEnabled(false);
                        recyclerView.setAdapter(adapter);
                        scrollView.scrollTo(0,0);
                        holder.setOnClickListener(R.id.share_cancel, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colseDialog();
                            }
                        });
                        holder.setOnClickListener(R.id.share_confirm, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(progressDialog!=null){
                                    progressDialog.showProgress();
                                }
                                colseDialog();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        viewHeight = 0;
                                        bitmapList.clear();
                                        getNestedScrollViewBitmap(scrollView);
                                        resultPicture();
                                    }
                                },500);
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(false)
                .show();
    }

    private void colseDialog() {
        if (niceDialog != null && niceDialog.isVisible()) {
            niceDialog.dismiss();
        }
    }


    public void setExtroyBitmap(Bitmap extroyBitmap) {
        this.extroyBitmap = extroyBitmap;
    }

    private PictureResultListener listener;
    public void setPictureResultListener(PictureResultListener listener){
        this.listener = listener;
    }

    /*****
     * 图片操作接口
     */
    public interface PictureResultListener{
        void onCutLongPictureResult(Bitmap bitmap, String mesg);
    }

}
