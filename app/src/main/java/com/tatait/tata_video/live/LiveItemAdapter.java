package com.tatait.tata_video.live;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tatait.tata_video.player.PlayActivity;
import com.tatait.tata_video.R;

/**
 * Created by Lynn on 17/12/30.
 */

public class LiveItemAdapter extends RecyclerView.Adapter<LiveItemAdapter.ViewHolder> {

    private Context mContext;
    // 数据集
    private String[] mDataList = new String[] {
            "公视1","公视2","公视3","TVBS新闻","动物星球",
            "星空卫视","体育1台",
    };

    private int[] mIconList = new int[] {
            R.drawable.ic_live, R.drawable.ic_live, R.drawable.ic_live, R.drawable.ic_live, R.drawable.ic_live,
            R.drawable.ic_live, R.drawable.ic_live,
    };

    private String [] mUrlList = new String[]{
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=6",
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=7",
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=8",
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=25",
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=35",
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=73",
            "http://115.159.45.139:8888/52itv.net/ltv/index.m3u8?c=78",
    };

    public LiveItemAdapter(Context context) {
        mContext = context;
    }
    // view 相关
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.live_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    // 数据相关
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mIcon.setImageResource(mIconList[position]);
        holder.mTitle.setText(mDataList[position]);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayActivity.launch((Activity)mContext, mUrlList[position], mDataList[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mIcon;
        public TextView mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.iv_live_icon);
            mTitle = (TextView) itemView.findViewById(R.id.tv_live_title);
        }
    }

}
