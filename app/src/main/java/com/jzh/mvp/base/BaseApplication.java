package com.jzh.mvp.base;

import android.app.Application;
import android.content.Context;

import com.jzh.mvp.injection.component.AppComponent;
import com.jzh.mvp.injection.component.DaggerAppComponent;
import com.jzh.mvp.injection.module.BaseModule;

/**
 * <p></p>
 * <p></p>
 *
 * @author jinzhenhua
 * @version 1.0  ,create at:2020/5/29 10:21
 */
public class BaseApplication extends Application {

    public static BaseApplication application;
    protected AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initAppComponent();
    }

    public void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder().baseModule(new BaseModule()).build();
    }

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
