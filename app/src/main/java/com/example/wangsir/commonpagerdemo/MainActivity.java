package com.example.wangsir.commonpagerdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.wangsir.commonpagerdemo.adapter.base.CommonAdapter;
import com.example.wangsir.commonpagerdemo.adapter.base.ViewHolder;
import com.example.wangsir.commonpagerdemo.module.AddressBean;
import com.example.wangsir.commonpagerdemo.myapplication.AiKuApplication;
import com.example.wangsir.commonpagerdemo.view.CommonPager;
import com.example.wangsir.commonpagerdemo.view.activity.BaseActivity;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(commonPager.commonContainer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        commonPager.dynamic();
    }

    @Override
    protected void success() {

        Log.i("fjdkfjdkjfkd","fjkdjlsfjl");
        ListView listView = new ListView(MainActivity.this);
        listView.setBackgroundColor(Color.TRANSPARENT);
        CommonAdapter adapter = new CommonAdapter<AddressBean.DataBean>(MainActivity.this,addressBean.getData(),R.layout.layout_choose_address_item) {
            @Override
            public void convert(ViewHolder helper, AddressBean.DataBean item, int position) {
                helper.setText(R.id.tv_address_username,item.getUsername());
                helper.setText(R.id.tv_address_phone,item.getUsertel());
                helper.setText(R.id.tv_address,item.getAddress());
                helper.getConvertView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    }
                });
            }
        };
        listView.setAdapter(adapter);

        commonPager.changeViewTo(listView);

    }

    @Override
    protected void loadnetData() {
//        commonPager.updateUI();
        load();
    }

    private void load() {
        Log.i("开始加载的时间:", refFormatNowDate());

        OkHttpUtils
                .post()
                .url("http://101.200.79.102:8099/user/getAllAddr")
                .addParams("userid", "78")
                .build()
                .execute(new StringCallback(){

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        commonPager.isReadData = false;
                        commonPager.updateUI();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.i("response--res",response);
                        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
                        Log.i("结束加载的时间:", refFormatNowDate());
                        if (!TextUtils.isEmpty(response)){
                            commonPager.isReadData = true;//读到数据不为空
                            commonPager.isNullData = false;
                            AddressBean addressBean = new Gson().fromJson(response, AddressBean.class);
                            MainActivity.this.addressBean = addressBean;
//                            tofList(addressBean);
                        }else{
                            commonPager.isNullData = true;
                        }
                        commonPager.updateUI();
                    }
                });
    }

   /* private void tofList(AddressBean addressBean) {
        this.addressBean = addressBean;

    }*/

    public String refFormatNowDate() {
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        return retStrFormatNowDate;
    }


}
