package com.zxin.marry.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zxin.marry.R;
import com.zxin.marry.activity.CameraInfoActivity;
import com.zxin.marry.activity.OnLineCameraActivity;
import com.zxin.marry.activity.ReserveRecordActivity;
import com.zxin.marry.bean.Camera;
import com.zxin.marry.bean.CameramandBean;
import com.zxin.marry.bean.FirstOrderBean;
import com.zxin.marry.bean.OnLineCameraForm;
import com.zxin.marry.mvp.presenter.PhotoGrapherPresenter;
import com.zxin.marry.util.StringUtils;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.util.ImageUtil;
import com.zxin.root.view.RefreshCommonView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class PhotoGrapherContract implements IBaseView , RefreshCommonView.RefreshLoadMoreListener{
    private Context mContext;
    private FirstOrderBean.ThreeEntity threeEntity;

    @Override
    public void setParameter(Object... parameter) {
        threeEntity = (FirstOrderBean.ThreeEntity) parameter[0];
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void loadDatas() {

    }

    private CameramandBean cameramandBean;
    @Override
    public void onResultSuccess(Object bean) {
        if (bean == null)
            return;
        cameramandBean = (CameramandBean)bean;
        iView.getLLButtonView().setVisibility(cameramandBean.getBookbtn() != 0 || cameramandBean.getLookbtn() != 0?View.VISIBLE:View.GONE);
        iView.getOnLineView().setVisibility(cameramandBean.getBookbtn() != 0 ?View.VISIBLE:View.GONE);
        iView.getReserveRecordView().setVisibility(cameramandBean.getLookbtn() != 0 ?View.VISIBLE:View.GONE);
        iView.getIVOptionalCameraView().setVisibility(cameramandBean.getIsdiycamer() == 1?View.VISIBLE:View.GONE);
        iView.getSDVCameraView().setEnabled(cameramandBean.getIsdiycamer() == 1);
        if (cameramandBean.getOnline_camer()!=null){
            ImageUtil.loadImageViewLoding(mContext, cameramandBean.getOnline_camer().getAvatar(), iView.getIVOptionalCameraView(), R.mipmap.default_iamge);
        }else{
            ImageUtil.loadImageView(mContext,R.drawable.user_1, iView.getIVOptionalCameraView());
        }
        iView.getMaquilleurView().setText(StringUtils.textIsEmpty(cameramandBean.getCameramand())?"暂未安排":cameramandBean.getCameramand());
        iView.getPhotographerView().setText(StringUtils.textIsEmpty(cameramandBean.getDresser())?"暂未安排":cameramandBean.getDresser());
        iView.getRemindView().setText(cameramandBean.getCamer_dresser_explain());;
        iView.getMaquilleurNumView().setText(StringUtils.textIsEmpty(cameramandBean.getCameramand_number())?"":cameramandBean.getCameramand_number());
        iView.getPhotographerNumView().setText(StringUtils.textIsEmpty(cameramandBean.getDresser_number())?"":cameramandBean.getDresser_number());
        if (cameramandBean.getDatang() != null){
            iView.getDepartmentView().setVisibility(StringUtils.textIsEmpty(cameramandBean.getDatang().getPhone())?View.GONE:View.VISIBLE);
            iView.getManagerNameView().setText(cameramandBean.getDatang().getName());
            iView.getPhoneNumberView().setText(cameramandBean.getDatang().getPhone());
            iView.getSectionView().setText(cameramandBean.getDatang().getDepartmentname());
            iView.getServiceProgressView().setText("摄影师化妆师已安排");
            iView.getNum1View().setVisibility(View.VISIBLE);
            iView.getNum2View().setVisibility(View.VISIBLE);
        }else{
            iView.getServiceProgressView().setText("摄影师化妆师暂未安排");
            iView.getNum1View().setVisibility(View.GONE);
            iView.getNum2View().setVisibility(View.GONE);
        }

    }

    @Override
    public void onAddResult(boolean bool) {

    }

    @Override
    public void onUpdateResult(boolean bool) {

    }

    @Override
    public void onDeleteResult(boolean bool) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void setContext(Context context) {
        this.mContext = context;
    }

    private PhotoGrapherPresenter presenter;

    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (PhotoGrapherPresenter) basePresenter[0];
    }

    private PhotoAndMakeupArtistView iView;

    public void setPhotoAndMakeupArtistListener(PhotoAndMakeupArtistView testView) {
        this.iView = testView;
    }

    public interface PhotoAndMakeupArtistView {
        LinearLayout getDepartmentView();
        ImageView getInformationImageView();
        LinearLayout getRL1View();
        TextView getManagerNameView();
        TextView getPhoneNumberView();
        LinearLayout getRLDepView();
        TextView getSectionView();
        TextView getTVDepView();
        View getViewLineView();
        LinearLayout getRLCallView();
        ImageView getIV1View();
        TextView getServiceProgressView();
        SimpleDraweeView getSDVCameraView();
        ImageView getIVOptionalCameraView();
        TextView getMaquilleurView();
        TextView getNum1View();
        TextView getMaquilleurNumView();
        TextView getPhotographerView();
        TextView getNum2View();
        TextView getPhotographerNumView();
        LinearLayout getLLButtonView();
        Button getOnLineView();
        Button getReserveRecordView();
        TextView getTextView3View();
        TextView getRemindView();
    }

    @Override
    public void OnClick(View v) {
        if (v.getId()== R.id.btn_on_line){
            if (cameramandBean.getServicelevel() != null) {
                Intent intent = new Intent(mContext, OnLineCameraActivity.class);
                intent.putExtra("photoDate", cameramandBean.getPhotodate());
                intent.putExtra("serviceLevel", cameramandBean.getServicelevel());
                intent.putExtra("orderId", threeEntity.getOrderid());
                intent.putExtra("shopId", threeEntity.getShopid());
                mContext.startActivity(intent);
            }
        } else if (v.getId()== R.id.btn_reserve_record){
            Intent intent = new Intent(mContext, ReserveRecordActivity.class);
            intent.putExtra("orderId", threeEntity.getOrderid());
            mContext.startActivity(intent);
        }else if (v.getId()== R.id.sdv_camera){
            if (cameramandBean.getServicelevel() != null) {
                Intent intent = new Intent(mContext, CameraInfoActivity.class);
                intent.putExtra(Camera.class.getSimpleName(),cameramandBean.getOnline_camer());
                intent.putExtra("shopId", threeEntity.getShopid());
                intent.putExtra("orderId", threeEntity.getOrderid());
                intent.putExtra("photoDate", cameramandBean.getPhotodate());
                intent.putExtra("serviceLevel", cameramandBean.getServicelevel());
                mContext.startActivity(intent);
            }
        }
    }

    private ReserveRecordView iReserveView;
    private String orderId;
    private SimpleAdapter reserveAdapter;
    private List<Camera> reserveList = new ArrayList<>();

    public void setReserveRecordListener(ReserveRecordView testView) {
        this.iReserveView = testView;
    }

    public interface ReserveRecordView {
        RefreshCommonView getRefreshCommonView();
    }

    public void setReserveRecordParameter(Object... parameter) {
        orderId = (String) parameter[0];
    }

    public void initReserveRecordDatas() {
        reserveList.clear();
        reserveAdapter = new SimpleAdapter<Camera>(mContext, reserveList, R.layout.item_reserve_record) {
            @Override
            protected void onBindViewHolder(TrdViewHolder holder, final Camera camera) {
                holder.setText(R.id.tv_name,camera.getCamer())
                    .setText(R.id.tv_photot_date,String.format("拍照日期: %s", camera.getPhotodate()))
                    .setText(R.id.tv_price,camera.getPrice() == 0?"免指定费":String.format(String.format("%s元", Double.valueOf(camera.getPrice()))))
                    .setText(R.id.tv_payment_type,"支付方式："+(camera.getPrice() == 0?"免费":"微信支付"))
                    .setText(R.id.tv_reserve_time,String.format("预约时间%s", camera.getBooktime()))
                    .setText(R.id.tv_reserve_number,String.format("交易号%s", camera.getTransactionnumber()))
                    .setText(R.id.tv_payment_time,String.format("付款时间%s", camera.getPaytime()))
                    .setVisible(R.id.tv_reserve_number,camera.getPrice() != 0)
                    .setVisible(R.id.tv_payment_time,camera.getPrice() != 0);
                holder.<RatingBar>getView(R.id.ratingBar).setRating(camera.getScore());
            }
        };
        iReserveView.getRefreshCommonView().setRecyclerViewAdapter(reserveAdapter);
        iReserveView.getRefreshCommonView().setIsLoadMore(false);
        iReserveView.getRefreshCommonView().setRefreshLoadMoreListener(this);
    }

    public void onResultReserveRecordDatas(Object obj){
        finishLoad();
        if (obj==null)
            return;
        OnLineCameraForm cameraForm = (OnLineCameraForm)obj;
        reserveList.addAll(cameraForm.getInfo());
        if (reserveList.isEmpty()) {
            reserveList.clear();
            iReserveView.getRefreshCommonView().setIsEmpty(true);
        } else {
            iReserveView.getRefreshCommonView().setIsEmpty(false);
            iReserveView.getRefreshCommonView().setIsLoadMore(true);
        }
        reserveAdapter.notifyDataSetChanged();
    }

    @Override
    public void startRefresh() {
        reserveList.clear();
        presenter.getReserveRecordList(orderId);
    }

    @Override
    public void startLoadMore() {

    }

    public void finishLoad(){
        iReserveView.getRefreshCommonView().finishRefresh();
        iReserveView.getRefreshCommonView().finishLoadMore();
    }

}
