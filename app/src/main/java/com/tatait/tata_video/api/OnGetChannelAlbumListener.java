package com.tatait.tata_video.api;

import com.tatait.tata_video.model.AlbumList;
import com.tatait.tata_video.model.ErrorInfo;

/**
 * Created by Lynn on 17/12/1.
 */

public interface OnGetChannelAlbumListener {
    void onGetChannelAlbumSuccess(AlbumList albumList);
    void onGetChannelAlbumFailed(ErrorInfo info);
}
