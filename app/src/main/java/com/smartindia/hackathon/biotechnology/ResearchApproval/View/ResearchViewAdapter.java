package com.smartindia.hackathon.biotechnology.ResearchApproval.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchDataDetails;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.RetrofitRsrchApprvlProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter.ResearchApprovalPresenter;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter.ResearchApprovalPresenterImpl;

import java.util.ArrayList;

public class ResearchViewAdapter extends RecyclerView.Adapter<ResearchViewAdapter.MyViewHolder> implements ResearchView{

    private LayoutInflater inflater;
    public Context context;
    ArrayList<ResearchDataDetails> data;
    ResearchApprovalPresenter presenter;
    public ResearchViewAdapter(Context context, ArrayList<ResearchDataDetails> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
        presenter=new ResearchApprovalPresenterImpl(new RetrofitRsrchApprvlProvider(),this);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.research_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        ResearchDataDetails item=data.get(i);
        myViewHolder.researchName.setText(item.getResearchName());
        myViewHolder.studentName.setText(item.getStuName());
        myViewHolder.studentEmail.setText(item.getStuEmail());
        myViewHolder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myViewHolder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myViewHolder.stuProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void showProgressBar(boolean b) {


    }

    @Override
    public void showMessage(String message) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView researchName,studentName,studentEmail;
        public final Button accept,reject,stuProfileButton;
        public ProgressBar progressBar;
    public MyViewHolder(View itemView)
    {
        super(itemView);
        researchName=(TextView)itemView.findViewById(R.id.research_name);
        studentName=(TextView)itemView.findViewById(R.id.stu_name);
        studentEmail=(TextView)itemView.findViewById(R.id.stu_email);
        accept=(Button)itemView.findViewById(R.id.accept_button);
        reject=(Button)itemView.findViewById(R.id.reject_button);
        stuProfileButton=(Button)itemView.findViewById(R.id.stu_profile_button);
        progressBar=(ProgressBar)itemView.findViewById(R.id.progressbar);
    }
}
}
