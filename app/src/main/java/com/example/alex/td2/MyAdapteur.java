package com.example.alex.td2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by alex on 29/01/2016.
 */
public class MyAdapteur extends RecyclerView.Adapter<MyAdapteur.ViewHolder> {
    List<youtubeJSON> data;
public final static  String NAME_CITY="name_city";
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        // each data item is just a string in this case
        public TextView mTextViewName;
        public TextView mTextViewChannel;
        public ViewHolder(View v) {
            super(v);
            mTextViewName =(TextView) v.findViewById(R.id.Video_name); //to do a personnal out put result
            mTextViewChannel =(TextView) v.findViewById(R.id.Channel_name);

        }
    }
    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapteur(List<youtubeJSON> datas) {
        data = datas;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapteur.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // holder.mTextViewCity.setText(data.get(position).country_code.toString());

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return data.size();
    }
    
}