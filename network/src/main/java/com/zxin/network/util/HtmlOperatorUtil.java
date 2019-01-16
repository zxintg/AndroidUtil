package com.zxin.network.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zxin.network.bean.AndroidBusResultBean;
import com.zxin.network.bean.CodeKKResultBean;
import com.zxin.network.bean.DoubanMeizi;
import com.zxin.network.bean.HuaBanMeizi;
import com.zxin.network.bean.HuaBanMeiziInfo;
import com.zxin.network.bean.MeiziTu;
import com.zxin.network.bean.YunShangResultBean;
import com.zxin.zxinlib.bean.AndroidBusBean;
import com.zxin.zxinlib.bean.CodeKKBean;
import com.zxin.zxinlib.bean.YunShangBean;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;

/**
 * Html页面标签节点处理
 */
public class HtmlOperatorUtil {

    private static volatile HtmlOperatorUtil htmlOperatorUtil;

    public static HtmlOperatorUtil getInstance() {

        if (htmlOperatorUtil == null) {
            synchronized (HtmlOperatorUtil.class) {
                if (htmlOperatorUtil == null) {
                    htmlOperatorUtil = new HtmlOperatorUtil();
                }
            }
        }
        return htmlOperatorUtil;
    }

    /**
     * 解析妹子图html
     */
    public List<MeiziTu> parserMeiziTuHtml(String html, String type) {

        List<MeiziTu> list = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements links = doc.select("li");

        Element aelement;
        Element imgelement;
        for (int i = 7; i < links.size(); i++) {
            imgelement = links.get(i).select("img").first();
            aelement = links.get(i).select("a").first();
            MeiziTu bean = new MeiziTu();
            bean.setOrder(i);

            bean.setTitle(imgelement.attr("alt"));
            bean.setType(type);
            bean.setHeight(354);
            bean.setWidth(236);
            bean.setImageurl(imgelement.attr("data-original"));
            bean.setUrl(aelement.attr("href"));
            bean.setGroupid(url2groupid(bean.getUrl()));
            list.add(bean);
        }
        return list;
    }

    /**
     * 保存豆瓣妹子数据到数据库中
     */
    public List<DoubanMeizi> getDoubanMeiziList(String str) {
        List<DoubanMeizi> datasList = new ArrayList<>();
        try {

            Document parse = Jsoup.parse(str);
            Elements elements = parse.select("div[class=thumbnail]>div[class=img_single]>a>img");
            for (Element e : elements) {
                String src = e.attr("src");
                String title = e.attr("title");

                DoubanMeizi meizi = new DoubanMeizi();
                meizi.setUrl(src);
                meizi.setTitle(title);
                meizi.setType(7);
                datasList.add(meizi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datasList;
    }

    /**
     * 获取妹子图的GroupId
     */
    private int url2groupid(String url) {

        return Integer.parseInt(url.split("/")[3]);
    }

    /**
     * 解析json返回的数据 拼接为集合
     */
    public static HuaBanMeizi createFromJson(String json) {
        HuaBanMeizi result = new Gson().fromJson(json, HuaBanMeizi.class);
        Iterator<Map.Entry<String, JsonElement>> iterator = result.list.entrySet().iterator();
        if (result.infos == null) {
            result.infos = new ArrayList<>();
        }
        while (iterator.hasNext()) {
            Map.Entry<String, JsonElement> element = iterator.next();
            try {
                result.infos.add(new Gson().fromJson(element.getValue(), HuaBanMeiziInfo.class));
            } catch (Exception e) {

            }
        }
        result.list = null;
        return result;
    }

    /****
     * code
     * @param json
     * @return
     */
    public static CodeKKResultBean getCodeKKList(String json){
        try {
            CodeKKResultBean result = new Gson().fromJson(new JSONObject(json).optString("data"), CodeKKResultBean.class);
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /******
     * 云商
     * @param str
     * @return
     */
    public YunShangResultBean getYuShangjiList(String str) {
        YunShangResultBean resultBean = new YunShangResultBean();
        List<YunShangBean> datasList = new ArrayList<>();
        try {
            //Document parse = Jsoup.parse(new String(str.getBytes("GB2312"), "UTF-8"));
            Document parse = Jsoup.parse(str);
            Elements elements = parse.select("div[class=s-list s-pro-list]>ul>li[class=item]");
            for (Element e : elements) {
                YunShangBean bean = new YunShangBean();

                bean.imageUrl = e.getElementsByClass("pic").select("div[class=small-pic]>a>img").attr("src");

                Elements content = e.getElementsByClass("description");
                bean.name = content.select("div[class=til]").select("a").text();
                bean.time = content.select("div[class=til]").select("em").text();

                bean.content = content.select("div[class=info]").text();

                Elements companys = content.select("div[class=company]").select("a");
                for (Element company : companys){
                    bean.product += company.text();
                }


                Elements price = e.getElementsByClass("price").select("div[class=mt15]");
                Elements priceChild = price.first().select("a");
                bean.address = priceChild.first().text()+" "+priceChild.last().text();

                bean.linkUrl = price.last().select("a").first().attr("href");

                bean.call = "18550424957";

                datasList.add(bean);
            }
            resultBean.yunShangList = datasList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBean;
    }

    /*****
     * 安卓BUS
     * @param str
     * @return
     */
    public AndroidBusResultBean getAndroidBusList(String str) {
        AndroidBusResultBean resultBean = new AndroidBusResultBean();
        List<AndroidBusBean> datasList = new ArrayList<>();
        try {
            //Document parse = Jsoup.parse(new String(str.getBytes("GB2312"), "UTF-8"));
            Document parse = Jsoup.parse(str);
            Elements elements = parse.select("div[class=left_content]");
            String[] page = elements.select("div[class=dt]").select("span").text().split("，");//第1页，共352页
            resultBean.pageNum = Integer.parseInt(page[0].substring(1,page[0].length()-1));
            resultBean.totalPage = Integer.parseInt(page[1].substring(1,page[1].length()-1));

            Elements datasHtml = elements.select("div[class=dc]>div[class=dr]");
            for (Element e : datasHtml) {
                AndroidBusBean bean = new AndroidBusBean();
                String baseUrl = "http://www.apkbus.com/";
                bean.linkUrl = baseUrl+e.select("a").attr("href");
                bean.imageUrl = baseUrl+e.select("a>img").attr("src");

                Elements child = e.select("div[class=tr]");
                bean.title = child.select("a>h3").text();

                Elements user = child.select("div[class=info]>div[class=il]");
                bean.headImgUrl = user.select("img").attr("src");
                bean.userNmae = user.select("span").get(0).text();
                if (user.select("span").size()==3) {
                    bean.userLevelUrl = baseUrl + user.select("span").get(1).select("a>img").attr("src");
                    bean.time = user.select("span").get(2).select("i").attr("title");
                }else if (user.select("span").size()==2){
                    bean.time = user.select("span").get(1).select("i").attr("title");
                }

                bean.desc = child.select("div[class=content]").text();
                datasList.add(bean);
            }
            resultBean.androidBusList = datasList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBean;
    }

}
