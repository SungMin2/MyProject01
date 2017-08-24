package com.example.administrator.myproject01;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class Myarea extends Fragment {
    View view;

    double longitude, latitude;

    LocationManager lm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_myarea,null);
        ImageButton bt = (ImageButton) view.findViewById(R.id.myarea_sport_bt);



        lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                            100, // 통지사이의 최소 시간간격 (miliSecond)
                            1, // 통지사이의 최소 변경거리 (m)
                            mLocationListener);
                    lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                            100, // 통지사이의 최소 시간간격 (miliSecond)
                            1, // 통지사이의 최소 변경거리 (m)
                            mLocationListener);

                }catch(SecurityException ex){
                    Toast.makeText(getContext(),"오류",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }



                Intent it = new Intent(getContext(), MapsActivity.class);
                startActivity(it);
            }
        });

        return view;
    }



    private final LocationListener mLocationListener = new LocationListener() {

        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            Log.d("test", "onLocationChanged, location:" + location);
            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도

            if(latitude != 0){
                lm.removeUpdates(mLocationListener);
            }
            Toast.makeText(getContext(),longitude + ", " + latitude,Toast.LENGTH_SHORT).show();
        }
        public void onProviderDisabled(String provider) {
            // Disabled시
        }
        public void onProviderEnabled(String provider) {
            // Enabled시
        }
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
        }
    };
}
