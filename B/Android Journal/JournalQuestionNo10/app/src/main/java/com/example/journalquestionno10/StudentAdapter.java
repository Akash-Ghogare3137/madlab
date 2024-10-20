package com.example.journalquestionno10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Student> studentList;

    public StudentAdapter(Context context, ArrayList<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }


    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_student, parent, false);
        }

        // Get the views from the layout
        TextView studentName = convertView.findViewById(R.id.studentName);
        TextView studentAge = convertView.findViewById(R.id.studentAge);

        // Set the values
        Student student = studentList.get(position);
        studentName.setText(student.getName());
        studentAge.setText(String.valueOf(student.getAge()));

        return convertView;
    }
}
