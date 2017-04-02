package com.smartindia.hackathon.biotechnology.instrument.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.helper.image_loader.GlideImageLoader;
import com.smartindia.hackathon.biotechnology.instrument.model.Instrument_Provider;
import com.smartindia.hackathon.biotechnology.instrument.model.RetrofitInstrumentProvider;
import com.smartindia.hackathon.biotechnology.instrument.model.data.InstrumentData;
import com.smartindia.hackathon.biotechnology.instrument.presenter.InstrumentPresenter;
import com.smartindia.hackathon.biotechnology.instrument.presenter.InstrumentProviderImpl;

import static android.R.id.message;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstrumentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstrumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstrumentFragment extends Fragment implements InstrumentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private ProgressBar progressBar;
    private TextView  name,available,details,application,name1;
    ImageView image;
    private SharedPrefs sharedPrefs;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private OnFragmentInteractionListener mListener;
    InstrumentPresenter instrumentPresenter;
    InstrumentView instrumentView;
    Instrument_Provider instrument_provider;

    public InstrumentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment InstrumentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstrumentFragment newInstance(String param1) {
        InstrumentFragment fragment = new InstrumentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Iket",mParam1);
        View view= inflater.inflate(R.layout.instrument_product, container, false);
        name= (TextView) view.findViewById(R.id.instrument_name);
        name1= (TextView) view.findViewById(R.id.instrument_name1);
        application=(TextView) view.findViewById(R.id.instrument_application);
        available=(TextView) view.findViewById(R.id.institution_available);
        details=(TextView)view.findViewById(R.id.instrument_details);
        progressBar=(ProgressBar)view.findViewById(R.id.progressbar1);
        image=(ImageView)view.findViewById(R.id.incubator_img);
        instrumentPresenter=new InstrumentProviderImpl(this,new RetrofitInstrumentProvider());
        instrumentPresenter.request_Instrument("00","1",mParam1);
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
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void showProgressBar(boolean show) {
        if(show) {
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void showMessage(String error) {
        Toast.makeText(getContext()," "+message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheck(InstrumentData instrumentData) {
        name.setText(instrumentData.getName());
        name1.setText(instrumentData.getName());
        available.setText(instrumentData.getAvailable());
        details.setText(instrumentData.getDetails());
        application.setText(instrumentData.getApplication());
//        GlideImageLoader glideImageLoader=new GlideImageLoader(getActivity());
//        glideImageLoader.loadImage(instrumentData.getImage(),image);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
