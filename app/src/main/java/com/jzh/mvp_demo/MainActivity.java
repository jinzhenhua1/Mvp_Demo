package com.jzh.mvp_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jzh.mvp_demo.mvp.module.weather.view.WeatherActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
//    @BindView(R.id.activity_main_text_button)
//    Button activity_main_text_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @OnClick(R.id.activity_main_text_button)
    private void goToMvp(){
        startActivity(new Intent(getApplicationContext(), WeatherActivity.class));
    }
}
