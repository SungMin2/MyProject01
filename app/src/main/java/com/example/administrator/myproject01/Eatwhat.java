package com.example.administrator.myproject01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Eatwhat extends Fragment {
    View view;
    ImageView eatwhat_img1, eatwhat_img2, eatwhat_img3, eatwhat_img4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.activity_eatwhat,null);
        eatwhat_img1 = (ImageView) view.findViewById(R.id.eatwhat_img1);
        eatwhat_img2 = (ImageView) view.findViewById(R.id.eatwhat_img2);
        eatwhat_img3 = (ImageView) view.findViewById(R.id.eatwhat_img3);
        eatwhat_img4 = (ImageView) view.findViewById(R.id.eatwhat_img4);

        eatwhat_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hansik_it = new Intent(getContext(), Eatwhat_hansik.class);
                startActivity(hansik_it);
            }
        });
        eatwhat_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent joongsik_it = new Intent(getContext(), Eatwhat_joongsik.class);
                startActivity(joongsik_it);
            }
        });
        eatwhat_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yangsik_it = new Intent(getContext(), Eatwhat_yangsik.class);
                startActivity(yangsik_it);
            }
        });
        eatwhat_img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ilsik_it = new Intent(getContext(), Eatwhat_ilsik.class);
                startActivity(ilsik_it);
            }
        });
        return view;
    }
}