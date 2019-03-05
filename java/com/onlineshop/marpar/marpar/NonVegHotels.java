package com.onlineshop.marpar.marpar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapters.NonVegAdapter;
import Adapters.veghoteladapter;
import Models.NonVegHotelModel;


public class NonVegHotels extends Fragment {

    List<NonVegHotelModel> list=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("NonVegHotels");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_non_veg_hotels, container, false);
     recyclerView=(RecyclerView)view.findViewById(R.id.nonvegrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
       myRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                   String url = (String) postSnapshot.child("url").getValue();
                   String name = (String) postSnapshot.child("hotelName").getValue();
                   String desc = (String) postSnapshot.child("desc").getValue();
                   Double lat = (Double) postSnapshot.child("lat").getValue();
                   Double lan = (Double) postSnapshot.child("lon").getValue();
                   NonVegHotelModel model=new NonVegHotelModel(name,url,desc,lat,lan);
                   list.add(model);
                   adapter=new NonVegAdapter(list,getContext());
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
