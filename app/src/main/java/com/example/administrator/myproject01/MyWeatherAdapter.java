package com.example.administrator.myproject01;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class MyWeatherAdapter extends RecyclerView.Adapter<MyWeatherAdapter.ViewHolder> {

    private List<Weather_view> weatherList;
    private int itemLayout;

    public MyWeatherAdapter(List<Weather_view> items , int itemLayout){

        this.weatherList = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        Weather_view item = weatherList.get(position);
        viewHolder.weather_date.setText(item.getDate());
        viewHolder.weather_img.setBackgroundResource(item.getImg());
        viewHolder.weather_temp.setText(item.getTemp());
        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    /**
     * 뷰 재활용을 위한 viewHolder
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView weather_img;
        public TextView weather_temp;
        public TextView weather_date;

        public ViewHolder(View itemView){
            super(itemView);

            weather_img = (ImageView) itemView.findViewById(R.id.weather_img);
            weather_date = (TextView) itemView.findViewById(R.id.weather_date);
            weather_temp = (TextView) itemView.findViewById(R.id.weather_temp);
        }

    }
}