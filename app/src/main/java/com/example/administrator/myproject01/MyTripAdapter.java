package com.example.administrator.myproject01;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class MyTripAdapter extends RecyclerView.Adapter<MyTripAdapter.ViewHolder> {

    private List<Trip_view> tripList;
    private int itemLayout;

    public MyTripAdapter(List<Trip_view> items , int itemLayout){

        this.tripList = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final Handler handler = new Handler();
        final Trip_view item = tripList.get(position);

        viewHolder.trip_num.setText(item.getNum());
        viewHolder.trip_title.setText(item.getTitle());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url = new URL(item.getImgURL());
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            viewHolder.trip_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.trip_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.trip_info.setText(item.getInfo());
        viewHolder.trip_address.setText(item.getAddress());
        viewHolder.trip_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView trip_num;
        public TextView trip_title;
        public ImageView trip_img;
        public TextView trip_info;
        public TextView trip_address;
        public TextView trip_tel;
        public LinearLayout trip_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            trip_title = (TextView) itemView.findViewById(R.id.trip_title);
            trip_num = (TextView) itemView.findViewById(R.id.trip_num);
            trip_img = (ImageView) itemView.findViewById(R.id.trip_img);
            trip_info = (TextView) itemView.findViewById(R.id.trip_info);
            trip_address = (TextView) itemView.findViewById(R.id.trip_address);
            trip_tel = (TextView) itemView.findViewById(R.id.trip_tel);

            trip_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.trip_moreinfo_layout);
        }
    }
}