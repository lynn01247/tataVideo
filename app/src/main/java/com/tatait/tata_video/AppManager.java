package com.tatait.tata_video;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.gson.Gson;
import com.tencent.bugly.Bugly;

import okhttp3.OkHttpClient;

import static com.tatait.tata_video.widget.KeyStore.BUGLY_APP_ID_;

/**
 * Created by Lynn on 17/12/4.
 */

public class AppManager extends Application {

    private static Gson mGson;
    private static OkHttpClient mOkHttpClient;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mGson = new Gson();
        mOkHttpClient = new OkHttpClient();
        initBugly();
    }

    public static Gson getGson() {
        return mGson;
    }

    public static OkHttpClient getHttpClient() {
        return mOkHttpClient;
    }

    public static Context getContext() {
        return mContext;
    }

    public static Resources getResource() {
        return mContext.getResources();
    }

    /**
     * 当前网络是否可用
     * @return
     */
    public static boolean isNetWorkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isNetworkWifiAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(1) != null) {
            NetworkInfo.State state = connectivityManager.getNetworkInfo(1).getState();
            if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    private void initBugly() {
        if (!BuildConfig.DEBUG) {
            Bugly.init(this, BUGLY_APP_ID_, false);
        }
    }
}
