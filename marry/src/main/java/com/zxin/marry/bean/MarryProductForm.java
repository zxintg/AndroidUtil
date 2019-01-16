package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class MarryProductForm {
    private int code;
    private Data data;
    private String message;
    private PageDefault pagedefault;

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public PageDefault getPageDefault() {
        return this.pagedefault;
    }

    public static class Data {
        List<RecommendForm.RecommendAdv> adv;
        MarryProductForm.Pic pic;
        List<ShopClassBean.Posts> postsRes;
        List<ShopClassBean.TaoBaoProduct> taobaoke_goods;
        List<MarryProductForm.MarryProductType> taobaoke_goodtypes;

        public MarryProductForm.Pic getPic() {
            return this.pic;
        }

        public List<ShopClassBean.Posts> getPosts() {
            if (this.postsRes == null) {
                return new ArrayList();
            }
            return this.postsRes;
        }

        public List<RecommendForm.RecommendAdv> getRecommend_adv() {
            if (this.adv == null) {
                return new ArrayList();
            }
            return this.adv;
        }

        public List<ShopClassBean.TaoBaoProduct> getTaobaoke_goods() {
            if (this.taobaoke_goods == null) {
                return new ArrayList();
            }
            return this.taobaoke_goods;
        }

        public List<MarryProductType> getTaobaoke_goodtypes() {
            if (this.taobaoke_goodtypes == null) {
                return new ArrayList();
            }
            return this.taobaoke_goodtypes;
        }
    }

    public static class MarryProductType implements Parcelable {
        public static final Parcelable.Creator<MarryProductType> CREATOR = new Parcelable.Creator() {
            public MarryProductForm.MarryProductType createFromParcel(Parcel paramAnonymousParcel) {
                return new MarryProductForm.MarryProductType(paramAnonymousParcel);
            }

            public MarryProductForm.MarryProductType[] newArray(int paramAnonymousInt) {
                return new MarryProductForm.MarryProductType[paramAnonymousInt];
            }
        };
        String id;
        String logo;
        String name;

        public MarryProductType() {
        }

        protected MarryProductType(Parcel paramParcel) {
            this.id = paramParcel.readString();
            this.name = paramParcel.readString();
            this.logo = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getId() {
            return this.id;
        }

        public String getLogo() {
            if (this.logo == null) {
                return "";
            }
            return this.logo;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "MarryProductType{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", logo='" + this.logo + '\'' + '}';
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.id);
            paramParcel.writeString(this.name);
            paramParcel.writeString(this.logo);
        }
    }

    public static class Pic {
        String picurl;
        String title;

        public String getPicurl() {
            return this.picurl;
        }

        public String getTitle() {
            return this.title;
        }
    }
}
