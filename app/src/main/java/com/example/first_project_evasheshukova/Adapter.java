package com.example.first_project_evasheshukova;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<Endings> {

    Context context;
    List<Endings> objects;

    public Adapter(Context context,  int resource, int textViewResourceId, List<Endings> objects){
        super(context, resource, textViewResourceId, objects);

        this.context=context;
        this.objects=objects;    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.list_row,parent,false);

        TextView lastEnding = view.findViewById(R.id.lastEnding);
        Endings temp = objects.get(position);
        lastEnding.setText(temp.getEnding().toString());

        return view;
    }
}
