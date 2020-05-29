package com.jzh.mvp.injection.component;

import android.content.Context;

import com.jzh.mvp.injection.module.BaseModule;
import com.jzh.mvp.injection.scope.PerApplication;
import com.jzh.mvp.mvp.module.weather.base.IWeatherContract;
import com.jzh.mvp.mvp.module.weather.model.WeatherModel;
import com.jzh.mvp.mvp.module.weather.view.WeatherActivity;

import dagger.Component;

/**
 * <p></p>
 *
 * @author zhangyz , gdutzyz@126.com
 * @version 1.0 , create at 2019/03/01 10:15
 */
@PerApplication
@Component(modules = {BaseModule.class})
public interface AppComponent {

	@SuppressWarnings("unused")
    Context provideApplicationContext();

    void inject(WeatherModel model);
    void inject(WeatherActivity activity);
}
