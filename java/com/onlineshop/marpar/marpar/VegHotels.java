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

import Adapters.veghoteladapter;
import Models.vegHotelModel;


public class VegHotels extends Fragment {
RecyclerView recyclerView;
    List<vegHotelModel> list=new ArrayList<>();
    RecyclerView.Adapter adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("veghotels");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_veg_hotels, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.veghotelrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {

                 for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    String name= (String) postSnapshot.child("hotelName").getValue();
                     String url= (String) postSnapshot.child("imgurl").getValue();
                     String desc= (String) postSnapshot.child("desc").getValue();
                    Double lat= (Double) postSnapshot.child("lat").getValue();
                     Double lan= (Double) postSnapshot.child("lan").getValue();
                      vegHotelModel hotelModel=new vegHotelModel(url,desc,name,lat,lan);

          list.add(hotelModel);



       adapter=new veghoteladapter(list,getContext());


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
