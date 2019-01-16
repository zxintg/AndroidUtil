package com.zxin.marry.bean;

import com.zxin.marry.util.StringUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/12.
 */

public class TaskListCommon {
    private int code;
    private ArrayList<TaskCommon> list;
    private String message;

    public int getCode() {
        return this.code;
    }

    public ArrayList<TaskCommon> getList() {
        if (this.list == null) {
            this.list = new ArrayList();
        }
        return this.list;
    }

    public String getMessage() {
        return this.message;
    }

    public static class TaskCommon {
        private String date;
        private ArrayList<Task> task;
        private String title;

        public String getDate() {
            return StringUtils.textIsEmpty(this.date) ? title : date;
        }

        public ArrayList<Task> getTask() {
            if (this.task == null) {
                this.task = new ArrayList();
            }
            return this.task;
        }

        public String getTitle() {
            return this.title;
        }

        public static class Task {
            private String descr;
            private String downdate;
            private String gettime;
            private String id;
            private int isover;
            private int shopid;
            private int taskchildid;
            private String taskid;
            private String tasktypeid;
            private String title;
            private String typename;
            private String userid;

            public String getDescr() {
                return this.descr;
            }

            public String getDowndate() {
                return this.downdate;
            }

            public String getGettime() {
                return this.gettime;
            }

            public String getId() {
                return this.id;
            }

            public int getIsover() {
                return this.isover;
            }

            public int getShopid() {
                return this.shopid;
            }

            public int getTaskchildid() {
                return this.taskchildid;
            }

            public String getTaskid() {
                return this.taskid;
            }

            public String getTasktypeid() {
                return this.tasktypeid;
            }

            public String getTitle() {
                return this.title;
            }

            public String getTypename() {
                return this.typename;
            }

            public String getUserid() {
                return this.userid;
            }
        }
    }
}
