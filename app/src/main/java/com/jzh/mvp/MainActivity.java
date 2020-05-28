package com.jzh.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.jzh.mvp.mvp.module.weather.view.WeatherActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.activity_main_text_button)
    public void goToMvp(){
//        Toast.makeText(MainActivity.this,"测试",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), WeatherActivity.class));
    }
}
