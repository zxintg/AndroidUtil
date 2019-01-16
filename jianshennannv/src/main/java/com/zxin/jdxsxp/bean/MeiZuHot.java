package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/30.
 */

public class MeiZuHot {
    private int code;
    private String msg;
    private ResBean res;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public ResBean getRes() {
        return this.res;
    }

    public void setCode(int paramInt) {
        this.code = paramInt;
    }

    public void setMsg(String paramString) {
        this.msg = paramString;
    }

    public void setRes(ResBean paramResBean) {
        this.res = paramResBean;
    }

    public static class ResBean {
        private AlertBean alert;
        private List<?> banner;
        private List<?> homepage;
        private List<VerticalBean> vertical;
        private List<AlbumBean> album;

        public List<AlbumBean> getAlbum() {
            return this.album;
        }

        public void setAlbum(List<AlbumBean> paramList) {
            this.album = paramList;
        }

        public AlertBean getAlert() {
            return this.alert;
        }

        public List<?> getBanner() {
            return this.banner;
        }

        public List<?> getHomepage() {
            return this.homepage;
        }

        public List<VerticalBean> getVertical() {
            return this.vertical;
        }

        public void setAlert(AlertBean paramAlertBean) {
            this.alert = paramAlertBean;
        }

        public void setBanner(List<?> paramList) {
            this.banner = paramList;
        }

        public void setHomepage(List<?> paramList) {
            this.homepage = paramList;
        }

        public void setVertical(List<VerticalBean> paramList) {
            this.vertical = paramList;
        }

        public static class AlertBean {
        }

        public static class VerticalBean {
            private int atime;
            private List<String> cid;
            private boolean cr;
            private String desc;
            private int favs;
            private String id;
            private String img;
            private int ncos;
            private String preview;
            private int rank;
            private String rule;
            private String store;
            private List<String> tag;
            private String thumb;
            private List<?> url;
            private UserBean user;
            private int views;
            private String wp;
            private boolean xr;

            public int getAtime() {
                return this.atime;
            }

            public List<String> getCid() {
                return this.cid;
            }

            public String getDesc() {
                return this.desc;
            }

            public int getFavs() {
                return this.favs;
            }

            public String getId() {
                return this.id;
            }

            public String getImg() {
                return this.img;
            }

            public int getNcos() {
                return this.ncos;
            }

            public String getPreview() {
                return this.preview;
            }

            public int getRank() {
                return this.rank;
            }

            public String getRule() {
                return this.rule;
            }

            public String getStore() {
                return this.store;
            }

            public List<String> getTag() {
                return this.tag;
            }

            public String getThumb() {
                return this.thumb;
            }

            public List<?> getUrl() {
                return this.url;
            }

            public UserBean getUser() {
                return this.user;
            }

            public int getViews() {
                return this.views;
            }

            public String getWp() {
                return this.wp;
            }

            public boolean isCr() {
                return this.cr;
            }

            public boolean isXr() {
                return this.xr;
            }

            public void setAtime(int paramInt) {
                this.atime = paramInt;
            }

            public void setCid(List<String> paramList) {
                this.cid = paramList;
            }

            public void setCr(boolean paramBoolean) {
                this.cr = paramBoolean;
            }

            public void setDesc(String paramString) {
                this.desc = paramString;
            }

            public void setFavs(int paramInt) {
                this.favs = paramInt;
            }

            public void setId(String paramString) {
                this.id = paramString;
            }

            public void setImg(String paramString) {
                this.img = paramString;
            }

            public void setNcos(int paramInt) {
                this.ncos = paramInt;
            }

            public void setPreview(String paramString) {
                this.preview = paramString;
            }

            public void setRank(int paramInt) {
                this.rank = paramInt;
            }

            public void setRule(String paramString) {
                this.rule = paramString;
            }

            public void setStore(String paramString) {
                this.store = paramString;
            }

            public void setTag(List<String> paramList) {
                this.tag = paramList;
            }

            public void setThumb(String paramString) {
                this.thumb = paramString;
            }

            public void setUrl(List<?> paramList) {
                this.url = paramList;
            }

            public void setUser(UserBean paramUserBean) {
                this.user = paramUserBean;
            }

            public void setViews(int paramInt) {
                this.views = paramInt;
            }

            public void setWp(String paramString) {
                this.wp = paramString;
            }

            public void setXr(boolean paramBoolean) {
                this.xr = paramBoolean;
            }

            public static class UserBean {
                private String auth;
                private String avatar;
                private int follower;
                private String id;
                private boolean isvip;
                private String name;
                private int viptime;

                public String getAuth() {
                    return this.auth;
                }

                public String getAvatar() {
                    return this.avatar;
                }

                public int getFollower() {
                    return this.follower;
                }

                public String getId() {
                    return this.id;
                }

                public String getName() {
                    return this.name;
                }

                public int getViptime() {
                    return this.viptime;
                }

                public boolean isIsvip() {
                    return this.isvip;
                }

                public void setAuth(String paramString) {
                    this.auth = paramString;
                }

                public void setAvatar(String paramString) {
                    this.avatar = paramString;
                }

                public void setFollower(int paramInt) {
                    this.follower = paramInt;
                }

                public void setId(String paramString) {
                    this.id = paramString;
                }

                public void setIsvip(boolean paramBoolean) {
                    this.isvip = paramBoolean;
                }

                public void setName(String paramString) {
                    this.name = paramString;
                }

                public void setViptime(int paramInt) {
                    this.viptime = paramInt;
                }
            }
        }

        public static class AlbumBean {
            private int atime;
            private String cover;
            private String desc;
            private String ename;
            private int favs;
            private String id;
            private boolean isfeed;
            private String lcover;
            private String name;
            private String nickname;
            private int sn;
            private String status;
            private String subname;
            private List<?> tag;
            private int top;
            private int type;
            private List<?> url;
            private UserBean user;

            public int getAtime() {
                return this.atime;
            }

            public String getCover() {
                return this.cover;
            }

            public String getDesc() {
                return this.desc;
            }

            public String getEname() {
                return this.ename;
            }

            public int getFavs() {
                return this.favs;
            }

            public String getId() {
                return this.id;
            }

            public String getLcover() {
                return this.lcover;
            }

            public String getName() {
                return this.name;
            }

            public String getNickname() {
                return this.nickname;
            }

            public int getSn() {
                return this.sn;
            }

            public String getStatus() {
                return this.status;
            }

            public String getSubname() {
                return this.subname;
            }

            public List<?> getTag() {
                return this.tag;
            }

            public int getTop() {
                return this.top;
            }

            public int getType() {
                return this.type;
            }

            public List<?> getUrl() {
                return this.url;
            }

            public UserBean getUser() {
                return this.user;
            }

            public boolean isIsfeed() {
                return this.isfeed;
            }

            public void setAtime(int paramInt) {
                this.atime = paramInt;
            }

            public void setCover(String paramString) {
                this.cover = paramString;
            }

            public void setDesc(String paramString) {
                this.desc = paramString;
            }

            public void setEname(String paramString) {
                this.ename = paramString;
            }

            public void setFavs(int paramInt) {
                this.favs = paramInt;
            }

            public void setId(String paramString) {
                this.id = paramString;
            }

            public void setIsfeed(boolean paramBoolean) {
                this.isfeed = paramBoolean;
            }

            public void setLcover(String paramString) {
                this.lcover = paramString;
            }

            public void setName(String paramString) {
                this.name = paramString;
            }

            public void setNickname(String paramString) {
                this.nickname = paramString;
            }

            public void setSn(int paramInt) {
                this.sn = paramInt;
            }

            public void setStatus(String paramString) {
                this.status = paramString;
            }

            public void setSubname(String paramString) {
                this.subname = paramString;
            }

            public void setTag(List<?> paramList) {
                this.tag = paramList;
            }

            public void setTop(int paramInt) {
                this.top = paramInt;
            }

            public void setType(int paramInt) {
                this.type = paramInt;
            }

            public void setUrl(List<?> paramList) {
                this.url = paramList;
            }

            public void setUser(UserBean paramUserBean) {
                this.user = paramUserBean;
            }

            public static class UserBean {
                private String avatar;
                private int follower;
                private int following;
                private String gcid;
                private int gender;
                private String id;
                private boolean isvip;
                private String name;
                private int viptime;

                public String getAvatar() {
                    return this.avatar;
                }

                public int getFollower() {
                    return this.follower;
                }

                public int getFollowing() {
                    return this.following;
                }

                public String getGcid() {
                    return this.gcid;
                }

                public int getGender() {
                    return this.gender;
                }

                public String getId() {
                    return this.id;
                }

                public String getName() {
                    return this.name;
                }

                public int getViptime() {
                    return this.viptime;
                }

                public boolean isIsvip() {
                    return this.isvip;
                }

                public void setAvatar(String paramString) {
                    this.avatar = paramString;
                }

                public void setFollower(int paramInt) {
                    this.follower = paramInt;
                }

                public void setFollowing(int paramInt) {
                    this.following = paramInt;
                }

                public void setGcid(String paramString) {
                    this.gcid = paramString;
                }

                public void setGender(int paramInt) {
                    this.gender = paramInt;
                }

                public void setId(String paramString) {
                    this.id = paramString;
                }

                public void setIsvip(boolean paramBoolean) {
                    this.isvip = paramBoolean;
                }

                public void setName(String paramString) {
                    this.name = paramString;
                }

                public void setViptime(int paramInt) {
                    this.viptime = paramInt;
                }
            }
        }
    }

}
