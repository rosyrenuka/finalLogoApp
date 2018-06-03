package com.example.hp.logo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 30-05-2018.
 */

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<String> list1 ;
    ArrayList<String> list2;
    ArrayList<String> list3;


    public UserRecyclerAdapter(Context context, ArrayList<String> list1, ArrayList<String> list2,ArrayList<String> list3) {
        this.context = context;
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_layout_recycler,null);

        ViewHolder holder = new ViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    String title = list1.get(position);
    String description = list2.get(position);

    if(position==0)
    {
        holder.imageView.setImageResource(R.drawable.paris1);
    }
    if(position==1)
    {
        holder.imageView.setImageResource(R.drawable.paris2);
    }
    if(position==2)
    {
        holder.imageView.setImageResource(R.drawable.paris3);
    }

    if(position==3){
        holder.imageView.setImageResource(R.drawable.paris4);
    }
    if(position==4){
        holder.imageView.setImageResource(R.drawable.paris5);
    }

        if(position==5){
            holder.imageView.setImageResource(R.drawable.paris6);
        }


    holder.title.setText(title+"");
    holder.description.setText(description+"");

    holder.ratingBar.setNumStars(5);
    holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        }
    });


    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        ImageView imageView;
        TextView title;
        TextView description;
        TextView knowmore;
        RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view=itemView;
            imageView=view.findViewById(R.id.image_view);
            title=view.findViewById(R.id.title);
            ratingBar=view.findViewById(R.id.rating);
            description=view.findViewById(R.id.description);
            knowmore=view.findViewById(R.id.knowmore);
        }
    }
}
