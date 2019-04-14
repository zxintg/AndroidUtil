package com.zxin.basemodel.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;

import com.zxin.basemodel.dao.CityDaoUtil;
import com.zxin.basemodel.entity.City;
import com.zxin.root.bean.Address;
import com.zxin.root.view.popup.PickerToolsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liukui on 2016/9/28.
 */
public class CustomAddressPicker {

    public enum AddressType {
        All, Province, City, District, Province_City, City_District
    }

    private PickerToolsView province_pv, city_pv, district_pv;
    private List<String> provinceList, cityList, districtList;
    public Address selected;
    private List<City> initProvince, initCity, initDistrict;
    private Map<String, City> provinceMap, cityMap, districtMap;
    private boolean isInit = false;

    public CustomAddressPicker(PickerToolsView... view) {
        selected = new Address();
        if (type == null || type == AddressType.All) {
            province_pv = view[0];
            city_pv = view[1];
            district_pv = view[2];
            provinceMap = new HashMap<>();
            cityMap = new HashMap<>();
            districtMap = new HashMap<>();
            province_pv.setVisibility(View.VISIBLE);
            city_pv.setVisibility(View.VISIBLE);
            district_pv.setVisibility(View.VISIBLE);
        } else {
            switch (type) {

                case Province:
                    province_pv = view[0];
                    provinceMap = new HashMap<>();
                    province_pv.setVisibility(View.VISIBLE);
                    break;

                case City:
                    city_pv = view[0];
                    cityMap = new HashMap<>();
                    city_pv.setVisibility(View.VISIBLE);
                    break;

                case District:
                    district_pv = view[0];
                    districtMap = new HashMap<>();
                    district_pv.setVisibility(View.VISIBLE);
                    break;

                case Province_City:
                    province_pv = view[0];
                    city_pv = view[1];
                    provinceMap = new HashMap<>();
                    cityMap = new HashMap<>();
                    province_pv.setVisibility(View.VISIBLE);
                    city_pv.setVisibility(View.VISIBLE);
                    break;

                case City_District:
                    city_pv = view[0];
                    district_pv = view[1];
                    cityMap = new HashMap<>();
                    districtMap = new HashMap<>();
                    city_pv.setVisibility(View.VISIBLE);
                    district_pv.setVisibility(View.VISIBLE);
                    break;

            }
        }
        isInit = true;
        initArrayList();
    }

    private AddressType type;

    public void setAddressType(AddressType type) {
        this.type = type;
    }

    /*****
     * 初始化数据
     */
    private void initArrayList() {
        if (province_pv == null) {
            provinceList = null;
        } else {
            if (provinceList == null) provinceList = new ArrayList<>();
            provinceList.clear();
        }
        if (city_pv == null) {
            cityList = null;
        } else {
            if (cityList == null) cityList = new ArrayList<>();
            cityList.clear();
        }
        if (district_pv == null) {
            districtList = null;
        } else {
            if (districtList == null) districtList = new ArrayList<>();
            districtList.clear();
        }
    }

    /*****
     * 显示数据
     * @param address
     */
    public void show(Address address) {
        setSelectedAddress(address);
    }

    public void initTimer(List<City> cityList) {
        switch (type) {

            case All:
                initAll(cityList);
                break;

            case Province:
                initProvince(cityList);
                break;

            case City:
                initCity(cityList);
                break;

            case District:
                initDistrict(cityList);
                break;

            case Province_City:
                initProvinceCity(cityList);
                break;

            case City_District:
                initCityDistrict(cityList);
                break;

        }
        loadComponent();
        addListener();
    }

    private void initAll(List<City> initCity) {
        if (provinceList != null && initCity != null && !initCity.isEmpty()) {
            //请求市
            provinceList.clear();
            provinceMap.clear();
            for (City city : initCity) {
                provinceList.add(city.area_name);
                provinceMap.put(city.area_name, city);
            }
            selected.province = initCity.get(0).area_name;
            selected.provinceId = initCity.get(0).area_id;
        }
        if (cityList != null) {
            //请求县、区
            this.initCity = CityDaoUtil.getInstance().getCityByPid(selected.provinceId);
            cityList.clear();
            cityMap.clear();
            for (City city : this.initCity) {
                cityList.add(city.area_name);
                cityMap.put(city.area_name, city);
            }
            if (this.initCity == null || this.initCity.isEmpty()) {
                selected.city = "-";
                selected.cityId = 0;
                cityList.add(selected.city);
            } else {
                selected.city = this.initCity.get(0).area_name;
                selected.cityId = this.initCity.get(0).area_id;
            }
        }
        if (districtList != null) {
            //请求县、区
            initDistrict = CityDaoUtil.getInstance().getCityByPid(selected.cityId);
            districtList.clear();
            districtMap.clear();
            for (City city : initDistrict) {
                districtList.add(city.area_name);
                districtMap.put(city.area_name, city);
            }
            if (initDistrict == null || initDistrict.isEmpty()) {
                selected.district = "-";
                selected.districtId = 0;
                districtList.add(selected.district);
            } else {
                selected.district = initDistrict.get(0).area_name;
                selected.districtId = initDistrict.get(0).area_id;
            }
        }
    }

    private void initProvince(List<City> initCity) {
        if (provinceList != null && initCity != null && !initCity.isEmpty()) {
            //请求市
            provinceList.clear();
            provinceMap.clear();
            for (City city : initCity) {
                provinceList.add(city.area_name);
                provinceMap.put(city.area_name, city);
            }
            selected.province = initCity.get(0).area_name;
            selected.provinceId = initCity.get(0).area_id;
        }
    }

    private void initCity(List<City> initCity) {
        if (cityList != null && initCity != null && !initCity.isEmpty()) {
            //请求市
            cityList.clear();
            cityMap.clear();
            for (City city : initCity) {
                cityList.add(city.area_name);
                cityMap.put(city.area_name, city);
            }
            selected.city = initCity.get(0).area_name;
            selected.cityId = initCity.get(0).area_id;
        }
    }

    private void initDistrict(List<City> initCity) {
        if (districtList != null && initCity != null && !initCity.isEmpty()) {
            //请求市
            districtList.clear();
            districtMap.clear();
            for (City city : initCity) {
                districtList.add(city.area_name);
                districtMap.put(city.area_name, city);
            }
            selected.district = initCity.get(0).area_name;
            selected.districtId = initCity.get(0).area_id;
        }
    }

    private void initProvinceCity(List<City> initCity) {
        if (provinceList != null && initCity != null && !initCity.isEmpty()) {
            //请求市
            provinceList.clear();
            provinceMap.clear();
            for (City city : initCity) {
                provinceList.add(city.area_name);
                provinceMap.put(city.area_name, city);
            }
            selected.province = initCity.get(0).area_name;
            selected.provinceId = initCity.get(0).area_id;
        }
        if (cityList != null) {
            //请求县、区
            this.initCity = CityDaoUtil.getInstance().getCityByPid(selected.provinceId);
            cityList.clear();
            cityMap.clear();
            for (City city : this.initCity) {
                cityList.add(city.area_name);
                cityMap.put(city.area_name, city);
            }
            if (this.initCity == null || this.initCity.isEmpty()) {
                selected.city = "-";
                selected.cityId = 0;
                cityList.add(selected.city);
            } else {
                selected.city = this.initCity.get(0).area_name;
                selected.cityId = this.initCity.get(0).area_id;
            }
        }
    }

    private void initCityDistrict(List<City> initCity) {
        if (cityList != null && initCity != null && !initCity.isEmpty()) {
            //请求市
            cityList.clear();
            cityMap.clear();
            for (City city : initCity) {
                cityList.add(city.area_name);
                cityMap.put(city.area_name, city);
            }
            selected.city = initCity.get(0).area_name;
            selected.cityId = initCity.get(0).area_id;
        }
        if (districtList != null) {
            //请求县、区
            initDistrict = CityDaoUtil.getInstance().getCityByPid(selected.cityId);
            districtList.clear();
            districtMap.clear();
            for (City city : initDistrict) {
                districtList.add(city.area_name);
                districtMap.put(city.area_name, city);
            }
            if (initDistrict == null || initDistrict.isEmpty()) {
                selected.district = "-";
                selected.districtId = 0;
                districtList.add(selected.district);
            } else {
                selected.district = initDistrict.get(0).area_name;
                selected.districtId = initDistrict.get(0).area_id;
            }
        }
    }

    private void loadComponent() {
        if (province_pv != null) {
            province_pv.setData(provinceList);
            province_pv.setSelected(0);
        }
        if (city_pv != null) {
            city_pv.setData(cityList);
            city_pv.setSelected(0);
        }
        if (district_pv != null) {
            district_pv.setData(districtList);
            district_pv.setSelected(0);
        }
        executeScroll();
    }

    /*****
     * 添加滚动事件
     */
    private boolean isProvince = false;

    private void addListener() {
        if (province_pv != null)
            province_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    City city = provinceMap.get(text);
                    selected.province = city.area_name;
                    selected.provinceId = city.area_id;
                    isInit = true;
                    isProvince = true;
                    if (city_pv != null)
                        cityChange();
                }
            });
        if (city_pv != null)
            city_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    City city = cityMap.get(text);
                    selected.city = city.area_name;
                    selected.cityId = city.area_id;
                    isInit = true;
                    isProvince = false;
                    if (district_pv != null)
                        districtChange();
                }
            });

        if (district_pv != null)
            district_pv.setOnSelectListener(new PickerToolsView.onSelectListener() {
                @Override
                public void onSelect(String text) {
                    City city = districtMap.get(text);
                    selected.district = city.area_name;
                    selected.districtId = city.area_id;
                    isProvince = false;
                    isInit = true;
                }
            });
    }

    private void cityChange() {
        if (cityList.isEmpty())
            return;
        if (selected.provinceId == 0)
            return;
        cityList.clear();
        cityMap.clear();
        if (cityList != null) {
            //请求县、区
            initCity = CityDaoUtil.getInstance().getCityByPid(selected.provinceId);
            for (City city : initCity) {
                cityList.add(city.area_name);
                cityMap.put(city.area_name, city);
            }
            if (initCity == null || initCity.isEmpty()) {
                selected.city = "-";
                selected.cityId = 0;
                cityList.add(selected.city);
            } else if (isInit) {
                selected.city = initCity.get(0).area_name;
                selected.cityId = initCity.get(0).area_id;
            }
        }
        city_pv.setData(cityList);
        city_pv.setSelected(selected.city);
        executeAnimator(city_pv);
        executeScroll();
        if (!isProvince)
            return;
        if (district_pv != null)
            districtChange();
        isProvince = false;
    }

    //县、区选择
    private void districtChange() {
        if (districtList.isEmpty())
            return;
        if (selected.cityId == 0)
            return;
        districtList.clear();
        districtMap.clear();
        if (districtList != null) {
            //请求县、区
            initDistrict = CityDaoUtil.getInstance().getCityByPid(selected.cityId);
            for (City city : initDistrict) {
                districtList.add(city.area_name);
                districtMap.put(city.area_name, city);
            }
            if (initDistrict == null || initDistrict.isEmpty()) {
                selected.district = "-";
                selected.districtId = 0;
                districtList.add(selected.district);

            } else if (isInit) {
                selected.district = initDistrict.get(0).area_name;
                selected.districtId = initDistrict.get(0).area_id;
            }
        }
        district_pv.setData(districtList);
        district_pv.setSelected(selected.district);
        executeAnimator(district_pv);
        executeScroll();
    }

    private void executeScroll() {
        if (province_pv != null) {
            province_pv.setCanScroll(provinceList.size() > 1);
        }
        if (city_pv != null) {
            city_pv.setCanScroll(cityList.size() > 1);
        }
        if (district_pv != null) {
            district_pv.setCanScroll(districtList.size() > 1);
        }
    }

    /**
     * 设置日期控件是否可以循环滚动
     */
    public void setIsLoop(boolean isLoop) {
        if (this.province_pv != null)
            this.province_pv.setIsLoop(isLoop);
        if (this.city_pv != null)
            this.city_pv.setIsLoop(isLoop);
        if (this.district_pv != null)
            this.district_pv.setIsLoop(isLoop);
    }

    /**
     * 设置地址控件默认选中
     */
    private void setSelectedAddress(Address address) {
        this.selected = address;
        switch (type) {

            case All:
                province_pv.setSelected(address.province);
                executeAnimator(province_pv);
                isInit = false;
                cityChange();
                //districtChange();
                break;

            case Province:
                province_pv.setSelected(address.province);
                executeAnimator(province_pv);
                isInit = false;
                break;

            case City:
                city_pv.setSelected(address.city);
                executeAnimator(city_pv);
                isInit = false;
                break;

            case District:
                district_pv.setSelected(address.district);
                executeAnimator(district_pv);
                isInit = false;
                break;

            case Province_City:
                province_pv.setSelected(address.province);
                executeAnimator(province_pv);
                isInit = false;
                cityChange();
                break;

            case City_District:
                city_pv.setSelected(address.city);
                executeAnimator(city_pv);
                isInit = false;
                districtChange();
                break;

        }
    }

    private void executeAnimator(View view) {
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.3f, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.3f, 1f);
        ObjectAnimator.ofPropertyValuesHolder(view, pvhX, pvhY, pvhZ).setDuration(200).start();
    }
}
