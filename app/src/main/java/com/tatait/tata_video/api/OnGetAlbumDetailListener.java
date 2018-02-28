package com.tatait.tata_video.api;

import com.tatait.tata_video.model.Album;
import com.tatait.tata_video.model.ErrorInfo;

/**
 * Created by Lynn on 17/12/1.
 */

public interface OnGetAlbumDetailListener {
    void onGetAlbumDetailSuccess(Album album);
    void onGetAlbumDetailFailed(ErrorInfo info);
}
