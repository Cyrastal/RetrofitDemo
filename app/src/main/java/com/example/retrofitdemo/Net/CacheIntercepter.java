package com.example.retrofitdemo.Net;

import android.content.Context;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheIntercepter implements Interceptor {
    CacheControl.Builder builder = new CacheControl.Builder();
    private Context mcontext;

    public CacheIntercepter(Context mcontext) {
        this.mcontext = mcontext;
    }



    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        if (!NetUtils.checkNet(mcontext)){
           request.newBuilder().cacheControl(CacheControl.FORCE_CACHE);
        }
        Response response = chain.proceed(request);
        int maxAge = 60;

        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .addHeader("name","shone")
                .header("Cache-Control", "public, max-age=" + maxAge)
                .build();


    }
}
