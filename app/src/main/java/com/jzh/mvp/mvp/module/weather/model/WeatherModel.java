package com.jzh.mvp.mvp.module.weather.model;

import android.util.Log;
import android.widget.Toast;

import com.dev.base.greendao.DaoSession;
import com.jzh.mvp.http.TextService;
import com.jzh.mvp.mvp.base.BaseModel;
import com.jzh.mvp.mvp.base.HttpResponseListener;
import com.jzh.mvp.mvp.module.weather.base.IWeatherContract;

import javax.inject.Inject;

/**
 * <p>model层</p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public class WeatherModel extends BaseModel implements IWeatherContract.IWeatherModel {
    @Inject
    public DaoSession session;

    @Override
    public void getWeather(String city, HttpResponseListener listener) {
        Log.e("WeatherModel",session.toString());
        sendRequestUntilStop(getService(TextService.class).getWeatherData(city),listener);
    }

}
