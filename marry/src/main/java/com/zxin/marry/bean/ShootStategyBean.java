package com.zxin.marry.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/20.
 */

public class ShootStategyBean implements Parcelable{
    public static final Parcelable.Creator<ShootStategyBean> CREATOR = new Parcelable.Creator() {
        public ShootStategyBean createFromParcel(Parcel paramAnonymousParcel) {
            return new ShootStategyBean(paramAnonymousParcel);
        }

        public ShootStategyBean[] newArray(int paramAnonymousInt) {
            return new ShootStategyBean[paramAnonymousInt];
        }
    };
    public int code;
    public ArrayList<Date> data;
    public String line;
    public ArrayList<Line> lines;
    public String linetip;
    public String message;
    public Pagedefault pagedefault;
    public String pic;
    public ArrayList<Photo> piclist;
    public Scene scene;
    public Systemset systemset;

    public ShootStategyBean() {
    }

    protected ShootStategyBean(Parcel paramParcel) {
        this.lines = paramParcel.createTypedArrayList(Line.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public ArrayList<Date> getData() {
        return this.data;
    }

    public String getLine() {
        return this.line;
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public String getLinetip() {
        if (this.linetip == null) {
            return "";
        }
        return this.linetip;
    }

    public String getMessage() {
        if (this.message == null) {
            return "";
        }
        return this.message;
    }

    public Pagedefault getPagedefault() {
        return this.pagedefault;
    }

    public String getPic() {
        return this.pic;
    }

    public ArrayList<Photo> getPiclist() {
        return this.piclist;
    }

    public Scene getScene() {
        return this.scene;
    }

    public Systemset getSystemset() {
        return this.systemset;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeTypedList(this.lines);
    }

    public static class Date {
        public String count;
        public String id;
        public String is_collect;
        public String ischioce;
        public String iscollect;
        public String lineid;
        public String name;
        public String number;
        public String pic;
        public String picurl;
        public String text;
        public String type;
        public String typechioce;
        public String url;

        public String getCount() {
            if (this.count == null) {
                return "0";
            }
            return this.count;
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getIs_collect() {
            if (this.is_collect == null) {
                return "";
            }
            return this.is_collect;
        }

        public String getIschioce() {
            if (this.ischioce == null) {
                return "";
            }
            return this.ischioce;
        }

        public String getIscollect() {
            if (this.iscollect == null) {
                return "";
            }
            return this.iscollect;
        }

        public String getLineid() {
            if (this.lineid == null) {
                return "";
            }
            return this.lineid;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public String getNumber() {
            if (this.number == null) {
                return "";
            }
            return this.number;
        }

        public String getPic() {
            if (this.pic == null) {
                return "";
            }
            return this.pic;
        }

        public String getPicurl() {
            if (this.picurl == null) {
                return "";
            }
            return this.picurl;
        }

        public String getText() {
            if (this.text == null) {
                return "";
            }
            return this.text;
        }

        public String getType() {
            if (this.type == null) {
                return "";
            }
            return this.type;
        }

        public String getTypechioce() {
            if (this.typechioce == null) {
                return "1";
            }
            return this.typechioce;
        }

        public String getUrl() {
            if (this.url == null) {
                return "";
            }
            return this.url;
        }

        public void setIs_collect(String paramString) {
            this.is_collect = paramString;
        }

        public void setIschioce(String paramString) {
            this.ischioce = paramString;
        }

        public void setPicurl(String paramString) {
            this.picurl = paramString;
        }

        public void setTypechioce(String paramString) {
            this.typechioce = paramString;
        }

        public void setUrl(String paramString) {
            this.url = paramString;
        }
    }

    public static class Line implements Parcelable {
        public static final Parcelable.Creator<Line> CREATOR = new Parcelable.Creator() {
            public ShootStategyBean.Line createFromParcel(Parcel paramAnonymousParcel) {
                return new ShootStategyBean.Line(paramAnonymousParcel);
            }

            public ShootStategyBean.Line[] newArray(int paramAnonymousInt) {
                return new ShootStategyBean.Line[paramAnonymousInt];
            }
        };
        private String id;
        private String isdrive;
        private String name;

        protected Line(Parcel paramParcel) {
            this.id = paramParcel.readString();
            this.name = paramParcel.readString();
            this.isdrive = paramParcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getIsdrive() {
            if (this.isdrive == null) {
                return "";
            }
            return this.isdrive;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeString(this.id);
            paramParcel.writeString(this.name);
            paramParcel.writeString(this.isdrive);
        }
    }

    public class Pagedefault {
        public int page;
        public String pagenumber;
        public String pagetime;

        public Pagedefault() {
        }

        public int getPage() {
            return this.page;
        }

        public String getPagenumber() {
            if (this.pagenumber == null) {
                return "";
            }
            return this.pagenumber;
        }

        public String getPagetime() {
            if (this.pagetime == null) {
                return "";
            }
            return this.pagetime;
        }

        public void setPage(int paramInt) {
            this.page = paramInt;
        }

        public void setPagenumber(String paramString) {
            this.pagenumber = paramString;
        }

        public void setPagetime(String paramString) {
            this.pagetime = paramString;
        }
    }

    public class Photo {
        public String id;
        public String is_collect;
        public String picurl;
        public String sceneid;

        public Photo() {
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getIs_collect() {
            if (this.is_collect == null) {
                return "";
            }
            return this.is_collect;
        }

        public String getPicurl() {
            if (this.picurl == null) {
                return "";
            }
            return this.picurl;
        }

        public String getSceneid() {
            if (this.sceneid == null) {
                return "";
            }
            return this.sceneid;
        }

        public void setIs_collect(String paramString) {
            this.is_collect = paramString;
        }
    }

    public class Scene {
        public String id;
        public String name;
        public String number;
        public String pic;
        public String text;
        public String type;

        public Scene() {
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public String getNumber() {
            if (this.number == null) {
                return "0";
            }
            return this.number;
        }

        public String getPic() {
            if (this.pic == null) {
                return "";
            }
            return this.pic;
        }

        public String getText() {
            if (this.text == null) {
                return "";
            }
            return this.text;
        }

        public String getType() {
            if (this.type == null) {
                return "";
            }
            return this.type;
        }
    }

    public class Systemset {
        public String raiders_applogo;
        public String raiders_linelogo;
        public String raiders_scenelogo;

        public Systemset() {
        }

        public String getRaiders_applogo() {
            if (this.raiders_applogo == null) {
                return "";
            }
            return this.raiders_applogo;
        }

        public String getRaiders_linelogo() {
            if (this.raiders_linelogo == null) {
                return "";
            }
            return this.raiders_linelogo;
        }

        public String getRaiders_scenelogo() {
            if (this.raiders_scenelogo == null) {
                return "";
            }
            return this.raiders_scenelogo;
        }
    }
}
