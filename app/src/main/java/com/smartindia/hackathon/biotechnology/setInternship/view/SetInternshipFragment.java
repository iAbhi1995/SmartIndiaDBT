package com.smartindia.hackathon.biotechnology.setInternship.view;

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
import com.smartindia.hackathon.biotechnology.setInternship.model.RetrofitSetInternshipProvider;
import com.smartindia.hackathon.biotechnology.setInternship.presenter.SetInternshipPresenterImpl;
import com.smartindia.hackathon.biotechnology.setInternship.presenter.SetInternsipPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetInternshipFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetInternshipFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetInternshipFragment extends Fragment implements SetInternshipView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SharedPrefs sharedPrefs;
    private String  access_token,skill,company,location,date,duration,
            stipend,applyBy,aboutCompany,aboutInternship,no,perk,apply,other;
    private Button button;
    private TextView  access_tokentxt,skilltxt,companytxt,locationtxt,datetxt,durationtxt,
            stipendtxt,applyBytxt,aboutCompanytxt,aboutInternshiptxt,notxt,perktxt,applytxt,othertxt;
    private SetInternsipPresenter setInternsipPresenter;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SetInternshipFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SetInternshipFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetInternshipFragment newInstance(String param1, String param2) {
        SetInternshipFragment fragment = new SetInternshipFragment();
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
        View view=inflater.inflate(R.layout.fragment_set_internship, container, false);


        sharedPrefs = new SharedPrefs(getContext());
access_token=sharedPrefs.getAccessToken();
        setInternsipPresenter=new SetInternshipPresenterImpl(new RetrofitSetInternshipProvider(),this);

        Log.d("Response", "2");
      // button = (Button) findViewById(R.id.button);
        skilltxt= (TextView) view.findViewById(R.id.text1);
        companytxt = (TextView)view.findViewById(R.id.text2);
        locationtxt = (TextView) view.findViewById(R.id.internship_location);
        datetxt = (TextView) view.findViewById(R.id.internship_startDate);
        durationtxt = (TextView) view.findViewById(R.id.internship_duration);
        stipendtxt = (TextView) view.findViewById(R.id.internship_stipend);
        applyBytxt = (TextView) view.findViewById(R.id.internship_applyBy);

        aboutCompanytxt = (TextView) view.findViewById(R.id.internship_company_description);

        aboutInternshiptxt = (TextView) view.findViewById(R.id.internship_details);
        notxt = (TextView) view.findViewById(R.id.internship_numbers);
        perktxt = (TextView) view.findViewById(R.id.internship_perks);
        applytxt = (TextView) view.findViewById(R.id.internship_prerequisites);
       // other = (EditText)view.findViewById(R.id.editText);
        button=(Button)view.findViewById(R.id.button_intern);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skill=skilltxt.getText().toString();
                company=companytxt.getText().toString();
                location=locationtxt.getText().toString();
                date=datetxt.getText().toString();
                duration=durationtxt.getText().toString();
                stipend=stipendtxt.getText().toString();
                applyBy=applyBytxt.getText().toString();
                aboutCompany=aboutCompanytxt.getText().toString();
                aboutInternship=aboutInternshiptxt.getText().toString();
                no=notxt.getText().toString();
                perk=perktxt.getText().toString();
                apply=applytxt.getText().toString();
        setInternsipPresenter.requestIntern(access_token,skill,company,location,date,duration,stipend,applyBy,aboutCompany,aboutInternship,no,perk,apply);


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
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();




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
