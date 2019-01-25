package com.corgo.corgoandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Daniel on 1/1/2019.
 */

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    private final ArrayList<Post> mPostList;
    private LayoutInflater mInflater;

    public TimelineAdapter(Context context, ArrayList<Post> postList) {
        mInflater = LayoutInflater.from(context);
        this.mPostList = postList;
    }

    @Override
    public TimelineAdapter.TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.timeline_item, parent, false);
        return new TimelineViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(TimelineAdapter.TimelineViewHolder holder, int position) {
        Post mCurrent = mPostList.get(position);
        holder.timelineItemInfo.setText(mCurrent.getDescription());
        if (mCurrent.getDescription().length() < 75) {
            holder.timelineItemInfo.setTextSize(28);
        } else if (mCurrent.getDescription().length() < 125) {
            holder.timelineItemInfo.setTextSize(22);
        } else {
            holder.timelineItemInfo.setTextSize(16);
        }
        holder.timelineItemTitle.setText(mCurrent.getTitle());
        //holder.timelineItemAvatar
        holder.timelineItemPayment.setText(mCurrent.getPayment());
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    class TimelineViewHolder extends RecyclerView.ViewHolder {
        //public final ImageView timelineItemAvatar;
        public final TextView timelineItemTitle;
        public final TextView timelineItemPayment;
        public final TextView timelineItemInfo;

        final TimelineAdapter mAdapter;

        public TimelineViewHolder(View itemView, TimelineAdapter adapter) {
            super(itemView);
            //timelineItemAvatar = itemView.findViewById(R.id.card_avatar);
            timelineItemTitle = itemView.findViewById(R.id.card_title);
            timelineItemPayment = itemView.findViewById(R.id.card_payment);
            timelineItemInfo = itemView.findViewById(R.id.card_info);
            this.mAdapter = adapter;
        }
    }
}
