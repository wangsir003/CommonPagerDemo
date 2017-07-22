package com.example.wangsir.commonpagerdemo.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangsir.commonpagerdemo.view.CommonPager;


/**
 * @author：${changwei}
 * @function: tab首页
 * @mailbox：1083467224@qq.com
 * @date: on 2017/6/8 09:30
 */
public abstract class BaseFragment2 extends Fragment {
    /*protected Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=  getContext();
    }*/
    protected CommonPager pager;

    public BaseFragment2() {
        pager=new CommonPager() {
            @Override
            public void showSuccess() {
                BaseFragment2.this.showSuccess();
            }

            @Override
            public void loadData() {
                BaseFragment2.this.loadData();
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return pager.commonContainer;
    }



    /**
     * 加载成功界面
     */
    protected abstract void showSuccess();

    /**
     * 耗时操作
     */
    protected abstract void loadData();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            pager.dynamic();
        }
    }
}

