package com.smartindia.hackathon.biotechnology.sub_category.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.smartindia.hackathon.biotechnology.R;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.helper.image_loader.GlideImageLoader;
import com.smartindia.hackathon.biotechnology.helper.image_loader.ImageLoader;
import com.smartindia.hackathon.biotechnology.home.Home_page;
import com.smartindia.hackathon.biotechnology.instrument.view.InstrumentFragment;
import com.smartindia.hackathon.biotechnology.productDesc.view.ProductFragment;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.Equipment_List;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.IncubatorList;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.ProductListData;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.SurveyList;
import com.smartindia.hackathon.biotechnology.sub_category.model.data.UserList;

/**
 * Created by aman on 28/3/17.
 */

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    ProductListData productListData;
    private List<Equipment_List> equipmentList = new ArrayList<>();
    private List<SurveyList> surveyList = new ArrayList<>();
    private List<IncubatorList> incubatorList = new ArrayList<>();
    private List<UserList> userList = new ArrayList<>();
    private int subcategoryId = 0;
    private ProductsListFragment productsListFragment;
    private SharedPrefs sharedPrefs;

    private ImageLoader imageLoader;
    ProductsRecyclerAdapter(Context context, ProductsListFragment productsListFragment) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.productsListFragment = productsListFragment;
        imageLoader = new GlideImageLoader(context);
    }
    public void setData(ProductListData productListData, int subcategoryId) {
        Log.d("iket","setdata"+subcategoryId);
        try {
            if (subcategoryId == 0) {
                Log.d("iket", "" + productListData.isSuccess() + productListData.getEquipment_list().get(0).getName());
            }
        }
        catch (Exception e)
        {
            Log.d("iket",""+e);
        }
        if(subcategoryId==0)
            this.equipmentList=productListData.getEquipment_list();
        else if(subcategoryId==1 || subcategoryId==2 || subcategoryId==3)
            this.incubatorList=productListData.getIncubator_list();
        else if(subcategoryId==4 || subcategoryId==5)
            this.surveyList=productListData.getSurvey_list();
        else if(subcategoryId==6 || subcategoryId==7)
            this.userList=productListData.getUser_list();
        this.subcategoryId = subcategoryId;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.equipment_item, parent, false);
        if (subcategoryId == 0)
            view = layoutInflater.inflate(R.layout.equipment_item, parent, false);
        else if (subcategoryId == 1 || subcategoryId == 2 || subcategoryId == 3)
            view = layoutInflater.inflate(R.layout.biotech_park_item, parent, false);
        else if (subcategoryId == 4 || subcategoryId == 5)
            view = layoutInflater.inflate(R.layout.survey_item, parent, false);
        else if (subcategoryId == 6 || subcategoryId == 7)
            view = layoutInflater.inflate(R.layout.common_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {

        Log.d("iket","subid"+subcategoryId);
        if (subcategoryId == 0) {
            final Equipment_List equipment_list = equipmentList.get(position);
            holder.name.setText(equipment_list.getName());
            holder.institue.setText(equipment_list.getInstitute());
            holder.features.setText(equipment_list.getFeatures());
            holder.city.setText(equipment_list.getCity());
            imageLoader.loadImage(equipment_list.getImage(),holder.image);
            holder.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InstrumentFragment fragment = InstrumentFragment.newInstance((equipmentList.get(position).getId()));
                    ((Home_page) context).setFragment(fragment, equipmentList.get(position).getName());
                }
            });

        }
        else if(subcategoryId==1 || subcategoryId==2 || subcategoryId==3)
        {
            final IncubatorList equipment_list = incubatorList.get(position);
            holder.name.setText(equipment_list.getName());
            holder.email.setText(equipment_list.getEmail());
            holder.city.setText(equipment_list.getPlace());
            imageLoader.loadImage(equipment_list.getImage(),holder.image,holder.progressBar);
        }
        else if(subcategoryId==4 || subcategoryId==5)
        {
            final SurveyList equipment_list = surveyList.get(position);
            holder.field.setText(equipment_list.getField());
            holder.description.setText(equipment_list.getDescription());
            holder.title.setText(equipment_list.getTitle());
        }
        else if(subcategoryId==6 || subcategoryId==7)
        {
            final UserList equipment_list = userList.get(position);
            holder.name.setText(equipment_list.getName());
            holder.description.setText(equipment_list.getDescription());
            holder.email.setText(equipment_list.getEmail());
            holder.city.setText(equipment_list.getLocation());
            imageLoader.loadImage(equipment_list.getImage(),holder.image,holder.progressBar);
        }
    }

    @Override
    public int getItemCount() {
        int a = 5;
        if (subcategoryId == 0)
            a = equipmentList.size();
        else if (subcategoryId == 1 || subcategoryId == 2 || subcategoryId == 3)
            a = incubatorList.size();
        else if (subcategoryId == 4 || subcategoryId == 5)
            a = surveyList.size();
        else if (subcategoryId == 6 || subcategoryId == 7)
            a = surveyList.size();
        return a;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView name, features, city, institue,email,field,description,title;
        ProgressBar progressBar;
        public LinearLayout linearLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            if (subcategoryId == 0) {
                linearLayout=(LinearLayout)itemView.findViewById(R.id.layout10);
                image = (ImageView) itemView.findViewById(R.id.institute_image);
                name = (TextView) itemView.findViewById(R.id.instrument_name);
                city = (TextView) itemView.findViewById(R.id.instrument_city);
                features = (TextView) itemView.findViewById(R.id.instrument_features);
                institue = (TextView) itemView.findViewById(R.id.instrument_institute);

            }
           else if(subcategoryId==1 || subcategoryId==2 || subcategoryId==3)
            {
                linearLayout=(LinearLayout)itemView.findViewById(R.id.layout1);
                image=(ImageView)itemView.findViewById(R.id.biotech_park_image1);
                email=(TextView)itemView.findViewById(R.id.biotech_park_website1);
                progressBar=(ProgressBar)itemView.findViewById(R.id.progressBar2);
                name=(TextView)itemView.findViewById(R.id.biotech_park_name1);
                city=(TextView)itemView.findViewById(R.id.biotech_park_city1);
            }
            else if(subcategoryId==4 || subcategoryId==5)
            {
                linearLayout=(LinearLayout)itemView.findViewById(R.id.layout2);
                field=(TextView)itemView.findViewById(R.id.survey_q2);
                title=(TextView)itemView.findViewById(R.id.survey_title2);
                description=(TextView)itemView.findViewById(R.id.survey_q1);
            }
            else if(subcategoryId==6 || subcategoryId==7)
            {
                linearLayout=(LinearLayout)itemView.findViewById(R.id.layout);
                name=(TextView)itemView.findViewById(R.id.name);
                city=(TextView)itemView.findViewById(R.id.location);
                email=(TextView)itemView.findViewById(R.id.others);
                description=(TextView)itemView.findViewById(R.id.description);
                image=(ImageView)itemView.findViewById(R.id.attractn_img);
                progressBar=(ProgressBar)itemView.findViewById(R.id.progress_bar);
            }

        }
    }
}
