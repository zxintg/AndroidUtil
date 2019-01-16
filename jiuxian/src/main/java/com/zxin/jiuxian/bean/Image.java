package com.zxin.jiuxian.bean;

import java.io.Serializable;

public class Image implements Serializable {
    private static final long serialVersionUID = -3258021073228693783L;
    public boolean isWebUrl;
    public boolean mCamera;
    public boolean mChecked;
    public boolean mDefault;
    public String mName;
    public String mPath;
    public long mTime;

    public Image(String mPath, String mName, long mTime) {
        this.mPath = mPath;
        this.mName = mName;
        this.mTime = mTime;
    }

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof Image)) {
            Image localImage = (Image) paramObject;
            if ((this.mPath != null) && (localImage.mPath != null)) {
                return this.mPath.equalsIgnoreCase(localImage.mPath);
            }
        }
        return super.equals(paramObject);
    }
}
