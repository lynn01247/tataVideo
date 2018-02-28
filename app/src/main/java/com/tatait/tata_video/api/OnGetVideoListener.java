package com.tatait.tata_video.api;

import com.tatait.tata_video.model.ErrorInfo;
import com.tatait.tata_video.model.sohu.VideoList;

/**
 * Created by Lynn on 17/12/1.
 */

public interface OnGetVideoListener {
    void OnGetVideoSuccess(VideoList videoList);
    void OnGetVideoFailed(ErrorInfo info);
}
