package com.smartindia.hackathon.biotechnology.Internship.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
        View view = layoutInflater.inflate(R.layout.internship_item, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final InternshipItemData internshipItemData=  internshipItemDataList.get(position);
holder.skillName.setText(internshipItemData.getTopic());
        holder.companyName.setText(internshipItemData.getCompanyName());
        holder.stipend.setText(internshipItemData.getStipend());
        holder.duration.setText(internshipItemData.getDuration());
        holder.location.setText(internshipItemData.getLocation());
        holder.startDate.setText(internshipItemData.getStartDate());
holder.appliedBy.setText(internshipItemData.getApplyBy());
holder.button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //isme aage jane ke liye
    }
});
    }

    @Override
    public int getItemCount() {
        return internshipItemDataList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        private TextView skillName ;
        private TextView companyName ;
        private  TextView startDate;


        private TextView duration ;
        private  TextView stipend;
        private TextView appliedBy;
        private TextView location;
        private Button button;




        public MyViewHolder(View itemView) {
            super(itemView);

            skillName=(TextView)itemView.findViewById(R.id.text1);

            companyName=(TextView)itemView.findViewById(R.id.textView);
            location=(TextView)itemView.findViewById(R.id.internship_location);
            startDate=(TextView)itemView.findViewById(R.id.internship_startDate);
            duration=(TextView)itemView.findViewById(R.id.internship_duration);
            stipend=(TextView)itemView.findViewById(R.id.internship_stipend);

            appliedBy=(TextView)itemView.findViewById(R.id.internship_applied);
            button=(Button)itemView.findViewById(R.id.button2);






        }
    }
}
