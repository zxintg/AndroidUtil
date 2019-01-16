package com.zxin.jiuxian.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.zxin.jiuxian.util.StringUtils;
import com.zxin.zxinlib.bean.VerticalBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeHeaderResult {
    public List<HeaderData> infoList;

    public class BaseHomeHeaderData {
        public int advId;
        public int modleId;
        public int homeIndex;
        public String indexName;
        public String laceColor;
        public int marginTopNum;
    }

    public class HeaderAd implements Parcelable{
        public static final String ALIGN_LEFT = "1";
        public static final String ALIGN_RIGHT = "2";
        public static final int BAOKUAN_RECOMMENT_FLAG = 1;
        public static final int GUESS_YOU_LIKE_FLAG = 2;
        public static final int TYPE_BKTJ = 1;
        public static final int TYPE_CNXH = 2;
        public int advertisingId;
        public String backUpImg;
        public int dealType;
        public String headImgUrl;
        public String adImg;
        public int advSort;
        public String mJEventId;
        public int jzSourceId;
        public String advertisingName;
        public String adTitle;
        public String nineClickName;
        public String showAlign;
        public int mSource = -1;
        public String adLink;

        protected HeaderAd(Parcel in) {
            advertisingId = in.readInt();
            backUpImg = in.readString();
            dealType = in.readInt();
            headImgUrl = in.readString();
            adImg = in.readString();
            advSort = in.readInt();
            mJEventId = in.readString();
            jzSourceId = in.readInt();
            advertisingName = in.readString();
            adTitle = in.readString();
            nineClickName = in.readString();
            showAlign = in.readString();
            mSource = in.readInt();
            adLink = in.readString();
        }

        public final Creator<HeaderAd> CREATOR = new Creator<HeaderAd>() {
            @Override
            public HeaderAd createFromParcel(Parcel in) {
                return new HeaderAd(in);
            }

            @Override
            public HeaderAd[] newArray(int size) {
                return new HeaderAd[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(advertisingId);
            dest.writeString(backUpImg);
            dest.writeInt(dealType);
            dest.writeString(headImgUrl);
            dest.writeString(adImg);
            dest.writeInt(advSort);
            dest.writeString(mJEventId);
            dest.writeInt(jzSourceId);
            dest.writeString(advertisingName);
            dest.writeString(adTitle);
            dest.writeString(nineClickName);
            dest.writeString(showAlign);
            dest.writeInt(mSource);
            dest.writeString(adLink);
        }
    }

    public class HeaderData extends HomeHeaderResult.BaseHomeHeaderData {
        public List<HomeHeaderResult.HeaderAd> itemList;

        public List<CatePageResult.CateBannerItem> getBannerList(){
            List<CatePageResult.CateBannerItem> list = new ArrayList<>();
            for (HomeHeaderResult.HeaderAd headerAd : itemList){
                CatePageResult.CateBannerItem  banner = new CatePageResult.CateBannerItem();
                banner.adImg = headerAd.adImg;
                banner.adLink = headerAd.adLink;
                banner.adTitle = headerAd.adTitle;
                list.add(banner);
            }
            return list;
        }

        public List<VerticalBanner> getVerBannerList(){
            List<VerticalBanner> mBannerList = new ArrayList<>();
            for (HomeHeaderResult.HeaderAd headerAd : itemList){
                VerticalBanner  banner = new VerticalBanner();
                banner.setTitle(headerAd.adTitle);
                banner.setImageUrl(headerAd.adImg);
                banner.setLineUrl(headerAd.adLink);
                mBannerList.add(banner);
            }
            return mBannerList;
        }
    }

    public class HomeProduct {
        public double jxPrice;
        public int proId;
        public String proImg;
        public String proName;
        public double proPrice;
        public boolean sellOut;

        public String mJEventId;
        public int jzSourceId;
        public String promTitle;
        public int mSource = -1;
    }

    public class Seckill extends HomeHeaderResult.BaseHomeHeaderData {
        public String adLink;
        public String adTitle;
        public int hour;
        public int minute;
        public List<HomeHeaderResult.HomeProduct> proList;
        public int second;
        public String text;
    }

    public Map<Integer,HeaderData> getHomeDatasMap(){
        Map<Integer,HeaderData> result = new HashMap<>();
        for (HeaderData headerData : infoList){
            if (headerData.itemList==null||headerData.itemList.isEmpty())
                continue;
            result.put(headerData.homeIndex,headerData);
        }
        return result;
    }


    public List<Advertising> getAdvertisingList(){
        List<Advertising> adList = new ArrayList<>();

        List<HeaderData> titleList = new ArrayList<>();
        Map<String,HeaderData> adMap = new HashMap<>();
        Map<String,HeaderData> logoMap = new HashMap<>();
        for (HeaderData headerData : infoList){
            headerData.indexName = headerData.indexName.replace("  "," ");
            if (headerData.indexName.endsWith("酒馆标题")){
                titleList.add(headerData);
            }
            if (headerData.indexName.endsWith("酒馆广告位")){
                adMap.put(headerData.indexName,headerData);
            }
            if (headerData.indexName.endsWith("酒馆LOGO")){
                logoMap.put(headerData.indexName,headerData);
            }
        }

        for (HeaderData headerData : titleList){
            Advertising advertising = new Advertising();
            advertising.mTitle = headerData.itemList.get(0);

            String tag = headerData.indexName.split("酒馆标题")[0];
            if (StringUtils.textIsEmpty(tag))
                continue;

            if (adMap.get(tag+"酒馆广告位")==null)
                continue;
            advertising.mDataList = adMap.get(tag+"酒馆广告位").itemList;

            if (logoMap.get(tag+"酒馆LOGO")==null)
                continue;
            advertising.mLogoList = logoMap.get(tag+"酒馆LOGO").itemList;

            adList.add(advertising);
        }

        return adList;
    }

    public class Advertising{
        public HomeHeaderResult.HeaderAd mTitle;
        public List<HomeHeaderResult.HeaderAd> mDataList;
        public List<HomeHeaderResult.HeaderAd> mLogoList;
    }

}
