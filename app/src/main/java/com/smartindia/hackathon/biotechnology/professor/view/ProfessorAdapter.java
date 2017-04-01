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
import com.smartindia.hackathon.biotechnology.productDesc.view.ProductFragment;
import com.smartindia.hackathon.biotechnology.professor.model.data.InstitutionItemData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorData;
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.MyViewHolder>{
    private List<InstitutionItemData> institutionItemDataList  = new ArrayList<>();
    private List<ProfessorItemData> professorItemDataList = new ArrayList<>();
    private Context context;
    private String type2;
    private ProfessorView professorView;
    private ProfessorFragment professorFragment;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    public ProfessorAdapter(Context context, ProfessorFragment professorFragment) {
        this.context = context;
        this.professorView = new ProfessorFragment();
        this.professorFragment = professorFragment;
        layoutInflater = LayoutInflater.from(context);
        imageLoader= new GlideImageLoader(context);
    }

    public void setData(ProfessorData itemData, String type) {
        // this.professorItemDataList = itemDataList;
        type2 = type;
        if(type2.equals("1"))
            professorItemDataList = itemData.getProfessorItemDataList();
        else if ((type.equals("2")) || (type.equals("3")) || (type.equals("4")))
        {
           institutionItemDataList =itemData.getInstitutionItemDataList();
        }
        else  if(type2.equals("5")) {
        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.common_item, parent, false);
        if(type2.equals("1"))
            view=layoutInflater.inflate(R.layout.common_item,parent,false);
        else if((type2.equals("2"))||(type2.equals("3"))||(type2.equals("4")))
            view=layoutInflater.inflate(R.layout.biotech_park_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if(type2.equals("1"))
        {
            final ProfessorItemData professorItemData= professorItemDataList.get(position);
            holder.one.setText(professorItemData.getOne());
            holder.two.setText(professorItemData.getTwo());
            holder.three.setText(professorItemData.getThree());
            holder.four.setText(professorItemData.getFour());
            imageLoader.loadImage(professorItemData.getImage(),holder.image,holder.progressBar);

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProductFragment fragment= ProductFragment.newInstance((professorItemDataList.get(position).getId()));
                    ((Home_page)context).setFragment(fragment,professorItemDataList.get(position).getOne());
                }
            });
        }

        else if((type2.equals("2"))||(type2.equals("3"))||(type2.equals("4")))
        {
            final InstitutionItemData institutionItemData=institutionItemDataList.get(position);
            holder.one.setText(institutionItemData.getName());
            holder.two.setText(institutionItemData.getPlace());
            holder.three.setText(institutionItemData.getEmail());
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        ProductFragment fragment= ProductFragment.newInstance((institutionItemDataList.get(position).getId()));
        ((Home_page)context).setFragment(fragment,institutionItemDataList.get(position).getName());//doubt
    }
});


        }


    }

    @Override
    public int getItemCount() {
        if(type2.equals("1")){
        return professorItemDataList.size();}
        else if((type2.equals("2"))||(type2.equals("3"))||(type2.equals("4"))) {
            return institutionItemDataList.size();}
        return 0;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        private TextView one ;
        private TextView two ;
        private  TextView three;
        private TextView four;
        private ImageView image;
        private ProgressBar progressBar;
private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            if(type2.equals("1"))
            {
                one=(TextView)itemView.findViewById(R.id.name);
                two=(TextView)itemView.findViewById(R.id.location);
                three=(TextView)itemView.findViewById(R.id.others);
                four=(TextView)itemView.findViewById(R.id.description);
                image=(ImageView)itemView.findViewById(R.id.attractn_img);
                progressBar=(ProgressBar)itemView.findViewById(R.id.progress_bar);
                linearLayout=(LinearLayout)itemView.findViewById(R.id.layout);
            }
            else if((type2.equals("2"))||(type2.equals("3"))||(type2.equals("4"))) {
                one = (TextView) itemView.findViewById(R.id.biotech_park_name1);
                two = (TextView) itemView.findViewById(R.id.biotech_park_city1);
                three = (TextView) itemView.findViewById(R.id.biotech_park_website1);

                image = (ImageView) itemView.findViewById(R.id.biotech_park_image1);
                progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar2);
                linearLayout = (LinearLayout) itemView.findViewById(R.id.layout1);

            }




        }
    }
    }

