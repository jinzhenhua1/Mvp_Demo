package com.jzh.mvp.mvp.base;


import com.jzh.mvp.base.BaseApplication;
import com.jzh.mvp.injection.component.AppComponent;

import java.lang.ref.WeakReference;

/**
 * <p></p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public class BasePresenter<T extends IBaseContract.IBaseView,P extends IBaseContract.IBaseModel> implements IBaseContract.IBasePresenter {
    // 防止 Activity 不走 onDestory() 方法，所以采用弱引用来防止内存泄漏
    private WeakReference<T> mViewRef;
    protected P model;
    protected AppComponent mAppComponent;

    public BasePresenter(T view){
        mViewRef = new WeakReference<T>(view);
        init();
    }

    @Override
    public void onStop() {
        if(model != null){
            //清除调用中的接口
            model.onStop();
        }
    }

    @Override
    public void onDestory() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
        if(model != null){
            //清除调用中的接口
            model.onDestory();
            model = null;
        }
    }

    @Override
    public boolean isViewAttach() {
        return mViewRef != null;
    }

    public T getView() {
        return mViewRef.get();
    }

    /**
     * 获取回调接口的实现，经过一层封装，默认显示加载进度框
     * @param callback
     * @return
     */
    public ApiCallbackWrapper getApiCallBackWithLoading(HttpResponseListener callback){
        return new ApiCallbackWrapper(callback,true);
    }

    /**
     * 拦截回调方法，中间插入oading操作
     * @param <T>
     */
    protected class ApiCallbackWrapper<T> implements HttpResponseListener<T>{
        private HttpResponseListener callback;
        private boolean showLoading;

        public ApiCallbackWrapper(HttpResponseListener callback,boolean showLoading){
            this.callback = callback;
            this.showLoading = showLoading;
            if(showLoading){
                getView().showLoading();
            }
        }

        @Override
        public void onSuccess(Object tag, T o) {
            callback.onSuccess(tag,o);
            if(showLoading){
                getView().dismissLoading();
            }
        }

        @Override
        public void onFailure(Throwable throwable) {
            callback.onFailure(throwable);
            if(showLoading){
                getView().dismissLoading();
            }
        }
    }

    //初始化注入类
    protected void init() {
        mAppComponent = BaseApplication.application.getmAppComponent();
    }
}
