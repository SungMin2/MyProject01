package com.example.administrator.myproject01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class Search extends AppCompatActivity {
    ImageButton search_back_bt;
    ImageButton search_bt;
    Button search_hashtag_term1;
    Button search_hashtag_term2;
    Button search_hashtag_term3;
    Button search_hashtag_term4;
    Button search_hashtag_term5;
    Button search_hashtag_term6;
    Button search_hashtag_area1;
    Button search_hashtag_area2;
    Button search_hashtag_area3;
    Button search_hashtag_area4;
    Button search_hashtag_area5;
    Button search_hashtag_area6;
    Button search_hashtag_act1;
    Button search_hashtag_act2;
    Button search_hashtag_act3;
    Button search_hashtag_act4;
    Button search_hashtag_act5;
    Button search_hashtag_act6;
    Button search_hashtag_act7;
    Button search_hashtag_act8;
    Button search_hashtag_act9;
    EditText search_etx;
    View v2;
    View v3;
    String selected_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_back_bt = (ImageButton) findViewById(R.id.search_back_bt);
        search_bt = (ImageButton) findViewById(R.id.search_bt);
        search_hashtag_term1 = (Button) findViewById(R.id.search_hashtag_term1);
        search_hashtag_term2 = (Button) findViewById(R.id.search_hashtag_term2);
        search_hashtag_term3 = (Button) findViewById(R.id.search_hashtag_term3);
        search_hashtag_term4 = (Button) findViewById(R.id.search_hashtag_term4);
        search_hashtag_term5 = (Button) findViewById(R.id.search_hashtag_term5);
        search_hashtag_term6 = (Button) findViewById(R.id.search_hashtag_term6);
        search_hashtag_area1 = (Button) findViewById(R.id.search_hashtag_area1);
        search_hashtag_area2 = (Button) findViewById(R.id.search_hashtag_area2);
        search_hashtag_area3 = (Button) findViewById(R.id.search_hashtag_area3);
        search_hashtag_area4 = (Button) findViewById(R.id.search_hashtag_area4);
        search_hashtag_area5 = (Button) findViewById(R.id.search_hashtag_area5);
        search_hashtag_area6 = (Button) findViewById(R.id.search_hashtag_area6);
        search_hashtag_act1 = (Button) findViewById(R.id.search_hashtag_act1);
        search_hashtag_act2 = (Button) findViewById(R.id.search_hashtag_act2);
        search_hashtag_act3 = (Button) findViewById(R.id.search_hashtag_act3);
        search_hashtag_act4 = (Button) findViewById(R.id.search_hashtag_act4);
        search_hashtag_act5 = (Button) findViewById(R.id.search_hashtag_act5);
        search_hashtag_act6 = (Button) findViewById(R.id.search_hashtag_act6);
        search_hashtag_act7 = (Button) findViewById(R.id.search_hashtag_act7);
        search_hashtag_act8 = (Button) findViewById(R.id.search_hashtag_act8);
        search_hashtag_act9 = (Button) findViewById(R.id.search_hashtag_act9);
        search_etx = (EditText) findViewById(R.id.search_etx);

        search_back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        search_etx.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                search_etx.setText("");
                return false;
            }
        });

        search_hashtag_term1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v2 = View.inflate(Search.this, R.layout.activity_datechoice, null);
                AlertDialog.Builder date_ad = new AlertDialog.Builder(Search.this);
                final DatePicker datePicker = (DatePicker) v2.findViewById(R.id.datePicker);
                GregorianCalendar calendar = new GregorianCalendar();

                Toast.makeText(getApplicationContext(),"기간선택\n시작할 날짜를 선택하세요",Toast.LENGTH_SHORT).show();
                date_ad.setMessage("시작 날짜 선택\n");
                date_ad.setView(v2);
                date_ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        v2 = View.inflate(Search.this, R.layout.activity_datechoice, null);
                        AlertDialog.Builder date_ad2 = new AlertDialog.Builder(Search.this);
                        final DatePicker datePicker2 = (DatePicker) v2.findViewById(R.id.datePicker);
                        GregorianCalendar calendar = new GregorianCalendar();

                        Toast.makeText(getApplicationContext(),"기간선택\n마지막 날짜를 선택하세요",Toast.LENGTH_SHORT).show();
                        date_ad2.setMessage("끝 날짜 선택\n");
                        date_ad2.setView(v2);
                        date_ad2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),datePicker.getYear()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getDayOfMonth()+" ~ "+
                                datePicker2.getYear()+"/"+(datePicker2.getMonth()+1)+"/"+datePicker2.getDayOfMonth(),Toast.LENGTH_SHORT).show();
                            }
                        });
                        date_ad2.setNegativeButton("취소",null);
                        date_ad2.show();
                    }
                });
                date_ad.setNegativeButton("취소",null);
                date_ad.show();
            }
        });
        search_hashtag_area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v3 = View.inflate(Search.this, R.layout.activity_areachoice, null);
                AlertDialog.Builder area_ad = new AlertDialog.Builder(Search.this);

                final Spinner area_sp = (Spinner) v3.findViewById(R.id.area_spin);

                area_ad.setTitle("지역 선택");
                area_ad.setView(v3);
                area_ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selected_area = area_sp.getSelectedItem().toString();
                        Toast.makeText(getApplicationContext(),selected_area,Toast.LENGTH_SHORT).show();
                    }
                });
                area_ad.setNegativeButton("취소",null);
                area_ad.show();
            }
        });
    }

}
