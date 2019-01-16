package com.zxin.jdxsxp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/7.
 */

public class SearchListModel {
    private List<UserAlbumModel> albums;
    private boolean hasResult;

    public List<UserAlbumModel> getAlbums() {
        return this.albums;
    }

    public boolean isHasResult() {
        return this.hasResult;
    }

    public void setAlbums(List<UserAlbumModel> paramList) {
        this.albums = paramList;
    }

    public void setHasResult(boolean paramBoolean) {
        this.hasResult = paramBoolean;
    }
}
