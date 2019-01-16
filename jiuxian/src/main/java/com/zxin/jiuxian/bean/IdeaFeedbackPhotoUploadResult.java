package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class IdeaFeedbackPhotoUploadResult {
    @JSONField(name = "files")
    public List<FileInfo> mFileInfos;
    @JSONField(name = "status")
    public int mStatus;

    public static class FileInfo {
        @JSONField(name = "fieldName")
        public String mFieldName;
        @JSONField(name = "originalFilename")
        public String mOriginalFileName;
        @JSONField(name = "path")
        public String mPath;
    }
}
