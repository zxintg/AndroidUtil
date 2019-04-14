package com.zxin.sources.mvp.view;

import android.content.Context;
import android.view.View;
import com.zxin.basemodel.util.HtmlJumpUtil;
import com.zxin.network.bean.CodeKKResultBean;
import com.zxin.network.mvp.presenter.BasePresenter;
import com.zxin.network.mvp.view.IBaseView;
import com.zxin.sources.R;
import com.zxin.sources.mvp.presenter.CodeKKPresenter;
import com.zxin.root.adapter.simple.SimpleAdapter;
import com.zxin.root.adapter.simple.TrdViewHolder;
import com.zxin.root.bean.CodeKKBean;
import com.zxin.root.bean.TitleBean;
import com.zxin.root.view.CommonCrosswiseBar;
import com.zxin.root.view.RefreshCommonView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class CodeKKContract implements IBaseView,RefreshCommonView.RefreshLoadMoreListener{
    private SimpleAdapter adapter;
    private List<CodeKKBean> codeKKList = new ArrayList<>();
    private Context mContext;
    private TitleBean titleBean;

    @Override
    public void setParameter(Object... parameter) {
        titleBean = (TitleBean) parameter[0];
    }

    @Override
    public void initDatas() {
        adapter = new SimpleAdapter<CodeKKBean>(mContext, codeKKList, R.layout.item_codekk) {
            @Override
            protected void onBindViewHolder(final TrdViewHolder holder, final CodeKKBean data) {
                holder.setText(R.id.item_codekk_title, data.projectName)
                        .setText(R.id.item_codekk_content,data.desc)
                        .setText(R.id.item_codekk_projecturl,data.projectUrl)
                        .<CommonCrosswiseBar>getView(R.id.item_codekk_createtime).setRightText(data.createTime.split("T")[0]);
                holder.setOnClickListener(R.id.item_codekk_projecturl, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HtmlJumpUtil.toWebForUrlActivity(data.projectName,data.projectUrl);
                    }
                });
            }
        };
        iView.getRecyclerView().setRecyclerViewAdapter(adapter);
        iView.getRecyclerView().setIsAutoLoad(false);
        iView.getRecyclerView().setRefreshLoadMoreListener(this);
    }

    @Override
    public void loadDatas() {
        iView.getRecyclerView().notifyData();
    }

    @Override
    public void onResultSuccess(Object bean) {
        finishLoad();
        if (bean==null)
            return;
        CodeKKResultBean codeKK = (CodeKKResultBean) bean;
        codeKKList.addAll(codeKK.projectArray);
        if (codeKKList.isEmpty()) {
            codeKKList.clear();
            iView.getRecyclerView().setIsEmpty(true);
        } else {
            iView.getRecyclerView().setIsEmpty(false);
            iView.getRecyclerView().setIsLoadMore(codeKK.pageSize*pageNum<codeKK.totalCount);
        }
        adapter.notifyDataSetChanged();
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

    private CodeKKPresenter presenter;
    @Override
    public void setP(BasePresenter... basePresenter) {
        presenter = (CodeKKPresenter) basePresenter[0];
    }

    @Override
    public void OnClick(View v) {

    }

    private int pageNum = 1;
    @Override
    public void startRefresh() {
        pageNum = 1;
        codeKKList.clear();
        presenter.getTestMeiZi(titleBean.label,pageNum);
    }

    @Override
    public void startLoadMore() {
        pageNum++;
        presenter.getTestMeiZi(titleBean.label,pageNum);
    }


    private CodeView iView;

    public void setCodeViewListener(CodeView testView){
        this.iView = testView;
    }
    public interface CodeView{
        RefreshCommonView getRecyclerView();
    }

    public void finishLoad(){
        iView.getRecyclerView().finishRefresh();
        iView.getRecyclerView().finishLoadMore();
    }
}
