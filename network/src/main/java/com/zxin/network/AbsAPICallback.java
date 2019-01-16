package com.zxin.network;

import android.content.Context;
import android.net.ParseException;
import android.util.Log;
import com.google.gson.JsonParseException;
import com.zxin.network.exception.ResultException;
import com.zxin.zxinlib.util.ToastUtil;
import com.zxin.zxinlib.view.dialog.ProgressBarDialog;
import org.json.JSONException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by hy on 2017/10/19.
 */
public abstract class AbsAPICallback<T> extends Subscriber<T> {
    protected Context mContext;
    private ProgressBarDialog dialog = null;

    public AbsAPICallback(Context context, boolean isLoadProgress) {
        this.mContext = context;
        if(isLoadProgress && dialog == null){
            dialog = new ProgressBarDialog(context);
        }
        if(isLoadProgress && dialog!=null){
            dialog.showProgress();
        }
    }

    @Override
    public void onError(Throwable e) {
        if(dialog!=null&&dialog.isShowing()){
            dialog.closeProgress();
        }
        Log.e("e", "httpException = " + e);
        Throwable throwable = e;
        //获取最根源的异常
        while (throwable.getCause() != null) {
            e = throwable;
            throwable = throwable.getCause();
        }
        if (e instanceof HttpException) {//HTTP错误
            HttpException httpException = (HttpException) e;
            switch (httpException.code()) {

                case -1:
                    ToastUtil.showShort(httpException.getMessage());
                    break;

                default:
                    Log.e("e", "HTTP错误");
                    break;
            }
        } else if (e instanceof SocketTimeoutException) {

        } else if (e instanceof ResultException) {//服务器返回的错误
            ResultException resultException = (ResultException) e;
            switchError(resultException);
            Log.e("e", "resultException = " + resultException.getMessage() + "----erroer = " + resultException.getErrCode());
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            Log.e("e", "json解析异常！");
        } else if (e instanceof ConnectException) {
            ResultException resultException = new ResultException(0, "ConnectException");
            onResultError(resultException);
        }
    }

    /**
     * 服务器返回的错误
     */
    protected abstract void onResultError(ResultException ex);

    protected abstract void onDone(T t);

    @Override
    public void onCompleted() {
        if(dialog!=null&&dialog.isShowing()){
            dialog.closeProgress();
        }
    }

    private void switchError(ResultException resultException) {
        switch (resultException.getErrCode()) {
            default:
                onResultError(resultException);
                break;

        }
    }

    @Override
    public void onNext(T tBaseResponse) {
        if(dialog!=null&&dialog.isShowing()){
            dialog.closeProgress();
        }
        onDone(tBaseResponse);
    }
}
