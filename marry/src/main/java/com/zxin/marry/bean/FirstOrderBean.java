package com.zxin.marry.bean;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Administrator on 2018/6/19.
 */

public class FirstOrderBean implements Parcelable{
    private String code;
    private List<String> display;
    private EightEntity eight;
    private ElevenEntity eleven;
    private FiveEntity five;
    private FourEntity four;
    private String message;
    private NineEntity nine;
    private OneEntity one;
    private SevenEntity seven;
    private SixEntity six;
    private TenEntity ten;
    private ElevenEntity thirteen;
    private ThreeEntity three;
    private TwoEntity two;

    protected FirstOrderBean(Parcel in) {
        code = in.readString();
        display = in.createStringArrayList();
        message = in.readString();
    }

    public Creator<FirstOrderBean> CREATOR = new Creator<FirstOrderBean>() {
        @Override
        public FirstOrderBean createFromParcel(Parcel in) {
            return new FirstOrderBean(in);
        }

        @Override
        public FirstOrderBean[] newArray(int size) {
            return new FirstOrderBean[size];
        }
    };

    public String getCode() {
        return this.code;
    }

    public List<String> getDisplay() {
        return this.display;
    }

    public EightEntity getEight() {
        return this.eight;
    }

    public ElevenEntity getEleven() {
        return this.eleven;
    }

    public FiveEntity getFive() {
        return this.five;
    }

    public FourEntity getFour() {
        return this.four;
    }

    public String getMessage() {
        return this.message;
    }

    public NineEntity getNine() {
        return this.nine;
    }

    public OneEntity getOne() {
        return this.one;
    }

    public SevenEntity getSeven() {
        return this.seven;
    }

    public SixEntity getSix() {
        return this.six;
    }

    public TenEntity getTen() {
        return this.ten;
    }

    public ElevenEntity getThirteen() {
        return this.thirteen;
    }

    public ThreeEntity getThree() {
        return this.three;
    }

    public TwoEntity getTwo() {
        return this.two;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setDisplay(List<String> paramList) {
        this.display = paramList;
    }

    public void setEight(EightEntity paramEightEntity) {
        this.eight = paramEightEntity;
    }

    public void setEleven(ElevenEntity paramElevenEntity) {
        this.eleven = paramElevenEntity;
    }

    public void setFive(FiveEntity paramFiveEntity) {
        this.five = paramFiveEntity;
    }

    public void setFour(FourEntity paramFourEntity) {
        this.four = paramFourEntity;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setNine(NineEntity paramNineEntity) {
        this.nine = paramNineEntity;
    }

    public void setOne(OneEntity paramOneEntity) {
        this.one = paramOneEntity;
    }

    public void setSeven(SevenEntity paramSevenEntity) {
        this.seven = paramSevenEntity;
    }

    public void setSix(SixEntity paramSixEntity) {
        this.six = paramSixEntity;
    }

    public void setTen(TenEntity paramTenEntity) {
        this.ten = paramTenEntity;
    }

    public void setThree(ThreeEntity paramThreeEntity) {
        this.three = paramThreeEntity;
    }

    public void setTwo(TwoEntity paramTwoEntity) {
        this.two = paramTwoEntity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeStringList(display);
        dest.writeString(message);
    }

    public class EightEntity implements Parcelable{
        private String CompareDate;
        private String CompareDate1;
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String procedureid;
        private String shopid;
        private String status;

        protected EightEntity(Parcel in) {
            CompareDate = in.readString();
            CompareDate1 = in.readString();
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<EightEntity> CREATOR = new Creator<EightEntity>() {
            @Override
            public EightEntity createFromParcel(Parcel in) {
                return new EightEntity(in);
            }

            @Override
            public EightEntity[] newArray(int size) {
                return new EightEntity[size];
            }
        };

        public String getCompareDate() {
            return this.CompareDate;
        }

        public String getCompareDate1() {
            return this.CompareDate1;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCompareDate(String paramString) {
            this.CompareDate = paramString;
        }

        public void setCompareDate1(String paramString) {
            this.CompareDate1 = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(CompareDate);
            dest.writeString(CompareDate1);
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class ElevenEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String orderkey;
        private String procedureid;
        private String shopid;
        private String status;

        protected ElevenEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            orderkey = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<ElevenEntity> CREATOR = new Creator<ElevenEntity>() {
            @Override
            public ElevenEntity createFromParcel(Parcel in) {
                return new ElevenEntity(in);
            }

            @Override
            public ElevenEntity[] newArray(int size) {
                return new ElevenEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getOrderkey() {
            return this.orderkey;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setOrderkey(String paramString) {
            this.orderkey = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(orderkey);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class FiveEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private Object orderkey;
        private String procedureid;
        private String shopid;
        private String status;

        protected FiveEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<FiveEntity> CREATOR = new Creator<FiveEntity>() {
            @Override
            public FiveEntity createFromParcel(Parcel in) {
                return new FiveEntity(in);
            }

            @Override
            public FiveEntity[] newArray(int size) {
                return new FiveEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public Object getOrderkey() {
            return this.orderkey;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setOrderkey(Object paramObject) {
            this.orderkey = paramObject;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class FourEntity implements Parcelable{
        private String bookdressdate;
        private String bookdressdate1;
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String procedureid;
        private String shopid;
        private String status;

        protected FourEntity(Parcel in) {
            bookdressdate = in.readString();
            bookdressdate1 = in.readString();
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<FourEntity> CREATOR = new Creator<FourEntity>() {
            @Override
            public FourEntity createFromParcel(Parcel in) {
                return new FourEntity(in);
            }

            @Override
            public FourEntity[] newArray(int size) {
                return new FourEntity[size];
            }
        };

        public String getBookdressdate() {
            return this.bookdressdate;
        }

        public String getBookdressdate1() {
            return this.bookdressdate1;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setBookdressdate(String paramString) {
            this.bookdressdate = paramString;
        }

        public void setBookdressdate1(String paramString) {
            this.bookdressdate1 = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(bookdressdate);
            dest.writeString(bookdressdate1);
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class NineEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private Object orderkey;
        private String procedureid;
        private String shopid;
        private String status;

        protected NineEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<NineEntity> CREATOR = new Creator<NineEntity>() {
            @Override
            public NineEntity createFromParcel(Parcel in) {
                return new NineEntity(in);
            }

            @Override
            public NineEntity[] newArray(int size) {
                return new NineEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public Object getOrderkey() {
            return this.orderkey;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setOrderkey(Object paramObject) {
            this.orderkey = paramObject;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class OneEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String marrydate;
        private String message;
        private String mname;
        private String mphone;
        private String name;
        private String order_price;
        private String orderid;
        private String orderpayforkey;
        private String procedureid;
        private String s2_name;
        private String shopid;
        private String status;
        private String wname;
        private String wphone;

        protected OneEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            marrydate = in.readString();
            message = in.readString();
            mname = in.readString();
            mphone = in.readString();
            name = in.readString();
            order_price = in.readString();
            orderid = in.readString();
            orderpayforkey = in.readString();
            procedureid = in.readString();
            s2_name = in.readString();
            shopid = in.readString();
            status = in.readString();
            wname = in.readString();
            wphone = in.readString();
        }

        public Creator<OneEntity> CREATOR = new Creator<OneEntity>() {
            @Override
            public OneEntity createFromParcel(Parcel in) {
                return new OneEntity(in);
            }

            @Override
            public OneEntity[] newArray(int size) {
                return new OneEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMarrydate() {
            return this.marrydate;
        }

        public String getMessage() {
            return this.message;
        }

        public String getMname() {
            return this.mname;
        }

        public String getMphone() {
            return this.mphone;
        }

        public String getName() {
            return this.name;
        }

        public String getOrder_price() {
            return this.order_price;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getOrderpayforkey() {
            return this.orderpayforkey;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getS2_name() {
            return this.s2_name;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public String getWname() {
            return this.wname;
        }

        public String getWphone() {
            return this.wphone;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMarrydate(String paramString) {
            this.marrydate = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setMname(String paramString) {
            this.mname = paramString;
        }

        public void setMphone(String paramString) {
            this.mphone = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrder_price(String paramString) {
            this.order_price = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setOrderpayforkey(String paramString) {
            this.orderpayforkey = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setS2_name(String paramString) {
            this.s2_name = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        public void setWname(String paramString) {
            this.wname = paramString;
        }

        public void setWphone(String paramString) {
            this.wphone = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(marrydate);
            dest.writeString(message);
            dest.writeString(mname);
            dest.writeString(mphone);
            dest.writeString(name);
            dest.writeString(order_price);
            dest.writeString(orderid);
            dest.writeString(orderpayforkey);
            dest.writeString(procedureid);
            dest.writeString(s2_name);
            dest.writeString(shopid);
            dest.writeString(status);
            dest.writeString(wname);
            dest.writeString(wphone);
        }
    }

    public class SevenEntity implements Parcelable{
        private String checktruing;
        private String checktruing1;
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String procedureid;
        private String shopid;
        private String status;

        protected SevenEntity(Parcel in) {
            checktruing = in.readString();
            checktruing1 = in.readString();
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<SevenEntity> CREATOR = new Creator<SevenEntity>() {
            @Override
            public SevenEntity createFromParcel(Parcel in) {
                return new SevenEntity(in);
            }

            @Override
            public SevenEntity[] newArray(int size) {
                return new SevenEntity[size];
            }
        };

        public String getChecktruing() {
            return this.checktruing;
        }

        public String getChecktruing1() {
            return this.checktruing1;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setChecktruing(String paramString) {
            this.checktruing = paramString;
        }

        public void setChecktruing1(String paramString) {
            this.checktruing1 = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(checktruing);
            dest.writeString(checktruing1);
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class SixEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String procedureid;
        private String selectphotodate;
        private String selectphotodate1;
        private String shopid;
        private String status;

        protected SixEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            selectphotodate = in.readString();
            selectphotodate1 = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<SixEntity> CREATOR = new Creator<SixEntity>() {
            @Override
            public SixEntity createFromParcel(Parcel in) {
                return new SixEntity(in);
            }

            @Override
            public SixEntity[] newArray(int size) {
                return new SixEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getSelectphotodate() {
            return this.selectphotodate;
        }

        public String getSelectphotodate1() {
            return this.selectphotodate1;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setSelectphotodate(String paramString) {
            this.selectphotodate = paramString;
        }

        public void setSelectphotodate1(String paramString) {
            this.selectphotodate1 = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(selectphotodate);
            dest.writeString(selectphotodate1);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class TenEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String getphotodate;
        private String getphotodate1;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String procedureid;
        private String shopid;
        private String status;

        protected TenEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            getphotodate = in.readString();
            getphotodate1 = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<TenEntity> CREATOR = new Creator<TenEntity>() {
            @Override
            public TenEntity createFromParcel(Parcel in) {
                return new TenEntity(in);
            }

            @Override
            public TenEntity[] newArray(int size) {
                return new TenEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getGetphotodate() {
            return this.getphotodate;
        }

        public String getGetphotodate1() {
            return this.getphotodate1;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setGetphotodate(String paramString) {
            this.getphotodate = paramString;
        }

        public void setGetphotodate1(String paramString) {
            this.getphotodate1 = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(getphotodate);
            dest.writeString(getphotodate1);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class ThreeEntity implements Parcelable{
        private String cameramandname;
        private String cameramandname2;
        private String createtime;
        private int current;
        private String desc;
        private String dressername;
        private String dressername2;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String procedureid;
        private String shopid;
        private String status;

        protected ThreeEntity(Parcel in) {
            cameramandname = in.readString();
            cameramandname2 = in.readString();
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            dressername = in.readString();
            dressername2 = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<ThreeEntity> CREATOR = new Creator<ThreeEntity>() {
            @Override
            public ThreeEntity createFromParcel(Parcel in) {
                return new ThreeEntity(in);
            }

            @Override
            public ThreeEntity[] newArray(int size) {
                return new ThreeEntity[size];
            }
        };

        public String getCameramandname() {
            return this.cameramandname;
        }

        public String getCameramandname2() {
            return this.cameramandname2;
        }

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getDressername() {
            return this.dressername;
        }

        public String getDressername2() {
            return this.dressername2;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCameramandname(String paramString) {
            this.cameramandname = paramString;
        }

        public void setCameramandname2(String paramString) {
            this.cameramandname2 = paramString;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setDressername(String paramString) {
            this.dressername = paramString;
        }

        public void setDressername2(String paramString) {
            this.dressername2 = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(cameramandname);
            dest.writeString(cameramandname2);
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(dressername);
            dest.writeString(dressername2);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }

    public class TwoEntity implements Parcelable{
        private String createtime;
        private int current;
        private String desc;
        private String id;
        private String isdelete;
        private String message;
        private String name;
        private String orderid;
        private String photodate;
        private String photodate1;
        private String procedureid;
        private String shopid;
        private String status;

        protected TwoEntity(Parcel in) {
            createtime = in.readString();
            current = in.readInt();
            desc = in.readString();
            id = in.readString();
            isdelete = in.readString();
            message = in.readString();
            name = in.readString();
            orderid = in.readString();
            photodate = in.readString();
            photodate1 = in.readString();
            procedureid = in.readString();
            shopid = in.readString();
            status = in.readString();
        }

        public Creator<TwoEntity> CREATOR = new Creator<TwoEntity>() {
            @Override
            public TwoEntity createFromParcel(Parcel in) {
                return new TwoEntity(in);
            }

            @Override
            public TwoEntity[] newArray(int size) {
                return new TwoEntity[size];
            }
        };

        public String getCreatetime() {
            return this.createtime;
        }

        public int getCurrent() {
            return this.current;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getId() {
            return this.id;
        }

        public String getIsdelete() {
            return this.isdelete;
        }

        public String getMessage() {
            return this.message;
        }

        public String getName() {
            return this.name;
        }

        public String getOrderid() {
            return this.orderid;
        }

        public String getPhotodate() {
            return this.photodate;
        }

        public String getPhotodate1() {
            return this.photodate1;
        }

        public String getProcedureid() {
            return this.procedureid;
        }

        public String getShopid() {
            return this.shopid;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCreatetime(String paramString) {
            this.createtime = paramString;
        }

        public void setCurrent(int paramInt) {
            this.current = paramInt;
        }

        public void setDesc(String paramString) {
            this.desc = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setIsdelete(String paramString) {
            this.isdelete = paramString;
        }

        public void setMessage(String paramString) {
            this.message = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }

        public void setOrderid(String paramString) {
            this.orderid = paramString;
        }

        public void setPhotodate(String paramString) {
            this.photodate = paramString;
        }

        public void setPhotodate1(String paramString) {
            this.photodate1 = paramString;
        }

        public void setProcedureid(String paramString) {
            this.procedureid = paramString;
        }

        public void setShopid(String paramString) {
            this.shopid = paramString;
        }

        public void setStatus(String paramString) {
            this.status = paramString;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(createtime);
            dest.writeInt(current);
            dest.writeString(desc);
            dest.writeString(id);
            dest.writeString(isdelete);
            dest.writeString(message);
            dest.writeString(name);
            dest.writeString(orderid);
            dest.writeString(photodate);
            dest.writeString(photodate1);
            dest.writeString(procedureid);
            dest.writeString(shopid);
            dest.writeString(status);
        }
    }
}
