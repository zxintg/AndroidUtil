package com.zxin.zxinlib.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class CodeKKBean implements Parcelable {

    public String _id;
    public int voteUp;
    //项目下载路径
    public String projectUrl;
    //项目名称
    public String projectName;
    //实例路径
    public String demoUrl;
    //描述
    public String desc;
    //创建时间"2016-12-18T09:37:30.724000"
    public String createTime;
    //更新时间 "2016-12-18T09:37:30.724000"
    public String updateTime;
    //详情地址
    public String codeKKUrl;
    //作者主页
    public String authorUrl;
    //作者名称
    public String authorName;

    public List<KKTagBean> tags;


    protected CodeKKBean(Parcel in) {
        _id = in.readString();
        voteUp = in.readInt();
        projectUrl = in.readString();
        projectName = in.readString();
        demoUrl = in.readString();
        desc = in.readString();
        createTime = in.readString();
        updateTime = in.readString();
        codeKKUrl = in.readString();
        authorUrl = in.readString();
        authorName = in.readString();
        tags = in.createTypedArrayList(KKTagBean.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeInt(voteUp);
        dest.writeString(projectUrl);
        dest.writeString(projectName);
        dest.writeString(demoUrl);
        dest.writeString(desc);
        dest.writeString(createTime);
        dest.writeString(updateTime);
        dest.writeString(codeKKUrl);
        dest.writeString(authorUrl);
        dest.writeString(authorName);
        dest.writeTypedList(tags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CodeKKBean> CREATOR = new Creator<CodeKKBean>() {
        @Override
        public CodeKKBean createFromParcel(Parcel in) {
            return new CodeKKBean(in);
        }

        @Override
        public CodeKKBean[] newArray(int size) {
            return new CodeKKBean[size];
        }
    };
}
