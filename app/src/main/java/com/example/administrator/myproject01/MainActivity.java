package com.example.administrator.myproject01;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    View v1;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setSubtitle("   어디가서 머하지?");
        toolbar.setLogo(R.drawable.mainlogo3);
        toolbar.setSubtitleTextColor(Color.rgb(255,255,255));
        toolbar.setBackgroundColor(Color.rgb(178,204,255));
        toolbar.setNavigationIcon(R.drawable.menu);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(R.drawable.location, "Weekly pick", new Thisweek());
        adapter.addFragment(R.drawable.where, "Around me", new Myarea());
        adapter.addFragment(R.drawable.culture, "Do what", new Dowhat());
        adapter.addFragment(R.drawable.food_icon, "Eat what", new Eatwhat());
        adapter.addFragment(R.drawable.music, "Listen what", new Listenwhat());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
            tabLayout.getTabAt(i).setIcon(adapter.getFragmentInfo(i).getIconResId());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_search) {
            Intent it1 = new Intent(getApplicationContext(), Search.class);
            startActivity(it1);
        } else if (id == R.id.nav_setting) {
            Intent it2 =  new Intent(getApplicationContext(), Setting.class);
            startActivity(it2);
        } else if (id == R.id.nav_notice) {
            Intent it3 = new Intent(getApplicationContext(), Notice.class);
            startActivity(it3);
        } else if (id == R.id.nav_QnA) {
            AlertDialog.Builder QnA_ad = new AlertDialog.Builder(MainActivity.this);
            QnA_ad.setTitle("Q&A");
            QnA_ad.setMessage("관리자에게 메세지를 보내시겠습니까?");
            QnA_ad.setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent it4 = new Intent(Intent.ACTION_VIEW);
                    it4.putExtra("address","010-2507-8200");
                    it4.putExtra("sms_body","관리자님 문의드립니다.\n");
                    it4.setType("vnd.android-dir/mms-sms");
                    startActivity(it4);
                }
            });
            QnA_ad.setNegativeButton("아니요",null);
            QnA_ad.show();

        } else if (id == R.id.nav_share) {
            v1 = View.inflate(MainActivity.this, R.layout.activity_share, null);
            AlertDialog.Builder share_ad = new AlertDialog.Builder(MainActivity.this);
            share_ad.setTitle("'어머?' 공유하기");
            share_ad.setView(v1);
            share_ad.setPositiveButton("확인",null);
            share_ad.setNegativeButton("취소",null);
            share_ad.show();
        } else if (id == R.id.nav_push) {
            AlertDialog.Builder push_ad = new AlertDialog.Builder(MainActivity.this);
            push_ad.setTitle("푸시 알람 사용");
            push_ad.setMessage("푸시 알람을 사용 하시겠습니까?");
            push_ad.setPositiveButton("네", null);
            push_ad.setNegativeButton("아니요", null);
            push_ad.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
