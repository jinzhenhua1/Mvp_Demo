package com.jzh.mvp_demo.mvp.module.weather.base;

import com.jzh.mvp_demo.mvp.base.HttpResponseListener;
import com.jzh.mvp_demo.mvp.base.IBaseContract;
import com.jzh.mvp_demo.mvp.module.weather.bean.WeatherData;

public class IWeatherContract {

    public interface IWeatherPresenter extends IBaseContract.IBasePresenter{

        public void getWeather(String city);
    }

    public interface IWeatherView extends IBaseContract.IBaseView{
        public void showWeahter(WeatherData weatherData);
    }

    public interface IWeatherModel extends IBaseContract.IBaseModel{
        public void getWeather(String city, HttpResponseListener listener);
    }
}
