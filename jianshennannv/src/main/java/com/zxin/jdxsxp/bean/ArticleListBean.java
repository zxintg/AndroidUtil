package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class ArticleListBean {
    private int success;
    private List<DataBean> data;

    public List<DataBean> getData() {
        return this.data;
    }

    public int getSuccess() {
        return this.success;
    }

    public void setData(List<DataBean> paramList) {
        this.data = paramList;
    }

    public void setSuccess(int paramInt) {
        this.success = paramInt;
    }

    public static class DataBean {
        private int commentNum;
        private String content;
        private String createTime;
        private String headImg;
        private int isCollect;
        private int isZam;
        private String nickname;
        private String picSrc;
        private int stateType;
        private int themeId;
        private int themeType;
        private int uid;
        private int zamNum;

        public int getCommentNum() {
            return this.commentNum;
        }

        public String getContent() {
            return this.content;
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public String getHeadImg() {
            return this.headImg;
        }

        public int getIsCollect() {
            return this.isCollect;
        }

        public int getIsZam() {
            return this.isZam;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getPicSrc() {
            return this.picSrc;
        }

        public int getStateType() {
            return this.stateType;
        }

        public int getThemeId() {
            return this.themeId;
        }

        public int getThemeType() {
            return this.themeType;
        }

        public int getUid() {
            return this.uid;
        }

        public int getZamNum() {
            return this.zamNum;
        }

        public void setCommentNum(int paramInt) {
            this.commentNum = paramInt;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void setCreateTime(String paramString) {
            this.createTime = paramString;
        }

        public void setHeadImg(String paramString) {
            this.headImg = paramString;
        }

        public void setIsCollect(int paramInt) {
            this.isCollect = paramInt;
        }

        public void setIsZam(int paramInt) {
            this.isZam = paramInt;
        }

        public void setNickname(String paramString) {
            this.nickname = paramString;
        }

        public void setPicSrc(String paramString) {
            this.picSrc = paramString;
        }

        public void setStateType(int paramInt) {
            this.stateType = paramInt;
        }

        public void setThemeId(int paramInt) {
            this.themeId = paramInt;
        }

        public void setThemeType(int paramInt) {
            this.themeType = paramInt;
        }

        public void setUid(int paramInt) {
            this.uid = paramInt;
        }

        public void setZamNum(int paramInt) {
            this.zamNum = paramInt;
        }
    }
}
