package com.tatait.tata_video.home;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;

import com.tatait.tata_video.FragmentManagerWrapper;
import com.tatait.tata_video.GuideActivity;
import com.tatait.tata_video.base.BaseActivity;
import com.tatait.tata_video.blog.BlogActivity;
import com.tatait.tata_video.favorite.FavoriteActivity;
import com.tatait.tata_video.history.HistoryActivity;

public class HomeActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private MenuItem mPreItem;
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment;

    @Override
    protected int getLayoutId() {
        return com.tatait.tata_video.R.layout.activity_home;
    }

    @Override
    protected void initView() {
        setSupportActionBar();
        setActionBarIcon(com.tatait.tata_video.R.drawable.ic_drawer_home);
        setTitle("视频");

        mDrawerLayout = bindViewId(com.tatait.tata_video.R.id.drawer_layout);
        mNavigationView = bindViewId(com.tatait.tata_video.R.id.navigation_view);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, com.tatait.tata_video.R.string.drawer_open, com.tatait.tata_video.R.string.drawer_close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        //TODO
        mPreItem = mNavigationView.getMenu().getItem(0);
        mPreItem.setChecked(true);
        initFragment();
        handleNatigationView();
    }

    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
        mCurrentFragment = FragmentManagerWrapper.getInstance().createFragment(HomeFragment.class);
        mFragmentManager.beginTransaction().add(com.tatait.tata_video.R.id.fl_main_content, mCurrentFragment).commit();
    }

    private void handleNatigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case com.tatait.tata_video.R.id.navigation_item_video:
                        if (mPreItem != null) {
                            mPreItem.setCheckable(false);
                        }
                        switchFragment(HomeFragment.class);
                        mToolBar.setTitle(com.tatait.tata_video.R.string.home_title);
                        mPreItem = item;
                        mDrawerLayout.closeDrawer(Gravity.START);
                        item.setChecked(true);
                        break;
                    case com.tatait.tata_video.R.id.navigation_item_blog:
//                        if (mPreItem != null) {
//                            mPreItem.setCheckable(false);
//                        }
//                        switchFragment(BlogFragment.class);
//                        mToolBar.setTitle(com.tatait.tata_video.R.string.blog_title);
//                        mPreItem = item;
//                        mDrawerLayout.closeDrawer(Gravity.START);
//                        item.setChecked(true);
                        startActivity(new Intent(HomeActivity.this, BlogActivity.class));
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case com.tatait.tata_video.R.id.navigation_item_about:
//                        switchFragment(AboutFragment.class);
//                        mToolBar.setTitle(com.tatait.tata_video.R.string.about_title);
                        startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case com.tatait.tata_video.R.id.navigation_item_history:
                        HistoryActivity.launch(HomeActivity.this);
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                    case com.tatait.tata_video.R.id.navigation_item_collect:
                        FavoriteActivity.launch(HomeActivity.this);
                        mDrawerLayout.closeDrawer(Gravity.START);
                        break;
                }
                return false;
            }
        });
    }

    private void switchFragment(Class<?> clazz) {
        Fragment fragment = FragmentManagerWrapper.getInstance().createFragment(clazz);
        if (fragment.isAdded()) {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).show(fragment).commitAllowingStateLoss();
        } else {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).add(com.tatait.tata_video.R.id.fl_main_content, fragment).commitAllowingStateLoss();
        }
        mCurrentFragment = fragment;
    }

    @Override
    protected void initData() {
       //TODO
    }
}
