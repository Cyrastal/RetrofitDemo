package com.example.retrofitdemo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {
    @GET
    Observable<Moudel> service(@Url String url);
}
