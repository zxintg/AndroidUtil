package com.zxin.mvp.model;

import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;
import com.zxin.network.response.BaseResponse;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class TestOneModel extends BaseModel {

   public void getMeiziJsonList(String type,int pageNum){
       getHttpService().getZXinWebApi("http://route.showapi.com/")
               .getHuaBanMeizi("20", String.valueOf(pageNum) , "15314", type, "d424376f51f1467da1b8c75debebf148")
               .subscribeOn(Schedulers.io())
               .observeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new AbsAPICallback<ResponseBody>(getContext(), true) {
                   @Override
                   protected void onDone(ResponseBody strData) {
                       getListener().onSuccess(getTag(),strData);
                   }

                   @Override
                   public void onResultError(ResultException ex) {
                       getListener().onFailure(getTag(),"异常");
                   }
               });
   }

    public void getMeiziHtmlList(int pageNum) {
        getHttpService().getZXinWebApi("http://www.dbmeinv.com/dbgroup/")
                .getDoubanMeizi(7, pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ResponseBody>(getContext(), true) {
                    @Override
                    protected void onDone(ResponseBody strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
}
