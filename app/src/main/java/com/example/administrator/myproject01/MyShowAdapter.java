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


public class MyShowAdapter extends RecyclerView.Adapter<MyShowAdapter.ViewHolder> {

    private List<Show_view> showList;
    private int itemLayout;

    public MyShowAdapter(List<Show_view> items , int itemLayout){

        this.showList = items;
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
        final Show_view item = showList.get(position);

        viewHolder.show_num.setText(item.getNum());
        viewHolder.show_title.setText(item.getTitle());
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
                            viewHolder.show_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.show_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.show_info.setText(item.getInfo());
        viewHolder.show_address.setText(item.getAddress());
        viewHolder.show_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return showList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView show_num;
        public TextView show_title;
        public ImageView show_img;
        public TextView show_info;
        public TextView show_address;
        public TextView show_tel;
        public LinearLayout show_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            show_title = (TextView) itemView.findViewById(R.id.show_title);
            show_num = (TextView) itemView.findViewById(R.id.show_num);
            show_img = (ImageView) itemView.findViewById(R.id.show_img);
            show_info = (TextView) itemView.findViewById(R.id.show_info);
            show_address = (TextView) itemView.findViewById(R.id.show_address);
            show_tel = (TextView) itemView.findViewById(R.id.show_tel);

            show_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.show_moreinfo_layout);
        }
    }
}