package com.example.retrofitdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.Net.CacheIntercepter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends RxAppCompatActivity {
    private SmartRefreshLayout smartRefreshLayout;
    private static final String TAG = "MainActivity";
    private List<Moudel.DataBean> datas = new ArrayList<>();
    private final Function<Moudel, Observable<List<Moudel.DataBean>>> change = data -> {
        datas.addAll(data.getData());
        return Observable.just(datas);
    };
    private MyAdapter myAdapter;
    private RecyclerView recyclerView;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smartRefreshLayout=findViewById(R.id.refresh);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initNet();


            }
        });
        OkHttpClient client = initOkhttp();


        Retrofit retrofit = initRetrofit(client);
        api = retrofit.create(Api.class);


        initNet();
        Log.d(TAG, "onCreate: " + datas.size());
        initRecycleView();


    }

    private void initRecycleView() {
        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    private void initNet() {

        //发送请求
        api.service("product_find")
                .compose(bindToLifecycle())
                .flatMap(change)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .cache()
                .doOnComplete(()->{smartRefreshLayout.finishRefresh();})
                .subscribe(new Observer<List<Moudel.DataBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Moudel.DataBean> dataBeans) {
                        myAdapter = new MyAdapter(R.layout.item, dataBeans);
                        myAdapter.setPreLoadNumber(4);
                        recyclerView.setAdapter(myAdapter);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        /**
         * 执行回调
         */

    }

    private Retrofit initRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("http://restaurant.t.imooc.com/basePro/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    private OkHttpClient initOkhttp() {
        File cacheFile = new File(this.getApplication().getCacheDir(), "cacheData");
        Cache cache = new Cache(cacheFile, 1024*1024*14);//google建议放到这里
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addNetworkInterceptor(new CacheIntercepter(getApplicationContext()))//这里大家一定要注意了是addNetworkOnterceptor别搞错了啊。
               .cache(cache)
                .addInterceptor(loggingInterceptor)
                .build();
    }

}
