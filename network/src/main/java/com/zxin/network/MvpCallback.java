package com.zxin.network;

/**
 * Created by Administrator on 2017/11/27.
 */

public interface MvpCallback {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void  onSuccess(int tage,Object data);

    /**
     *  使用网络API接口请求方式时，虽然已经请求成功但是由
     *  于{@code msg}的原因无法正常返回数据。
     */
    void onFailure(int tager,String msg);

    /**
     * 当请求数据结束时，无论请求结果是成功，失败或是抛出异常都会执行此方法给用户做处理，通常做网络
     * 请求时可以在此处隐藏“正在加载”的等待控件
     */
    void onComplete(int tager);

}
