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


public class MyFestivalAdapter extends RecyclerView.Adapter<MyFestivalAdapter.ViewHolder> {

    private List<Festival_view> festivalList;
    private int itemLayout;

    public MyFestivalAdapter(List<Festival_view> items , int itemLayout){

        this.festivalList = items;
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
        final Festival_view item = festivalList.get(position);

        viewHolder.festival_num.setText(item.getNum());
        viewHolder.festival_title.setText(item.getTitle());
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
                            viewHolder.festival_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.festival_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.festival_info.setText(item.getInfo());
        viewHolder.festival_address.setText(item.getAddress());
        viewHolder.festival_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return festivalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView festival_num;
        public TextView festival_title;
        public ImageView festival_img;
        public TextView festival_info;
        public TextView festival_address;
        public TextView festival_tel;
        public LinearLayout festival_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            festival_title = (TextView) itemView.findViewById(R.id.festival_title);
            festival_num = (TextView) itemView.findViewById(R.id.festival_num);
            festival_img = (ImageView) itemView.findViewById(R.id.festival_img);
            festival_info = (TextView) itemView.findViewById(R.id.festival_info);
            festival_address = (TextView) itemView.findViewById(R.id.festival_address);
            festival_tel = (TextView) itemView.findViewById(R.id.festival_tel);

            festival_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.festival_moreinfo_layout);
        }
    }
}