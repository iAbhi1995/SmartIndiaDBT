package com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.Data.ResultData;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Model.RetrofitSurveyProvider;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Presenter.SurveyViewerPresenter;
import com.smartindia.hackathon.biotechnology.SurveyViewerInstitute.Presenter.SurveyViewerPresenterImpl;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

public class SurveyViewerFragment extends Fragment implements SurveyView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private SurveyViewerPresenter presenter;
    private SharedPrefs shared_prefs;

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
        shared_prefs = new SharedPrefs(getContext());
        View v = inflater.inflate(R.layout.fragment_survey_viewer, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_survey_viewer);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);


//       presenter=new SurveyViewerPresenterImpl(this,new MockSurveyProvider());
        presenter = new SurveyViewerPresenterImpl(this, new RetrofitSurveyProvider());
        presenter.requestSurveyResult(shared_prefs.getAccessToken());


        return v;
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
        Snackbar.make(getView().findViewById(R.id.relativeLayoutSurveyViewer), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void setSurveyAdapter(ResultData resultData) {
        recyclerView.setAdapter(new RecyclerSurveyViewerAdapter(getContext(), resultData.getSurveyResultDetailsList()));
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}