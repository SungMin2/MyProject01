package com.example.administrator.myproject01;

import android.os.Bundle;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;

public class MapsActivity extends NMapActivity{

    private NMapView mMapView;
    private final String CLIENT_ID = "XWZSWk5YphZ5wIUJ_XLv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMapView = new NMapView(this);
        setContentView(R.layout.mapview_fragments);
        mMapView = (NMapView)findViewById(R.id.mapView);

        mMapView.setClientId(CLIENT_ID);
        mMapView.setClickable(true);
        mMapView.setEnabled(true);
        mMapView.setFocusable(true);
        mMapView.setFocusableInTouchMode(true);
        mMapView.requestFocus();

    }
}