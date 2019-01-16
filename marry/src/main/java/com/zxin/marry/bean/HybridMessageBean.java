package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/22.
 */

public class HybridMessageBean implements Parcelable{
    private int code;
    private ArrayList<Info> info;
    private String isread0;
    private String isread1;
    private String message;
    private String page;

    protected HybridMessageBean(Parcel in) {
        code = in.readInt();
        info = in.createTypedArrayList(Info.CREATOR);
        isread0 = in.readString();
        isread1 = in.readString();
        message = in.readString();
        page = in.readString();
    }

    public static final Creator<HybridMessageBean> CREATOR = new Creator<HybridMessageBean>() {
        @Override
        public HybridMessageBean createFromParcel(Parcel in) {
            return new HybridMessageBean(in);
        }

        @Override
        public HybridMessageBean[] newArray(int size) {
            return new HybridMessageBean[size];
        }
    };

    public int getCode() {
        return this.code;
    }

    public ArrayList<Info> getInfo() {
        return this.info;
    }

    public String getIsread0() {
        return this.isread0;
    }

    public String getIsread1() {
        return this.isread1;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPage() {
        return this.page;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setInfo(ArrayList<Info> paramArrayList) {
        this.info = paramArrayList;
    }

    public void setIsread0(String paramString) {
        this.isread0 = paramString;
    }

    public void setIsread1(String paramString) {
        this.isread1 = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setPage(String paramString) {
        this.page = paramString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeTypedList(info);
        dest.writeString(isread0);
        dest.writeString(isread1);
        dest.writeString(message);
        dest.writeString(page);
    }

    public static class Info implements Parcelable {
        private String content;
        private String createtime;
        private String desc;
        private String formatTime;
        private String format_date;
        private String id;
        private String imgsrc;
        private String isread;
        private String istype;
        private String messageid;
        private String messageurl;
        private String orderid;
        private String photodate;
        private String receiveuid;
        private String remarktype;
        private String servicelevel;
        private String shopid;
        private String title;

        protected Info(Parcel in) {
            content = in.readString();
            createtime = in.readString();
            desc = in.readString();
            formatTime = in.readString();
            format_date = in.readString();
            id = in.readString();
            imgsrc = in.readString();
            isread = in.readString();
            istype = in.readString();
            messageid = in.readString();
            messageurl = in.readString();
            orderid = in.readString();
            photodate = in.readString();
            receiveuid = in.readString();
            remarktype = in.readString();
            servicelevel = in.readString();
            shopid = in.readString();
            title = in.readString();
        }

        public static final Creator<Info> CREATOR = new Creator<Info>() {
            @Override
            public Info createFromParcel(Parcel in) {
                return new Info(in);
            }

            @Override
            public Info[] newArray(int size) {
                return new Info[size];
            }
        };

        public String getContent() {
            return this.content;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getFormatTime() {
            return this.formatTime;
        }

        public String getId() {
            return this.id;
        }

        public String getImgsrc() {
            if (this.imgsrc == null) {
                return "";
            }
            return this.imgsrc;
        }

        public String getIsread() {
            return this.isread;
        }

        public String getIstype() {
            return this.istype;
        }

        public String getMessageurl() {
            if (this.messageurl == null) {
                return "";
            }
            return this.messageurl;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getPhotodate() {
            if (this.photodate == null) {
                return "";
            }
            return this.photodate;
        }

        public String getRemarktype() {
            if (this.remarktype == null) {
                return "";
            }
            return this.remarktype;
        }

        public String getServicelevel() {
            if (this.servicelevel == null) {
                return "";
            }
            return this.servicelevel;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getTitle() {
            return this.title;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setImgsrc(String paramString) {
            this.imgsrc = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public String toString() {
            return super.toString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(content);
            dest.writeString(createtime);
            dest.writeString(desc);
            dest.writeString(formatTime);
            dest.writeString(format_date);
            dest.writeString(id);
            dest.writeString(imgsrc);
            dest.writeString(isread);
            dest.writeString(istype);
            dest.writeString(messageid);
            dest.writeString(messageurl);
            dest.writeString(orderid);
            dest.writeString(photodate);
            dest.writeString(receiveuid);
            dest.writeString(remarktype);
            dest.writeString(servicelevel);
            dest.writeString(shopid);
            dest.writeString(title);
        }
    }
}
