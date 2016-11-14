package com.looklook.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.looklook.R;
import com.looklook.beans.MeiTu;

/**
 * @author swt
 * @time 2016/11/9 11:22
 */
public class MeiTuAdapter extends RecyclerArrayAdapter<MeiTu.NewslistBean> {
    private Activity activity;

    public MeiTuAdapter(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiTuViewHolder(parent);
    }

    private class MeiTuViewHolder extends BaseViewHolder<MeiTu.NewslistBean> {
        private ImageView ivImage;

        public MeiTuViewHolder(ViewGroup parent) {
            super(parent, R.layout.meitu_layout_item);
            ivImage = (ImageView) $(R.id.ivImage);

        }

        @Override
        public void setData(MeiTu.NewslistBean data) {

            Glide.with(getContext())
                    .load(data.getPicUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .centerCrop()
                    .into(ivImage);
        }
    }
}
