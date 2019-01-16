package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;

public class FileDescResult {
    @JSONField(name = "files")
    public ArrayList<FileInfo> mFiles;
    @JSONField(name = "status")
    public String mStatus;

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileDesc [mFiles=");
        localStringBuilder.append(this.mFiles);
        localStringBuilder.append(", mStatus=");
        localStringBuilder.append(this.mStatus);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }

    public static class FileInfo {
        @JSONField(name = "fieldName")
        public String mFieldName;
        @JSONField(name = "originalFilename")
        public String mOriginalFilename;
        @JSONField(name = "path")
        public String mPath;

        public String toString() {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("FileInfo [mPath=");
            localStringBuilder.append(this.mPath);
            localStringBuilder.append(", mOriginalFilename=");
            localStringBuilder.append(this.mOriginalFilename);
            localStringBuilder.append(", mFieldName=");
            localStringBuilder.append(this.mFieldName);
            localStringBuilder.append("]");
            return localStringBuilder.toString();
        }
    }
}
