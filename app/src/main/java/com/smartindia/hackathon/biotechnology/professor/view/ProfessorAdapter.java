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
import com.smartindia.hackathon.biotechnology.professor.model.data.ProfessorItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 27/3/17.
 */

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.MyViewHolder>{

    private List<ProfessorItemData> professorItemDataList = new ArrayList<>();
    private Context context;
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

    public void setData(List<ProfessorItemData> itemDataList) {
        this.professorItemDataList = itemDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.common_item, parent, false);
        /*
        * if(usertype.equals("0"))
        *   view=layoutInflator
        *   else if()
        *
        *
        *
        *
        *
        *
        *
        *
        * */
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
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




    @Override
    public int getItemCount() {
        return professorItemDataList.size();
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

            one=(TextView)itemView.findViewById(R.id.name);
            two=(TextView)itemView.findViewById(R.id.location);
            three=(TextView)itemView.findViewById(R.id.others);
            four=(TextView)itemView.findViewById(R.id.description);
            image=(ImageView)itemView.findViewById(R.id.attractn_img);
            progressBar=(ProgressBar)itemView.findViewById(R.id.progress_bar);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.layout);
        }
    }
    }

