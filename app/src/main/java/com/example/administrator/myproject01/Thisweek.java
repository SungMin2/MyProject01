package com.example.administrator.myproject01;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Thisweek extends Fragment {
    LinearLayout layout = null;
    View view;
    RecyclerView weather_rv;
    TextView thisweek1_date_tv;
    ImageButton thisweek1_date_bt;
    ImageView this_festival, this_trip, this_food, this_sport, this_shop;
    TextView weather_area;
    int z = 0;
    double longitude,latitude;
    String thisweek_tv, weather_date;
    Calendar calendar, calendar2;
    Date date;
    DateFormat dateFormat;

    LocationManager lm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        view = inflater.inflate(R.layout.activity_thisweek,null);

        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        long now = System.currentTimeMillis();
        date = new Date(now);

        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        dateFormat = new SimpleDateFormat("MM.dd");

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                calendar.add(Calendar.DATE, -6);
                calendar2.add(Calendar.DATE, 0);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 2:
                calendar.add(Calendar.DATE, 0);
                calendar2.add(Calendar.DATE, 6);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 3:
                calendar.add(Calendar.DATE, -1);
                calendar2.add(Calendar.DATE, 5);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 4:
                calendar.add(Calendar.DATE, -2);
                calendar2.add(Calendar.DATE, 4);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 5:
                calendar.add(Calendar.DATE, -3);
                calendar2.add(Calendar.DATE, 3);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 6:
                calendar.add(Calendar.DATE, -4);
                calendar2.add(Calendar.DATE, 2);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 7:
                calendar.add(Calendar.DATE, -5);
                calendar2.add(Calendar.DATE, 1);
                thisweek_tv = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
        }


        lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        thisweek1_date_tv = (TextView) view.findViewById(R.id.thisweek1_date_tv);
        thisweek1_date_bt = (ImageButton) view.findViewById(R.id.thisweek1_date_bt);
        weather_rv = (RecyclerView)view.findViewById(R.id.weather_rv);
        weather_area = (TextView) view.findViewById(R.id.weather_area);

        thisweek1_date_tv.setText(thisweek_tv);
        thisweek1_date_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(z == 1){ //  미수신할때는 반드시 자원해체를 해주어야 한다.
                    weather_area.setVisibility(View.GONE);
                    weather_rv.setVisibility(View.GONE);
                    z = 0;
                }else{
                    try{
                        // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
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
                    weather_area.setVisibility(View.VISIBLE);
                    weather_rv.setVisibility(View.VISIBLE);
                    z = 1;
                }
            }
        });
        thisweek1_date_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(z == 1){ //  미수신할때는 반드시 자원해체를 해주어야 한다.
                    weather_area.setVisibility(View.GONE);
                    weather_rv.setVisibility(View.GONE);
                    z = 0;
                }else{
                    try{
                        // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
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
                    weather_area.setVisibility(View.VISIBLE);
                    weather_rv.setVisibility(View.VISIBLE);
                    z = 1;
                }
            }
        });


        this_festival = (ImageView) view.findViewById(R.id.this_festival);
        this_trip = (ImageView) view.findViewById(R.id.this_trip);
        this_food = (ImageView) view.findViewById(R.id.this_food);
        this_sport = (ImageView) view.findViewById(R.id.this_sport);
        this_shop = (ImageView) view.findViewById(R.id.this_shop);

        this_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Dowhat_festival.class);
                startActivity(intent);
            }
        });
        this_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Dowhat_trip.class);
                startActivity(intent);
            }
        });
        this_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Eatwhat_hansik.class);
                startActivity(intent);
            }
        });
        this_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Dowhat_sport.class);
                startActivity(intent);
            }
        });
        this_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Dowhat_shop.class);
                startActivity(intent);
            }
        });


        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        lm.removeUpdates(mLocationListener);
    }



    private final LocationListener mLocationListener = new LocationListener() {

        public void onLocationChanged(Location location) {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            Log.d("test", "onLocationChanged, location:" + location);
            longitude = location.getLongitude(); //경도
            latitude = location.getLatitude();   //위도

            Weather_Interface weather_interface = Weather_Interface.retrofit.create(Weather_Interface.class);
            Call<WeatherRepo> call = weather_interface.repoContributors(1, latitude, longitude);
            call.enqueue(new Callback<WeatherRepo>() {
                @Override
                public void onResponse(Call<WeatherRepo> call, Response<WeatherRepo> response) {
                    List<Weather_view> weather_viewList = new ArrayList<Weather_view>();

                    weather_area.setText(response.body().getWeather().getForecast6days().get(0).getGrid().getCity());

                    calendar.add(Calendar.DATE, -1);
                    for(int i = 0; i < 7; i ++){
                        Weather_view weather_view = new Weather_view();

                        calendar.add(Calendar.DATE, 1);
                        switch (calendar.get(Calendar.DAY_OF_WEEK)){
                            case 1:
                                weather_date = dateFormat.format(calendar.getTime()) + " (일)";
                                break;
                            case 2:
                                weather_date = dateFormat.format(calendar.getTime()) + " (월)";
                                break;
                            case 3:
                                weather_date = dateFormat.format(calendar.getTime()) + " (화)";
                                break;
                            case 4:
                                weather_date = dateFormat.format(calendar.getTime()) + " (수)";
                                break;
                            case 5:
                                weather_date = dateFormat.format(calendar.getTime()) + " (목)";
                                break;
                            case 6:
                                weather_date = dateFormat.format(calendar.getTime()) + " (금)";
                                break;
                            case 7:
                                weather_date = dateFormat.format(calendar.getTime()) + " (토)";
                                break;
                        }

                        weather_view.setDate(weather_date);
                        weather_view.setImg(response.body().getWeather().getForecast6days().get(0).getSky().getSkycode(i));
                        weather_view.setTemp(response.body().getWeather().getForecast6days().get(0).getTemperature().getTemp(i));
                        weather_viewList.add(weather_view);
                    }
                    calendar.add(Calendar.DATE, -6);

                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    weather_rv.setAdapter(new MyWeatherAdapter(weather_viewList,R.layout.activity_weather_view));
                    weather_rv.setLayoutManager(layoutManager);
                    weather_rv.setItemAnimator(new DefaultItemAnimator());
                }

                @Override
                public void onFailure(Call<WeatherRepo> call, Throwable t) {
                    Toast.makeText(getContext(),"날씨정보 가져오기 실패!\n잠시 후 다시 시도해주세요.",Toast.LENGTH_SHORT).show();
                }
            });

            if(latitude != 0){
                lm.removeUpdates(mLocationListener);
            }
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
