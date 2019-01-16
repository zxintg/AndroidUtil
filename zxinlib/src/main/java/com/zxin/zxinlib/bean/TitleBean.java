package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/5/16.
 */

public class TitleBean implements Parcelable{
    //主键
    public long id;
    public String id2;
    //标签
    public String label;
    //标题
    public String title;
    //连接地址
    public String lineUrl;
    //排序顺序(-1:无序，大于0的均有效)
    public int orderNum;
    //是否有效(1：有效 0：无效)
    public int isEffective;
    //资源
    public int labImage;
    public int labImage2;
    //图片路径
    public String url;

    public TitleBean() {

    }

    protected TitleBean(Parcel in) {
        id = in.readLong();
        id2 = in.readString();
        label = in.readString();
        title = in.readString();
        lineUrl = in.readString();
        orderNum = in.readInt();
        isEffective = in.readInt();
        labImage = in.readInt();
        labImage2 = in.readInt();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(id2);
        dest.writeString(label);
        dest.writeString(title);
        dest.writeString(lineUrl);
        dest.writeInt(orderNum);
        dest.writeInt(isEffective);
        dest.writeInt(labImage);
        dest.writeInt(labImage2);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TitleBean> CREATOR = new Creator<TitleBean>() {
        @Override
        public TitleBean createFromParcel(Parcel in) {
            return new TitleBean(in);
        }

        @Override
        public TitleBean[] newArray(int size) {
            return new TitleBean[size];
        }
    };
}
