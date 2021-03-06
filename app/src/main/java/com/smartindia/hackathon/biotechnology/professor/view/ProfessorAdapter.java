package com.smartindia.hackathon.biotechnology.professor.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.smartindia.hackathon.biotechnology.Internship.model.data.InternshipItemData;
import com.smartindia.hackathon.biotechnology.Internship.view.InternshipRecyclerAdapter;
import com.smartindia.hackathon.biotechnology.Internship.view.InternshipView;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.image_loader.GlideImageLoader;
import com.smartindia.hackathon.biotechnology.helper.image_loader.ImageLoader;
import com.smartindia.hackathon.biotechnology.home.Home_page;
import com.smartindia.hackathon.biotechnology.instrument.view.InstrumentFragment;
import com.smartindia.hackathon.biotechnology.productDesc.view.ProductFragment;
import com.smartindia.hackathon.biotechnology.professor.model.data.FacilityItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.InstitutionItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ResearchItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.SurveyItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.MyViewHolder> {
    private List<InstitutionItemData> institutionItemDataList = new ArrayList<>();
    private List<ProfessorItemData> professorItemDataList = new ArrayList<>();

    private List<ResearchItemData> researchItemDataList = new ArrayList<>();
    private List<SurveyItemData> surveyItemDataList = new ArrayList<>();
    private List<FacilityItemData> facilityItemDataList = new ArrayList<>();
    private Context context;
    private String type2="1";
    private ProfessorView professorView;
    private ProfessorFragment professorFragment;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;

    public ProfessorAdapter(Context context, ProfessorFragment professorFragment) {
        this.context = context;
        this.professorView = new ProfessorFragment();
        this.professorFragment = professorFragment;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);
    }

    public void setData(ProfessorData itemData, String type) {
        // this.professorItemDataList = itemDataList;
        this.type2 = type;
        if (type2.equals("6"))
            professorItemDataList = itemData.getProfessorItemDataList();
        else if ((type.equals("2")) || (type.equals("3")) || (type.equals("4"))) {
            institutionItemDataList = itemData.getInstitutionItemDataList();
        } else if (type2.equals("5")) {

            surveyItemDataList = itemData.getSurveyItemDataList();
        } else if (type2.equals("1")) {
            facilityItemDataList = itemData.getFacilityItemDataList();
        } else if (type2.equals("7")) {
            researchItemDataList = itemData.getResearchItemDataList();
        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.common_item, parent, false);
        if (type2.equals("6"))
            view = layoutInflater.inflate(R.layout.common_item, parent, false);
        else if ((type2.equals("2")) || (type2.equals("3")) || (type2.equals("4")))
            view = layoutInflater.inflate(R.layout.biotech_park_item, parent, false);
        else if (type2.equals("5"))
            view = layoutInflater.inflate(R.layout.survey_item, parent, false);
        else if (type2.equals("7"))
            view = layoutInflater.inflate(R.layout.internship_item, parent, false);
        else if (type2.equals("1")) {

            view=layoutInflater.inflate(R.layout.insturment_item,parent,false);
        }
            return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (type2.equals("6")) {

            final ProfessorItemData professorItemData = professorItemDataList.get(position);

            holder.one.setText(professorItemData.getOne());
            holder.two.setText(professorItemData.getTwo());
            holder.three.setText(professorItemData.getThree());
            holder.four.setText(professorItemData.getFour());
            imageLoader.loadImage(professorItemData.getImage(), holder.image, holder.progressBar);

//            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    ProductFragment fragment = ProductFragment.newInstance((professorItemDataList.get(position).getId()));
//                    ((Home_page) context).setFragment(fragment, professorItemDataList.get(position).getOne());
//                }
//            });

        } else if ((type2.equals("2")) || (type2.equals("3")) || (type2.equals("4"))) {
            final InstitutionItemData institutionItemData = institutionItemDataList.get(position);

            holder.one.setText(institutionItemData.getName());
            holder.two.setText(institutionItemData.getPlace());
            holder.three.setText(institutionItemData.getEmail());
            imageLoader.loadImage(institutionItemData.getImage(), holder.image, holder.progressBar);//thik karnanhai
//            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//
//                    ProductFragment fragment = ProductFragment.newInstance((institutionItemDataList.get(position).getId()));
//                    ((Home_page) context).setFragment(fragment, institutionItemDataList.get(position).getName());//doubt
//                }
//            });
        } else if (type2.equals("5")) {
            final SurveyItemData surveyItemData = surveyItemDataList.get(position);
            holder.one.setText(surveyItemData.getTitle());
            holder.q1.setText(surveyItemData.getQ1());
            holder.q2.setText(surveyItemData.getQ2());
//            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    ProductFragment fragment = ProductFragment.newInstance((surveyItemDataList.get(position).getId()));
//                    ((Home_page) context).setFragment(fragment, surveyItemDataList.get(position).getTitle());
//                }
//            });
        } else if (type2.equals("1")) {

            final FacilityItemData facilityItemData = facilityItemDataList.get(position);
            holder.one.setText(facilityItemData.getName());
            holder.two.setText(facilityItemData.getPlace());
            holder.three.setText(facilityItemData.getInstitute());
            holder.four.setText(facilityItemData.getSpecification());
            imageLoader.loadImage(facilityItemData.getImage(), holder.image, holder.progressBar);//thik karnanhai
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InstrumentFragment fragment = InstrumentFragment.newInstance((facilityItemDataList.get(position).getId()));
                    ((Home_page) context).setFragment(fragment, facilityItemDataList.get(position).getName());
                }
            });


        } else if (type2.equals("7")) {
            final ResearchItemData researchItemData = researchItemDataList.get(position);
            holder.one.setText(researchItemData.getTopic());
            holder.two.setText(researchItemData.getCompanyName());
            holder.three.setText(researchItemData.getStipend());
            holder.four.setText(researchItemData.getDuration());
            holder.five.setText(researchItemData.getLocation());
            holder.six.setText(researchItemData.getStartDate());
            holder.seven.setText(researchItemData.getApplyBy());
//            holder.button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                }
//            });


        }
    }


    @Override
    public int getItemCount() {

        int a=5;

        if (type2.equals("6")) {
            // return professorItemDataList.size();}
            a = professorItemDataList.size();
        } else if ((type2.equals("2")) || (type2.equals("3")) || (type2.equals("4"))) {

            //return institutionItemDataList.size();}
            a = institutionItemDataList.size();
        } else if (type2.equals("5")) {

            //return institutionItemDataList.size();}
            a = surveyItemDataList.size();
        } else if (type2.equals("1")) {

            //return institutionItemDataList.size();}
            a = facilityItemDataList.size();
        } else if (type2.equals("7")) {

            //return institutionItemDataList.size();}
            a = researchItemDataList.size();
        }
        return (a);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView one,q1,q2;
        private TextView two;
        private TextView three;
        private TextView four;
        private ImageView image;
        private ProgressBar progressBar;
        private LinearLayout linearLayout;
        private TextView six, five;
        private TextView seven;
        private Button button;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (type2.equals("6")) {
                one = (TextView) itemView.findViewById(R.id.name);
                two = (TextView) itemView.findViewById(R.id.location);
                three = (TextView) itemView.findViewById(R.id.others);
                four = (TextView) itemView.findViewById(R.id.description);
                image = (ImageView) itemView.findViewById(R.id.attractn_img);
                progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar);
                linearLayout = (LinearLayout) itemView.findViewById(R.id.layout);
            } else if ((type2.equals("2")) || (type2.equals("3")) || (type2.equals("4"))) {

                one = (TextView) itemView.findViewById(R.id.biotech_park_name1);
                two = (TextView) itemView.findViewById(R.id.biotech_park_city1);
                three = (TextView) itemView.findViewById(R.id.biotech_park_website1);
                progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar2);
                image = (ImageView) itemView.findViewById(R.id.biotech_park_image1);
                progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar2);
                linearLayout = (LinearLayout) itemView.findViewById(R.id.layout1);

            } else if (type2.equals("7")) {
                one = (TextView) itemView.findViewById(R.id.text1);
                two = (TextView) itemView.findViewById(R.id.textView);
                three = (TextView) itemView.findViewById(R.id.internship_location);
                four = (TextView) itemView.findViewById(R.id.internship_startDate);
                five = (TextView) itemView.findViewById(R.id.internship_duration);
                six = (TextView) itemView.findViewById(R.id.internship_stipend);
                seven = (TextView) itemView.findViewById(R.id.internship_applied);
                // image=(ImageView)itemView.findViewById(R.id.attractn_img);
                //progressBar=(ProgressBar)itemView.findViewById(R.id.progress_bar);

                button = (Button) itemView.findViewById(R.id.button25);

            } else if (type2.equals("1")) {
                one = (TextView) itemView.findViewById(R.id.instrument_name);
                two = (TextView) itemView.findViewById(R.id.instrument_city);
                three = (TextView) itemView.findViewById(R.id.instrument_features);
                four = (TextView) itemView.findViewById(R.id.instrument_institute);
                image = (ImageView) itemView.findViewById(R.id.institute_image);
                progressBar = (ProgressBar) itemView.findViewById(R.id.progress_bar5);
                linearLayout = (LinearLayout) itemView.findViewById(R.id.layout10);
            }
            else if (type2.equals("5")) {
                one = (TextView) itemView.findViewById(R.id.survey_title2);
                q2 = (TextView) itemView.findViewById(R.id.survey_q2);
                q1 = (TextView) itemView.findViewById(R.id.survey_q1);
                linearLayout=(LinearLayout) itemView.findViewById(R.id.layout2);
            }


        }
    }
}
