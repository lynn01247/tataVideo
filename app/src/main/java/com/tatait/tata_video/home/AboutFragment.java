package com.tatait.tata_video.home;

import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import com.tatait.tata_video.R;
import com.tatait.tata_video.base.BaseFragment;

/**
 * Created by Lynn on 17/11/21.
 */

public class AboutFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void initView() {
        TextView textView = bindViewId(R.id.tv_app_des);
        textView.setAutoLinkMask(Linkify.ALL);//表示文字中有链接可点
        textView.setMovementMethod(LinkMovementMethod.getInstance());//表示文字可以滚动
    }

    @Override
    protected void initData() {

    }
}
