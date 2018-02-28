package com.tatait.tata_video.api;

import com.tatait.tata_video.model.ErrorInfo;
import com.tatait.tata_video.model.sohu.Video;

/**
 * Created by Lynn on 17/12/1.
 */

public interface OnGetVideoPlayUrlListener {

    void onGetSuperUrl(Video video, String url);//超清url

    void onGetNoramlUrl(Video video, String url);//标清url

    void onGetHighUrl(Video video, String url);//高清url

    void onGetFailed(ErrorInfo info);

}
