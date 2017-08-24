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


public class MyHansikAdapter extends RecyclerView.Adapter<MyHansikAdapter.ViewHolder> {

    private List<Hansik_view> hansikList;
    private int itemLayout;

    public MyHansikAdapter(List<Hansik_view> items , int itemLayout){

        this.hansikList = items;
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
        final Hansik_view item = hansikList.get(position);

        viewHolder.hansik_num.setText(item.getNum());
        viewHolder.hansik_title.setText(item.getTitle());
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
                            viewHolder.hansik_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.hansik_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.hansik_info.setText(item.getInfo());
        viewHolder.hansik_address.setText(item.getAddress());
        viewHolder.hansik_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return hansikList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView hansik_num;
        public TextView hansik_title;
        public ImageView hansik_img;
        public TextView hansik_info;
        public TextView hansik_address;
        public TextView hansik_tel;
        public LinearLayout hansik_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            hansik_title = (TextView) itemView.findViewById(R.id.hansik_title);
            hansik_num = (TextView) itemView.findViewById(R.id.hansik_num);
            hansik_img = (ImageView) itemView.findViewById(R.id.hansik_img);
            hansik_info = (TextView) itemView.findViewById(R.id.hansik_info);
            hansik_address = (TextView) itemView.findViewById(R.id.hansik_address);
            hansik_tel = (TextView) itemView.findViewById(R.id.hansik_tel);

            hansik_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.hansik_moreinfo_layout);
        }
    }
}