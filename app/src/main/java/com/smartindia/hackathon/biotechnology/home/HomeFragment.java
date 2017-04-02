package com.smartindia.hackathon.biotechnology.home;

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
import android.widget.RelativeLayout;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.Updates.Model.Data.UpdateData;
import com.smartindia.hackathon.biotechnology.Updates.Model.MockUpdateProvider;
import com.smartindia.hackathon.biotechnology.Updates.Presenter.UpdatePresenter;
import com.smartindia.hackathon.biotechnology.Updates.Presenter.UpdatePresenterImpl;
import com.smartindia.hackathon.biotechnology.Updates.View.RecyclerAdapterUpdate;
import com.smartindia.hackathon.biotechnology.Updates.View.UpdateView;
import com.smartindia.hackathon.biotechnology.sub_category.view.SubCategoryFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements UpdateView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RelativeLayout searchLayout;


    private OnFragmentInteractionListener mListener;
    private ProgressBar progressbar;
    private RecyclerView recyclerView;
    private UpdatePresenter presenter;

    public HomeFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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


//        presenter=new UpdatePresenterImpl(this,new RetrofitUpdateProvider());

        Log.d("abhi", "In the frag");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        presenter = new UpdatePresenterImpl(this, new MockUpdateProvider());
        presenter.requestUpdate();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ((Home_page) getContext()).getSupportActionBar().show();
        searchLayout = (RelativeLayout) view.findViewById(R.id.search_layout);
        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Home_page) getContext()).setFragment(new SubCategoryFragment(), "Search");
                ((Home_page) getContext()).getSupportActionBar().hide();
            }
        });
//        progressbar = (ProgressBar) view.findViewById(R.id.progressBar1);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewHome);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onHomeFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void showProgressBar(boolean b) {
        if (b) {

        }
//            progressbar.setVisibility(View.VISIBLE);
        else {
//            progressbar.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public void showMessage(String s) {
        Snackbar.make(getView().findViewById(R.id.RelLayout_Home), s, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void settingAdapter(UpdateData body) {
        recyclerView.setAdapter(new RecyclerAdapterUpdate(getContext(), body.getUpdate()));
    }

    public interface OnFragmentInteractionListener {

        void onHomeFragmentInteraction(Uri uri);
    }

}
