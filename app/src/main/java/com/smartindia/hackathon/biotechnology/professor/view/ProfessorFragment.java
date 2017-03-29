package com.smartindia.hackathon.biotechnology.professor.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.Internship.model.RetrofitInternshipProvider;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipTopicData;
import com.smartindia.hackathon.biotechnology.Internship.presenter.InternshipPresenter;
import com.smartindia.hackathon.biotechnology.Internship.presenter.InternshipPresenterImpl;
import com.smartindia.hackathon.biotechnology.Internship.view.InternshipRecyclerAdapter;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.professor.model.MockProfessorProvider;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorCityData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorCollegeData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorTopicData;
import com.smartindia.hackathon.biotechnology.professor.model.RetrofitProfessorProvider;
import com.smartindia.hackathon.biotechnology.professor.presenter.ProfessorPresenter;
import com.smartindia.hackathon.biotechnology.professor.presenter.ProfessorPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfessorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfessorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfessorFragment extends Fragment implements ProfessorView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    Button button_submit;
    private SharedPrefs sharedPrefs;

    private ProfessorCityData professorCityData;
    private ProfessorData professorData;
    private ProfessorCollegeData professorCollegeData;
    private ProfessorTopicData professorTopicData;
    private ProfessorPresenter professorPresenter;
    private String college_id,city_id,topic_id,access_token,type;
    private LinearLayoutManager linearLayoutManager;
    private ProfessorAdapter professorAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private OnFragmentInteractionListener mListener;

    public ProfessorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfessorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfessorFragment newInstance(String param1, String param2) {
        ProfessorFragment fragment = new ProfessorFragment();
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
        View view=inflater.inflate(R.layout.fragment_internship, container, false);

        sharedPrefs = new SharedPrefs(getContext());
        professorPresenter=new ProfessorPresenterImpl(new MockProfessorProvider(),this);
        professorAdapter = new ProfessorAdapter(getContext(),this);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_filter);
        linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(professorAdapter);
        spinner1 = (Spinner)view.findViewById(R.id.spinner_city);
        spinner2= (Spinner)view.findViewById(R.id.spinner_college);
        spinner3 = (Spinner)view.findViewById(R.id.spinner_topic);
        progressBar=(ProgressBar)view.findViewById(R.id.professor_bar);
        button_submit= (Button) view.findViewById(R.id.button_submit);
        access_token=sharedPrefs.getAccessToken();
        type= sharedPrefs.getKeyTypeAnalogus();              ;//type kese lu
//        professorPresenter=new ProfessorPresenterImpl(new RetrofitProfessorProvider(),this);
        Log.d("professorActivity","1");
        professorPresenter.requestProfessor(access_token,type,"z","z");
        Log.d("professorActivity","2");

        button_submit.setOnClickListener(
                new Button.OnClickListener(){                       /*Interface*/
                    public void onClick(View v){                                               /*Call Baack Method*/

                        submit();


                    }

                }
        );

        return(view);

    }

    public void submit() {
        Log.d("prof","10");
        professorPresenter.requestProfessor(access_token,type,city_id,topic_id);



    }

    @Override
    public void showError(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showSpinnerCity(ProfessorData professorData) {

        List<ProfessorCityData> professorCityDataList=
                new ArrayList<ProfessorCityData>(professorData.getProfessorCityDataList());
        ArrayAdapter<String> adapter;
        int n= professorCityDataList.size();
        final String city_id_ar[]=new String[n];
        String city_name_ar[]=new String[n];
        int i=0;
        while(i < n)
        {
            professorCityData= professorCityDataList.get(i);
           city_id_ar[i] =  professorCityData.getCityId();
            city_name_ar[i] =  professorCityData.getCity();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, city_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {


                city_id=city_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void showSpinnerCollege(ProfessorData professorData) {

        List<ProfessorCollegeData> professorCollegeDataList=
                new ArrayList<ProfessorCollegeData>(professorData.getProfessorCollegeDataList());
        ArrayAdapter<String> adapter;
        int n= professorCollegeDataList.size();
        int i=0;
        final String college_id_ar[]=new String[n];
        String college_name_ar[]=new String[n];
        while(i < n)
        {
            professorCollegeData= professorCollegeDataList.get(i);
            college_id_ar[i] =  professorCollegeData.getCollegeId();
            college_name_ar[i] =  professorCollegeData.getCollege();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, college_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {


                college_id=college_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void showSpinnerTopic(ProfessorData professorData) {

        List<ProfessorTopicData> professorTopicDataList=
                new ArrayList<ProfessorTopicData>(professorData.getProfessorTopicDataList());
        ArrayAdapter<String> adapter;
        int n= professorTopicDataList.size();
        final String topic_id_ar[]=new String[n];
        String topic_name_ar[]=new String[n];
        int i=0;
        while(i < n)
        {
            professorTopicData= professorTopicDataList.get(i);
            topic_id_ar[i] =  professorTopicData.getTopicId();
            topic_name_ar[i] =  professorTopicData.getTopic();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, topic_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {


                topic_id=topic_id_ar[t].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void check(ProfessorData professorData) {

        showSpinnerCity(professorData);
        showSpinnerCollege(professorData);
        showSpinnerTopic(professorData);
        professorAdapter.setData(professorData.getProfessorItemDataList());
        professorAdapter.notifyDataSetChanged();

    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public void showMessage(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
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
