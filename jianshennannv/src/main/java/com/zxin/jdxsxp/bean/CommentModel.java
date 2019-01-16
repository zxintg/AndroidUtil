package com.zxin.jdxsxp.bean;

/**
 * Created by Administrator on 2018/9/6.
 */

public class CommentModel {
    private int albumId;
    private int commentId;
    private String content;
    private int dynamicId;
    private String face;
    private int gameId;
    private boolean hasCertification;
    private int id;
    private String nick;
    private String toNick;
    private int toUserId;
    private byte type;
    private int userId;

    public int getAlbumId() {
        return this.albumId;
    }

    public int getCommentId() {
        return this.commentId;
    }

    public String getContent() {
        return this.content;
    }

    public int getDynamicId() {
        return this.dynamicId;
    }

    public String getFace() {
        return this.face;
    }

    public int getGameId() {
        return this.gameId;
    }

    public int getId() {
        return this.id;
    }

    public String getNick() {
        return this.nick;
    }

    public String getToNick() {
        return this.toNick;
    }

    public int getToUserId() {
        return this.toUserId;
    }

    public byte getType() {
        return this.type;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean isHasCertification() {
        return this.hasCertification;
    }

    public void setAlbumId(int paramInt) {
        this.albumId = paramInt;
    }

    public void setCommentId(int paramInt) {
        this.commentId = paramInt;
    }

    public void setContent(String paramString) {
        this.content = paramString;
    }

    public void setDynamicId(int paramInt) {
        this.dynamicId = paramInt;
    }

    public void setFace(String paramString) {
        this.face = paramString;
    }

    public void setGameId(int paramInt) {
        this.gameId = paramInt;
    }

    public void setHasCertification(boolean paramBoolean) {
        this.hasCertification = paramBoolean;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setNick(String paramString) {
        this.nick = paramString;
    }

    public void setToNick(String paramString) {
        this.toNick = paramString;
    }

    public void setToUserId(int paramInt) {
        this.toUserId = paramInt;
    }

    public void setType(byte paramByte) {
        this.type = paramByte;
    }

    public void setUserId(int paramInt) {
        this.userId = paramInt;
    }
}
