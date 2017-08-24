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


public class MyJoongsikAdapter extends RecyclerView.Adapter<MyJoongsikAdapter.ViewHolder> {

    private List<Joongsik_view> joongsikList;
    private int itemLayout;

    public MyJoongsikAdapter(List<Joongsik_view> items , int itemLayout){

        this.joongsikList = items;
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
        final Joongsik_view item = joongsikList.get(position);

        viewHolder.joongsik_num.setText(item.getNum());
        viewHolder.joongsik_title.setText(item.getTitle());
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
                            viewHolder.joongsik_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.joongsik_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.joongsik_info.setText(item.getInfo());
        viewHolder.joongsik_address.setText(item.getAddress());
        viewHolder.joongsik_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return joongsikList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView joongsik_num;
        public TextView joongsik_title;
        public ImageView joongsik_img;
        public TextView joongsik_info;
        public TextView joongsik_address;
        public TextView joongsik_tel;
        public LinearLayout joongsik_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            joongsik_title = (TextView) itemView.findViewById(R.id.joongsik_title);
            joongsik_num = (TextView) itemView.findViewById(R.id.joongsik_num);
            joongsik_img = (ImageView) itemView.findViewById(R.id.joongsik_img);
            joongsik_info = (TextView) itemView.findViewById(R.id.joongsik_info);
            joongsik_address = (TextView) itemView.findViewById(R.id.joongsik_address);
            joongsik_tel = (TextView) itemView.findViewById(R.id.joongsik_tel);

            joongsik_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.joongsik_moreinfo_layout);
        }
    }
}