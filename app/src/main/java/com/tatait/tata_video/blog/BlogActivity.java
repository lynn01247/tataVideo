package com.tatait.tata_video.blog;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.tatait.tata_video.R;
import com.tatait.tata_video.base.BaseActivity;

public class BlogActivity extends BaseActivity {

    private WebView mWebView;
    private ProgressBar mProgressBar;
    private static final int MAX_VALUE = 100;
    private static final String BLOG_URL = "https://github.com/lynn01247";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_blog;
    }

    @Override
    protected void initView() {
        LinearLayout back_ll = bindViewId(R.id.app_bar_back);
        back_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mWebView = bindViewId(R.id.webview);
        mProgressBar = bindViewId(R.id.pb_progress);
        WebSettings settings = mWebView.getSettings();//用来设置webview的属性
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        mProgressBar.setMax(MAX_VALUE);
        mWebView.loadUrl(BLOG_URL);
        mWebView.setWebChromeClient(mWebChromeClient);
    }

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mProgressBar.setProgress(newProgress);//加载过程中更新进度
            if (newProgress == MAX_VALUE) {
                mProgressBar.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress);
        }
    };

    @Override
    protected void initData() {

    }
}
