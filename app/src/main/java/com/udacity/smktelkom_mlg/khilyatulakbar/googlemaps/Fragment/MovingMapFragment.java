package com.udacity.smktelkom_mlg.khilyatulakbar.googlemaps.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.udacity.smktelkom_mlg.khilyatulakbar.googlemaps.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovingMapFragment extends Fragment implements OnMapReadyCallback {

    static final CameraPosition BWI = CameraPosition.builder()
            .target(new LatLng(-8.215475, 114.366526))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition BALI = CameraPosition.builder()
            .target(new LatLng(-8.719735, 115.169073))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition JMBR = CameraPosition.builder()
            .target(new LatLng(-8.168839, 113.702154))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition STB = CameraPosition.builder()
            .target(new LatLng(-7.706783, 114.005430))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;

    public MovingMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moving_map, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btnSeattle = (Button) getView().findViewById(R.id.btnBali);
        btnSeattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(BALI);
            }
        });

        Button btnDublin = (Button) getView().findViewById(R.id.btnJember);
        btnDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(JMBR);
            }
        });

        Button btnTokyo = (Button) getView().findViewById(R.id.btnSitubondo);
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(STB);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(BWI);

    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
