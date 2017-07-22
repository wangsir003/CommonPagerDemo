package com.example.wangsir.commonpagerdemo.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wangsir.commonpagerdemo.R;
import com.example.wangsir.commonpagerdemo.myapplication.AiKuApplication;


/**
 * Created by Administrator on 2017/6/20.
 */

public abstract class CommonPager {
    public boolean onLoadingData=false;


    // 是否读取到数据
    public boolean isReadData=false;
    // 数据集是否为空
    public boolean isNullData=false;

    // 四类界面
    public View loading;
    public View error;
    public View empty;

    public ViewGroup commonContainer;

    /**
     * 确保代码在主线程中执行
     */
    /*public void runOnUiThread(){
        Runnable action=new Runnable() {
            @Override
            public void run() {

                Log.i("look->onLoadingData",String.valueOf(onLoadingData));
                Log.i("look->isReadData",String.valueOf(isReadData));
                Log.i("look->isNullData",String.valueOf(isNullData));
                onLoadingData=false;
                //是否读取到数据
                if(isReadData){
                    // 获取到数据，判断数据集是否为空
                    if(isNullData){
                        // 加载空数据
                        showEmpty();
                    }else{
                        // 加载成功界面
                        showSuccess();
                    }
                }else {
                    // 没有获取到数据，显示错误界面
                    showError();
                }
            }
        };
        AiKuApplication.getHandler().post(action);
    }*/

    /**
     * 更新UI
     */

    public void updateUI(){
        onLoadingData=false;
        //是否读取到数据
        if(isReadData){
            // 获取到数据，判断数据集是否为空
            if(isNullData){
                // 加载空数据
                showEmpty();
            }else{
                // 加载成功界面
                showSuccess();
            }
        }else {
            // 没有获取到数据，显示错误界面
            showError();
        }
    }

    public CommonPager() {
        if (AiKuApplication.getContext() != null){
            Log.i("njjj:","测试");
        }
        commonContainer = new FrameLayout(AiKuApplication.getContext());
    }


    /**
     * 动态界面加载流程的起点
     */
    public void dynamic() {
        Log.i("look->2onLoadingData",String.valueOf(onLoadingData));
        Log.i("look->2isReadData",String.valueOf(isReadData));
        Log.i("look->2isNullData",String.valueOf(isNullData));
        if(onLoadingData||isReadData){
            return;
        }
        onLoadingData=true;
        showProgress();
        loadData();
    }

    /**
     * 数据加载中
     */
    public void showProgress(){
        loading = View.inflate(AiKuApplication.getContext(), R.layout.pager_loading, null);
        ImageView ivPagerLoading = (ImageView) loading.findViewById(R.id.iv_pager_loading);
        //加载动态图片
        Glide.with(AiKuApplication.getContext()).load(R.drawable.icon_loading).into(ivPagerLoading);

        changeViewTo(loading);
    }
    /**
     * 显示错误界面
     */
    public void showError() {
        error = View.inflate(AiKuApplication.getContext(), R.layout.pager_error, null);
        error.findViewById(R.id.error_btn_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dynamic();
            }
        });
        changeViewTo(error);
    }

    /**
     * 加载空数据
     */
    public void showEmpty() {
        empty = View.inflate(AiKuApplication.getContext(), R.layout.pager_empty, null);

        changeViewTo(empty);
    }

    /**
     * 切换到目标界面，原有的会被删除
     * @param view
     */
    public void changeViewTo(View view){
        commonContainer.removeAllViews();
        commonContainer.addView(view);
    }


    /**
     * 加载成功界面
     */
    public abstract void showSuccess();

    /**
     * 耗时操作
     */
    public abstract void loadData();
}
