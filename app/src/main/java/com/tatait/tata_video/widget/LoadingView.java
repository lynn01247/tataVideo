package com.tatait.tata_video.widget;

import android.content.Context;
import android.widget.LinearLayout;

import com.tatait.tata_video.R;

/**
 * Created by Lynn on 17/12/15.
 */

public class LoadingView extends LinearLayout {

    public LoadingView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.loading_view_layout ,this);
    }
}
