package com.common.camera.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.common.camera.R;
import com.common.camera.crop.UCrop;
import com.common.camera.model.ImageFloder;
import com.common.camera.model.LocalAlbum;
import com.common.camera.utils.CameraAlbumUtils;
import com.common.camera.utils.FileImageUtils;
import com.common.camera.view.ListImageDirPopupWindow;
import com.zxin.zxinlib.adapter.SimpleAdapter.SimpleAdapter;
import com.zxin.zxinlib.adapter.SimpleAdapter.TrdViewHolder;
import com.zxin.zxinlib.util.ImageUtil;
import com.zxin.zxinlib.util.SystemBarTintManager;
import com.zxin.zxinlib.util.SystemInfoUtil;
import com.zxin.zxinlib.view.CommonCrosswiseBar;
import com.zxin.zxinlib.view.RefreshCommonView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liukui on 2017/11/13.
 * <p>
 * 相册界面
 */
public class AlbumActivity extends AppCompatActivity implements RefreshCommonView.RefreshLoadMoreListener, ListImageDirPopupWindow.OnImageDirSelected {
    private CommonCrosswiseBar mTitle;
    private RefreshCommonView mRefresh;
    private SimpleAdapter adapter;
    private List<String> imageList = new ArrayList<>();
    private List<ImageFloder> mImageFloders = new ArrayList<>();
    private FileImageUtils fileUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(R.layout.activity_album);
        initView();
        setDates();
    }

    private void initView() {
        imageList.clear();
        mImageFloders.clear();
        mTitle = (CommonCrosswiseBar) findViewById(R.id.ccb_album_title);
        mRefresh = (RefreshCommonView) findViewById(R.id.rcv_album_commonlayout);
        fileUtils = new FileImageUtils(this);
    }

    private void setDates() {
        //家长端
        mTitle.setLeftButton(R.mipmap.ic_black_left_arrow);
        mTitle.setBGColor(R.color.color_ffffff);
        mTitle.setTitleTextColor(R.color.color_333333);
        mTitle.setRightButton(R.drawable.action_bar_black_menu_normal_pressed);
        mTitle.setRightTextColor(R.color.color_666666);
        adapter = new SimpleAdapter<String>(this, imageList, R.layout.item_album) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final String data) {
                ImageView ivGallery = holder.getView(R.id.iv_album_image);
                int with = (SystemInfoUtil.getScreenWidth() - 40) / 3;
                ivGallery.setLayoutParams(new RelativeLayout.LayoutParams(with, with));
                ImageUtil.loadImageViewLoding(mContext, mImgDir.getAbsolutePath() + "/" + data, holder.<ImageView>getView(R.id.iv_album_image), R.mipmap.default_iamge, R.mipmap.default_iamge);
                ivGallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //跳转到预览界面
                        UCrop.of(mImgDir.getAbsolutePath() + "/" + data)
                                .cropEnable(CameraAlbumUtils.getInstance(AlbumActivity.this).getTailorType())//第一个参数为FALSE时，第二个参数无效
                                .withAspectRatio(1, 1)
                                .withMaxResultSize(CameraAlbumUtils.getInstance(AlbumActivity.this).getWith(), CameraAlbumUtils.getInstance(AlbumActivity.this).getHeight())
                                .withTargetActivity(ImageTailorActivity.class)
                                .start(AlbumActivity.this);
                        onBackPressed();
                    }
                });
            }
        };
        mRefresh.setRecyclerViewAdapter(adapter);
        mRefresh.setRefreshLoadMoreListener(this);
        mRefresh.setIsLoadMore(false);

        mTitle.setOnClickListener(R.id.common_bar_leftBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTitle.setOnClickListener(R.id.common_bar_rightBtn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //展示更多
                if (mListImageDirPopupWindow == null || mListImageDirPopupWindow.isShowing())
                    return;
                mListImageDirPopupWindow.showAtDropDownCenter(v);
            }
        });
    }

    @Override
    public void startRefresh() {
        imageList.clear();
        mImageFloders.clear();
        fileUtils.getLocalImage(mHandler,selectPath);
    }

    @Override
    public void startLoadMore() {

    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mRefresh.finishRefresh();
            if (msg.obj == null) {
                mRefresh.setIsEmpty(true);
                return;
            } else {
                mRefresh.setIsEmpty(false);
            }
            mImgDir = (File) msg.obj;
            LocalAlbum album = msg.getData().getParcelable("data");
            mImageFloders.addAll(album.imageList);
            selectPath = mImgDir.getName();
            mTitle.setRightText(selectPath);
            try {
                List<String> mImgs = Arrays.asList(mImgDir.list(fileUtils.getFileterImage()));//获取文件夹下的图片集合
                imageList.addAll(mImgs);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //查询出来的图片是正序的，为了让图片按照时间倒序显示，对其倒序操作
            Collections.sort(imageList, new Comparator<String>() {
                @Override
                public int compare(String lhs, String rhs) {
                    return -1;
                }
            });
            adapter.notifyDataSetChanged();
            initListDirPopupWindw();//初始化小相册的popupWindow
        }
    };

    private File mImgDir;
    private ListImageDirPopupWindow mListImageDirPopupWindow;

    //设置相册PopupWindow
    private void initListDirPopupWindw() {
        mListImageDirPopupWindow = new ListImageDirPopupWindow(this, mImageFloders, mTitle.getMeasuredHeight());
        mListImageDirPopupWindow.setOnImageDirSelected(this);
    }

    private String selectPath = "";
    @Override
    public void albumSelected(ImageFloder floder) {
        imageList.clear();
        selectPath = floder.getName();
        mListImageDirPopupWindow.dismiss();
        mTitle.setRightText(selectPath);
        File file = new File(floder.getDir());
        List<String> picFileList = null;
        try {
            picFileList = Arrays.asList(file.list(fileUtils.getFileterImage()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(picFileList, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return -1;
            }
        });
        //重新设置数据和checkBox初始化
        mImgDir = file;
        imageList.addAll(picFileList);
        adapter.notifyDataSetChanged();
    }

    @TargetApi(19)
    private void initWindow() {
        //家长端
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setTintResource(R.drawable.top_bar_ffff);
            tintManager.setTintAlpha(0f);
        }
    }
}
