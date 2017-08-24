package com.example.administrator.myproject01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class Notice extends AppCompatActivity {

    String [] num_notice = {"NO.","1","2","3","4","5","6","7","8"};
    String [] notice = {"TITLE","공지사항1","공지사항2","공지사항3","공지사항4","공지사항5","공지사항6","공지사항7","공지사항8"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        ListView num_lv = (ListView) findViewById(R.id.notice_num_lv);
        ListView notice_lv = (ListView) findViewById(R.id.notice_lv);
        ImageButton notice_back_bt = (ImageButton) findViewById(R.id.notice_back_bt);

        notice_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayAdapter<String> notice_num = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, num_notice);
        num_lv.setAdapter(notice_num);
        ArrayAdapter<String> notice_ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notice);
        notice_lv.setAdapter(notice_ad);
    }
}
