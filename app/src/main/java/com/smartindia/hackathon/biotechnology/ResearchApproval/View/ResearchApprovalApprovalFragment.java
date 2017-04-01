package com.smartindia.hackathon.biotechnology.ResearchApproval.View;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchData;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.Data.ResearchDataDetails;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.MockProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Model.RetrofitRsrchApprvlProvider;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter.ResearchApprovalPresenter;
import com.smartindia.hackathon.biotechnology.ResearchApproval.Presenter.ResearchApprovalPresenterImpl;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.login.view.LoginView;

import java.util.ArrayList;

public class ResearchApprovalApprovalFragment extends Fragment implements ResearchView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private SharedPrefs sharedPrefs;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ResearchApprovalPresenter presenter;
    public ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;

    public ResearchApprovalApprovalFragment() {

    }

    public static ResearchApprovalApprovalFragment newInstance(String param1, String param2) {
        ResearchApprovalApprovalFragment fragment = new ResearchApprovalApprovalFragment();
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
        sharedPrefs = new SharedPrefs(getActivity());
        presenter = new ResearchApprovalPresenterImpl(new MockProvider(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter.requestResearch(sharedPrefs.getAccessToken());
        View v = inflater.inflate(R.layout.fragment_research_approval, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rcylrVw);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        return v;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
//            progressBar.setVisibility(View.VISIBLE);
        } else {
//            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getActivity().findViewById(R.id.relLyt), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void showRecyclerView(ResearchData researchData) {
        ResearchApprovalViewAdapter adapter = new ResearchApprovalViewAdapter(getActivity(), (ArrayList<ResearchDataDetails>) researchData.getResearchDataDetailsList());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
