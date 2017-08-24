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


public class MyYangsikAdapter extends RecyclerView.Adapter<MyYangsikAdapter.ViewHolder> {

    private List<Yangsik_view> yangsikList;
    private int itemLayout;

    public MyYangsikAdapter(List<Yangsik_view> items , int itemLayout){

        this.yangsikList = items;
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
        final Yangsik_view item = yangsikList.get(position);

        viewHolder.yangsik_num.setText(item.getNum());
        viewHolder.yangsik_title.setText(item.getTitle());
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
                            viewHolder.yangsik_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.yangsik_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.yangsik_info.setText(item.getInfo());
        viewHolder.yangsik_address.setText(item.getAddress());
        viewHolder.yangsik_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return yangsikList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView yangsik_num;
        public TextView yangsik_title;
        public ImageView yangsik_img;
        public TextView yangsik_info;
        public TextView yangsik_address;
        public TextView yangsik_tel;
        public LinearLayout yangsik_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            yangsik_title = (TextView) itemView.findViewById(R.id.yangsik_title);
            yangsik_num = (TextView) itemView.findViewById(R.id.yangsik_num);
            yangsik_img = (ImageView) itemView.findViewById(R.id.yangsik_img);
            yangsik_info = (TextView) itemView.findViewById(R.id.yangsik_info);
            yangsik_address = (TextView) itemView.findViewById(R.id.yangsik_address);
            yangsik_tel = (TextView) itemView.findViewById(R.id.yangsik_tel);

            yangsik_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.yangsik_moreinfo_layout);
        }
    }
}