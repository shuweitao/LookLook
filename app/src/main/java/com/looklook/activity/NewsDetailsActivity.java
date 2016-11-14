package com.looklook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.looklook.R;
import com.looklook.view.MyToolbar;

import java.util.ArrayList;

/**
 * @author swt
 * @time 2016/11/3 14:19
 */
public class NewsDetailsActivity extends BaseActivity {
    ImageView ivImage;
    MyToolbar toolbar;
    WebView webtext;
    private CollapsingToolbarLayout collapsing_toolbar;
    private FloatingActionButton fab_gd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        initData();
    }

    private void initView() {
        ivImage = (ImageView) findViewById(R.id.ivImage);
        toolbar = (MyToolbar) findViewById(R.id.toolbar);
        webtext = (WebView) findViewById(R.id.web_text);
        fab_gd = (FloatingActionButton) findViewById(R.id.fab_gd);
        collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("新闻详情");

    }

    private void initData() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //设置返回箭头
        toolbar.setGravityCenter();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.top_arrow_back));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //新页面的数据
        Bundle bundle = this.getIntent().getExtras();
        ArrayList<String> data = bundle.getStringArrayList("data");
        Log.i("url", data.get(0));
        webtext.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webtext.loadUrl(data.get(1));
        Glide.with(this).load(data.get(0)).error(R.mipmap.bg).fitCenter().into(ivImage);

        fab_gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "美图有美女", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
