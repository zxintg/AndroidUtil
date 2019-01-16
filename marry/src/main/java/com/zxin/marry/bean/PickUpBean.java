package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */

public class PickUpBean {
    private String code;
    private List<InfoEntity> info;
    private String message;

    public String getCode() {
        return this.code;
    }

    public List<InfoEntity> getInfo() {
        return this.info;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setInfo(List<InfoEntity> paramList) {
        this.info = paramList;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public static class InfoEntity implements Parcelable {
        private String goodname;
        private String goodsizename;
        private int isin;
        private int isout;
        private String number;
        private String unittype;

        protected InfoEntity(Parcel in) {
            goodname = in.readString();
            goodsizename = in.readString();
            isin = in.readInt();
            isout = in.readInt();
            number = in.readString();
            unittype = in.readString();
        }

        public static final Creator<InfoEntity> CREATOR = new Creator<InfoEntity>() {
            @Override
            public InfoEntity createFromParcel(Parcel in) {
                return new InfoEntity(in);
            }

            @Override
            public InfoEntity[] newArray(int size) {
                return new InfoEntity[size];
            }
        };

        public String getGoodname() {
            return this.goodname;
        }

        public String getGoodsizename() {
            return this.goodsizename;
        }

        public int getIsin() {
            return this.isin;
        }

        public int getIsout() {
            return this.isout;
        }

        public String getNumber() {
            return this.number;
        }

        public String getUnittype() {
            return this.unittype;
        }

        public void setGoodname(String paramString) {
            this.goodname = paramString;
        }

        public void setGoodsizename(String paramString) {
            this.goodsizename = paramString;
        }

        public void setIsin(int paramInt) {
            this.isin = paramInt;
        }

        public void setIsout(int paramInt) {
            this.isout = paramInt;
        }

        public void setNumber(String paramString) {
            this.number = paramString;
        }

        public void setUnittype(String paramString) {
            this.unittype = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(goodname);
            dest.writeString(goodsizename);
            dest.writeInt(isin);
            dest.writeInt(isout);
            dest.writeString(number);
            dest.writeString(unittype);
        }
    }
}
