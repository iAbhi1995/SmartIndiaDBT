package com.smartindia.hackathon.biotechnology.BiotechPark.View;

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
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.BiotechPark.Model.Data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.BiotechPark.Model.RetrofitBiotechParkProvider;
import com.smartindia.hackathon.biotechnology.BiotechPark.Presenter.BiotechParkPresenter;
import com.smartindia.hackathon.biotechnology.BiotechPark.Presenter.BiotechParkPresenterImpl;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

public class BiotechParkFragment extends Fragment implements BiotechParkView {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView incubator_name,incubator_thrustArea,incubator_state,incubator_city,incubator_address,incubator_website,incubator_person,incubator_contact;
    ProgressBar ProgressBar;
    ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progressbar);
    Toolbar toolbar = (Toolbar)getView().findViewById(R.id.order_toolbar) ;
    private String mParam1;
    private String mParam2;
    private SharedPrefs sharedPrefs;
    private String token;
    private BiotechParkPresenter incubatorsPresenter;
    private LinearLayoutManager linearLayoutManager;

    private OnFragmentInteractionListener mListener;

    public BiotechParkFragment() {}

    public static BiotechParkFragment newInstance(String param1, String param2) {
        BiotechParkFragment fragment = new BiotechParkFragment();
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
        View view = inflater.inflate(R.layout.fragment_incubators, container, false);
        initialize();

        incubator_name=(TextView)getView().findViewById(R.id.incubator_name);
        incubator_thrustArea=(TextView)getView().findViewById(R.id.incubator_thrustArea);
        incubator_state=(TextView)getView().findViewById(R.id.incubator_state);
        incubator_city=(TextView)getView().findViewById(R.id.incubator_city);
        incubator_address=(TextView)getView().findViewById(R.id.incubator_address);
        incubator_website=(TextView)getView().findViewById(R.id.incubator_website);
        incubator_person=(TextView)getView().findViewById(R.id.incubator_person);
        incubator_contact=(TextView)getView().findViewById(R.id.incubator_contact);
        ProgressBar=(ProgressBar)getView().findViewById(R.id.progressbar);
        incubatorsPresenter.getBiotechPark("","");


        return view;
    }
    private void initialize() {
        sharedPrefs = new SharedPrefs(getContext());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        linearLayoutManager = new LinearLayoutManager(getContext());
        incubatorsPresenter = new BiotechParkPresenterImpl(this, new RetrofitBiotechParkProvider());
        token = sharedPrefs.getAccessToken();

    }
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

    @Override
    public void showMessage(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void OnDataReceived(BiotechParkData incubatorData) {
//        BiotechParkDetails incubatorDetails = incubatorData.getBiotechParkDetails();
//        incubator_name.setText(incubatorDetails.getBiotechPark_name());
//        incubator_thrustArea.setText(incubatorDetails.getBiotechPark_thrustArea());
//        incubator_state.setText(incubatorDetails.getBiotechPark_state());
//        incubator_city.setText(incubatorDetails.getBiotechPark_city());
//        incubator_address.setText(incubatorDetails.getBiotechPark_address());
//        incubator_website.setText(incubatorDetails.getBiotechPark_website());
//        incubator_person.setText(incubatorDetails.getBiotechPark_person());
//        incubator_contact.setText(incubatorDetails.getBiotechPark_contact());
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
