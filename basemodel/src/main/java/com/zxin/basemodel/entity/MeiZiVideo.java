package com.zxin.basemodel.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2018/5/11.
 */
@Entity
public class MeiZiVideo {
    @Id(autoincrement = true)
    private Long id;
    //缩略图
    private String thumbUrl;
    //播放地址
    private String videoUrl;
    //昵称
    private String nickname;
    //用户名称
    private String userId;
    //创建时间
    private Long createTime;
    //最近播放时间
    private Long lastTime;
    //话题
    private String topic;
    //Vid
    private int vid;
    //播放次数
    private int playNum;

    @Generated(hash = 1487297628)
    public MeiZiVideo(Long id, String thumbUrl, String videoUrl, String nickname,
            String userId, Long createTime, Long lastTime, String topic, int vid,
            int playNum) {
        this.id = id;
        this.thumbUrl = thumbUrl;
        this.videoUrl = videoUrl;
        this.nickname = nickname;
        this.userId = userId;
        this.createTime = createTime;
        this.lastTime = lastTime;
        this.topic = topic;
        this.vid = vid;
        this.playNum = playNum;
    }

    @Generated(hash = 1039647290)
    public MeiZiVideo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

}
