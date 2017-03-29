package com.smartindia.hackathon.biotechnology.SurveyDownload.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.SurveyDownload.Presenter.SurveyPresenter;

public class SurveyDownload extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView title,description,question1,question2,question3,question4;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progressbar);
    Toolbar toolbar = (Toolbar)getView().findViewById(R.id.order_toolbar) ;

    private SurveyPresenter surveyPresenter;
    private LinearLayoutManager linearLayoutManager;

    public SurveyDownload() {}
    public static SurveyDownload newInstance(String param1, String param2) {
        SurveyDownload fragment = new SurveyDownload();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_survey_download, container, false);
        initialize();

        sur=(TextView)getView().findViewById(R.id.incubator_name);
        incubator_thrustArea=(TextView)getView().findViewById(R.id.incubator_thrustArea);
        incubator_state=(TextView)getView().findViewById(R.id.incubator_state);
        incubator_city=(TextView)getView().findViewById(R.id.incubator_city);
        incubator_address=(TextView)getView().findViewById(R.id.incubator_address);
        incubator_website=(TextView)getView().findViewById(R.id.incubator_website);
        incubator_person=(TextView)getView().findViewById(R.id.incubator_person);
        incubator_contact=(TextView)getView().findViewById(R.id.incubator_contact);
        ProgressBar=(ProgressBar)getView().findViewById(R.id.progressbar);
        incubatorsPresenter.getIncubator("","");
        return view;
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
