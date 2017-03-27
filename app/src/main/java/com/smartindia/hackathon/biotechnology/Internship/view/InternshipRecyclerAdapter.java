package com.smartindia.hackathon.biotechnology.Internship.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipItemData;
import com.smartindia.hackathon.biotechnology.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class InternshipRecyclerAdapter extends RecyclerView.Adapter<InternshipRecyclerAdapter.MyViewHolder>{
    private List<InternshipItemData> internshipItemDataList = new ArrayList<>();
    private Context context;
    private InternshipView internshipView;
    private InternshipFragment internshipFragment;
    private LayoutInflater layoutInflater;

    public InternshipRecyclerAdapter(Context context, InternshipFragment internshipFragment) {
        this.context = context;
        this.internshipView = new InternshipFragment();
        this.internshipFragment = internshipFragment;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<InternshipItemData> itemDataList) {
        this.internshipItemDataList = itemDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.fragment_internship, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final InternshipItemData internshipItemData=  internshipItemDataList.get(position);



    }

    @Override
    public int getItemCount() {
        return internshipItemDataList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
