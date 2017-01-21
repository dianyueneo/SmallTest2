package com.wangpos.by.cashier3;

import android.app.Application;

import net.wequick.small.Small;

/**
 * Created by Administrator on 2017/1/16.
 */

public class ConfigApplication extends Application {

    private static ConfigApplication instance;

    public ConfigApplication() {
        Small.preSetUp(this);
    }

    public static ConfigApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Small.setBaseUri("http://m.wequick.net/demo/");
        Small.setLoadFromAssets(BuildConfig.LOAD_FROM_ASSETS);
    }

}
