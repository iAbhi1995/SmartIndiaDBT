package com.smartindia.hackathon.biotechnology.MyProfile.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.smartindia.hackathon.biotechnology.R;

import java.util.List;

/**
 * Created by Abhishek on 28-03-2017.
 */

public class GridViewAdapter extends BaseAdapter {
    Context context = null;
    List<String> skills;
    List<String> postSkills;

    GridViewAdapter(Context context, List<String> a) {
        this.context = context;
        this.skills = a;
    }

    @Override
    public int getCount() {
        return skills.size();
    }

    @Override
    public Object getItem(int position) {
        return skills.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.skills_item, null);
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkedBox);
        checkBox.setText(skills.get(position));
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked())
                    postSkills.add(skills.get(position));
                else
                    postSkills.remove(skills.get(position));
            }
        });
        return view;
    }
}