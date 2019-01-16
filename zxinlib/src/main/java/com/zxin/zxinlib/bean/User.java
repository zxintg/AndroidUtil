package com.zxin.zxinlib.bean;

/**
 * Created by acer on 2017/11/23.
 */

public class User {
    private  String photoUrl;//	用户头像
    private  String mobile;//	手机号码
    private  String nickName;//	用户昵称
    private  String token;//	 登录返回token
    private  String code;//	验证码
    private  String registrationId;//推送id

    public int getIsApplyCourseListen() {
        return isApplyCourseListen;
    }

    public void setIsApplyCourseListen(int isApplyCourseListen) {
        this.isApplyCourseListen = isApplyCourseListen;
    }

    private  int  isApplyCourseListen;//1、否 2、是

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
