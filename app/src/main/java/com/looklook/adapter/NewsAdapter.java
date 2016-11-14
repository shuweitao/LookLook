package com.looklook.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.looklook.R;
import com.looklook.beans.News;


/**
 * Created by Mr.Jude on 2016/6/7.
 */
public class NewsAdapter extends RecyclerArrayAdapter<News.NewslistBean> {
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {

        return new NewsViewHolder(parent);
    }


    private class NewsViewHolder extends BaseViewHolder<News.NewslistBean> {
        private TextView mTv_name;
        private ImageView mImg_face;
        private TextView mTv_sign;

        public NewsViewHolder(ViewGroup parent) {
            super(parent, R.layout.news_recycler_item);
            mTv_name = (TextView) $(R.id.person_name);
            mTv_sign = (TextView) $(R.id.person_sign);
            mImg_face = (ImageView) $(R.id.person_face);
        }

        @Override
        public void setData(News.NewslistBean data) {
            mTv_name.setText(data.getTitle());
            mTv_sign.setText(data.getCtime());
            Glide.with(getContext())
                    .load(data.getPicUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .centerCrop()
                    .into(mImg_face);
        }
    }
}
