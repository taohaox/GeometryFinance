package com.geometryfinance.util;

import android.util.Log;

import com.geometryfinance.BuildConfig;

/**
 * Created by Administrator on 2015/11/23.
 */
public class LogUtils {

    public static void w(String msg){
        if(BuildConfig.DEBUG){
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            Log.d(method, Thread.currentThread().getStackTrace()[3] + " " + msg);
        }

    }
    public static void e(String msg){
        if(BuildConfig.DEBUG) {
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            Log.d(method, Thread.currentThread().getStackTrace()[3] + " " + msg);
        }
    }
    public static void d(String msg){
        if(BuildConfig.DEBUG){
            String method = Thread.currentThread().getStackTrace()[3].getMethodName();
            Log.d(method, Thread.currentThread().getStackTrace()[3]+" "+msg);
        }
    }
    public static void i(String msg){
        if(BuildConfig.DEBUG) {
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            Log.d(method, Thread.currentThread().getStackTrace()[3] + " " + msg);
        }

    } public static void v(String msg){
        if(BuildConfig.DEBUG){
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            Log.d(method, Thread.currentThread().getStackTrace()[3] + " " + msg);
        }
    }
}
