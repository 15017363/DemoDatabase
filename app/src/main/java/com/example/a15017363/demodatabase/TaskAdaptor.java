package com.example.a15017363.demodatabase;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15017363 on 11/5/2017.
 */

public class TaskAdaptor extends ArrayAdapter<Task> {
    private Context context;
    private ArrayList<Task> taskArrayList;
    private TextView tvID;
    private TextView tvDesc;
    private TextView tvDate;


    public TaskAdaptor(Context context,int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        taskArrayList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvID = (TextView)rowView.findViewById(R.id.tvID);
        tvDesc = (TextView)rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView)rowView.findViewById(R.id.tvDate);

        Task currentTask = taskArrayList.get(position);
        tvID.setText(currentTask.getId()+"");
        tvDate.setText(currentTask.getDate());
        tvDesc.setText(currentTask.getDescription());

        return rowView;
    }
}
