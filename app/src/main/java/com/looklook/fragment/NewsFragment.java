package com.looklook.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.looklook.R;
import com.looklook.activity.NewsDetailsActivity;
import com.looklook.adapter.NewsAdapter;
import com.looklook.beans.News;
import com.looklook.utils.Api;
import com.looklook.utils.Constant;
import com.looklook.utils.JsonUtils;
import com.looklook.utils.OkHttpUtils;
import com.looklook.utils.PixUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author swt
 * @time 2016/11/2 15:23
 */

public class NewsFragment extends BaseFragent {

    private EasyRecyclerView recyclerView;
    private NewsAdapter adapter;
    private int page = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment_layout, container, false);
        recyclerView = (EasyRecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new NewsAdapter(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //添加边框
        SpaceDecoration itemDecoration = new SpaceDecoration((int) PixUtil.convertDpToPixel(8, getContext()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);

        //加载更多
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                getData();
            }

            @Override
            public void onMoreClick() {

            }
        });

        //刷新
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        page = 0;
                        getData();
                    }
                }, 100);
            }
        });

        //点击事件
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<String> data = new ArrayList<String>();
                data.add(adapter.getAllData().get(position).getPicUrl());
                data.add(adapter.getAllData().get(position).getUrl());
                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                //用Bundle携带数据
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("data", data);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    public void getData() {
        Map<String, String> mParams = new HashMap<String, String>();
        mParams.put("key", Constant.APIKEY);
        mParams.put("num", "10");
        mParams.put("page", page + "");
        String method = "social/";

        OkHttpUtils.get(Api.BASE_URL + method + OkHttpUtils.doUrl(mParams), new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                Log.i("swt", response);
//                ArrayList<News> news= JsonUtils.deserialize(response, new TypeToken<List<News>>(){}.getType());
                News news = JsonUtils.deserialize(response, News.class);
                List<News.NewslistBean> newslist = news.getNewslist();
                adapter.addAll(newslist);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(getContext(), "获取数据失败", Toast.LENGTH_LONG).show();
            }
        });

        page = page + 1;
    }
}
