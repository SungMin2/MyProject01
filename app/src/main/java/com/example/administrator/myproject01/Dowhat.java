package com.example.administrator.myproject01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dowhat extends Fragment {
    View view;
    TextView dowhat_date_tv, dowhat_title_tv;
    String dowhat_date;
    ImageView trip_iv, show_iv, movie_iv, festival_iv;
    ImageButton dowhat_sport_bt, dowhat_shop_bt, dowhat_trip_bt, dowhat_heal_bt, dowhat_food_bt, dowhat_festival_bt, dowhat_hotel_bt, dowhat_movie_bt, dowhat_show_bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_dowhat,null);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        DateFormat dateFormat = new SimpleDateFormat("MM.dd");

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                calendar.add(Calendar.DATE, -6);
                calendar2.add(Calendar.DATE, 0);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 2:
                calendar.add(Calendar.DATE, 0);
                calendar2.add(Calendar.DATE, 6);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 3:
                calendar.add(Calendar.DATE, -1);
                calendar2.add(Calendar.DATE, 5);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 4:
                calendar.add(Calendar.DATE, -2);
                calendar2.add(Calendar.DATE, 4);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 5:
                calendar.add(Calendar.DATE, -3);
                calendar2.add(Calendar.DATE, 3);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 6:
                calendar.add(Calendar.DATE, -4);
                calendar2.add(Calendar.DATE, 2);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
            case 7:
                calendar.add(Calendar.DATE, -5);
                calendar2.add(Calendar.DATE, 1);
                dowhat_date = dateFormat.format(calendar.getTime()) + "~" + dateFormat.format(calendar2.getTime());
                break;
        }

        DateFormat dateFormat2 = new SimpleDateFormat("MM");

        dowhat_date_tv = (TextView) view.findViewById(R.id.dowhat_date_tv);
        dowhat_title_tv = (TextView) view.findViewById(R.id.dowhat_title_tv);

        String title_tv;
        if(calendar.get(Calendar.WEEK_OF_MONTH) == 1){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 1주차 어머's 추천";
        }else if(calendar.get(Calendar.WEEK_OF_MONTH) == 2){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 2주차 어머's 추천";
        }else if(calendar.get(Calendar.WEEK_OF_MONTH) == 3){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 3주차 어머's 추천";
        }else if(calendar.get(Calendar.WEEK_OF_MONTH) == 4){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 4주차 어머's 추천";
        }else{
            title_tv = dateFormat2.format(calendar.getTime()) + "월 5주차 어머's 추천";
        }

        dowhat_title_tv.setText(title_tv);
        dowhat_date_tv.setText(dowhat_date);

        trip_iv = (ImageView) view.findViewById(R.id.dowhat_img1);
        show_iv = (ImageView) view.findViewById(R.id.dowhat_img2);
        movie_iv = (ImageView) view.findViewById(R.id.dowhat_img3);
        festival_iv = (ImageView) view.findViewById(R.id.dowhat_img4);

        dowhat_sport_bt = (ImageButton) view.findViewById(R.id.dowhat_sport_bt);
        dowhat_shop_bt = (ImageButton) view.findViewById(R.id.dowhat_shop_bt);
        dowhat_trip_bt = (ImageButton) view.findViewById(R.id.dowhat_trip_bt);
        dowhat_heal_bt = (ImageButton) view.findViewById(R.id.dowhat_heal_bt);
        dowhat_food_bt = (ImageButton) view.findViewById(R.id.dowhat_food_bt);
        dowhat_festival_bt = (ImageButton) view.findViewById(R.id.dowhat_festival_bt);
        dowhat_hotel_bt = (ImageButton) view.findViewById(R.id.dowhat_hotel_bt);
        dowhat_movie_bt = (ImageButton) view.findViewById(R.id.dowhat_movie_bt);
        dowhat_show_bt = (ImageButton) view.findViewById(R.id.dowhat_show_bt);


        trip_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_trip.class);
                startActivity(trip_it);
            }
        });
        show_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show_it = new Intent(getContext(), Dowhat_show.class);
                startActivity(show_it);
            }
        });
        movie_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movie_it = new Intent(getContext(), Dowhat_movie.class);
                startActivity(movie_it);
            }
        });
        festival_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent festival_it = new Intent(getContext(), Dowhat_festival.class);
                startActivity(festival_it);
            }
        });
        dowhat_sport_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_sport.class);
                startActivity(trip_it);
            }
        });
        dowhat_shop_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_shop.class);
                startActivity(trip_it);
            }
        });
        dowhat_trip_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_trip.class);
                startActivity(trip_it);
            }
        });
        dowhat_heal_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_heal.class);
                startActivity(trip_it);
            }
        });
        dowhat_food_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_food.class);
                startActivity(trip_it);
            }
        });
        dowhat_festival_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent festival_it = new Intent(getContext(), Dowhat_festival.class);
                startActivity(festival_it);
            }
        });
        dowhat_hotel_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trip_it = new Intent(getContext(), Dowhat_hotel.class);
                startActivity(trip_it);
            }
        });
        dowhat_movie_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movie_it = new Intent(getContext(), Dowhat_movie.class);
                startActivity(movie_it);
            }
        });
        dowhat_show_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show_it = new Intent(getContext(), Dowhat_show.class);
                startActivity(show_it);
            }
        });

        return view;
    }
}
