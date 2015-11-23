package com.geometryfinance.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2015/11/23.
 */
public class VersionUtils {

    /**
     * 获取版本名称
     * @param context
     * @return
     */
    public static String getVersionName(Context context){
        String versionName = "";
        try {
            PackageInfo packageInfo =  context.getPackageManager().getPackageInfo(context.getPackageName(),0);
            versionName = packageInfo.versionName;
            if(versionName==null){
                return "";
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本号
     * @param context
     * @return
     */
    public static int getVersionCode(Context context){
        int versionCode = -1;
        try {
            PackageInfo packageInfo =  context.getPackageManager().getPackageInfo(context.getPackageName(),0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
}
