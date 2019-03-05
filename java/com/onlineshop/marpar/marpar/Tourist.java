package com.onlineshop.marpar.marpar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Adapters.TouristAdapter;
import Models.TouristModel;


public class Tourist extends Fragment {
List<TouristModel>list=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Tourists");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_tourist, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.touristRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String place = (String) postSnapshot.child("place").getValue();
                    String desc = (String) postSnapshot.child("description").getValue();
                    String url = (String) postSnapshot.child("url").getValue();
                    Double lat = (Double) postSnapshot.child("lat").getValue();
                    Double lan = (Double) postSnapshot.child("lon").getValue();
                    TouristModel model = new TouristModel(place,desc,url,lat,lan);

                    list.add(model);

                    adapter = new TouristAdapter(list, getContext());
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;

    }

}
