package com.tatait.tata_video.home;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lynn on 17/11/25.
 */

public class HomePicAdapter extends PagerAdapter {
    private Context mContext;

    private int[] mDes = new int[] {
            com.tatait.tata_video.R.string.a_name,
            com.tatait.tata_video.R.string.b_name,
            com.tatait.tata_video.R.string.c_name,
            com.tatait.tata_video.R.string.d_name,
            com.tatait.tata_video.R.string.e_name,
    };

    private int[] mImg = new int[] {
            com.tatait.tata_video.R.drawable.a,
            com.tatait.tata_video.R.drawable.b,
            com.tatait.tata_video.R.drawable.c,
            com.tatait.tata_video.R.drawable.d,
            com.tatait.tata_video.R.drawable.e,
            com.tatait.tata_video.R.drawable.f,
    };

    public HomePicAdapter(Activity activity) {
        mContext = activity;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       View view = LayoutInflater.from(mContext).inflate(com.tatait.tata_video.R.layout.home_pic_item, null);
        TextView textView = (TextView) view.findViewById(com.tatait.tata_video.R.id.tv_dec);
        ImageView imageView = (ImageView) view.findViewById(com.tatait.tata_video.R.id.iv_img);
        textView.setText(mDes[position]);
        imageView.setImageResource(mImg[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
