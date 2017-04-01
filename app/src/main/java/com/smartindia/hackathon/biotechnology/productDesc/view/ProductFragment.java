package com.smartindia.hackathon.biotechnology.productDesc.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.productDesc.model.MockProduct;
import com.smartindia.hackathon.biotechnology.productDesc.model.RetrofitProductProvider;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.BiotechParkData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.IncubatorsData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InstitutionsData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.InsturmentData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProductData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ProfileData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.ResearchPaperData;
import com.smartindia.hackathon.biotechnology.productDesc.model.data.SurveyData;
import com.smartindia.hackathon.biotechnology.productDesc.presenter.ProductPresenter;
import com.smartindia.hackathon.biotechnology.productDesc.presenter.ProductPresenterImpl;
import com.smartindia.hackathon.biotechnology.setInternship.presenter.SetInternsipPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.message;
public class ProductFragment extends Fragment implements ProductView,AppBarLayout.OnOffsetChangedListener{
    private static final String ARG_PARAM1 = "param1";
    private String id;
    private OnFragmentInteractionListener mListener;

    private String token,type;
    private SharedPrefs sharedPrefs;
    private ProductPresenter productPresenter;
    private IncubatorsData incubatorsData;
    private ProfileData profileData;
    private BiotechParkData biotechParkData;
    private InstitutionsData institutionsData;
    private InsturmentData insturmentData;
    private ResearchPaperData researchPaperData;
    private SurveyData surveyData;
    View a0,a1,a2,a3,a4,a5,a6;
   // private ProductData productData;
    private TextView incubator_name1,incubator_thrustArea1,incubator_state1,
                        incubator_city1,incubator_address1,incubator_website1,incubator_person1
                        ,incubator_contact1;
//ayush
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
//ayush
    public static ProductFragment newInstance(String param1) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product, container, false);;
        sharedPrefs=new SharedPrefs(getContext());
        token=sharedPrefs.getAccessToken();
        type=sharedPrefs.getKeyTypeAnalogus();
        type="3";
     //   productPresenter=new ProductPresenterImpl(new RetrofitProductProvider(),this);
        productPresenter=new ProductPresenterImpl(new MockProduct(),this);
        a0=view.findViewById(R.id.a0);
        a1=view.findViewById(R.id.a1);
        a2=view.findViewById(R.id.a2);
        a3=view.findViewById(R.id.a3);
        a4=view.findViewById(R.id.a4);
        a5=view.findViewById(R.id.a5);
        a6=view.findViewById(R.id.a6);
        showView(type);


        if(type.equals("0"))
        {

        }

        else if(type.equals("1"))
        {

        }


        else if(type.equals("2"))
        {



        }
        else if(type.equals("3"))
        {  view= inflater.inflate(R.layout.incubator_product, container, false);



            incubator_name1=(TextView)view.findViewById(R.id.incubator_name);
            incubator_thrustArea1=(TextView)view.findViewById(R.id.incubator_thrustArea);
           // incubator_state1=(TextView)view.findViewById(R.id.incubator_state);  //ye change karna hai
           incubator_city1=(TextView)view.findViewById(R.id.incubator_city);
           // incubator_address1=(TextView)view.findViewById(R.id.incubator_address);   //ye change karna hai
            incubator_website1=(TextView)view.findViewById(R.id.incubator_website);
            incubator_person1=(TextView)view.findViewById(R.id.incubator_person);
            incubator_contact1=(TextView)view.findViewById(R.id.incubator_contact);

            productPresenter.requestProduct("2",type,"4");

        }
        else if(type.equals("4"))
        {

            //view= inflater.inflate(R.layout.fragment_product, container, false);




        }
        //ayush
        mTitle          = (TextView) view.findViewById(R.id.biotech_park_name1);
        mTitleContainer = (LinearLayout) view.findViewById(R.id.main_linearlayout_title);
        mAppBarLayout   = (AppBarLayout) view.findViewById(R.id.main_appbar);
        mAppBarLayout.addOnOffsetChangedListener(this);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        return view;

    }


    public void showView(String view)
    {
        if(view.equals("0"))
        {
            a0.setVisibility(View.VISIBLE);
        }
        else if(view.equals("1"))
        {
            a1.setVisibility(View.VISIBLE);
        }
        else if(view.equals("2"))
        {
            a2.setVisibility(View.VISIBLE);
        }
        else if(view.equals("3"))
        {
            a3.setVisibility(View.VISIBLE);
        }
        else if(view.equals("a4"))
        {
            a4.setVisibility(View.VISIBLE);
        }
        else if(view.equals("a5"))
        {
            a5.setVisibility(View.VISIBLE);
        }
        else if(view.equals("a6"))
        {
            a6.setVisibility(View.VISIBLE);
        }
        else
        {

        }

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
    public void showMessage(String error) {
 Toast.makeText(getContext()," "+message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onVerified(ProductData productData) {

        if(type.equals("0"))
        {

        }
        else if(type.equals("1"))
        {

        }
        else if(type.equals("2"))
        {

        }
        else if(type.equals("3"))
        {
            IncubatorsData incubatorsDatas=productData.getIncubatorsData();



        /*    incubator_name=(TextView)getView().findViewById(R.id.incubator_name);
            incubator_thrustArea=(TextView)getView().findViewById(R.id.incubator_thrustArea);
            incubator_state=(TextView)getView().findViewById(R.id.incubator_state);
            incubator_city=(TextView)getView().findViewById(R.id.incubator_city);
            incubator_address=(TextView)getView().findViewById(R.id.incubator_address);
            incubator_website=(TextView)getView().findViewById(R.id.incubator_website);
            incubator_person=(TextView)getView().findViewById(R.id.incubator_person);
            incubator_contact=(TextView)getView().findViewById(R.id.incubator_contact);

*/

            incubator_name1.setText(incubatorsDatas.getIncubator_name());
            incubator_thrustArea1.setText(incubatorsDatas.getIncubator_thrustArea());
            incubator_state1.setText(incubatorsDatas.getIncubator_state());
            incubator_city1.setText(incubatorsDatas.getIncubator_city());
            incubator_address1.setText(incubatorsDatas.getIncubator_address());
            incubator_website1.setText(incubatorsDatas.getIncubator_website());
        incubator_person1.setText(incubatorsDatas.getIncubator_person());
            incubator_contact1.setText(incubatorsDatas.getIncubator_contact());



        }
        else if(type.equals("4"))
        {

        }
        else if(type.equals("5"))
        {

        } else if(type.equals("6"))
        {

        } else if(type.equals("7"))
        {

        }




    }



    //ayush
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}