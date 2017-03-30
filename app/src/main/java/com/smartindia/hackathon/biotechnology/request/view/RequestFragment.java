package com.smartindia.hackathon.biotechnology.request.view;

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
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.home.Home_page;
import com.smartindia.hackathon.biotechnology.request.model.MockRequestProvider;
import com.smartindia.hackathon.biotechnology.request.model.RetrofitRequestProvider;
import com.smartindia.hackathon.biotechnology.request.model.data.RequestDataDetails;
import com.smartindia.hackathon.biotechnology.request.presenter.RequestPresenter;
import com.smartindia.hackathon.biotechnology.request.presenter.RequestPresenterImpl;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RequestFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestFragment extends Fragment implements  RequestView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RecyclerView recyclerView;
    Toolbar toolbar;

    ProgressBar progressBar;

    private RequestPresenter requestPresenter;

    private LinearLayoutManager linearLayoutManager;
    private SharedPrefs sharedPrefs;
    private String  access_token;
    private RequestAdapter requestAdapter;


    private OnFragmentInteractionListener mListener;

    public RequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RequestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RequestFragment newInstance(String param1, String param2) {
        RequestFragment fragment = new RequestFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_request, container, false);
progressBar=(ProgressBar)view.findViewById(R.id.progressBar) ;
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_filter);
        sharedPrefs = new SharedPrefs(getContext());

        access_token=sharedPrefs.getAccessToken();
requestPresenter=new RequestPresenterImpl(new MockRequestProvider(),this);
      //  requestPresenter=new RequestPresenterImpl(new RetrofitRequestProvider(),this);
        requestAdapter=new RequestAdapter(getContext(),this);

        linearLayoutManager= new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(requestAdapter);
        requestPresenter.requestAppStatus(access_token);

//        ((Home_page)getActivity()).getSupportActionBar().hide();

        return(view);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void showProgressbar(boolean show) {


        if(show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext()," "+message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dataReceive(List<RequestDataDetails> requestDataDetailsList) {
        requestAdapter.setData(requestDataDetailsList);
        requestAdapter.notifyDataSetChanged();  //doubt
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
