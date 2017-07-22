package com.example.wangsir.commonpagerdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.wangsir.commonpagerdemo.module.AddressBean;
import com.example.wangsir.commonpagerdemo.view.CommonPager;

/**
 * Created by wangsir on 2017/7/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected CommonPager commonPager;
    public AddressBean addressBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        commonPager = new CommonPager() {
            @Override
            public void showSuccess() {
                Log.i("fjkdjfkd", "我被调用了");
                success();
            }

            @Override
            public void loadData() {
                loadnetData();
            }
        };
        setContentView(commonPager.commonContainer);
    }

    protected abstract void success();

    protected abstract void loadnetData();
}
