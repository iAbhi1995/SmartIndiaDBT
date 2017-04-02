package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.SurveyResultDetails;

import java.util.List;

public class RecyclerSurveyViewerAdapter extends RecyclerView.Adapter<RecyclerSurveyViewerAdapter.MyViewHolder> {

    public Context context;
    private LayoutInflater inflater;
    private List<SurveyResultDetails> data;

    public RecyclerSurveyViewerAdapter(Context context, List<SurveyResultDetails> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
//        presenter=new ResearchApprovalPresenterImpl(new RetrofitRsrchApprvlProvider(),this);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recycler_item_survey_viewer, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
        final SurveyResultDetails item = data.get(i);
        myViewHolder.name.setText(item.getSurvey_name());
        myViewHolder.ques1.setText(item.getQues1());
        myViewHolder.accepted1.setText(item.getAns1());
        myViewHolder.rejected1.setText(100 - Double.parseDouble(item.getAns1()) + "");
        myViewHolder.ques2.setText(item.getQues2());
        myViewHolder.accepted2.setText(item.getAns2());
        myViewHolder.rejected2.setText(100 - Double.parseDouble(item.getAns2()) + "");
        myViewHolder.ques3.setText(item.getQues3());
        myViewHolder.accepted3.setText(item.getAns3());
        myViewHolder.rejected3.setText(100 - Double.parseDouble(item.getAns3()) + "");
        myViewHolder.ques4.setText(item.getQues4());
        myViewHolder.accepted4.setText(item.getAns4());
        myViewHolder.rejected4.setText(100 - Double.parseDouble(item.getAns4()) + "");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView accepted1, accepted2, accepted3, accepted4, rejected1, rejected2, rejected3, rejected4;
        public final TextView ques1, ques2, ques3, ques4, name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            accepted1 = (TextView) itemView.findViewById(R.id.accepted1);
            accepted2 = (TextView) itemView.findViewById(R.id.accepted2);
            accepted3 = (TextView) itemView.findViewById(R.id.accepted3);
            accepted4 = (TextView) itemView.findViewById(R.id.accepted4);
            rejected1 = (TextView) itemView.findViewById(R.id.rejected1);
            rejected2 = (TextView) itemView.findViewById(R.id.rejected2);
            rejected3 = (TextView) itemView.findViewById(R.id.rejected3);
            rejected4 = (TextView) itemView.findViewById(R.id.rejected4);
            ques1 = (TextView) itemView.findViewById(R.id.quest1);
            ques2 = (TextView) itemView.findViewById(R.id.quest2);
            ques3 = (TextView) itemView.findViewById(R.id.quest3);
            ques4 = (TextView) itemView.findViewById(R.id.quest4);
        }
    }
}