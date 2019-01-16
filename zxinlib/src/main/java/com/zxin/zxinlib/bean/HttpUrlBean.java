package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/5/11.
 */

public class HttpUrlBean implements Parcelable {
    public long id;
    //创建时间
    public String createTimer;
    //标签
    public String lable;
    //标题
    public String name;
    //连接地址
    public String url;
    //最后一次浏览时间
    public String lastTime;
    //浏览次数
    public long times;
    //排序顺序(-1:无序，大于0的均有效)
    public int orderNum;
    //是否有效(1：有效 0：无效)
    public int isEffective;
    //修改时间
    public String modifyTime;

    public HttpUrlBean() {

    }

    protected HttpUrlBean(Parcel in) {
        id = in.readLong();
        createTimer = in.readString();
        lable = in.readString();
        name = in.readString();
        url = in.readString();
        lastTime = in.readString();
        times = in.readLong();
        orderNum = in.readInt();
        isEffective = in.readInt();
        modifyTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(createTimer);
        dest.writeString(lable);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(lastTime);
        dest.writeLong(times);
        dest.writeInt(orderNum);
        dest.writeInt(isEffective);
        dest.writeString(modifyTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HttpUrlBean> CREATOR = new Creator<HttpUrlBean>() {
        @Override
        public HttpUrlBean createFromParcel(Parcel in) {
            return new HttpUrlBean(in);
        }

        @Override
        public HttpUrlBean[] newArray(int size) {
            return new HttpUrlBean[size];
        }
    };
}
