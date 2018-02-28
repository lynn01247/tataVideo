package com.tatait.tata_video.model.sohu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lynn on 17/12/4.
 */

public class Data {

    @Expose
    private int count;

    @Expose
    @SerializedName("videos")
    private List<ResultAlbum> resultAlbumList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ResultAlbum> getResultAlbumList() {
        return resultAlbumList;
    }

    public void setResultAlbumList(List<ResultAlbum> resultAlbumList) {
        this.resultAlbumList = resultAlbumList;
    }
}
