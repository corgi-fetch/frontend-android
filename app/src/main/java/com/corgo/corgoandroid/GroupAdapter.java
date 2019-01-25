package com.corgo.corgoandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel on 1/7/2019.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private final ArrayList<Group> mGroupList;
    private LayoutInflater mInflater;
    public final static String EXTRA_GROUP_NAME = "com.corgo.corgoandroid.GROUP_NAME";
    public final static String EXTRA_GROUP_ID = "com.corgo.corgoandroid.GROUP_ID";


    public GroupAdapter(Context context, ArrayList<Group> groupList) {
        mInflater = LayoutInflater.from(context);
        this.mGroupList = groupList;
    }

    @Override
    public GroupAdapter.GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView;
        if (viewType == 1) {
            mItemView = mInflater.inflate(R.layout.group_title, parent, false);
        } else {
            mItemView = mInflater.inflate(R.layout.group_item, parent, false);
        }
        return new GroupViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(GroupAdapter.GroupViewHolder holder, int position) {
        if (position != 0) {
            int toGet = position - 1;
            Group mCurrent = mGroupList.get(toGet);
            holder.groupItemName.setText(mCurrent.getGroupName());
//            holder.item.setOnClickListener();
        }


    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }

    @Override
    public int getItemCount() {
        return mGroupList.size() + 1;
    }

    class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //public final ImageView groupItemAvatar;
        public final TextView groupItemName;
        public final LinearLayout item;
        private final Context context;


        final GroupAdapter mAdapter;

        public GroupViewHolder(View itemView, GroupAdapter adapter) {
            super(itemView);
            context = itemView.getContext();
            //groupItemAvatar = itemView.findViewById(R.id.group_item_avatar);
            groupItemName = itemView.findViewById(R.id.group_item_name);
            item = itemView.findViewById(R.id.group_item);
//            if (getAdapterPosition() == 0) {
                itemView.setClickable(true);
                itemView.setOnClickListener(this);
            //}

            this.mAdapter = adapter;

        }



        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != 0) {
                //Intent intent = new Intent(context, GroupActivity.class);
                Intent intent = new Intent(context, ScrollingActivity.class);
                Bundle extras = new Bundle();
                extras.putString(EXTRA_GROUP_NAME, mGroupList.get(position - 1).getGroupName());
                extras.putString(EXTRA_GROUP_ID, mGroupList.get(position - 1).getGroupId());
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        }
    }
}


