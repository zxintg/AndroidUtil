package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class MarriageCircleForm {
    private int code;
    private Data data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public static class Data {
        private List<RecommendForm.RecommendAdv> adv;
        private List<CircleForm.Circle> circlesindex;
        private List<TopicForm.Theme> themesindex;

        public void setAdv(List<RecommendForm.RecommendAdv> adv) {
            this.adv = adv;
        }

        public void setCirclesindex(List<CircleForm.Circle> circlesindex) {
            this.circlesindex = circlesindex;
        }

        public void setThemesindex(List<TopicForm.Theme> themesindex) {
            this.themesindex = themesindex;
        }

        public List<RecommendForm.RecommendAdv> getAdv() {
            if (this.adv == null) {
                return new ArrayList();
            }
            return this.adv;
        }

        public List<CircleForm.Circle> getCirclesindex() {
            if (this.circlesindex == null) {
                return new ArrayList();
            }
            return this.circlesindex;
        }

        public List<TopicForm.Theme> getThemesindex() {
            if (this.themesindex == null) {
                return new ArrayList();
            }
            return this.themesindex;
        }
    }
}
