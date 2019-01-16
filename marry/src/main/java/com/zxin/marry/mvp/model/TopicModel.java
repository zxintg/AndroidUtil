package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.ArticlesBean;
import com.zxin.marry.bean.PostsInfoBean;
import com.zxin.marry.bean.TermsBean;
import com.zxin.marry.bean.TopicDetailForm;
import com.zxin.marry.bean.TopicForm;
import com.zxin.marry.bean.UserCommon;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import com.zxin.zxinlib.util.SharedPreferencesManager;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class TopicModel extends BaseModel {

    /******
     * 详情
     */
    public void getTopicDetail(String uid, String themeId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getTopicDetail(uid, themeId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<TopicDetailForm>(getContext(), true) {
                    @Override
                    protected void onDone(TopicDetailForm strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }


    public void getMineTopicList(String uid, String type, String pagetype, int pageNum, String pagetime) {
        if (type.equals("index"))
            getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                    .getMineTopicList1(uid, pageNum, pagetype, pagetime, "10")
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new AbsAPICallback<TopicForm>(getContext(), true) {
                        @Override
                        protected void onDone(TopicForm strData) {
                            getListener().onSuccess(getTag(), strData);
                        }

                        @Override
                        public void onResultError(ResultException ex) {
                            getListener().onFailure(getTag(), "异常");
                        }
                    });
        else
            getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                    .getMineTopicList2(uid, pageNum, pagetype, pagetime, "10")
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new AbsAPICallback<TopicForm>(getContext(), true) {
                        @Override
                        protected void onDone(TopicForm strData) {
                            getListener().onSuccess(getTag(), strData);
                        }

                        @Override
                        public void onResultError(ResultException ex) {
                            getListener().onFailure(getTag(), "异常");
                        }
                    });
    }

    public void getPostsInfo(String posts_id) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getPostsInfo(posts_id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<PostsInfoBean>(getContext(), true) {
                    @Override
                    protected void onDone(PostsInfoBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }

    public void getHontNewsMenus() {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getHotNewsMenus()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<TermsBean>(getContext(), true) {
                    @Override
                    protected void onDone(TermsBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }


    public void getHontNewsList(String term_id,int pageNum,String pagetype,String pagetime) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/", ZXinMarryApi.class)
                .getHontNewsList(term_id, pageNum, pagetype, pagetime, "10")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ArticlesBean>(getContext(), true) {
                    @Override
                    protected void onDone(ArticlesBean strData) {
                        getListener().onSuccess(getTag(), strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(), "异常");
                    }
                });
    }
}
