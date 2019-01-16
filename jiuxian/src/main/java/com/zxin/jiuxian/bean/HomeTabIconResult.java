package com.zxin.jiuxian.bean;

import java.util.List;

public class HomeTabIconResult {
    public String flag;
    public List<IconInfo> navList;

    public static class IconInfo {
        public String lightImg;
        public String logicType;
        public String drakImg;
    }
}
