package com.example.daniel.boozerally;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends HashMap<String, String> {
    private Context mContext;
    private int mResource;

    private static class ViewHolder {
        TextView nume;
        TextView numar;

    }


    public ListAdapter(Context context, int resource, HashMap<String, String> objects) {
        mContext = context;
        mResource = resource;
    }

   /* public View getView(int position, View convertView, ViewGroup parent)
    {
     //   View v=View.inflate(mContext,R.layout.adapter_view_layout);
    } */


}
