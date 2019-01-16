package com.zxin.network.api;

import com.zxin.network.bean.BannerEntity;
import com.zxin.network.bean.GankMeiziResult;
import com.zxin.network.bean.JianDanMeizi;
import com.zxin.network.response.BaseResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ZXinWebApi {

  /**
   * 根据类型查询对应的妹子图
   */
  @GET("{type}/page/{pageNum}")
  Observable<BaseResponse<ResponseBody>> getMeiziTuApi(@Path("type") String type, @Path("pageNum") int pageNum);

  /**
   * 分页查询对应的妹子图
   */
  @GET("{type}/comment-page-{page}#comments")
  Observable<ResponseBody> getHomeMeiziApi(@Path("type") String type, @Path("page") int page);

  /**
   * 根据cid查询不同类型的妹子图片
   */
  @GET("show.htm")
  Observable<ResponseBody> getDoubanMeizi(@Query("cid") int cid, @Query("pager_offset") int pageNum);

  /**
   * gank妹子,福利
   */
  @GET("data/福利/{number}/{page}")
  Observable<GankMeiziResult> getGankMeizi(@Path("number") int number, @Path("page") int page);

  /**
   * 煎蛋妹子请求Api
   * http://jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments&page=
   */
  @GET("?oxwlxojflwblxbsapi=jandan.get_ooxx_comments")
  Observable<JianDanMeizi> getJianDanMeizi(@Query("page") int page);

  //缓存一个小时
  @Headers("Cache-Control: public, max-age=3600")
  @GET("appapi/index/banner/id/1?cmd=home_slider_top&limit=5")
  Observable<BaseResponse<List<BannerEntity>>> getBannerList();

  /**
   * 来自易源接口的花瓣妹子
   */
  @GET("819-1")
  Observable<ResponseBody> getHuaBanMeizi(@Query("num") String num,
                                          @Query("page") String page,
                                          @Query("showapi_appid") String appId,
                                          @Query("type") String type,
                                          @Query("showapi_sign") String sign);

  @GET("api/op/search")
  Observable<ResponseBody>  getCodeKKList(@Query("text") String text,
                                          @Query("page") int page);

  @GET("shanghai/{pageNum}")
  //@Headers("Content-Type:text/html; charset=gbk")
  Observable<ResponseBody>  getYunShangList(@Path("pageNum") int pageNum);


  @GET("code.php")
  Observable<ResponseBody>  getAndroidBusList(@Query("page") int pageNum);
}
