package com.zxin.basemodel.dao;

import com.zxin.basemodel.app.BaseApplication;
import com.zxin.basemodel.entity.GuanJianZi;
import com.zxin.basemodel.gen.GuanJianZiDao;
import com.zxin.root.bean.GuanJianZiBean;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class GuanJianZiDaoUtil {

    private static volatile GuanJianZiDaoUtil guanJianZiDaoUtil;
    private static GuanJianZiDao guanJianZiDao;

    private GuanJianZiDaoUtil(){}

    public static GuanJianZiDaoUtil getInstance(){
        if (guanJianZiDaoUtil==null){
            synchronized (HttpUrlDaoUtil.class){
                if (guanJianZiDaoUtil==null){
                    guanJianZiDaoUtil = new GuanJianZiDaoUtil();
                }
            }
        }
        if (guanJianZiDao==null)
            guanJianZiDao = BaseApplication.getInstance().getDaoSession().getGuanJianZiDao();
        return guanJianZiDaoUtil;
    }

    /**
     * 增加数据
     */
    public boolean addHttpUrl(String name, String lable, String root, String time) {
        GuanJianZi httpUrl = new GuanJianZi();
        httpUrl.setName(name);
        httpUrl.setLable(lable);
        httpUrl.setRoot(root);
        httpUrl.setTime(time);
        long rowId = guanJianZiDao.insert(httpUrl);//添加一个
        return rowId>0;
    }

    /**
     * 根据主键删除
     */
    public void deleteHttpUrl(long id) {
        guanJianZiDao.deleteByKey(id);
    }

    /**
     * 更改数据
     */
    public void updateHttpUrl(String name, String lable, String root, String time) {
        GuanJianZi httpUrl = new GuanJianZi();
        httpUrl.setName(name);
        httpUrl.setLable(lable);
        httpUrl.setRoot(root);
        httpUrl.setTime(time);
        guanJianZiDao.update(httpUrl);
    }

    /**
     * 查找数据
     */
    public List<GuanJianZiBean> getHttpUrlList() {
        List<GuanJianZiBean> httpUrlList = new ArrayList<>();
        for (GuanJianZi guanJianZi : guanJianZiDao.loadAll()) {
            GuanJianZiBean bean = new GuanJianZiBean();
            bean.id = guanJianZi.getId();
            bean.lable = guanJianZi.getLable();
            bean.name = guanJianZi.getName();
            bean.root = guanJianZi.getRoot();
            bean.time = guanJianZi.getTime();
            httpUrlList.add(bean);
        }
        return httpUrlList;
    }

    /****
     * 获取具体实体
     * @param id
     * @return
     */
    public GuanJianZiBean getHttpUrl(long id){
        GuanJianZiBean bean = new GuanJianZiBean();
        Query query = guanJianZiDao.queryBuilder().where(GuanJianZiDao.Properties.Id.eq(id)).build();
        GuanJianZi httpUrl = (GuanJianZi) query.unique();
        bean.id = httpUrl.getId();
        bean.lable = httpUrl.getLable();
        bean.name = httpUrl.getName();
        bean.root = httpUrl.getRoot();
        bean.time = httpUrl.getTime();
        return bean;
    }

}
