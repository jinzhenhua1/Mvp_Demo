package com.jzh.mvp_demo.mvp.base;

/**
 * <p>网络请求接口回调类</p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public interface HttpResponseListener<T> {
    /**
     * 网络请求成功
     *
     * @param tag 请求的标记
     * @param t   返回的数据
     */
    void onSuccess(Object tag, T t);

    /**
     * 网络请求失败()
     *
     * @param tag     请求的标记
     * @param failure 请求失败时，返回的信息类
     */
    void onFailure(Throwable throwable);
}
