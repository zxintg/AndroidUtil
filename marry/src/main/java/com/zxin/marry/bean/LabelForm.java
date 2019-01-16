package com.zxin.marry.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */

public class LabelForm {
    private int code;
    private List<Label> data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public List<Label> getData() {
        if (this.data == null) {
            return new ArrayList();
        }
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public static class Label {
        String thclass_id;
        String thclass_name;

        public Label() {
        }

        public Label(String thclass_id, String thclass_name) {
            this.thclass_id = thclass_id;
            this.thclass_name = thclass_name;
        }

        public String getThclass_id() {
            return this.thclass_id;
        }

        public String getThclass_name() {
            return this.thclass_name;
        }
    }
}
