package com.onlineshop.marpar.marpar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.text.DecimalFormat;

import Models.GPSTracker;


public class veghotelonclick extends Fragment implements OnMapReadyCallback {

    TextView title, desc;
    GoogleMap mgoogleMap;
    MapView mapView;
    Polyline line;


    Bundle bundle = getArguments();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_veghotelonclick, container, false);

     /* ;
      */
        Bundle bundle = getArguments();
        title = view.findViewById(R.id.hname);
        desc = view.findViewById(R.id.hdesc);
        title.setText(bundle.getString("name"));
        desc.setText(bundle.getString("desc"));


        return view;


    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.map1);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        MapsInitializer.initialize(getContext());
        bundle = getArguments();
        Double lat = bundle.getDouble("lat");
        Double lan = bundle.getDouble("lan");
        mgoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setMyLocationEnabled(true);


        GPSTracker gps = new GPSTracker(getContext());
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            Log.i("====>","===="+latitude);
            Log.i("====>","===="+longitude);

            int Radius = 6371;// radius of earth in Km

            double lat1 =latitude;
            double lat2 = lat;
            double lon1 = longitude;
            double lon2 = lan;
            double dLat = Math.toRadians(lat2 - lat1);
            double dLon = Math.toRadians(lon2 - lon1);
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                    + Math.cos(Math.toRadians(lat1))
                    * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                    * Math.sin(dLon / 2);
            double c = 2 * Math.asin(Math.sqrt(a));
            double valueResult = Radius * c;
            double km = valueResult / 1;
            DecimalFormat newFormat = new DecimalFormat("####");
            int kmInDec = Integer.valueOf(newFormat.format(km));
            double meter = valueResult % 1000;
            int meterInDec = Integer.valueOf(newFormat.format(meter));
            Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                    + " Meter   " + meterInDec);

            Polyline line =googleMap.addPolyline(new PolylineOptions()
                    .add(new LatLng(latitude,longitude), new LatLng(lat,lan))
                    .width(5)
                    .color(Color.RED));





            googleMap.addMarker(new MarkerOptions().position(new LatLng(lat,lan)).title(bundle.getString("name")).snippet(kmInDec+"Km"));
            CameraPosition Liberty = CameraPosition.builder().target(new LatLng(lat, lan)).zoom(16).bearing(0).tilt(45).build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));


        }else{

            gps.showSettingsAlert();
        }






        }








}



