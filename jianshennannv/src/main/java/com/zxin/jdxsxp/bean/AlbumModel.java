package com.zxin.jdxsxp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2018/9/5.
 */

public class AlbumModel implements Parcelable{
    private int browseCount;
    private boolean buy;
    private boolean collect;
    private String dsc;
    private String face;
    private boolean focus;
    private int gold;
    private boolean hasCertification;
    private int id;
    private int isVr;
    private String nick;
    private String size;
    private String tagName;
    private int thumbCount;
    private String title;
    private int type;
    private String url;
    private int userId;

    public AlbumModel(OtherUserAlbumModel localTheme) {
        setTitle(localTheme.getTitle());
        setBuy(localTheme.isBuy());
        setCollect(localTheme.isCollect());
        setBrowseCount(localTheme.getBrowseCount());
        setDsc(localTheme.getDsc());
        setFace(localTheme.getFace());
        setFocus(localTheme.isFocus());
        setGold(localTheme.getGold());
        setHasCertification(localTheme.isHasCertification());
        setId(localTheme.getId());
        setIsVr(localTheme.getIsVr());
        setNick(localTheme.getNick());
        setSize(localTheme.getSize());
        setThumbCount(localTheme.getThumbCount());
        setTitle(localTheme.getTitle());
        setType(localTheme.getType());
        setUrl(localTheme.getUrls()!=null?"":localTheme.getUrls().get(0));
        setUserId(localTheme.getUserId());
    }
    
    protected AlbumModel(Parcel in) {
        browseCount = in.readInt();
        buy = in.readByte() != 0;
        collect = in.readByte() != 0;
        dsc = in.readString();
        face = in.readString();
        focus = in.readByte() != 0;
        gold = in.readInt();
        hasCertification = in.readByte() != 0;
        id = in.readInt();
        isVr = in.readInt();
        nick = in.readString();
        size = in.readString();
        tagName = in.readString();
        thumbCount = in.readInt();
        title = in.readString();
        type = in.readInt();
        url = in.readString();
        userId = in.readInt();
    }

    public static final Creator<AlbumModel> CREATOR = new Creator<AlbumModel>() {
        @Override
        public AlbumModel createFromParcel(Parcel in) {
            return new AlbumModel(in);
        }

        @Override
        public AlbumModel[] newArray(int size) {
            return new AlbumModel[size];
        }
    };

    public int getBrowseCount() {
        return this.browseCount;
    }

    public String getDsc() {
        return this.dsc;
    }

    public String getFace() {
        return this.face;
    }

    public int getGold() {
        return this.gold;
    }

    public int getId() {
        return this.id;
    }

    public int getIsVr() {
        return this.isVr;
    }

    public String getNick() {
        return this.nick;
    }

    public String getSize() {
        return this.size;
    }

    public String getTagName() {
        return this.tagName;
    }

    public int getThumbCount() {
        return this.thumbCount;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean isBuy() {
        return this.buy;
    }

    public boolean isCollect() {
        return this.collect;
    }

    public boolean isFocus() {
        return this.focus;
    }

    public boolean isHasCertification() {
        return this.hasCertification;
    }

    public void setBrowseCount(int paramInt) {
        this.browseCount = paramInt;
    }

    public void setBuy(boolean paramBoolean) {
        this.buy = paramBoolean;
    }

    public void setCollect(boolean paramBoolean) {
        this.collect = paramBoolean;
    }

    public void setDsc(String paramString) {
        this.dsc = paramString;
    }

    public void setFace(String paramString) {
        this.face = paramString;
    }

    public void setFocus(boolean paramBoolean) {
        this.focus = paramBoolean;
    }

    public void setGold(int paramInt) {
        this.gold = paramInt;
    }

    public void setHasCertification(boolean paramBoolean) {
        this.hasCertification = paramBoolean;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setIsVr(int paramInt) {
        this.isVr = paramInt;
    }

    public void setNick(String paramString) {
        this.nick = paramString;
    }

    public void setSize(String paramString) {
        this.size = paramString;
    }

    public void setTagName(String paramString) {
        this.tagName = paramString;
    }

    public void setThumbCount(int paramInt) {
        this.thumbCount = paramInt;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setType(int paramInt) {
        this.type = paramInt;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void setUserId(int paramInt) {
        this.userId = paramInt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(browseCount);
        dest.writeByte((byte) (buy ? 1 : 0));
        dest.writeByte((byte) (collect ? 1 : 0));
        dest.writeString(dsc);
        dest.writeString(face);
        dest.writeByte((byte) (focus ? 1 : 0));
        dest.writeInt(gold);
        dest.writeByte((byte) (hasCertification ? 1 : 0));
        dest.writeInt(id);
        dest.writeInt(isVr);
        dest.writeString(nick);
        dest.writeString(size);
        dest.writeString(tagName);
        dest.writeInt(thumbCount);
        dest.writeString(title);
        dest.writeInt(type);
        dest.writeString(url);
        dest.writeInt(userId);
    }
}
