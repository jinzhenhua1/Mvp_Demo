package com.jzh.mvp_demo.mvp.module.weather.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzh.mvp_demo.R;
import com.jzh.mvp_demo.mvp.base.BaseMvpActivity;
import com.jzh.mvp_demo.mvp.module.weather.base.IWeatherContract;
import com.jzh.mvp_demo.mvp.module.weather.bean.WeatherData;
import com.jzh.mvp_demo.mvp.module.weather.persenter.WeatherPresenter;


/**
 * <p>view 层</p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/26 17:21
 */
public class WeatherActivity extends BaseMvpActivity<WeatherPresenter> implements IWeatherContract.IWeatherView {
    private Button btn_weather;
    private TextView tv_weather;

    @Override
    public void showWeahter(WeatherData weatherData) {
        tv_weather.setText(weatherData.toString());
    }

    @Override
    protected void initViewAndData(Bundle savedInstanceState) {
        btn_weather = findViewById(R.id.btn_weather);
        tv_weather = findViewById(R.id.tv_weather);

        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getWeather("广州");
            }
        });
    }

    @Override
    protected WeatherPresenter createPresenter() {
        return new WeatherPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }
}
