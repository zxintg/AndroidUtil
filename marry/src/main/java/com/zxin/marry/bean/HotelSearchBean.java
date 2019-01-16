package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/6.
 */

public class HotelSearchBean {
    private ArrayList<AreaBean> area;
    private int code;
    private ArrayList<OptionpriceBean> optionprice;
    private ArrayList<OptionsiteBean> optionsite;
    private ArrayList<OptiontableBean> optiontable;

    public ArrayList<AreaBean> getArea() {
        return this.area;
    }

    public int getCode() {
        return this.code;
    }

    public ArrayList<OptionpriceBean> getOptionprice() {
        return this.optionprice;
    }

    public ArrayList<OptionsiteBean> getOptionsite() {
        return this.optionsite;
    }

    public ArrayList<OptiontableBean> getOptiontable() {
        return this.optiontable;
    }

    public void setArea(ArrayList<AreaBean> paramArrayList) {
        this.area = paramArrayList;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setOptionprice(ArrayList<OptionpriceBean> paramArrayList) {
        this.optionprice = paramArrayList;
    }

    public void setOptionsite(ArrayList<OptionsiteBean> paramArrayList) {
        this.optionsite = paramArrayList;
    }

    public void setOptiontable(ArrayList<OptiontableBean> paramArrayList) {
        this.optiontable = paramArrayList;
    }

    public static class AreaBean {
        private String id;
        private String name;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }

    public static class OptionpriceBean {
        private String id;
        private String name;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }

    public static class OptionsiteBean {
        private String id;
        private String name;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }

    public static class OptiontableBean {
        private String id;
        private String name;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }

    public List<Searcher> getSearcherList(){
        List<Searcher> list = new ArrayList<>();
        if (getArea()!=null&&!getArea().isEmpty()){
            Searcher searcher = new Searcher();
            searcher.setTitle("位置区域");
            List<Option> optionList = new ArrayList<>();
            for (AreaBean area : getArea()) {
                Option option = new Option();
                option.setId(area.getId());
                option.setName(area.getName());
                optionList.add(option);
            }
            searcher.setList(optionList);
            list.add(searcher);
        }
        if (getOptionsite()!=null&&!getOptionsite().isEmpty()){
            Searcher searcher = new Searcher();
            searcher.setTitle("场地类型");
            List<Option> optionList = new ArrayList<>();
            for (OptionsiteBean area : getOptionsite()) {
                Option option = new Option();
                option.setId(area.getId());
                option.setName(area.getName());
                optionList.add(option);
            }
            searcher.setList(optionList);
            list.add(searcher);
        }
        if (getOptiontable()!=null&&!getOptiontable().isEmpty()){
            Searcher searcher = new Searcher();
            searcher.setTitle("容纳桌数");
            List<Option> optionList = new ArrayList<>();
            for (OptiontableBean area : getOptiontable()) {
                Option option = new Option();
                option.setId(area.getId());
                option.setName(area.getName());
                optionList.add(option);
            }
            searcher.setList(optionList);
            list.add(searcher);
        }
        if (getOptionprice()!=null&&!getOptionprice().isEmpty()){
            Searcher searcher = new Searcher();
            searcher.setTitle("每桌价格");
            List<Option> optionList = new ArrayList<>();
            for (OptionpriceBean area : getOptionprice()) {
                Option option = new Option();
                option.setId(area.getId());
                option.setName(area.getName());
                optionList.add(option);
            }
            searcher.setList(optionList);
            list.add(searcher);
        }

        return list;
    }

    public class Searcher{
        private String title;
        private List<Option> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Option> getList() {
            return list;
        }

        public void setList(List<Option> list) {
            this.list = list;
        }
    }


    public static class Option{
        private String id;
        private String name;
        private boolean isChecked;

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setName(String paramString) {
            this.name = paramString;
        }
    }

}
