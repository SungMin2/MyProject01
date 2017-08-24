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


public class MyMovieAdapter extends RecyclerView.Adapter<MyMovieAdapter.ViewHolder> {

    private List<Movie_view> movieList;
    private int itemLayout;

    public MyMovieAdapter(List<Movie_view> items , int itemLayout){

        this.movieList = items;
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
        final Movie_view item = movieList.get(position);

        viewHolder.movie_num.setText(item.getNum());
        viewHolder.movie_title.setText(item.getTitle());
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
                            viewHolder.movie_img.setImageBitmap(bm);
                        }
                    });
                    viewHolder.movie_img.setImageBitmap(bm);
                } catch(Exception e){}
            }
        });
        t.start();
        viewHolder.movie_info.setText(item.getInfo());
        viewHolder.movie_address.setText(item.getAddress());
        viewHolder.movie_tel.setText(item.getTel());

        viewHolder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView movie_num;
        public TextView movie_title;
        public ImageView movie_img;
        public TextView movie_info;
        public TextView movie_address;
        public TextView movie_tel;
        public LinearLayout movie_moreinfo_layout;

        public ViewHolder(View itemView){
            super(itemView);

            movie_title = (TextView) itemView.findViewById(R.id.movie_title);
            movie_num = (TextView) itemView.findViewById(R.id.movie_num);
            movie_img = (ImageView) itemView.findViewById(R.id.movie_img);
            movie_info = (TextView) itemView.findViewById(R.id.movie_info);
            movie_address = (TextView) itemView.findViewById(R.id.movie_address);
            movie_tel = (TextView) itemView.findViewById(R.id.movie_tel);

            movie_moreinfo_layout = (LinearLayout) itemView.findViewById(R.id.movie_moreinfo_layout);
        }
    }
}