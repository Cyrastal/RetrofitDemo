package com.example.retrofitdemo;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MyAdapter extends BaseQuickAdapter<Moudel.DataBean, BaseViewHolder> {
    public static final String BASE_URL="http://restaurant.t.imooc.com/basePro/";
    private RequestOptions requestOptions=new RequestOptions().dontAnimate().diskCacheStrategy(DiskCacheStrategy.ALL);
    public MyAdapter(int layoutResId, @Nullable List<Moudel.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Moudel.DataBean item) {

        helper.setText(R.id.tv,item.getName())
                .setText(R.id.tv2,item.getLabel())
        .setText(R.id.tv3,item.getPrice().toString()+"元");
        Glide.with(mContext).load(BASE_URL+item.getIcon()).apply(requestOptions).into((ImageView) helper.getView(R.id.iv));

    }
}
