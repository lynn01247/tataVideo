package com.tatait.tata_video.live;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.tatait.tata_video.R;
import com.tatait.tata_video.base.BaseActivity;

public class LiveActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private TextView mHdpTips;
    private static final int TIPS_DURATION = 3000;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_live;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://actionbar 左边箭头id
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initView() {
        setSupportActionBar();
        setSupportArrowActionBar(true);
        setTitle(getResources().getString(R.string.live_title));

        mRecyclerView = bindViewId(R.id.ry_live);
        mHdpTips = bindViewId(R.id.hdp_tips);
        //1 表示一列
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        //垂直布局排列
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new MyDecoration(this));
        LiveItemAdapter adapter = new LiveItemAdapter(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.scrollToPosition(0);//回到第一个位置
    }

    @Override
    protected void initData() {
        new android.os.Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mHdpTips.setVisibility(View.GONE);
            }
        }, TIPS_DURATION);
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, LiveActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }
}
