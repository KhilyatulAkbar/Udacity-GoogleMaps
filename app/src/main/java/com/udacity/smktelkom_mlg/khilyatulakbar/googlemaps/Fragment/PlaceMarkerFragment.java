package com.udacity.smktelkom_mlg.khilyatulakbar.googlemaps.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.udacity.smktelkom_mlg.khilyatulakbar.googlemaps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceMarkerFragment extends Fragment implements OnMapReadyCallback {

    static final CameraPosition SRONO = CameraPosition.builder()
            .target(new LatLng(-8.401871, 114.268358))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions quba;
    MarkerOptions eskape;
    MarkerOptions mts;
    MarkerOptions koramil;
    MarkerOptions pasar;
    MarkerOptions toko;

    public PlaceMarkerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_marker, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int imageresource = getResources().getIdentifier("@drawable/ic_place", "drawable", getActivity().getPackageName());

        house = new MarkerOptions()
                .position(new LatLng(-8.400375, 114.273540))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));

        quba = new MarkerOptions()
                .position(new LatLng(-8.402491, 114.272767))
                .title("Masjid Al Quba")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));

        eskape = new MarkerOptions()
                .position(new LatLng(-8.398974, 114.274173))
                .title("Eskape TV")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));

        mts = new MarkerOptions()
                .position(new LatLng(-8.403169, 114.262172))
                .title("MTsN Srono")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));

        koramil = new MarkerOptions()
                .position(new LatLng(-8.395404, 114.273552))
                .title("Koramil")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));

        pasar = new MarkerOptions()
                .position(new LatLng(-8.402066, 114.264051))
                .title("Pasar Srono")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));

        toko = new MarkerOptions()
                .position(new LatLng(-8.397795, 114.269773))
                .title("Toko Sahabat")
                .icon(BitmapDescriptorFactory.fromResource(imageresource));
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(quba);
        m_map.addMarker(eskape);
        m_map.addMarker(mts);
        m_map.addMarker(koramil);
        m_map.addMarker(pasar);
        m_map.addMarker(toko);
        flyTo(SRONO);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
