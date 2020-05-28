package com.jzh.mvp.http;

import com.jzh.mvp.mvp.module.weather.bean.WeatherData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * <p></p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public interface TextService {
    /**
     * MVP模式中使用的数据格式
     * @param str
     * @return ContextData可以替换为任意类型，但是HttpRespondData 为固定的数据格式
     */
    @GET("/weather_mini")
    Observable<HttpRespondData<WeatherData>> getWeatherData(@Query("city") String str);
}
