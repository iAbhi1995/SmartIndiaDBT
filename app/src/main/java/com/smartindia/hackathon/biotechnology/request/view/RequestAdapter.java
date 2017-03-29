package com.smartindia.hackathon.biotechnology.request.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestDataDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder>{

    private List<RequestDataDetails>detailsList=new ArrayList<>();
    private RequestFragment requestFragment;
    private LayoutInflater layoutInflater;
    private Context context;
    private RequestView requestView;

    public RequestAdapter( Context context,RequestFragment requestFragment ) {
        this.requestFragment = requestFragment;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.requestView=new RequestFragment();
    }


    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.my_internships, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final RequestDataDetails requestDataDetails=detailsList.get(position);

        holder.skillName.setText(requestDataDetails.getSkillName());

        holder.companyName.setText(requestDataDetails.getCompanyName());
        holder.appliedOn.setText(requestDataDetails.getAppliedOn());
        holder.appiedStatus.setText(requestDataDetails.getAppliedStatus());
        holder.comment.setText(requestDataDetails.getComment());


    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }
    public void setData(List<RequestDataDetails> requestDataDetailses) {
        detailsList = requestDataDetailses;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView skillName ;
        private TextView companyName ;
        private  TextView appliedOn;
        private TextView appiedStatus;
        private TextView comment;




        public MyViewHolder(View itemView) {
            super(itemView);
            skillName=(TextView)itemView.findViewById(R.id.text1);
            companyName=(TextView)itemView.findViewById(R.id.textView);
            appiedStatus=(TextView)itemView.findViewById(R.id.internship_status);
            appliedOn=(TextView)itemView.findViewById(R.id.internship_applied);
            comment=(TextView)itemView.findViewById(R.id.internship_comment);

        }
    }
}
