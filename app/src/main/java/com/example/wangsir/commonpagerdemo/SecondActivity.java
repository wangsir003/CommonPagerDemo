package com.example.wangsir.commonpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by wangsir on 2017/7/21.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        textView = (TextView) findViewById(R.id.tv_address);
        load();
    }

    private void load() {
        OkHttpUtils
                .get()
                .url("http://blog.sina.com.cn/s/blog_7309444701016yv5.html")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        textView.setText(response);
                    }
                });
    }
}
