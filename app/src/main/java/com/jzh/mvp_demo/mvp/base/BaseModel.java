package com.jzh.mvp_demo.mvp.base;

import com.jzh.mvp_demo.http.HttpRespondData;
import com.jzh.mvp_demo.http.HttpUtils;
import com.jzh.mvp_demo.http.RxTransformer;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

/**
 * <p></p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public class BaseModel implements IBaseContract.IBaseModel {

    private CompositeDisposable disposableWhenStop = new CompositeDisposable();
    private CompositeDisposable disposableWhenDestory = new CompositeDisposable();
    private RxTransformer api = new RxTransformer();

    @Override
    public void onStop() {
        //解除订阅
        disposableWhenStop.clear();
    }

    @Override
    public void onDestory() {
        //解除订阅
        disposableWhenDestory.clear();
    }

    /**
     * 发送网络请求，页面stop时会解除绑定
     *
     * @param observable
     * @param callback
     * @param <T>
     */
    protected <T> void sendRequestUntilStop(@NonNull Observable<HttpRespondData<T>> observable, final HttpResponseListener<T> callback) {
        disposableWhenStop.add(api.apiRequest(observable,callback));
    }

    /**
     * 发送网络请求，页面destory时会解除绑定
     *
     * @param observable
     * @param callback
     * @param <T>
     */
    protected <T> void sendRequestUntilDestory(@NonNull Observable<HttpRespondData<T>> observable, final HttpResponseListener<T> callback) {
        disposableWhenDestory.add(api.apiRequest(observable,callback));
    }


    protected  <T> T getService(Class<T> clazz){
        return HttpUtils.getRetrofit().create(clazz);
    }



}
