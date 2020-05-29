package com.jzh.mvp.mvp.module.weather.persenter;

import com.jzh.mvp.injection.component.DaggerAppComponent;
import com.jzh.mvp.injection.module.BaseModule;
import com.jzh.mvp.mvp.base.BasePresenter;
import com.jzh.mvp.mvp.base.HttpResponseListener;
import com.jzh.mvp.mvp.module.weather.base.IWeatherContract;
import com.jzh.mvp.mvp.module.weather.bean.WeatherData;
import com.jzh.mvp.mvp.module.weather.model.WeatherModel;

/**
 * <p>P 层 </p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public class WeatherPresenter extends BasePresenter<IWeatherContract.IWeatherView, IWeatherContract.IWeatherModel> implements IWeatherContract.IWeatherPresenter {

    public WeatherPresenter(IWeatherContract.IWeatherView view){
        super(view);
        model = new WeatherModel();
        //为model注入session
        mAppComponent.inject((WeatherModel)model);
    }

    @Override
    public void getWeather(String city) {
        /**
         * 默认显示加载框，且不用自己手动关闭
         */
        model.getWeather(city,getApiCallBackWithLoading(new HttpResponseListener<WeatherData>() {
            @Override
            public void onSuccess(Object tag, WeatherData data) {
                getView().showWeahter(data);
            }

            @Override
            public void onFailure(Throwable throwable) {
                getView().showError(throwable.getMessage());
            }
        }));
    }
}
