package com.tatait.tata_video.api;

import android.content.Context;

import com.tatait.tata_video.model.Album;
import com.tatait.tata_video.model.Channel;
import com.tatait.tata_video.model.Site;
import com.tatait.tata_video.model.sohu.Video;

/**
 * Created by Lynn on 17/12/1.
 */

public class SiteApi {

    public static void onGetChannelAlbums(Context context, int pageNo, int pageSize, int siteId, int channelId, OnGetChannelAlbumListener listener) {
        switch (siteId) {
            case Site.LETV:
                new LetvApi().onGetChannelAlbums(new Channel(channelId, context), pageNo, pageSize , listener);
                break;
            case Site.SOHU:
                new SohuApi().onGetChannelAlbums(new Channel(channelId, context), pageNo, pageSize , listener);
                break;
        }
    }

    public static void onGetAlbumDetail(Album album, OnGetAlbumDetailListener listener) {
        int siteId = album.getSite().getSiteId();
        switch (siteId) {
            case Site.LETV:
                new LetvApi().onGetAlbumDetail(album, listener);
                break;
            case Site.SOHU:
                new SohuApi().onGetAlbumDetail(album, listener);
                break;
        }
    }

    /**
     * 取video相关信息
     * @param album
     * @param listener
     */
    public static void onGetVideo(int pageSize, int pageNo, Album album, OnGetVideoListener listener) {
        int siteId = album.getSite().getSiteId();
        switch (siteId) {
            case Site.LETV:
                new LetvApi().onGetVideo(album, pageSize, pageNo, listener);
                break;
            case Site.SOHU:
                new SohuApi().onGetVideo(album,  pageSize, pageNo, listener);
                break;
        }
    }

    public static void onGetVideoPlayUrl(Video video, OnGetVideoPlayUrlListener listener) {
        int siteId = video.getSite();
        switch (siteId) {
            case Site.LETV:
                new LetvApi().onGetVideoPlayUrl(video,  listener);
                break;
            case Site.SOHU:
                new SohuApi().onGetVideoPlayUrl(video,   listener);
                break;
        }
    }

}
