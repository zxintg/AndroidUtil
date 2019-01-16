package com.zxin.marry.mvp.model;

import com.zxin.marry.api.ZXinMarryApi;
import com.zxin.marry.bean.BanquetHallBean;
import com.zxin.marry.bean.BanquetListBean;
import com.zxin.marry.bean.CartListBean;
import com.zxin.marry.bean.DishsListBean;
import com.zxin.marry.bean.HotelCaseBean;
import com.zxin.marry.bean.HotelDetails;
import com.zxin.marry.bean.HotelListBean;
import com.zxin.marry.bean.HotelSearchBean;
import com.zxin.marry.bean.RecommendHotelBean;
import com.zxin.marry.bean.ThreeHotelBean;
import com.zxin.marry.bean.WeddingMainBean;
import com.zxin.network.AbsAPICallback;
import com.zxin.network.exception.ResultException;
import com.zxin.network.mvp.model.BaseModel;

import retrofit2.http.Field;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/18.
 */

public class HotleModel extends BaseModel {

    /******
     * 详情
     */
    public void getFindHotleDetail() {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getFindHotleDetail()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<ThreeHotelBean>(getContext(), true) {
                    @Override
                    protected void onDone(ThreeHotelBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }
    public void getRecommendHotelList(String feastId) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getRecommendHotelList("["+feastId+"]")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<RecommendHotelBean>(getContext(), true) {
                    @Override
                    protected void onDone(RecommendHotelBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getWeddingMain(String feastId) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getWeddingMain("["+feastId+"]")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<WeddingMainBean>(getContext(), true) {
                    @Override
                    protected void onDone(WeddingMainBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getWeddingDetail(String hotelId) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getWeddingDetail(hotelId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<HotelDetails>(getContext(), true) {
                    @Override
                    protected void onDone(HotelDetails strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getHotelList(String feastId,String areaid,String optionsite_id,String price_sort,String optionsiteid,
                             String optiontableid,String optionpriceid,String area_id,String table_max,int pageNum,String pageType,String pagetime) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getHotelList("["+feastId+"]",areaid,optionsite_id,price_sort,optionsiteid,optiontableid,optionpriceid,area_id,table_max,pageNum,pageType,pagetime,"10")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<HotelListBean>(getContext(), true) {
                    @Override
                    protected void onDone(HotelListBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getHoteSearch(String feastId) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getHoteSearch("["+feastId+"]")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<HotelSearchBean>(getContext(), true) {
                    @Override
                    protected void onDone(HotelSearchBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getBanquetHallDetails(String id) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getBanquetHallDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<BanquetHallBean>(getContext(), true) {
                    @Override
                    protected void onDone(BanquetHallBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getBanquetMoreList(String hotelId,int pageNum,String pageType,String pagetime) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getBanquetMoreList(hotelId,pageNum,pageType,pagetime,"10")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<BanquetListBean>(getContext(), true) {
                    @Override
                    protected void onDone(BanquetListBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getCaseMoreList(String hotelId) {
        getHttpService().getZXinMarryApi("http://yl.cgsoft.net/",ZXinMarryApi.class)
                .getCaseMoreList(hotelId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<HotelCaseBean>(getContext(), true) {
                    @Override
                    protected void onDone(HotelCaseBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

    public void getDishsMoreList(String hotelId,int pageNum,String pageType,String pagetime) {
        getHttpService().getZXinMarryApi("http://hotel.jhxms.cn/",ZXinMarryApi.class)
                .getDishsMoreList(hotelId,pageNum,pageType,pagetime,"10")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbsAPICallback<DishsListBean>(getContext(), true) {
                    @Override
                    protected void onDone(DishsListBean strData) {
                        getListener().onSuccess(getTag(),strData);
                    }

                    @Override
                    public void onResultError(ResultException ex) {
                        getListener().onFailure(getTag(),"异常");
                    }
                });
    }

}
