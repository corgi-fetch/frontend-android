package com.corgo.corgoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Intent intent = getIntent();
        String title = intent.getStringExtra(GroupAdapter.EXTRA_GROUP_NAME);
        String id = intent.getStringExtra(GroupAdapter.EXTRA_GROUP_ID);

        Toolbar toolbar = (Toolbar) findViewById(R.id.group_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(title);
    }
}
