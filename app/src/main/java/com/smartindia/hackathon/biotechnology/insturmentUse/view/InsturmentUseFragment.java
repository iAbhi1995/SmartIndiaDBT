package com.smartindia.hackathon.biotechnology.insturmentUse.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.insturmentUse.model.RetrofitInsturmentUse;
import com.smartindia.hackathon.biotechnology.insturmentUse.presenter.InsturmentUsePresenter;
import com.smartindia.hackathon.biotechnology.insturmentUse.presenter.InsturmentUsePresenterImpl;
import com.smartindia.hackathon.biotechnology.setInternship.model.RetrofitSetInternshipProvider;
import com.smartindia.hackathon.biotechnology.setInternship.presenter.SetInternshipPresenterImpl;

import static android.R.id.message;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InsturmentUseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InsturmentUseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsturmentUseFragment extends Fragment implements InsturmentUseView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

private EditText nameTxt,emailTxt,phoneTxt,instituteTxt;
    private String name,email,institute,phone,id,access_token;
    private Button button;
    private SharedPrefs sharedPrefs;
    private ProgressBar progressBar;

private InsturmentUsePresenter insturmentUsePresenter;











    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InsturmentUseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsturmentUseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsturmentUseFragment newInstance(String param1, String param2) {
        InsturmentUseFragment fragment = new InsturmentUseFragment();
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
        View view=inflater.inflate(R.layout.fragment_insturment_use, container, false);

        sharedPrefs=new SharedPrefs(getContext());
       // setInternsipPresenter=new SetInternshipPresenterImpl(new RetrofitSetInternshipProvider(),this);


        insturmentUsePresenter=new InsturmentUsePresenterImpl(new RetrofitInsturmentUse(),this);
        Log.d("Response", "2");
        button = (Button)view.findViewById(R.id.button222);

        nameTxt=(EditText)view.findViewById(R.id.name22);
        phoneTxt=(EditText)view.findViewById(R.id.phoneNo2);
        emailTxt=(EditText)view.findViewById(R.id.email2);
        instituteTxt=(EditText)view.findViewById(R.id.institution2);
        progressBar=(ProgressBar)view.findViewById(R.id.insturmentUse_progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  skill=skilltxt.getText().toString();
                name=nameTxt.getText().toString();
                phone=phoneTxt.getText().toString();
                email=emailTxt.getText().toString();
                institute=instituteTxt.getText().toString();
                access_token=sharedPrefs.getAccessToken();
                id="1";// set by bundles is left from insturmrnt wala full view se
                insturmentUsePresenter.requestInsturment(id,access_token,name,email,phone,institute);
            }
        });











        return(view);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
