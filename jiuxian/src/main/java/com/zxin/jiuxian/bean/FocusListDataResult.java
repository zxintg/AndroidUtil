package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class FocusListDataResult {
    @JSONField(name = "dataList")
    public List<FocusList> mDataList;
    @JSONField(name = "totalPage")
    public int mTotalPage;
    @JSONField(name = "totalRecord")
    public int mTotalRecord;

    public static class FocusList {
        @JSONField(name = "fansNum")
        public int mFansNum;
        @JSONField(name = "imgPath")
        public String mImgPath;
        @JSONField(name = "isAdmin")
        public boolean mIsAdmin;
        @JSONField(name = "isTalent")
        public boolean mIsTalent;
        @JSONField(name = "level")
        public String mLevel;
        @JSONField(name = "nickName")
        public String mNickName;
        @JSONField(name = "talentNo")
        public int mTalentNo;
        @JSONField(name = "userId")
        public int mUserId;
        @JSONField(name = "userName")
        public String mUserName;
    }
}