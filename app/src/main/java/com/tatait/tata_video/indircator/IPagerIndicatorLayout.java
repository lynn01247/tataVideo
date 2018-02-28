package com.tatait.tata_video.indircator;

/**
 * Created by Lynn on 17/12/8.
 */

public interface IPagerIndicatorLayout extends IPagerChangeListener{

    /**
     * 添加到CoolIndicatorLayout上
     */
    void onAttachCoolIndicatorLayout();

    /**
     * 从CoolIndicatorLayout下移除
     */
    void onDetachCoolIndicatorLayout();
}
