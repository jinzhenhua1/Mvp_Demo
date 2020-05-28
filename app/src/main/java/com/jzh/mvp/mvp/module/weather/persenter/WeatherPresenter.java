package com.jzh.mvp.mvp.module.weather.persenter;

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
    }

    @Override
    public void getWeather(String city) {
//        getView().showLoading();
//        model.getWeather(city, new HttpResponseListener<WeatherData>() {
//            @Override
//            public void onSuccess(Object tag, WeatherData weatherData) {
//                getView().showWeahter(weatherData);
//                getView().dismissLoading();
//            }
//
//            @Override
//            public void onFailure(Throwable throwable) {
//                getView().showError(throwable.getMessage());
//                getView().dismissLoading();
//            }
//        });

        /**
         * 默认显示加载框，且不用自己手动关闭，跟上面效果一样
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
