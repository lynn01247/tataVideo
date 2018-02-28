package com.tatait.tata_video.indircator;

import java.util.List;

/**
 * Created by Lynn on 17/12/8.
 */

public interface IPagerIndicatorView extends IPagerChangeListener {

    void setPostionDataList(List<PositionData> list);
}
