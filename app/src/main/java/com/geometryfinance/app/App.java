package com.geometryfinance.app;

import android.app.Application;

import com.geometryfinance.BuildConfig;

import org.xutils.x;
/**
 * Created by Administrator on 2015/11/23.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
