package com.tatait.tata_video.model.sohu;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Lynn on 17/12/15.
 */

public class VideoList extends ArrayList<Video> {
    private static final String TAG = VideoList.class.getSimpleName();

    public void debug () {
        for (Video a : this) {
            Log.d(TAG, ">> videList " + a.toString());
        }
    }
}
