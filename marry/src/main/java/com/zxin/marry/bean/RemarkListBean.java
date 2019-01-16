package com.zxin.marry.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/11.
 */

public class RemarkListBean {
    private String addtime;
    private String code;
    private String comment;
    private String message;
    private ArrayList<MyQustion> question;
    private String questionkey;
    private ArrayList<RemarkBean> remark;
    private ArrayList<ReplyBean> reply;
    private SecondReplyBean secondreply;
    private String username;

    public String getAddtime() {
        return this.addtime;
    }

    public String getCode() {
        return this.code;
    }

    public String getComment() {
        return this.comment;
    }

    public String getMessage() {
        return this.message;
    }

    public ArrayList<MyQustion> getQuestion() {
        return this.question==null?new ArrayList<MyQustion>():question;
    }

    public String getQuestionkey() {
        if (this.questionkey == null) {
            return "";
        }
        return this.questionkey;
    }

    public ArrayList<RemarkBean> getRemark() {
        return this.remark==null?new ArrayList<RemarkBean>():remark;
    }

    public ArrayList<ReplyBean> getReply() {
        return this.reply==null?new ArrayList<ReplyBean>():reply;
    }

    public SecondReplyBean getSecondreply() {
        return this.secondreply;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAddtime(String paramString) {
        this.addtime = paramString;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setComment(String paramString) {
        this.comment = paramString;
    }

    public void setMessage(String paramString) {
        this.message = paramString;
    }

    public void setQuestion(ArrayList<MyQustion> paramArrayList) {
        this.question = paramArrayList;
    }

    public void setQuestionkey(String paramString) {
        this.questionkey = paramString;
    }

    public void setRemark(ArrayList<RemarkBean> paramArrayList) {
        this.remark = paramArrayList;
    }

    public void setReply(ArrayList<ReplyBean> paramArrayList) {
        this.reply = paramArrayList;
    }

    public void setSecondreply(SecondReplyBean paramSecondReplyBean) {
        this.secondreply = paramSecondReplyBean;
    }

    public void setUsername(String paramString) {
        this.username = paramString;
    }

    public static class MyQustion {
        public String content;
        public String id;
        public String maxNumber;
        public String questiontype;
        public String title;
        public ArrayList<ZI> zi;

        public String getContent() {
            if (this.content == null) {
                return "";
            }
            return this.content;
        }

        public String getId() {
            if (this.id == null) {
                return "";
            }
            return this.id;
        }

        public String getMaxNumber() {
            if (this.maxNumber == null) {
                return "300";
            }
            return this.maxNumber;
        }

        public String getQuestiontype() {
            if (this.questiontype == null) {
                return "";
            }
            return this.questiontype;
        }

        public String getTitle() {
            if (this.title == null) {
                return "";
            }
            return this.title;
        }

        public ArrayList<ZI> getZi() {
            return this.zi==null?new ArrayList<ZI>():zi;
        }

        public void setContent(String paramString) {
            this.content = paramString;
        }

        public void setId(String paramString) {
            this.id = paramString;
        }

        public void setMaxNumber(String paramString) {
            this.maxNumber = paramString;
        }

        public void setQuestiontype(String paramString) {
            this.questiontype = paramString;
        }

        public void setTitle(String paramString) {
            this.title = paramString;
        }

        public void setZi(ArrayList<ZI> paramArrayList) {
            this.zi = paramArrayList;
        }

        public static class ZI {
            private String checked;
            private String content;
            private boolean isChecked;
            private String questionzid;

            public String getChecked() {
                if (this.checked == null) {
                    return "";
                }
                return this.checked;
            }

            public String getContent() {
                return this.content;
            }

            public String getQuestionzid() {
                if (this.questionzid == null) {
                    return "";
                }
                return this.questionzid;
            }

            public boolean isChecked() {
                return this.isChecked;
            }

            public void setChecked(String paramString) {
                this.checked = paramString;
            }

            public void setChecked(boolean paramBoolean) {
                this.isChecked = paramBoolean;
            }

            public void setContent(String paramString) {
                this.content = paramString;
            }

            public void setQuestionzid(String paramString) {
                this.questionzid = paramString;
            }
        }
    }
}
