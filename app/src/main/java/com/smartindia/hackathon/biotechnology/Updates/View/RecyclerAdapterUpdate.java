package com.smartindia.hackathon.biotechnology.Updates.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;

import java.util.List;

public class RecyclerAdapterUpdate extends RecyclerView.Adapter<RecyclerAdapterUpdate.MyViewHolder> {

    public Context context;
    private LayoutInflater inflater;
    private List<String> data;

    public RecyclerAdapterUpdate(Context context, List<String> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        Log.d("Fragment", "Setting Adapter");
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_item_update, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterUpdate.MyViewHolder myViewHolder, int i) {

        String item = data.get(i);
        Log.d("Fragment", "OnBindView Holder");
        myViewHolder.news.setText(item);
    }

    @Override
    public int getItemCount() {
        Log.d("Count", data.size() + "");
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView news;

        public MyViewHolder(View itemView) {
            super(itemView);
            news = (TextView) itemView.findViewById(R.id.news_feed);
        }
    }
}