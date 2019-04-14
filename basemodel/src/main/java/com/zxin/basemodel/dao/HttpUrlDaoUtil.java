package com.zxin.basemodel.dao;

import com.zxin.basemodel.app.BaseApplication;
import com.zxin.basemodel.entity.HttpUrl;
import com.zxin.basemodel.gen.HttpUrlDao;
import com.zxin.root.bean.BasePageBean;
import com.zxin.root.bean.HttpUrlBean;
import com.zxin.root.bean.TitleBean;

import org.greenrobot.greendao.query.Query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/5/11.
 */

public class HttpUrlDaoUtil {

    private static volatile HttpUrlDaoUtil httpUrlDaoUtil;
    private static HttpUrlDao httpUrlDao;


    public static HttpUrlDaoUtil getInstance(){
        if (httpUrlDaoUtil==null){
            synchronized (HttpUrlDaoUtil.class){
                if (httpUrlDaoUtil==null){
                    httpUrlDaoUtil = new HttpUrlDaoUtil();
                }
            }
        }
        httpUrlDao = BaseApplication.getInstance().getDaoSession().getHttpUrlDao();
        return httpUrlDaoUtil;
    }

    /**
     * 增加数据
     */
    public boolean addHttpUrl(String name, String lable,String url) {
        String createTimer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        HttpUrl httpUrl = new HttpUrl();
        httpUrl.setCreateTimer(createTimer);
        httpUrl.setName(name);
        httpUrl.setUrl(url);
        httpUrl.setLastTime(createTimer);
        httpUrl.setTimes(0);
        httpUrl.setIsEffective(1);
        httpUrl.setLable(lable);
        httpUrl.setModifyTime(createTimer);
        httpUrl.setOrderNum(getEffectiveNum());
        long rowId = httpUrlDao.insert(httpUrl);//添加一个
        return rowId>=0;
    }

    /**
     * 根据主键删除
     */
    public void deleteHttpUrl(long id) {
        httpUrlDao.deleteByKey(id);
    }

    /**
     * 更改数据
     */
    public void updateHttpUrl(long id, String name, String lable, String url, boolean checked) {
        HttpUrl httpUrl = getHttpBean(id);
        String createTimer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        httpUrl.setId(id);
        httpUrl.setName(name);
        httpUrl.setUrl(url);
        httpUrl.setLable(lable);
        httpUrl.setModifyTime(createTimer);
        httpUrl.setIsEffective(checked?1:0);
        httpUrlDao.update(httpUrl);
    }

    /*****
     * 更新浏览次数、浏览时间
     * @param id
     */
    public void updateHttpUrlTimes(long id,long times) {
        String createTimer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        HttpUrl httpUrl = getHttpBean(id);
        httpUrl.setId(id);
        httpUrl.setTimes(times);
        httpUrl.setLastTime(createTimer);
        httpUrlDao.update(httpUrl);
    }

    /**
     * 查找数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    public BasePageBean getHttpUrlList(int pageNum, int pageSize) {
        BasePageBean pageBean = new BasePageBean();
        List<HttpUrlBean>  httpUrlList = new ArrayList<>();
        List<HttpUrl> list = httpUrlDao.queryBuilder()
                .orderAsc(HttpUrlDao.Properties.OrderNum)
               .offset((pageNum-1) * pageSize).limit(pageSize).list();
        int count = httpUrlDao.loadAll().size();

        for (HttpUrl httpUrl : list) {
            HttpUrlBean bean = new HttpUrlBean();
            bean.id = httpUrl.getId();
            bean.createTimer = httpUrl.getCreateTimer();
            bean.name = httpUrl.getName();
            bean.lastTime = httpUrl.getLastTime();
            bean.url = httpUrl.getUrl();
            bean.times = httpUrl.getTimes();
            bean.isEffective = httpUrl.getIsEffective();
            httpUrlList.add(bean);
        }
        pageBean.setPageNum(pageNum);
        pageBean.setPageSize(pageSize);
        pageBean.setHasNextPage(list.size()>=pageSize);
        pageBean.setCountSize(count);
        pageBean.setCountPage(count%pageSize==0?count/pageSize:((count/pageSize)+1));
        pageBean.setList(httpUrlList);
        return pageBean;
    }

    /****
     * 获取具体实体
     * @param id
     * @return
     */
    public HttpUrlBean getHttpUrl(long id){
        HttpUrlBean bean = new HttpUrlBean();
        HttpUrl httpUrl = getHttpBean(id);
        bean.id = httpUrl.getId();
        bean.createTimer = httpUrl.getCreateTimer();
        bean.name = httpUrl.getName();
        bean.lastTime = httpUrl.getLastTime();
        bean.url = httpUrl.getUrl();
        bean.times = httpUrl.getTimes();
        bean.lable = httpUrl.getLable();
        bean.modifyTime = httpUrl.getModifyTime();
        bean.orderNum = httpUrl.getOrderNum();
        bean.isEffective = httpUrl.getIsEffective();
        return bean;
    }

    public TitleBean getTitleBean(long id){
        TitleBean title = new TitleBean();
        Query query = httpUrlDao.queryBuilder().where(HttpUrlDao.Properties.Id.eq(id)).build();
        HttpUrl httpUtil = (HttpUrl) query.unique();
        title.id = httpUtil.getId();
        title.label = httpUtil.getLable();
        title.orderNum = httpUtil.getOrderNum();
        title.isEffective = httpUtil.getIsEffective();
        title.lineUrl = httpUtil.getUrl();
        title.title = httpUtil.getName();
        return title;
    }

    public List<TitleBean> getTitleMainList(){
        List<TitleBean> titleList = new ArrayList<>();
        List<HttpUrl> httpList = httpUrlDao.queryBuilder()
                .where(HttpUrlDao.Properties.IsEffective.eq(1), HttpUrlDao.Properties.OrderNum.notEq(-1))
                .orderAsc(HttpUrlDao.Properties.OrderNum).list();
        for (HttpUrl httpUtil : httpList){
            TitleBean title = new TitleBean();
            title.id = httpUtil.getId();
            title.label = httpUtil.getLable();
            title.orderNum = httpUtil.getOrderNum();
            title.isEffective = httpUtil.getIsEffective();
            title.lineUrl = httpUtil.getUrl();
            title.title = httpUtil.getName();
            titleList.add(title);
        }
        return titleList;
    }

    public List<TitleBean> getTitleAllList(){
        List<TitleBean> titleList = new ArrayList<>();
        List<HttpUrl> httpList = httpUrlDao.loadAll();
        for (HttpUrl httpUtil : httpList){
            TitleBean title = new TitleBean();
            title.id = httpUtil.getId();
            title.label = httpUtil.getLable();
            title.orderNum = httpUtil.getOrderNum();
            title.isEffective = httpUtil.getIsEffective();
            title.lineUrl = httpUtil.getUrl();
            title.title = httpUtil.getName();
            titleList.add(title);
        }
        return titleList;
    }

    public void updateHttpEffective(long id,int isEffective,int orderNum){
        String createTimer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        HttpUrl httpUrl = getHttpBean(id);
        httpUrl.setId(id);
        httpUrl.setOrderNum(orderNum);
        httpUrl.setModifyTime(createTimer);
        httpUrl.setIsEffective(isEffective);
        httpUrlDao.update(httpUrl);
    }

    public void updateHttpSelect(long id){
        String createTimer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        HttpUrl httpUrl = getHttpBean(id);
        httpUrl.setId(id);
        httpUrl.setOrderNum(getEffectiveNum());
        httpUrl.setModifyTime(createTimer);
        httpUrl.setIsEffective(1);
        httpUrlDao.update(httpUrl);
    }

    public int getEffectiveNum(){
        HttpUrl httpBean = httpUrlDao.queryBuilder()
                .where(HttpUrlDao.Properties.IsEffective.eq(1), HttpUrlDao.Properties.OrderNum.notEq(-1))
                .orderDesc(HttpUrlDao.Properties.OrderNum).limit(1).unique();
        int orderNum = httpBean==null?0:httpBean.getOrderNum();
        return orderNum==0?0:orderNum+1;
    }

    public HttpUrl getHttpBean(long id){
        return httpUrlDao.queryBuilder().where(HttpUrlDao.Properties.Id.eq(id)).build().unique();
    }

}
