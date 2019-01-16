package com.zxin.meziyowu.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/17.
 */

public class YoMeiDeatilBean {
    public int id;
    public String nickname;
    public int shareNum;
    public String url;
    public int vid;
    public String topic;

    public Avatar avatar;

    public List<YoMeiTag> tags;

    public class Avatar{
        public int height;
        public int width;
        public int id;
        public int sn;
        public String url;
    }

    public class YoMeiTag{
        public int id;
        public int is_love;
        public int isuse;
        public String name;
        public int category;
        public String cdate;
        public String color;
        public int sn;
        public int type;

        public String getColor() {
            return color.contains("#")?color:"#"+color;
        }
    }
}
