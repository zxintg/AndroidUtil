package com.common.camera.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.common.camera.R;
import com.common.camera.activity.AlbumPreviewActivity;
import com.common.camera.model.PhotoPreviewBean;
import com.common.camera.view.PhotoView;
import com.zxin.zxinlib.util.BaseStringUtils;
import com.zxin.zxinlib.util.ImageUtil;

/**
 * Created by Administrator on 2018/9/4.
 */

public class AlbumFragment extends Fragment {
    private PhotoView mPhotoView;

    private PhotoPreviewBean.PhotoPreview previewBean;
    public static AlbumFragment newInstance(PhotoPreviewBean.PhotoPreview previewBean) {
        AlbumFragment fragment = new AlbumFragment();
        Bundle args = new Bundle();
        args.putParcelable(BaseStringUtils.FRAGMENT_DATA, previewBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        previewBean = getArguments().getParcelable(BaseStringUtils.FRAGMENT_DATA);
        mPhotoView = (PhotoView) view.findViewById(R.id.pv_album);

        mPhotoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        mPhotoView.enable();
        lazyLoad();
        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof AlbumPreviewActivity){
                    ((AlbumPreviewActivity)getActivity()).ClickNotifyView(mPhotoView,previewBean);
                    return;
                }
                getActivity().onBackPressed();
            }
        });
    }

    //Fragment的View加载完毕的标记
    private boolean isViewCreated = false;
    //Fragment对用户可见的标记
    private boolean isUIVisible = false;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
            ImageUtil.loadImageViewProgress(getContext(), previewBean.imageUrl, mPhotoView ,R.mipmap.default_iamge, R.drawable.ugc_choose_photo_pressed);
        }
    }

}
