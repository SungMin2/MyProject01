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


public class MyShopAdapter extends RecyclerView.Adapter<MyShopAdapter.ViewHolder> {

    private List<Shop_view> shopList;
    private int itemLayout;

    public MyShopAdapter(List<Shop_view> items , int itemLayout){

        this.shopList = items;
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
        final Shop_view item = shopList.get(position);

        viewHolder.shop_num.setText(item.getNum());
        viewHolder.shop_title.setText(item.getTitle());
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
                            viewHolder.shop_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.shop_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.shop_info.setText(item.getInfo());
        viewHolder.shop_address.setText(item.getAddress());
        viewHolder.shop_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView shop_num;
        public TextView shop_title;
        public ImageView shop_img;
        public TextView shop_info;
        public TextView shop_address;
        public TextView shop_tel;
        public LinearLayout shop_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            shop_title = (TextView) itemView.findViewById(R.id.shop_title);
            shop_num = (TextView) itemView.findViewById(R.id.shop_num);
            shop_img = (ImageView) itemView.findViewById(R.id.shop_img);
            shop_info = (TextView) itemView.findViewById(R.id.shop_info);
            shop_address = (TextView) itemView.findViewById(R.id.shop_address);
            shop_tel = (TextView) itemView.findViewById(R.id.shop_tel);

            shop_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.shop_moreinfo_layout);
        }
    }
}