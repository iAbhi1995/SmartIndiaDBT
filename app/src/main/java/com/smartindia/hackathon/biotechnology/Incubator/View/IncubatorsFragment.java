package com.smartindia.hackathon.biotechnology.Incubator.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorData;
import com.smartindia.hackathon.biotechnology.Incubator.Model.Data.IncubatorDetails;
import com.smartindia.hackathon.biotechnology.Incubator.Model.MockDataProviderIncubator;
import com.smartindia.hackathon.biotechnology.Incubator.Presenter.IncubatorsPresenter;
import com.smartindia.hackathon.biotechnology.Incubator.Presenter.IncubatorsPresenterImpl;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

public class IncubatorsFragment extends Fragment implements IncubatorsInterface {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView incubator_name,incubator_thrustArea,incubator_state,incubator_city,incubator_address,incubator_website,incubator_person
            ,incubator_contact;
    ProgressBar ProgressBar;

    private String mParam1;
    private String mParam2;


    private SharedPrefs sharedPrefs;
    private String token;
    private IncubatorsPresenter incubatorsPresenter;
    private LinearLayoutManager linearLayoutManager;

    private OnFragmentInteractionListener mListener;

    public IncubatorsFragment() {}

    public static IncubatorsFragment newInstance(String param1, String param2) {
        IncubatorsFragment fragment = new IncubatorsFragment();
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
        View view = inflater.inflate(R.layout.fragment_incubators_fragmnt, container, false);
        Toolbar toolbar = (Toolbar)getView().findViewById(R.id.order_toolbar) ;
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
        incubatorsPresenter.getIncubator("1","2");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


        return view;
    }

    private void initialize() {

        sharedPrefs = new SharedPrefs(getContext());

//        ProgressBar progressBar = (ProgressBar)getView().findViewById(R.id.progressbar);

        linearLayoutManager = new LinearLayoutManager(getContext());
        incubatorsPresenter = new IncubatorsPresenterImpl(this, new MockDataProviderIncubator());
        token = sharedPrefs.getAccessToken();
         // incubatorsPresenter.getIncubator("1","2");
    }
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
    public void showMessage(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show)
            ProgressBar.setVisibility(View.VISIBLE);
        else
            ProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void OnDataReceived(IncubatorData incubatorData) {
        IncubatorDetails incubatorDetails = incubatorData.getIncubatorDetails();
        incubator_name.setText(incubatorDetails.getIncubator_name());
        incubator_thrustArea.setText(incubatorDetails.getIncubator_thrustArea());
        incubator_state.setText(incubatorDetails.getIncubator_state());
        incubator_city.setText(incubatorDetails.getIncubator_city());
        incubator_address.setText(incubatorDetails.getIncubator_address());
        incubator_website.setText(incubatorDetails.getIncubator_website());
        incubator_person.setText(incubatorDetails.getIncubator_person());
        incubator_contact.setText(incubatorDetails.getIncubator_contact());
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
