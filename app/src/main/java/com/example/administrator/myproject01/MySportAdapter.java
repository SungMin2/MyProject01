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


public class MySportAdapter extends RecyclerView.Adapter<MySportAdapter.ViewHolder> {

    private List<Sport_view> sportList;
    private int itemLayout;

    public MySportAdapter(List<Sport_view> items , int itemLayout){

        this.sportList = items;
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
        final Sport_view item = sportList.get(position);

        viewHolder.sport_num.setText(item.getNum());
        viewHolder.sport_title.setText(item.getTitle());
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
                            viewHolder.sport_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.sport_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.sport_info.setText(item.getInfo());
        viewHolder.sport_address.setText(item.getAddress());
        viewHolder.sport_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView sport_num;
        public TextView sport_title;
        public ImageView sport_img;
        public TextView sport_info;
        public TextView sport_address;
        public TextView sport_tel;
        public LinearLayout sport_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            sport_title = (TextView) itemView.findViewById(R.id.sport_title);
            sport_num = (TextView) itemView.findViewById(R.id.sport_num);
            sport_img = (ImageView) itemView.findViewById(R.id.sport_img);
            sport_info = (TextView) itemView.findViewById(R.id.sport_info);
            sport_address = (TextView) itemView.findViewById(R.id.sport_address);
            sport_tel = (TextView) itemView.findViewById(R.id.sport_tel);

            sport_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.sport_moreinfo_layout);
        }
    }
}