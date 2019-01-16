package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class CommunityPhotoUploadResult {
    @JSONField(name = "errCode")
    public String mErrorCode;
    @JSONField(name = "errText")
    public String mErrorText;
    @JSONField(name = "data")
    public List<UploadFileInfo> mFileInfos;
    @JSONField(name = "success")
    public int mSuccess;

    public static class UploadFileInfo {
        @JSONField(name = "contentType")
        public String mContentType;
        @JSONField(name = "filename")
        public String mFileName;
        @JSONField(name = "filePath")
        public String mFilePath;
        @JSONField(name = "fileSize")
        public int mFileSize;
        @JSONField(name = "originalFilename")
        public String mOriginalFileName;
    }
}
