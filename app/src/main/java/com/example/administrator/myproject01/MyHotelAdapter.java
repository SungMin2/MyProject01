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


public class MyHotelAdapter extends RecyclerView.Adapter<MyHotelAdapter.ViewHolder> {

    private List<Hotel_view> hotelList;
    private int itemLayout;

    public MyHotelAdapter(List<Hotel_view> items , int itemLayout){

        this.hotelList = items;
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
        final Hotel_view item = hotelList.get(position);

        viewHolder.hotel_num.setText(item.getNum());
        viewHolder.hotel_title.setText(item.getTitle());
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
                            viewHolder.hotel_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.hotel_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.hotel_info.setText(item.getInfo());
        viewHolder.hotel_address.setText(item.getAddress());
        viewHolder.hotel_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView hotel_num;
        public TextView hotel_title;
        public ImageView hotel_img;
        public TextView hotel_info;
        public TextView hotel_address;
        public TextView hotel_tel;
        public LinearLayout hotel_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            hotel_title = (TextView) itemView.findViewById(R.id.hotel_title);
            hotel_num = (TextView) itemView.findViewById(R.id.hotel_num);
            hotel_img = (ImageView) itemView.findViewById(R.id.hotel_img);
            hotel_info = (TextView) itemView.findViewById(R.id.hotel_info);
            hotel_address = (TextView) itemView.findViewById(R.id.hotel_address);
            hotel_tel = (TextView) itemView.findViewById(R.id.hotel_tel);

            hotel_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.hotel_moreinfo_layout);
        }
    }
}