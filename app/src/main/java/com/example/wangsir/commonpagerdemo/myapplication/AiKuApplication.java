package com.example.wangsir.commonpagerdemo.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by wangsir on 2017/7/20.
 */

public class AiKuApplication extends Application {

    private static AiKuApplication mApplicatiion = null;

    private Activity mCurrentActivityContext;
    //定位
    //保证改应用只被注册一次EventBus,设置为true可以关闭,false,开启
    private static boolean isRegister = true;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicatiion = this;

        //初始化OkHttpUtils
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(6000L, TimeUnit.MILLISECONDS)
                .readTimeout(6000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);



    }




    public static Context getContext() {
        return mApplicatiion;
    }



    public static boolean getIsRegister() {
        return isRegister;
    }

    public static void setIsRegister(boolean isRegister) {
        AiKuApplication.isRegister = isRegister;
    }


    public static AiKuApplication getInstance() {
        return mApplicatiion;
    }


    /**
     * 当前的Activity上下文
     * @param mCurrentActivityContext
     */
    public void setCurrentActivityContext(Activity mCurrentActivityContext) {
        this.mCurrentActivityContext = mCurrentActivityContext;
    }

    public Activity getCurrentActivityContext() {
        return mCurrentActivityContext;
    }

    /**
     * 检查当前网络是否可用网络
     */
    public  boolean isNetwordAvaiable(Activity activity) {
        Context context = activity.getApplicationContext();
        //获取手机所有链接管理的对象(包括wifo,net 等 链接的管理)
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            //获取NetworkInfo对象
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();
            if (networkInfos != null && networkInfos.length > 0) {
                for (int i = 0; i < networkInfos.length; i++) {
                    System.out.println(i + "状态" + networkInfos[i].getState());
                    System.out.println(i + "类型" + networkInfos[i].getTypeName());
                    if (networkInfos[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
