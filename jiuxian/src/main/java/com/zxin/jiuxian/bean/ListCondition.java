package com.zxin.jiuxian.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/8/16.
 */

public class ListCondition implements Parcelable{
    public String mAttrsId;
    public String mCateAttrId = "";
    public int mCateCategoryId;
    public double mCateEndPrice;
    public HashMap<String, String> mCateMap;
    public double mCateStartPrice;
    public int mCategoryId;
    public int mCompositeSelect;
    public double mEndPrice;
    public int mFiltrate;
    public HashMap<String, String> mFiltrateMap = new HashMap();
    public boolean mIsFirstIn = true;
    public boolean mIsHaveCondition = false;
    public boolean mIsTopTopic = false;
    public String mKeyWord;
    public String mLastAttrsId;
    public double mLastEndPrice;
    public int mLastPageIndex = 1;
    public double mLastStartPrice;
    public String mOrderBy;
    public int mPageIndex = 1;
    public boolean mRefreshCondition = true;
    public int mSalesVol;
    public double mStartPrice;

    protected ListCondition(Parcel in) {
        mAttrsId = in.readString();
        mCateAttrId = in.readString();
        mCateCategoryId = in.readInt();
        mCateEndPrice = in.readDouble();
        mCateStartPrice = in.readDouble();
        mCategoryId = in.readInt();
        mCompositeSelect = in.readInt();
        mEndPrice = in.readDouble();
        mFiltrate = in.readInt();
        mIsFirstIn = in.readByte() != 0;
        mIsHaveCondition = in.readByte() != 0;
        mIsTopTopic = in.readByte() != 0;
        mKeyWord = in.readString();
        mLastAttrsId = in.readString();
        mLastEndPrice = in.readDouble();
        mLastPageIndex = in.readInt();
        mLastStartPrice = in.readDouble();
        mOrderBy = in.readString();
        mPageIndex = in.readInt();
        mRefreshCondition = in.readByte() != 0;
        mSalesVol = in.readInt();
        mStartPrice = in.readDouble();
    }

    public static final Creator<ListCondition> CREATOR = new Creator<ListCondition>() {
        @Override
        public ListCondition createFromParcel(Parcel in) {
            return new ListCondition(in);
        }

        @Override
        public ListCondition[] newArray(int size) {
            return new ListCondition[size];
        }
    };

    public void init() {
        this.mCateMap = new HashMap();
        this.mFiltrateMap = new HashMap();
        this.mLastPageIndex = 1;
        this.mPageIndex = 1;
        this.mCategoryId = 0;
        this.mAttrsId = "";
        this.mStartPrice = 0.0D;
        this.mEndPrice = 0.0D;
        this.mIsHaveCondition = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAttrsId);
        dest.writeString(mCateAttrId);
        dest.writeInt(mCateCategoryId);
        dest.writeDouble(mCateEndPrice);
        dest.writeDouble(mCateStartPrice);
        dest.writeInt(mCategoryId);
        dest.writeInt(mCompositeSelect);
        dest.writeDouble(mEndPrice);
        dest.writeInt(mFiltrate);
        dest.writeByte((byte) (mIsFirstIn ? 1 : 0));
        dest.writeByte((byte) (mIsHaveCondition ? 1 : 0));
        dest.writeByte((byte) (mIsTopTopic ? 1 : 0));
        dest.writeString(mKeyWord);
        dest.writeString(mLastAttrsId);
        dest.writeDouble(mLastEndPrice);
        dest.writeInt(mLastPageIndex);
        dest.writeDouble(mLastStartPrice);
        dest.writeString(mOrderBy);
        dest.writeInt(mPageIndex);
        dest.writeByte((byte) (mRefreshCondition ? 1 : 0));
        dest.writeInt(mSalesVol);
        dest.writeDouble(mStartPrice);
    }
}
