package com.corgo.corgoandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {

    private final ArrayList<Post> mPostList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private TimelineAdapter mAdapter;


    public TimelineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Random randomGen = new Random();

        for (int i = 0; i < 20; i++) {
            Post addPost = new Post();
            int random = randomGen.nextInt(3);
            Log.d("testing random", String.valueOf(random));
            if (random == 0) {
                addPost.setDescription("This is the description for post " + i + ". Doesn't it look great! Cheers. :)");
            } else if (random == 1) {
                addPost.setDescription("A longer description for post " + i + ". Can I get a poke bowl from Poke Parlor, large, with Salmon, Tuna, Tako, and Yellowfin. Jalepenos, seaweed salad, carrots, corn, and mangoes. Furikaki, wasabi, and sesame seeds as the topping. Pepsi beverage!");
            } else {
                addPost.setDescription("Can somebody pick up some toilet paper from walgreens? This is for post " + i + " by the way. We are running super low.");
            }
            addPost.setTitle("Post " + i);
            addPost.setPayment("$" + i + ".00");
            mPostList.add(addPost);
        }



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        mRecyclerView = view.findViewById(R.id.timeline_recycler);

        mAdapter = new TimelineAdapter(getContext().getApplicationContext(), mPostList);
        mRecyclerView.setAdapter(this.mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));

        return view;
    }

}
