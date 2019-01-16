package com.zxin.meziyowu.api;

import com.zxin.meziyowu.bean.YoMeiBean;
import com.zxin.meziyowu.bean.YoMeiDeatilBean;
import com.zxin.meziyowu.bean.YoMeiTagModel;
import com.zxin.meziyowu.bean.YoWuResult;
import java.util.List;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface ZXinYoWuApi {

    @GET("v4/list_5/album_data/{type}")
    Observable<List<YoMeiBean>> getWallPaperItemList(
            @Path("type") String type
    );

    @FormUrlEncoded
    @POST("homepage-tag")
    Observable<YoWuResult<List<YoMeiTagModel>>> getHomeTagList(@Field("") String mesg);

    @FormUrlEncoded
    @POST("homepage")
    Observable<YoWuResult<List<YoMeiBean>>> getYoMeiListByTag(@Field("userId") String userId,
                                                      @Field("tagId") int tagId,
                                                      @Field("page") int page);

    @FormUrlEncoded
    @POST("smallvideo/one")
    Observable<YoWuResult<YoMeiDeatilBean>> getYoMeiVideoDetail(
                                                    @Field("userId") String userId,
                                                    @Field("userKey") String userKey,
                                                    @Field("macid") String macid,
                                                    @Field("videoId") int vid);

    @FormUrlEncoded
    @POST("bigv/one")
    Observable<YoWuResult<YoMeiDeatilBean>> getYoMeiDetail(
                                                    @Field("userId") String userId,
                                                    @Field("userKey") String userKey,
                                                    @Field("vid") int vid);

    @FormUrlEncoded
    @POST("smallvideo/list")
    Observable<YoWuResult<List<YoMeiBean>>> getYoMeiDetailList(@Field("vid") int vid,
                                                      @Field("page") int page);
}
