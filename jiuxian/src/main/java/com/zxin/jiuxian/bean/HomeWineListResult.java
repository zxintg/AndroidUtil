package com.zxin.jiuxian.bean;

import java.math.BigDecimal;
import java.util.List;

public class HomeWineListResult {
    public List<HomeWineListItem> list;
    public int pageCount;

    public static class HomeWineListItem {
        public BigDecimal clubPrice;
        public boolean isSelection;
        public boolean isSellOut;
        public double jxPrice;
        public int mPosition;
        public int proId;
        public String proImg;
        public String proName;
        public double proPrice;
        public List<HomeWineListResult.PromotionLableItem> promotionList;
        public boolean showVideoIcon;
    }

    public static class PromotionLableItem {
        public String backColor;
        public String name;
        public int type;
        public String wordColor;
    }
}

