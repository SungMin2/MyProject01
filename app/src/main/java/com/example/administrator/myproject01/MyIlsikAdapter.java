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


public class MyIlsikAdapter extends RecyclerView.Adapter<MyIlsikAdapter.ViewHolder> {

    private List<Ilsik_view> ilsikList;
    private int itemLayout;

    public MyIlsikAdapter(List<Ilsik_view> items , int itemLayout){

        this.ilsikList = items;
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
        final Ilsik_view item = ilsikList.get(position);

        viewHolder.ilsik_num.setText(item.getNum());
        viewHolder.ilsik_title.setText(item.getTitle());
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
                            viewHolder.ilsik_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.ilsik_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.ilsik_info.setText(item.getInfo());
        viewHolder.ilsik_address.setText(item.getAddress());
        viewHolder.ilsik_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return ilsikList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView ilsik_num;
        public TextView ilsik_title;
        public ImageView ilsik_img;
        public TextView ilsik_info;
        public TextView ilsik_address;
        public TextView ilsik_tel;
        public LinearLayout ilsik_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            ilsik_title = (TextView) itemView.findViewById(R.id.ilsik_title);
            ilsik_num = (TextView) itemView.findViewById(R.id.ilsik_num);
            ilsik_img = (ImageView) itemView.findViewById(R.id.ilsik_img);
            ilsik_info = (TextView) itemView.findViewById(R.id.ilsik_info);
            ilsik_address = (TextView) itemView.findViewById(R.id.ilsik_address);
            ilsik_tel = (TextView) itemView.findViewById(R.id.ilsik_tel);

            ilsik_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.ilsik_moreinfo_layout);
        }
    }
}