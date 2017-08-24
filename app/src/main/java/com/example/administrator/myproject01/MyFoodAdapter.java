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


public class MyFoodAdapter extends RecyclerView.Adapter<MyFoodAdapter.ViewHolder> {

    private List<Food_view> foodList;
    private int itemLayout;

    public MyFoodAdapter(List<Food_view> items , int itemLayout){

        this.foodList = items;
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
        final Food_view item = foodList.get(position);

        viewHolder.food_num.setText(item.getNum());
        viewHolder.food_title.setText(item.getTitle());
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
                            viewHolder.food_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.food_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.food_info.setText(item.getInfo());
        viewHolder.food_address.setText(item.getAddress());
        viewHolder.food_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView food_num;
        public TextView food_title;
        public ImageView food_img;
        public TextView food_info;
        public TextView food_address;
        public TextView food_tel;
        public LinearLayout food_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            food_title = (TextView) itemView.findViewById(R.id.food_title);
            food_num = (TextView) itemView.findViewById(R.id.food_num);
            food_img = (ImageView) itemView.findViewById(R.id.food_img);
            food_info = (TextView) itemView.findViewById(R.id.food_info);
            food_address = (TextView) itemView.findViewById(R.id.food_address);
            food_tel = (TextView) itemView.findViewById(R.id.food_tel);

            food_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.food_moreinfo_layout);
        }
    }
}