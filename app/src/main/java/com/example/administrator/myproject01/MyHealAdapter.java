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


public class MyHealAdapter extends RecyclerView.Adapter<MyHealAdapter.ViewHolder> {

    private List<Heal_view> healList;
    private int itemLayout;

    public MyHealAdapter(List<Heal_view> items , int itemLayout){

        this.healList = items;
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
        final Heal_view item = healList.get(position);

        viewHolder.heal_num.setText(item.getNum());
        viewHolder.heal_title.setText(item.getTitle());
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
                            viewHolder.heal_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.heal_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.heal_info.setText(item.getInfo());
        viewHolder.heal_address.setText(item.getAddress());
        viewHolder.heal_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return healList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heal_num;
        public TextView heal_title;
        public ImageView heal_img;
        public TextView heal_info;
        public TextView heal_address;
        public TextView heal_tel;
        public LinearLayout heal_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            heal_title = (TextView) itemView.findViewById(R.id.heal_title);
            heal_num = (TextView) itemView.findViewById(R.id.heal_num);
            heal_img = (ImageView) itemView.findViewById(R.id.heal_img);
            heal_info = (TextView) itemView.findViewById(R.id.heal_info);
            heal_address = (TextView) itemView.findViewById(R.id.heal_address);
            heal_tel = (TextView) itemView.findViewById(R.id.heal_tel);

            heal_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.heal_moreinfo_layout);
        }
    }
}