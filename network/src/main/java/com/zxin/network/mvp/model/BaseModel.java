package com.zxin.network.mvp.model;

import android.content.Context;
import com.zxin.network.MvpCallback;
import com.zxin.network.http.RetrofitHelper;

/**
 * Created by Administrator on 2017/11/27.
 */

public class BaseModel {
    private RetrofitHelper httpService;
    private Context context;

    private MvpCallback listener;
    private int tag;

    public RetrofitHelper getHttpService() {
        if (httpService == null) {
            httpService = RetrofitHelper.getInstance(context);
        }
        return httpService;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MvpCallback getListener() {
        return listener;
    }

    public void setListener(MvpCallback listener) {
        this.listener = listener;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

}
