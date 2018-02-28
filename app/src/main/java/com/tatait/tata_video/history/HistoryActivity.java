package com.tatait.tata_video.history;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.tatait.tata_video.R;
import com.tatait.tata_video.common.CommonActivity;

public class HistoryActivity extends CommonActivity {

    @Override
    public String getTitleText() {
        return getResources().getString(R.string.history_title);
    }

    @Override
    public String getEmptyText() {
        return getResources().getString(R.string.history_empty);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public String getTableName() {
        return "history";
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, HistoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        activity.startActivity(intent);
    }

}
