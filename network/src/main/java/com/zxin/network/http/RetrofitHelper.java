package com.zxin.network.http;

import android.content.Context;

import com.zxin.network.api.ZXinWebApi;
import com.zxin.network.interceptor.CommonParamsInterceptor;
import com.zxin.network.interceptor.HttpCacheInterceptor;
import com.zxin.network.interceptor.HttpHeaderInterceptor;
import com.zxin.network.response.ResponseConverterFactory;
import com.zxin.network.util.NetworkUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {
    private static final int DEFAULT_TIME_OUT = 10;//超时时间5s
    private static final int DEFAULT_READ_TIME_OUT = 10;//读取时间
    private static final int DEFAULT_WRITE_TIME_OUT = 10;//读取时间
    private static OkHttpClient mOkHttpClient;
    private static RetrofitHelper retrofitHelper;
    private static Context mContext;

    /****
     * 初始化
     * @param context
     * @return
     */
    public static RetrofitHelper getInstance(Context context) {
        if (retrofitHelper == null) {
            retrofitHelper = new RetrofitHelper();
        }
        mContext = context;
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {
                    //设置Http缓存
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
                    builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
                    builder.writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS);
                    //builder.addInterceptor(addHeaderInterceptor()); // token过滤
                    builder.addInterceptor(addCacheInterceptor());//缓存信息
                    addInterceptor(builder);
                    mOkHttpClient = builder.build();
                }
            }
        }
        return retrofitHelper;
    }

    /**
     *
     */
    public ZXinWebApi getZXinWebApi(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                //.addConverterFactory(ResponseConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(ZXinWebApi.class);
    }

    public <Api> Api getZXinMarryApi(String baseUrl, Class<Api>  service) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(ResponseConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public <Api> Api getZXinJiuXianApi(String baseUrl, Class<Api> service) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(ResponseConverterFactory.create("JiuXian"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public <Api> Api getZXinJdxsxpApi(String baseUrl, Class<Api> service) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(ResponseConverterFactory.create("Jdxsxp"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    public <Api> Api getZXinMeiZiYoWuApi(String baseUrl, Class<Api> service) {

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(ResponseConverterFactory.create("MeiZiYoWu"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(service);

    }

    /**
     * 添加各种拦截器
     *
     * @param builder
     */
    private static void addInterceptor(OkHttpClient.Builder builder) {
        // 添加日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpHeaderInterceptor httpHeaderInterceptor = new HttpHeaderInterceptor.Builder().build();
        //日志拦截
        builder.addInterceptor(loggingInterceptor);
        //头部参数拦截
        builder.addInterceptor(httpHeaderInterceptor);
        //缓存拦截
        builder.addInterceptor(new HttpCacheInterceptor(mContext));
        //请求参数拦截
        builder.addInterceptor(new CommonParamsInterceptor());
    }

    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetworkUtil.isNetWorkAviliable(mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetworkUtil.isNetWorkAviliable(mContext)) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周  只对get有用,post没有缓冲
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" +
                                    maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }

}
