package com.zxin.jiuxian.bean;

import android.annotation.SuppressLint;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */
@SuppressLint({"ParcelCreator"})
public class AddressListResultInfo {
    @JSONField(name = "addrList")
    public List<AddrListItem> mAddrList;
    @JSONField(name = "pageCount")
    public String mPageCount;

    public static class AddrListItem implements Serializable {
        public static final String BLANK_SPACE = " ";
        public static final String DEFAULT_ADDRESS_TYPE = "1";
        private static final long serialVersionUID = 1L;
        @JSONField(name = "addrId")
        public int mAddrId;
        @JSONField(name = "addressMore")
        public String mAddressMore;
        @JSONField(name = "city")
        public String mCity;
        @JSONField(name = "cityId")
        public int mCityId;
        @JSONField(name = "consignee")
        public String mConsignee;
        @JSONField(name = "district")
        public String mDistrict;
        @JSONField(name = "districtId")
        public int mDistrictId;
        public boolean mIsCheck = false;
        @JSONField(name = "isMain")
        public int mIsMain;
        @JSONField(name = "mobile")
        public String mMobile;
        @JSONField(name = "phone")
        public String mPhone;
        @JSONField(name = "province")
        public String mProvince;
        @JSONField(name = "provinceId")
        public int mProvinceId;

        public boolean equals(Object paramObject) {
            if ((paramObject instanceof AddrListItem)) {
                paramObject = (AddrListItem) paramObject;
                return this.mAddrId == ((AddrListItem) paramObject).mAddrId;
            }
            return super.equals(paramObject);
        }

        public String getDetailAddr() {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mProvince);
            localStringBuilder.append(" ");
            localStringBuilder.append(this.mCity);
            localStringBuilder.append(" ");
            localStringBuilder.append(this.mDistrict);
            localStringBuilder.append(" ");
            localStringBuilder.append(this.mAddressMore);
            return localStringBuilder.toString();
        }

        public int hashCode() {
            return this.mAddrId;
        }
    }
}
