package com.zxin.marry.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/22.
 */

public class CircuitViewPagerBean {
    private int code;
    private Line line;
    private ArrayList<Linescenes> linescenes;
    private String message;

    public int getCode() {
        return this.code;
    }

    public Line getLine() {
        return this.line;
    }

    public ArrayList<Linescenes> getLinescenes() {
        return this.linescenes==null?new ArrayList<Linescenes>():linescenes;
    }

    public String getMessage() {
        if (this.message == null) {
            return "";
        }
        return this.message;
    }

    public class Line {
        private String id;
        private String iscollect;
        private String isdrive;
        private String name;
        private String pic;
        private String text;

        public Line() {

        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getIscollect() {
            if (this.iscollect == null) {
                return "";
            }
            return this.iscollect;
        }

        public String getIsdrive() {
            if (this.isdrive == null) {
                return "";
            }
            return this.isdrive;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public String getPic() {
            if (this.pic == null) {
                return "";
            }
            return this.pic;
        }

        public String getText() {
            if (this.text == null) {
                return "";
            }
            return this.text;
        }
    }

    public class Linescenes {
        private String count;
        private String id;
        private String iscollect;
        private String name;
        private String number;
        private String pic;
        private String sceneid;
        private String text;
        private String url;

        public Linescenes() {
        }

        public String getCount() {
            if (this.count == null) {
                return "0";
            }
            return this.count;
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getIscollect() {
            if (this.iscollect == null) {
                return "";
            }
            return this.iscollect;
        }

        public String getName() {
            if (this.name == null) {
                return "";
            }
            return this.name;
        }

        public String getNumber() {
            if (this.number == null) {
                return "";
            }
            return this.number;
        }

        public String getPic() {
            if (this.pic == null) {
                return "";
            }
            return this.pic;
        }

        public String getSceneid() {
            if (this.sceneid == null) {
                return "";
            }
            return this.sceneid;
        }

        public String getText() {
            if (this.text == null) {
                return "";
            }
            return this.text;
        }

        public String getUrl() {
            if (this.url == null) {
                return "";
            }
            return this.url;
        }

        public void setUrl(String paramString) {
            this.url = paramString;
        }
    }
}
