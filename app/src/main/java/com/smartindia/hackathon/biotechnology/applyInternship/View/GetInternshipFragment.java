package com.smartindia.hackathon.biotechnology.applyInternship.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.ApplyInternData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.Data.GetInternshipData;
import com.smartindia.hackathon.biotechnology.applyInternship.Model.RetrofitApplyInternshipProvider;
import com.smartindia.hackathon.biotechnology.applyInternship.Presenter.ApplyInternPresenter;
import com.smartindia.hackathon.biotechnology.applyInternship.Presenter.ApplyInternPresenterImpl;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;


public class
GetInternshipFragment extends Fragment implements GetInternshipView {

    private static final String INTERN_ID = "intern_id";
    SharedPrefs session;
    private TextView title, instituteName, location, startDate, duration,
            stipend, applyBy, whoCanApply, internshipDetails,
            internshipNumbers, perks;
    private ApplyInternPresenter applyInternPresenter;
//    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String internId;


    private OnFragmentInteractionListener mListener;
    private ProgressBar progressBar;

    public GetInternshipFragment() {
        // Required empty public constructor
    }
    public static GetInternshipFragment newInstance(String intern_id) {
        GetInternshipFragment fragment = new GetInternshipFragment();
        Bundle args = new Bundle();
        args.putString(INTERN_ID, intern_id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            internId = getArguments().getString(INTERN_ID);
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        session=new SharedPrefs(getActivity());
        View v = inflater.inflate(R.layout.set_internship, container, false);
        title = (TextView) v.findViewById(R.id.title);
        progressBar = (ProgressBar) v.findViewById(R.id.progressbar);
        instituteName = (TextView) v.findViewById(R.id.textView);
        location = (TextView) v.findViewById(R.id.internship_location);
        startDate = (TextView) v.findViewById(R.id.internship_startDate);
        duration = (TextView) v.findViewById(R.id.internship_duration);
        stipend = (TextView) v.findViewById(R.id.internship_stipend);
        applyBy = (TextView) v.findViewById(R.id.internship_applyBy);
        internshipDetails = (TextView) v.findViewById(R.id.internship_details);
        internshipNumbers = (TextView) v.findViewById(R.id.internship_numbers);
        perks = (TextView) v.findViewById(R.id.internship_perks);
        whoCanApply = (TextView) v.findViewById(R.id.internship_prerequisites);
        applyInternPresenter=new ApplyInternPresenterImpl(new RetrofitApplyInternshipProvider(),this);
//        applyInternPresenter=new ApplyInternPresenterImpl(new MockInternshipProvider(),this);
        applyInternPresenter.getInternship(internId,session.getAccessToken());
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onGetInternshipFragment(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void ShowInternDetails(GetInternshipData getInternshipData)
    {
        title.setText(getInternshipData.getTitle());
        instituteName.setText(getInternshipData.getInstitute_name());
        location.setText(getInternshipData.getLocation());
        startDate.setText(getInternshipData.getStartDate());
        duration.setText(getInternshipData.getDuration());
        stipend.setText(getInternshipData.getStipend());
        applyBy.setText(getInternshipData.getApplyBy());
        whoCanApply.setText(getInternshipData.getWhoCanApply());
        internshipDetails.setText(getInternshipData.getInternshipDetail());
        internshipNumbers.setText(getInternshipData.getInternshipNumber());
        perks.setText(getInternshipData.getPerks());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(getView().findViewById(R.id.relLytIntrnship), message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    public void ApplyInternship(View v)
    {
        applyInternPresenter.applyInternship(internId,session.getAccessToken());
    }

    @Override
    public void SuccessfullApplication(ApplyInternData applyInternData) {
        Snackbar.make(getView().findViewById(R.id.relLytIntrnship), "Submission SuccesFul", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }


    public interface OnFragmentInteractionListener {
        void onGetInternshipFragment(Uri uri);
    }

    public interface OnFragmentInteraction {
        // TODO: Update argument type and name
        void onGetInternshipFragmentInteraction(Uri uri);
    }
}
