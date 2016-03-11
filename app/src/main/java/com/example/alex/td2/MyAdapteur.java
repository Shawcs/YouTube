package com.example.alex.td2;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by alex on 29/01/2016.
 */
public class MyAdapteur extends RecyclerView.Adapter<MyAdapteur.ViewHolder>{

    public List<youtubeJSON> list;
    private Context context;

    public MyAdapteur(List<youtubeJSON> list,Context context ) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        MyAdapteur.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url =list.get(position).snippet.thumbnails.defaut.url;
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(holder.ivVideo);
        holder.tvVideoName.setText(list.get(position).snippet.title);
        holder.tvVideo.setText( list.get(position).snippet.description);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvVideo;
        public ImageView ivVideo;
        public TextView tvVideoName;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            tvVideo = (TextView)itemView.findViewById(R.id.Channel_name);
            tvVideoName = (TextView) itemView.findViewById(R.id.Video_name);
        }

        @Override
        public void onClick(View v) {
           /* Intent i = new Intent(v.getContext(), VideoInfoActivity.class);
            i.putExtra("video", list.get(getAdapterPosition()));
            v.getContext().startActivity(i);*/
        }
    }

}
