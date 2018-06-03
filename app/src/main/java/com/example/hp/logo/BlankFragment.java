package com.example.hp.logo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    UserRecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<String> list1 =new ArrayList<>();
    ArrayList<String> list2= new ArrayList<>();
    ArrayList<String> list3=new ArrayList<>();


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.recycler_fragment, container, false);
       recyclerView = view.findViewById(R.id.recyclerview);

        list1.add("Narendra modi to return on tommmorow reported shortly");
        list1.add("The Wikipedia newspaper published monthly ");
        list1.add(" MarksList is updated at least once in 2017 by CBSE");
        list1.add(" Paris is one of Europe's major centres of finance");
        list1.add("Louis XVI and the royal family brought to Paris soon reported");
        list1.add(" Thousands of Parisian blue-collar workers joined students");

        list2.add("In May 1968, protesting students occupied the Sorbonne and put up barricades in the Latin Quarter. Thousands of Parisian workers joined the students");
        list2.add("President Nicolas Sarkozy launched the Grand Paris project, to integrate Paris more closely with the towns in the region around it.");
        list2.add("Thousands of Parisian blue-collar workers joined the students, and the movement grew into a two-week general strike.");
        list2.add("In May 1968, protesting students occupied the Sorbonne and put up barricades in the Latin Quarter. Thousands of Parisian workers joined");
        list2.add("President Nicolas Sarkozy launched the Grand Paris project, to integrate Paris more closely with the towns in the region ");
      list2.add("Thousands of Parisian blue-collar workers joined the students, and the movement grew into a two-week general strike.");

        adapter=new UserRecyclerAdapter(getContext(),list1,list2,list3);
        recyclerView.setAdapter(adapter);

        recyclerView .setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext() , DividerItemDecoration.HORIZONTAL));

        return view;
    }
}
