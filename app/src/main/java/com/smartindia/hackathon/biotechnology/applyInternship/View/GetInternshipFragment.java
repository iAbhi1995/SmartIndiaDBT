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


public class GetInternshipFragment extends Fragment implements GetInternshipView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private TextView title, motivationBox, location, startDate, duration,
            stipend, applyBy, aboutTheCompany, whoCanApply, internshipDetails,
            internshipNumbers, perks;
    SharedPrefs session;
    private ApplyInternPresenter applyInternPresenter;

    private static final String INTERN_ID = "intern_id";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String internId;


    private OnFragmentInteractionListener mListener;
    private ProgressBar progressBar;

    public GetInternshipFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GetInternshipFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GetInternshipFragment newInstance(String intern_id) {
        GetInternshipFragment fragment = new GetInternshipFragment();
        Bundle args = new Bundle();
        args.putString(INTERN_ID, intern_id);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            internId = getArguments().getString(INTERN_ID);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        session=new SharedPrefs(getActivity());
        View v = inflater.inflate(R.layout.set_internship, container, false);
        title = (TextView) v.findViewById(R.id.title);
        progressBar = (ProgressBar) v.findViewById(R.id.progressbar);
        motivationBox = (TextView) v.findViewById(R.id.textView);
        location = (TextView) v.findViewById(R.id.internship_location);
        startDate = (TextView) v.findViewById(R.id.internship_startDate);
        duration = (TextView) v.findViewById(R.id.internship_duration);
        stipend = (TextView) v.findViewById(R.id.internship_stipend);
        applyBy = (TextView) v.findViewById(R.id.internship_applyBy);
        aboutTheCompany = (TextView) v.findViewById(R.id.internship_company_description);
        internshipDetails = (TextView) v.findViewById(R.id.internship_details);
        internshipNumbers = (TextView) v.findViewById(R.id.internship_numbers);
        perks = (TextView) v.findViewById(R.id.internship_perks);
        whoCanApply = (TextView) v.findViewById(R.id.internship_prerequisites);
        applyInternPresenter=new ApplyInternPresenterImpl(new RetrofitApplyInternshipProvider(),this);
        applyInternPresenter.getInternship(internId,session.getAccessToken());
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void ShowInternDetails(GetInternshipData getInternshipData)
    {
        title.setText(getInternshipData.getTitle());
        motivationBox.setText(getInternshipData.getMotivation());
        location.setText(getInternshipData.getLocation());
        startDate.setText(getInternshipData.getStartDate());
        duration.setText(getInternshipData.getDuration());
        stipend.setText(getInternshipData.getStipend());
        applyBy.setText(getInternshipData.getApplyBy());
        aboutTheCompany.setText(getInternshipData.getAboutTheCompany());
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    public void ApplyInternship(View v)
    {
        applyInternPresenter.applyInternship(internId,session.getAccessToken());
    }

    @Override
    public void SuccessfullApplication(ApplyInternData applyInternData) {
        Snackbar.make(getView().findViewById(R.id.relLytIntrnship), "Submission SuccesFul", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
