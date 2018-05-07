package com.example.a16022895.p03_classjournal;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class moduleAdapter extends ArrayAdapter<Modules> implements Serializable{

    private ArrayList<Modules> objects;
    private Context context;
    private TextView tv1;
    private TextView tv2;

    public moduleAdapter(Context context, int resource,
                         ArrayList<Modules> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;

    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.list_item, parent,
                false);
        // Get the TextView object
        tv1 = (TextView)
                rowView.findViewById(R.id.tvModuleCode);
        tv2 = (TextView)
                rowView.findViewById(R.id.tvModuleName);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        Modules object = objects.get(pos);
        // Set the TextView to show the object info
        tv1.setText(object.getModuleCode());
        tv2.setText(object.getModuleName());
        // Return this row that is being populated.
        return rowView;
    }
}

