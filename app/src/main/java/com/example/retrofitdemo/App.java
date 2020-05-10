package com.example.retrofitdemo;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;

import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.tencent.bugly.crashreport.CrashReport;

public class App extends Application {

    private String mDeviceId;

    @Override
    public void onCreate() {

        super.onCreate();
        TraceCompat.beginSection("abc");
        initSmartView();
        initBugly();
        TraceCompat.endSection();


    }


    public String getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(String deviceId) {
        this.mDeviceId = deviceId;
    }


    private void initBugly() {
        CrashReport.initCrashReport(getApplicationContext());
    }

    private void initSmartView() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.gtarr);

                return new WaterDropHeader(context);
            }
        });
    }
}
