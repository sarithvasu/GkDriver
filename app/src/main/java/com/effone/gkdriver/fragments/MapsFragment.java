package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.effone.gkdriver.Common.GKDriver;
import com.effone.gkdriver.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;

public class MapsFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    LocationManager locationManager;
    GoogleMap myMap;
    MapView mMapView;
    private static final String TAG = "MapsFragment";
    private static final LatLng CENTER = new LatLng(42.092462, -70.712267);
    private Polygon[] mMutablePolygon = new Polygon[25];
    RadioGroup radioGroup;
    int id;
    RadioButton b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_maps, container, false);
        locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);

        init(root, savedInstanceState);

        return root;
    }

    public void init(View root, Bundle savedInstanceState) {
        MapsInitializer.initialize(this.getActivity());
        radioGroup = (RadioGroup) root.findViewById(R.id.radioGroup);
        id = radioGroup.getCheckedRadioButtonId();

        mMapView = (MapView) root.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(new LatLng(37.35, -122.0)).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        //  mMap.addMarker(new MarkerOptions().position(new LatLng(37.45, -122.0)).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        //  mMap.addMarker(new MarkerOptions().position(new LatLng(37.45, -122.2)).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        // mMap.addMarker(new MarkerOptions().position(new LatLng(37.35, -122.2)).title("Marker in Sydney").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
    /*    mMap.addPolygon(new PolygonOptions().add(new LatLng(37.35, -122.0)));
        mMap.addPolygon(new PolygonOptions().add(new LatLng(37.45, -122.0)));
        mMap.addPolygon(new PolygonOptions().add(new LatLng(37.45, -122.2)));
        mMap.addPolygon(new PolygonOptions().add(new LatLng(37.35, -122.2)));*/
        /*Polygon polygon = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(37.35, -122.0),
                        new LatLng(37.45, -122.0),
                        new LatLng(37.45, -122.2),
                        new LatLng(37.35, -122.2)
                        )
                .strokeColor(0xFF00AA00)
                .fillColor(Color.RED)
                .strokeWidth(6)
        );*/
        mMutablePolygon[0] = myMap.addPolygon(new PolygonOptions()
                .addAll(createRectangle(CENTER, .01, .01))
                .fillColor(Color.BLUE)
                .strokeColor(Color.WHITE)
                .strokeWidth(5)
        );
        mMutablePolygon[0].setClickable(true);

        List<LatLng> latLngs = new ArrayList<>();
        latLngs.add(new LatLng(41.990352, -70.975054));//lumbini Gardens
        latLngs.add(new LatLng(40.124080, -75.119511));//bagameni
        latLngs.add(new LatLng(42.116222, -70.847671));
        latLngs.add(new LatLng(44.668852, -90.171799));
        latLngs.add(new LatLng(41.883436, -70.762538));
        latLngs.add(new LatLng(44.158614, -78.607687));
        latLngs.add(new LatLng(42.207902, -71.004001));
        latLngs.add(new LatLng(43.161030, -77.610922));
        latLngs.add(new LatLng(41.761451, -70.719734));
        latLngs.add(new LatLng(42.083433, -71.018379));
        latLngs.add(new LatLng(41.892994, -70.910771));
        latLngs.add(new LatLng(42.083433, -71.018379));
        latLngs.add(new LatLng(43.161030, -77.610922));

        for (int i = 1; i < 13; i++) {
            mMutablePolygon[i] = myMap.addPolygon(new PolygonOptions()
                    .addAll(createRectangle(latLngs.get(i), .01, .01))
                    .fillColor(Color.BLUE)
                    .strokeColor(Color.WHITE)
                    .strokeWidth(5));
            mMutablePolygon[i].setClickable(true);

        }

        myMap.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            public void onPolygonClick(Polygon polygon) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId != -1){

                    RadioButton radioButton = (RadioButton) radioGroup.findViewById(selectedId);

                        Toast.makeText(getActivity(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "" + polygon.getPoints().get(4), Toast.LENGTH_LONG).show();

                }else {
                    GKDriver.createOKAlert(getActivity(), getString(R.string.confimation), getString(R.string.msg_avilabilty));
                }
            }
        });
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(CENTER, 10.f));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    private List<LatLng> createRectangle(LatLng center, double halfWidth, double halfHeight) {
        return Arrays.asList(new LatLng(center.latitude, center.longitude),
                //   new LatLng(center.latitude - halfHeight, center.longitude - halfWidth),
                //new LatLng(center.latitude - halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight + .01, center.longitude - halfWidth + .01),
                new LatLng(center.latitude + halfHeight, center.longitude - halfWidth),
                new LatLng(center.latitude, center.longitude));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
