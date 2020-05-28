package com.jzh.mvp_demo.mvp.module.weather.model;

import com.jzh.mvp_demo.http.TextService;
import com.jzh.mvp_demo.mvp.base.BaseModel;
import com.jzh.mvp_demo.mvp.base.HttpResponseListener;
import com.jzh.mvp_demo.mvp.module.weather.base.IWeatherContract;

/**
 * <p>model层</p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public class WeatherModel extends BaseModel implements IWeatherContract.IWeatherModel {

    @Override
    public void getWeather(String city, HttpResponseListener listener) {
        sendRequestUntilStop(getService(TextService.class).getWeatherData(city),listener);

    }
}
