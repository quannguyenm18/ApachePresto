package com.example.materialdl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.materialdl.R;
import com.example.materialdl.model.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Name> nameList;


    public ListAdapter(Context context, int layout, List<Name> nameList) {
        this.context = context;
        this.layout = layout;
        this.nameList = nameList;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);



        TextView tv_name = convertView.findViewById(R.id.tv_textView);

        Name name= nameList.get(position);

        tv_name.setText(name.getmName());







        return convertView;
    }

}
