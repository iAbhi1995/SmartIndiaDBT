package com.smartindia.hackathon.biotechnology.ResearchPaper.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> origin/master
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.Data.ResearchPaperData;
<<<<<<< HEAD
=======
import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.MockResearchPaperProvider;
>>>>>>> origin/master
import com.smartindia.hackathon.biotechnology.ResearchPaper.Model.RetrofitResearchPaperProvider;
import com.smartindia.hackathon.biotechnology.ResearchPaper.Presenter.ResearchPresenter;
import com.smartindia.hackathon.biotechnology.ResearchPaper.Presenter.ResearchPresenterImpl;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;


public class ResearchPaperFrag extends Fragment implements ResearchPaperView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static String ID = "id";

//
//    type to be set by the iket;;;;;
//
    private OnFragmentInteractionListener mListener;
    private TextView dataShow;
    private ProgressBar progressBar;

    private static String id, type;
//
//    type to be set by the iket;;;;;
//


    private OnFragmentInteractionListener mListener;
    private TextView dataShow;
    private ProgressBar progressBar;
    private ResearchPresenter researchPresenter;
    private SharedPrefs sharedPrefs;

    public ResearchPaperFrag() {
    }


    // TODO: Rename and change types and number of parameters
    public static ResearchPaperFrag newInstance(String param1, String param2) {
        ResearchPaperFrag fragment = new ResearchPaperFrag();
        Bundle args = new Bundle();
        args.putString(ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ID);
        }
        sharedPrefs = new SharedPrefs(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        researchPresenter = new ResearchPresenterImpl(this, new MockResearchPaperProvider());
        Log.d("ayush","In oncreate view");
        View v = inflater.inflate(R.layout.fragment_research_paper, container, false);
        dataShow = (TextView) v.findViewById(R.id.data_show);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        researchPresenter.requestResearchPaper(sharedPrefs.getAccessToken(), id);
<<<<<<< HEAD
=======
        Log.d("ayush","going to return");
>>>>>>> origin/master
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void showResearchPaper(ResearchPaperData researchPaperData) {
<<<<<<< HEAD
=======
        Log.d("ayush","Reached Here");
>>>>>>> origin/master
        dataShow.setText(researchPaperData.getDATA());
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
    public void showMessage(String s) {
        Snackbar.make(getActivity().findViewById(R.id.rel_Lyt_researchPaper), s, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
<<<<<<< HEAD

=======
>>>>>>> origin/master
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}