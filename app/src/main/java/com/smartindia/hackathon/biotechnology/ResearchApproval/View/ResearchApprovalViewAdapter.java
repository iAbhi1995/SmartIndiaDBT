package com.smartindia.hackathon.biotechnology.ResearchApproval.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchDataDetails;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.MockProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.RetrofitRsrchApprvlProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter.ResearchApprovalPresenter;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter.ResearchApprovalPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class ResearchApprovalViewAdapter extends RecyclerView.Adapter<ResearchApprovalViewAdapter.MyViewHolder> implements ResearchApprovalView {

    private LayoutInflater inflater;
    public Context context;
    public List<Integer> checked;
    ArrayList<ResearchDataDetails> data;
    ResearchApprovalPresenter presenter;
    public ResearchApprovalViewAdapter(Context context, ArrayList<ResearchDataDetails> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
        checked=new ArrayList<>();
//        presenter=new ResearchApprovalPresenterImpl(new RetrofitRsrchApprvlProvider(),this);
        presenter=new ResearchApprovalPresenterImpl(new MockProvider(),this);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.research_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
        final ResearchDataDetails item=data.get(i);
        myViewHolder.researchName.setText(item.getResearchName());
        myViewHolder.studentName.setText(item.getStuName());
        myViewHolder.studentEmail.setText(item.getStuEmail());
        if(item.isFlag())
        {
            myViewHolder.accept.setClickable(false);
            myViewHolder.accept.setVisibility(View.GONE);
            myViewHolder.reject.setClickable(false);
            myViewHolder.reject.setVisibility(View.GONE);
            myViewHolder.result.setVisibility(View.VISIBLE);
            myViewHolder.result.setText("Action Taken");
        }
        myViewHolder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestResearchApproval(item.getResearchId(),item.getStuId(),"1");
            }
        });
        myViewHolder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestResearchApproval(item.getResearchId(),item.getStuId(),"2");
            }
        });
        myViewHolder.stuProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Code for calling profile of student....


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public void showMessage(String message) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

    ResearchApprovalPresenter approvalPresenter;
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView researchName,studentName,studentEmail,result;
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
        result=(TextView)itemView.findViewById(R.id.result);
    }
}
}
