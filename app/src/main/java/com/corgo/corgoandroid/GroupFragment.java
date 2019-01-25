package com.corgo.corgoandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment {

    private final ArrayList<Group> mGroupList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private GroupAdapter mAdapter;

    public GroupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Random randomGen = new Random();

        for (int i = 0; i < 20; i++) {
            Group addGroup = new Group();
            addGroup.setGroupName("The title of this group " + i);
            mGroupList.add(addGroup);
        }



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        mRecyclerView = view.findViewById(R.id.group_recycler);

        mAdapter = new GroupAdapter(getContext().getApplicationContext(), mGroupList);
        mRecyclerView.setAdapter(this.mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_AUTO);

        return view;
    }
//
//    @Override
//    public void onClick(View v) {
//
//    }




}
