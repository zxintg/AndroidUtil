package com.zxin.basemodel.dao;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zxin.basemodel.app.BaseApplication;
import com.zxin.basemodel.entity.MeiZiCollect;
import com.zxin.basemodel.entity.MeiZiVideo;
import com.zxin.basemodel.gen.MeiZiCollectDao;
import com.zxin.basemodel.gen.MeiZiVideoDao;
import com.zxin.root.util.ToastUtil;

import org.greenrobot.greendao.query.Query;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class MeiZiVideoDaoUtil {

    private static volatile MeiZiVideoDaoUtil meiZiVideoDaoUtil = null;
    private static MeiZiVideoDao meiZiVideoDao;
    private static MeiZiCollectDao meiZiCollectDao;

    private Context mContext;

    private MeiZiVideoDaoUtil(Context mContext) {
        this.mContext = mContext;
    }

    public static MeiZiVideoDaoUtil getInstance(Context mContext) {
        if (meiZiVideoDaoUtil == null) {
            synchronized (MeiZiVideoDaoUtil.class) {
                if (meiZiVideoDaoUtil == null) {
                    meiZiVideoDaoUtil = new MeiZiVideoDaoUtil(mContext);
                }
            }
        }
        if (meiZiVideoDao == null)
            meiZiVideoDao = BaseApplication.getInstance().getDaoSession().getMeiZiVideoDao();
        if (meiZiCollectDao == null)
            meiZiCollectDao = BaseApplication.getInstance().getDaoSession().getMeiZiCollectDao();
        return meiZiVideoDaoUtil;
    }

    /**
     * 增加数据
     */
    public boolean addMeiZiVideo(String thumbUrl, String videoUrl, String nickname, String userId, String topic, int vid) {
        MeiZiVideo meiZiVideo = new MeiZiVideo();
        meiZiVideo.setThumbUrl(thumbUrl);
        meiZiVideo.setVideoUrl(videoUrl);
        meiZiVideo.setNickname(nickname);
        meiZiVideo.setUserId(userId);
        meiZiVideo.setTopic(topic);
        meiZiVideo.setVid(vid);

        Calendar now = Calendar.getInstance();
        long nowLong = now.getTime().getTime();
        meiZiVideo.setCreateTime(nowLong);
        meiZiVideo.setLastTime(nowLong);
        meiZiVideo.setPlayNum(0);

        long rowId = meiZiVideoDao.insert(meiZiVideo);//添加一个
        return rowId > 0;
    }

    public boolean addMeiZiVideoJsonArray(String json) {
        Gson gson = new Gson();
        List<MeiZiVideo> collectList = gson.fromJson(json, new TypeToken<List<MeiZiVideo>>() {
        }.getType());
        if (collectList == null || collectList.isEmpty()) {
            ToastUtil.getInstance(mContext).showShort("视频数据有问题，请检查！");
            return false;
        }
        for (MeiZiVideo meiZiVideo : collectList) {
            long rowId = meiZiVideoDao.insert(meiZiVideo);
            if (rowId > 0)
                continue;
            else {
                ToastUtil.getInstance(mContext).showShort("视频数据有问题，请检查！");
                return false;
            }
        }
        return true;
    }

    public boolean addMeiZiCollectJsonArray(String json) {
        Gson gson = new Gson();
        List<MeiZiCollect> collectList = gson.fromJson(json, new TypeToken<List<MeiZiCollect>>() {
        }.getType());
        if (collectList == null || collectList.isEmpty()) {
            ToastUtil.getInstance(mContext).showShort("收藏数据有问题，请检查！");
            return false;
        }
        for (MeiZiCollect meiZiVideo : collectList) {
            long rowId = meiZiCollectDao.insert(meiZiVideo);
            if (rowId > 0)
                continue;
            else {
                ToastUtil.getInstance(mContext).showShort("收藏数据有问题，请检查！");
                return false;
            }
        }
        return true;
    }

    public MeiZiCollect addMeiZiCollect(int id, String cover, String url, String userName) {
        MeiZiCollect meiZiVideo = new MeiZiCollect();
        meiZiVideo.setId(Long.parseLong(String.valueOf(id)));
        meiZiVideo.setCover(cover);
        meiZiVideo.setUrl(url);
        meiZiVideo.setName(userName);
        meiZiVideo.setCreateTime(Calendar.getInstance().getTime().getTime());
        long rowId = meiZiCollectDao.insert(meiZiVideo);//添加一个
        return rowId > 0 ? meiZiVideo : null;
    }

    /**
     * 根据主键删除
     */
    public void deleteMeiZiVideo(long id) {
        meiZiVideoDao.deleteByKey(id);
    }

    public void deleteMeiZiCollect(long id) {
        meiZiCollectDao.deleteByKey(id);
    }

    /**
     * 更改数据
     */
    public void updateMeiZiVideo(long id, int playNum) {
        MeiZiVideo meiZiVideo = new MeiZiVideo();
        meiZiVideo.setId(id);
        Calendar now = Calendar.getInstance();
        long nowLong = now.getTime().getTime();
        meiZiVideo.setLastTime(nowLong);
        meiZiVideo.setPlayNum(playNum);
        meiZiVideoDao.update(meiZiVideo);
    }

    /**
     * 查找数据
     */
    public List<MeiZiVideo> getMeiZiVideoList(int pageNum, int pageSize) {
        return meiZiVideoDao.queryBuilder().offset(pageNum * pageSize).limit(pageSize).orderAsc(MeiZiVideoDao.Properties.CreateTime).list();
    }

    public String getMeiZiVideoList() {
        return new Gson().toJson(meiZiVideoDao.queryBuilder().orderAsc(MeiZiVideoDao.Properties.CreateTime).list());
    }

    public List<MeiZiCollect> getMeiZiCollectList(int pageNum, int pageSize) {
        return meiZiCollectDao.queryBuilder().offset(pageNum * pageSize).limit(pageSize).orderDesc(MeiZiCollectDao.Properties.CreateTime).list();
    }

    public String getMeiZiCollectList() {
        return new Gson().toJson(meiZiCollectDao.queryBuilder().orderDesc(MeiZiCollectDao.Properties.CreateTime).list());
    }

    /****
     * 获取具体实体
     * @param vid
     * @return
     */
    public MeiZiVideo getMeiZiVideo(long vid) {
        Query query = meiZiVideoDao.queryBuilder().where(MeiZiVideoDao.Properties.Vid.eq(vid)).build();
        MeiZiVideo meizi = (MeiZiVideo) query.unique();
        return meizi;
    }

    public boolean hasMeiZiVideo(long vid) {
        Query query = meiZiVideoDao.queryBuilder().where(MeiZiVideoDao.Properties.Vid.eq(vid)).build();
        return query.unique() != null;
    }

    public MeiZiCollect getMeiZiCollect(String userName) {
        return meiZiCollectDao.queryBuilder().where(MeiZiCollectDao.Properties.Name.eq(userName)).build().unique();
    }

    /*****
     * 更新封面图片
     * @param collect
     */
    public void updateMeiZiCollectImage(MeiZiCollect collect) {
        meiZiCollectDao.update(collect);
    }
}
