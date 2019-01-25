package com.corgo.corgoandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private int tabPosition;
    private String sharedPrefFile = "com.corgo.corgoandroid.mainactivitysharedprefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSharedPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        tabPosition = mSharedPreferences.getInt("currentTab", 0); // HERE

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setLogo(R.drawable.ic_logo);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_timeline));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_group));
        //tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_job));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_post));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_notification));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_menu));


        final FloatingActionButton fabPost = findViewById(R.id.fabPost);
        final FloatingActionButton fabGroup = findViewById(R.id.fabGroup);
        fabGroup.hide();
        fabPost.hide();


        final ViewPager viewPager = findViewById(R.id.pager);


        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (viewPager.getCurrentItem() == 0) {
                            fabPost.show();
                        } else if (viewPager.getCurrentItem() == 1) {
                            fabGroup.show();
                        }
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                    case ViewPager.SCROLL_STATE_SETTLING:
                        fabPost.hide();
                        fabGroup.hide();
                        break;
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPosition = tab.getPosition();
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(tabPosition);
        if (tabPosition == 0) {
            fabPost.show();
        } else if (tabPosition == 1) {
            fabGroup.show();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mSharedPreferences.edit();
        preferencesEditor.putInt("currentTab", tabPosition);
        preferencesEditor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        SharedPreferences.Editor preferencesEditor = mSharedPreferences.edit();
//        preferencesEditor.clear();
//        preferencesEditor.apply();
    }

    public void navigatePostListActivity(View view) {
        Intent intent = new Intent(this, PostListActivity.class);
        startActivity(intent);
    }

    public void navigateJobListActivity(View view) {
        Intent intent = new Intent(this, JobListActivity.class);
        startActivity(intent);
    }

    public void navigateCreatePostActivity(View view) {
        Intent intent = new Intent(this, CreatePostActivity.class);
        startActivity(intent);
    }

    public void navigateCreateJobActivity(View view) {
        Intent intent = new Intent(this, CreateGroupActivity.class);
        startActivity(intent);
    }

    public void navigateInviteListActivity(View view) {
        Intent intent = new Intent(this, InviteListActivity.class);
        startActivity(intent);
    }

    public void navigateAlertListActivity(View view) {
        Intent intent = new Intent(this, AlertListActivity.class);
        startActivity(intent);
    }

    public void navigateEditInfoActivity(View view) {
        Intent intent = new Intent(this, EditSettingsActivity.class);
        startActivity(intent);
    }
}
