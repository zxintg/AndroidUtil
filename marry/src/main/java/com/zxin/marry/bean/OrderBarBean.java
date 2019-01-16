package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.zxin.marry.base.BaseFragment;
import com.zxin.zxinlib.bean.TitleBean;

/**
 * Created by Administrator on 2018/6/13.
 */

public class OrderBarBean extends TitleBean implements Parcelable{
    //资源文件
    public int labSource;
    public int index;
    public String tag;

    public OrderBarBean() {

    }

    protected OrderBarBean(Parcel in) {
        labSource = in.readInt();
        index = in.readInt();
        tag = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(labSource);
        dest.writeInt(index);
        dest.writeString(tag);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OrderBarBean> CREATOR = new Creator<OrderBarBean>() {
        @Override
        public OrderBarBean createFromParcel(Parcel in) {
            return new OrderBarBean(in);
        }

        @Override
        public OrderBarBean[] newArray(int size) {
            return new OrderBarBean[size];
        }
    };
}
