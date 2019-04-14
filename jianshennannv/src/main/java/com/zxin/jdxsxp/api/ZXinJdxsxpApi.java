package com.zxin.jdxsxp.api;

import com.zxin.jdxsxp.bean.AlbumModel;
import com.zxin.jdxsxp.bean.ArticleListBean;
import com.zxin.jdxsxp.bean.CommentToalModel;
import com.zxin.root.bean.DynamicModel;
import com.zxin.jdxsxp.bean.HomeTagModel;
import com.zxin.jdxsxp.bean.MZPicModle;
import com.zxin.jdxsxp.bean.MeiZuHome;
import com.zxin.jdxsxp.bean.MeiZuHot;
import com.zxin.jdxsxp.bean.MeiZuMeiZiDetail;
import com.zxin.jdxsxp.bean.MeinvBaogaoBean;
import com.zxin.jdxsxp.bean.MinvBaoGaodetail;
import com.zxin.jdxsxp.bean.OtherUserAlbumModel;
import com.zxin.jdxsxp.bean.OtherUserInfoTopModel;
import com.zxin.jdxsxp.bean.SearchBaiduPic;
import com.zxin.jdxsxp.bean.SearchListModel;
import com.zxin.jdxsxp.bean.SearchSouGou;
import com.zxin.jdxsxp.bean.SearchTagModel;
import com.zxin.jdxsxp.bean.UserAlbumModel;
import com.zxin.jdxsxp.bean.UserModel;
import com.zxin.jdxsxp.bean.ViewResult;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

public interface ZXinJdxsxpApi {

    /**
     * 根据类型查询对应的妹子图
     */
    @GET("wallpapers/public/v5.0/index?os=23&mzos=5.0&screen_size=1080x1920&language=zh-CN&locale=cn&country=&imei=861402038611733&sn=A02AECP829IKA&device_model=M1%20E&uid=141507966&firmware=Flyme%205.2.1.5Y&v=5.2.41&vc=22&net=wifi&start=0&max=5")
    Observable<MeiZuHome> getMainMeiZiApi();

    @GET("v3/homepage/vertical?adult=false&did=861402038611733&first=0&order=hot")
    Observable<MeiZuHot> getMainHotApi(
            @Query("limit") int limit,
            @Query("skip") int pageIndex
    );

    @GET("v1/wallpaper/category/4e4d610cdf714d2966000000/album?uid=5af806d8c8cfb77142b2081d&adult=false&first=1&order=new")
    Observable<MeiZuHot> getMeiNvListApi(
            @Query("limit") int limit,
            @Query("skip") int pageIndex
    );

    @GET("v1/wallpaper/album/{id}/wallpaper?adult=false&first=1&order=new")
    Observable<MeiZuMeiZiDetail> getMeiNvDetailApi(
            @Path("id") String id,
            @Query("limit") int limit,
            @Query("skip") int pageIndex
    );

    @GET("search/index?tn=resultjson&ie=utf-8&rn=30")
    Observable<SearchBaiduPic> getFindBaiDuList(
            @Query("word") String word,
            @Query("pn") int pn
    );

    @GET("wallpapers/public/search?os=0&mzos=1.0&screen_size=1x1&language=zh-CN&locale=cn&country=&imei=1&sn=1&device_model=M&firmware=Flyme2.1.2Y&v=5&vc=1&net=wifi&max=30")
    Observable<MZPicModle> getFind360List(
            @Query("q") String word,
            @Query("start") int start
    );

    @GET("pics?mood=0&picformat=0&mode=1&di=0&p=40030500&dp=1&w=05009900&dr=1&_asf=pic.sogou.com&reqType=ajax&tn=0&reqFrom=result")
    Observable<SearchSouGou> getFindSouGouList(
            @Query("query") String word,
            @Query("start") int start
    );

    @GET
    Observable<MinvBaoGaodetail> getPicDetailList(
           @Url String url
    );

    @GET("DesolateV2/getNewTheme")
    Observable<ArticleListBean> getArticleListApi();


    @GET("v4/list_5/album_data/{type}")
    Observable<List<MeinvBaogaoBean>> getWallPaperItemList(
            @Path("type") String type
    );

    @FormUrlEncoded
    @POST("api/home/tag")
    Observable<ViewResult<List<HomeTagModel>>> getHomeTagList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/home/album")
    Observable<ViewResult<List<AlbumModel>>> getHomeList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/user/info")
    Observable<ViewResult<OtherUserInfoTopModel>> getUserInfo(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/userAlbum")
    Observable<ViewResult<List<OtherUserAlbumModel>>> getUserAttenList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/dynamic/user/list")
    Observable<ViewResult<List<DynamicModel>>> getUserDynamicList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/dynamic/list")
    Observable<ViewResult<List<DynamicModel>>> getDynamicList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/user/login")
    Observable<ViewResult<UserModel>> userLogin(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/home/album")
    Observable<ViewResult<List<AlbumModel>>> getVideoItemList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/browse")
    Observable<ViewResult<UserAlbumModel>> getBrowseVideo(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/thumb")
    Observable<ViewResult> updateAlbumThumb(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/comments/list")
    Observable<ViewResult<List<UserAlbumModel>>> getAlbumUserList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/comments/list")
    Observable<ViewResult<CommentToalModel>> getCommentsList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/user/relate")
    Observable<ViewResult> updateUserAtten(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/collect")
    Observable<ViewResult> updateUserCllect(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/search/word/hot")
    Observable<ViewResult<List<SearchTagModel>>> getHotTagsList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/search/list")
    Observable<ViewResult<SearchListModel>> getSearchItemList(
            @Field("req") String json
    );

    @FormUrlEncoded
    @POST("api/album/browse")
    Observable<ViewResult<UserAlbumModel>> getAlbumDetail(
            @Field("token") String token,
            @Field("userId") String userId,
            @Field("req") String json,
            @Field("version") String version,
            @Field("packId") String packId,
            @Field("channel") String channel,
            @Field("os") String os
            );
}
