package com.tatait.tata_video.api;

import com.tatait.tata_video.model.Channel;

/**
 * Created by Lynn on 17/12/1.
 */

public abstract class BaseSiteApi {

    public abstract void onGetChannelAlbums(Channel channel, int pageNo, int pageSize, OnGetChannelAlbumListener listener);
}
