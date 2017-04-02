package com.smartindia.hackathon.biotechnology.Internship.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.Internship.model.RetrofitInternshipProvider;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipCityData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipCollegeData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipData;
import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipTopicData;
import com.smartindia.hackathon.biotechnology.Internship.presenter.InternshipPresenter;
import com.smartindia.hackathon.biotechnology.Internship.presenter.InternshipPresenterImpl;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InternshipFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InternshipFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InternshipFragment extends Fragment implements InternshipView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    Spinner spinner;
    Button button_submit;






    private InternshipCollegeData internshipCollegeData;
    private InternshipCityData internshipCityData;
    private InternshipTopicData internshipTopicData;
    private SharedPrefs sharedPrefs;
    private InternshipPresenter internshipPresenter;
    private String college_id,city_id,topic_id,access_token;
    private LinearLayoutManager linearLayoutManager;
    private InternshipRecyclerAdapter internshipRecyclerAdapter;
    private RecyclerView recyclerView;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InternshipFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InternshipFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InternshipFragment newInstance(String param1, String param2) {
        InternshipFragment fragment = new InternshipFragment();
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
        View view= inflater.inflate(R.layout.fragment_internship, container, false);
        sharedPrefs = new SharedPrefs(getContext());


        linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_filter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(internshipRecyclerAdapter);

        spinner = (Spinner)view.findViewById(R.id.sandbox);//note in xml give id spinner
        button_submit= (Button) view.findViewById(R.id.intent_data_id);//note to check id in xml is button_submit or not
      access_token=sharedPrefs.getAccessToken();
        internshipPresenter=new InternshipPresenterImpl(new RetrofitInternshipProvider(),this);
        internshipPresenter.requestInternship(access_token,"z","z");

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

        internshipPresenter.requestInternship(access_token,city_id,topic_id);



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
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void showSpinnerCity(InternshipData internshipData) {
        List<InternshipCityData> internshipCityDataList=
                new ArrayList<InternshipCityData>(internshipData.getInternshipCityData());
        ArrayAdapter<String> adapter;
        int n= internshipCityDataList.size();
        final String city_id_ar[]=new String[n];
        String city_name_ar[]=new String[n];
        int i=0;
        while(i < n)
        {
            internshipCityData= internshipCityDataList.get(i);
            city_id_ar[i] =  internshipCityData.getCityId();
            city_name_ar[i] =  internshipCityData.getCity();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, city_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void showSpinnerCollege(InternshipData internshipData) {

        List<InternshipCollegeData> internshipCollegeDataList=
                new ArrayList<InternshipCollegeData>(internshipData.getInternshipCollegeData());
        ArrayAdapter<String> adapter;
        int n= internshipCollegeDataList.size();
        final String college_id_ar[]=new String[n];
        String college_name_ar[]=new String[n];
        int i=0;
        while(i < n)
        {
             internshipCollegeData= internshipCollegeDataList.get(i);
            college_id_ar[i] =  internshipCollegeData.getCollegeId();
            college_name_ar[i] =  internshipCollegeData.getCollege();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, college_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void showSpinnerTopic(InternshipData internshipData) {
        List<InternshipTopicData> internshipTopicDataList=
                new ArrayList<InternshipTopicData>(internshipData.getInternshipTopicData());
        ArrayAdapter<String> adapter;
        int n= internshipTopicDataList.size();
        final String topic_id_ar[]=new String[n];
        String topic_name_ar[]=new String[n];
        int i=0;
        while(i < n)
        {
            internshipTopicData= internshipTopicDataList.get(i);
            topic_id_ar[i] =  internshipTopicData.getTopicId();
            topic_name_ar[i] =  internshipTopicData.getTopic();
            i++;
        }

        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, topic_name_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void check(InternshipData internshipData) {
        
        showSpinnerCity(internshipData);
        showSpinnerCollege(internshipData);
        showSpinnerTopic(internshipData);
        internshipRecyclerAdapter.setData(internshipData.getInternshipItemDataList());
        internshipRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * t
     * o the activity and potentially other fragments contained in that
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
