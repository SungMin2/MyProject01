package com.example.administrator.myproject01;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Setting extends AppCompatActivity {
    ImageButton setting_back_bt;
    TextView setting_tip;
    ImageButton setting_tip_bt;
    TextView setting_use;
    ImageButton setting_use_bt;
    TextView setting_push;
    Switch setting_push_bt;
    TextView setting_where;
    Switch setting_where_bt;
    TextView setting_share;
    ImageButton setting_share_bt;
    View v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setting_back_bt = (ImageButton) findViewById(R.id.setting_back_bt);
        setting_tip = (TextView) findViewById(R.id.setting_tip);
        setting_tip_bt = (ImageButton) findViewById(R.id.setting_tip_bt);
        setting_use = (TextView) findViewById(R.id.setting_use);
        setting_use_bt = (ImageButton) findViewById(R.id.setting_use_bt);
        setting_push = (TextView) findViewById(R.id.setting_push);
        setting_push_bt = (Switch) findViewById(R.id.setting_push_bt);
        setting_where = (TextView) findViewById(R.id.setting_where);
        setting_where_bt = (Switch) findViewById(R.id.setting_where_bt);
        setting_share = (TextView) findViewById(R.id.setting_share);
        setting_share_bt = (ImageButton) findViewById(R.id.setting_share_bt);

        //뒤로가기버튼
        setting_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //사용팁 텍스트뷰와 버튼 같은기능 넣기
        setting_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setting_tip_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //이용약관 텍스트뷰와 버튼 같은기능 넣기
        setting_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setting_use_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //푸시알림 텍스트뷰에 스위치 조절기능. 스위치 변화시 토스트띄움
        setting_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setting_push_bt.isChecked() == true){
                    setting_push_bt.setChecked(false);
                }else{
                    setting_push_bt.setChecked(true);
                }
            }
        });
        setting_push_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getApplicationContext(),"푸쉬알림 사용",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"푸쉬알림 사용안함",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //위치정보수집 텍스트뷰에 스위치 조절기능. 스위치 변화시 토스트띄움
        setting_where.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setting_where_bt.isChecked() == true){
                    setting_where_bt.setChecked(false);
                }else{
                    setting_where_bt.setChecked(true);
                }
            }
        });
        setting_where_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getApplicationContext(),"위치정보수집 사용",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"위치정보수집 사용안함",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //공유 텍스트뷰와 버튼 같은기능 넣기
        setting_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = View.inflate(Setting.this, R.layout.activity_share, null);
                AlertDialog.Builder share_ad = new AlertDialog.Builder(Setting.this);
                share_ad.setTitle("'어머?' 공유하기");
                share_ad.setView(v1);
                share_ad.setPositiveButton("확인",null);
                share_ad.setNegativeButton("취소",null);
                share_ad.show();
            }
        });
        setting_share_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = View.inflate(Setting.this, R.layout.activity_share, null);
                AlertDialog.Builder share_ad = new AlertDialog.Builder(Setting.this);
                share_ad.setTitle("'어머?' 공유하기");
                share_ad.setView(v1);
                share_ad.setPositiveButton("확인",null);
                share_ad.setNegativeButton("취소",null);
                share_ad.show();
            }
        });
    }
}
