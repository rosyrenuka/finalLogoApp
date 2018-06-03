package com.example.hp.logo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 31-05-2018.
 */

public class CustomSwipeAdapter extends PagerAdapter {

    private int arr[]={R.drawable.pager1,R.drawable.pager2,R.drawable.pager3};



    interface OnItemClicked{
        void OnClick(int position);
    }


    OnItemClicked listener;



    Context context;
    private LayoutInflater layoutInflater;


    public CustomSwipeAdapter(Context context, OnItemClicked listener) {
        this.context = context;
        this.listener=listener;

    }


    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {


       return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        if(position<=2) {


            layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.swipe_layout, container, false);

            ImageView imageView = view.findViewById(R.id.vimage);
            TextView tv1 = view.findViewById(R.id.vtext1);
            TextView tv2 = view.findViewById(R.id.vtext2);

            ImageView playButton=view.findViewById(R.id.play_button);


            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClick(position);
                }
            });


            imageView.setImageResource(arr[position]);
            tv1.setText("Manali is a year-round magnet for tourists");
            tv2.setText("Manali is a year-round magnet for tourists, with a spectacular view of the Pir Panjal and Dhauladhar ranges, and the Bear River flowing. ");
            container.addView(view);
            return view;
        }
        else{
            return null;
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((RelativeLayout)object);
    }
}
