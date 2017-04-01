package com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.Data.FeedbackQues;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Model.RetrofitFeedbackProvider;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Presenter.FeedbackPresenter;
import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.Presenter.FeedbackPresenterImpl;
import com.smartindia.hackathon.biotechnology.R;


public class Feedback_Fragment extends Fragment implements FeedbackView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FeedbackPresenter presenter;
    private static String instId="0";
    private static String INST_ID = "inst_id";
    private String comment = "";

    public Feedback_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Feedback_Fragment newInstance(String param1, String param2) {
        Feedback_Fragment fragment = new Feedback_Fragment();
        Bundle args = new Bundle();


        args.putString(INST_ID, instId);

        /*


        GEtting Institute Id using Bundle from calling activity or fragment



        */
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            instId = getArguments().getString(INST_ID);
        }
    }

    private TextView ques1, ques2, ques3, ques4;
    private ProgressBar progressBar;
    private Button submitButton;
    private EditText comments;
    private RadioGroup ans1Grp, ans2Grp, ans3Grp, ans4Grp;
    String ans1, ans2, ans3, ans4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feedback_, container, false);
        ques1 = (TextView) v.findViewById(R.id.ques1);
        ques2 = (TextView) v.findViewById(R.id.ques2);
        ques3 = (TextView) v.findViewById(R.id.ques3);
        ques4 = (TextView) v.findViewById(R.id.ques4);
        progressBar = (ProgressBar) v.findViewById(R.id.progressbar);
        submitButton = (Button) v.findViewById(R.id.submit_feed);
        ans1Grp = (RadioGroup) v.findViewById(R.id.ans1_grp);
        ans2Grp = (RadioGroup) v.findViewById(R.id.ans2_grp);
        ans3Grp = (RadioGroup) v.findViewById(R.id.ans3_grp);
        ans4Grp = (RadioGroup) v.findViewById(R.id.ans4_grp);
        comments = (EditText) v.findViewById(R.id.comment);
        presenter = new FeedbackPresenterImpl(new RetrofitFeedbackProvider(), this);

//        presenter = new FeedbackPresenterImpl(new MockFeedbackProvider(), this);
        presenter.requestFeedbackQues();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
            }
        });
        return v;
    }

    private void submitFeedback() {
        int id0 = ans1Grp.getCheckedRadioButtonId();
        if (id0 == R.id.rate01)
            ans1 = "1";
        else if (id0 == R.id.rate02)
            ans1 = "2";
        else if (id0 == R.id.rate03)
            ans1 = "3";
        else if (id0 == R.id.rate04)
            ans1 = "4";
        else if (id0 == R.id.rate05)
            ans1 = "5";
        else {
            Snackbar.make(getActivity().findViewById(R.id.frgmtFeedback), "Submission not possible unless all fields are filled!" +
                    " Please select some option for first question.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        int id1 = ans2Grp.getCheckedRadioButtonId();
        if (id0 == R.id.rate11)
            ans2 = "1";
        else if (id1 == R.id.rate12)
            ans2 = "2";
        else if (id1 == R.id.rate13)
            ans2 = "3";
        else if (id1 == R.id.rate14)
            ans2 = "4";
        else if (id1 == R.id.rate15)
            ans2 = "5";
        else {
            Snackbar.make(getActivity().findViewById(R.id.frgmtFeedback), "Submission not possible unless all fields are filled!" +
                    " Please select some option for second question.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        int id2 = ans3Grp.getCheckedRadioButtonId();
        if (id2 == R.id.rate21)
            ans3 = "1";
        else if (id2 == R.id.rate22)
            ans3 = "2";
        else if (id2 == R.id.rate23)
            ans3 = "3";
        else if (id2 == R.id.rate24)
            ans3 = "4";
        else if (id2 == R.id.rate25)
            ans3 = "5";
        else {
            Snackbar.make(getActivity().findViewById(R.id.frgmtFeedback), "Submission not possible unless all fields are filled!" +
                    " Please select some option for third question.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        int id3 = ans4Grp.getCheckedRadioButtonId();
        if (id3 == R.id.rate31)
            ans4 = "1";
        else if (id3 == R.id.rate32)
            ans4 = "2";
        else if (id3 == R.id.rate33)
            ans4 = "3";
        else if (id3 == R.id.rate34)
            ans4 = "4";
        else if (id3 == R.id.rate35)
            ans4 = "5";
        else {
            Snackbar.make(getActivity().findViewById(R.id.frgmtFeedback), "Submission not possible unless all fields are filled!" +
                    " Please select some option for fourth question.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            return;
        }
        presenter.requestSubmitFeedback(instId, ans1, ans2, ans3, ans4, comments.getText().toString());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean b) {
        if (b)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getActivity().findViewById(R.id.frgmtFeedback), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void setQuestions(FeedbackQues questions) {
        ques1.setText(questions.getQues1());
        ques2.setText(questions.getQues2());
        ques3.setText(questions.getQues3());
        ques4.setText(questions.getQues4());
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}