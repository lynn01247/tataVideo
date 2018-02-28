package com.tatait.tata_video.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.View;
import android.widget.LinearLayout;

import com.tatait.tata_video.BuildConfig;
import com.tatait.tata_video.R;
import com.tatait.tata_video.base.BaseActivity;
import com.tencent.bugly.beta.Beta;

/**
 * AboutActivity
 * Created by Lynn on 2015/12/27.
 */
public class AboutActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    protected void initView() {
        getFragmentManager().beginTransaction().replace(R.id.ll_fragment_container, new AboutFragment()).commit();
    }

    @Override
    protected void initData() {
        LinearLayout back_ll = bindViewId(R.id.app_bar_back);
        back_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static class AboutFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {
        private Preference mVersion;
        private Preference mUpdate;
        private Preference mShare;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference_about);

            mVersion = findPreference("version");
            mUpdate = findPreference("update");
            mShare = findPreference("share");

            mVersion.setSummary("V " + BuildConfig.VERSION_NAME);
            setListener();
        }

        private void setListener() {
            mUpdate.setOnPreferenceClickListener(this);
            mShare.setOnPreferenceClickListener(this);
        }

        @Override
        public boolean onPreferenceClick(Preference preference) {
            if (preference == mUpdate) {
                Beta.checkUpgrade();
                return true;
            } else if (preference == mShare) {
                share();// openUrl(preference.getSummary().toString());
                return true;
            }
            return false;
        }

        private void share() {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app, getString(R.string.app_name)));
            startActivity(Intent.createChooser(intent, getString(R.string.share)));
        }

        private void openUrl(String url) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
    }
}