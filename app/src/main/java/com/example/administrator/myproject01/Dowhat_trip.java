package com.example.administrator.myproject01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Dowhat_trip extends AppCompatActivity {
    LinearLayout layout = null;
    RecyclerView recyclerview;
    TextView dowhat_trip_date;
    String dowhat_date, title_tv;

    String title, address, tel, url, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dowhat_trip);

        recyclerview = (RecyclerView) findViewById(R.id.trip_rv);

        GetXMLTask1 task1 = new GetXMLTask1();
        task1.execute("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?serviceKey=JI5iaAMofKW0PgTEzjqzA38Ut65niZWOSb2qDUs%2BXHVBM10SOY8toEJhq4ESw0rWBNtG%2BBIVJNMXNDkSt9H15g%3D%3D&MobileOS=AND&MobileApp=MyProject01&arrange=C&numOfRows=10&contentTypeId=12");


        dowhat_trip_date = (TextView) findViewById(R.id.dowhat_trip_date);

        long now = System.currentTimeMillis();
        Date date = new Date(now);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        DateFormat dateFormat = new SimpleDateFormat("MM.dd");

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                calendar.add(Calendar.DATE, -6);
                calendar2.add(Calendar.DATE, 0);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
            case 2:
                calendar.add(Calendar.DATE, 0);
                calendar2.add(Calendar.DATE, 6);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
            case 3:
                calendar.add(Calendar.DATE, -1);
                calendar2.add(Calendar.DATE, 5);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
            case 4:
                calendar.add(Calendar.DATE, -2);
                calendar2.add(Calendar.DATE, 4);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
            case 5:
                calendar.add(Calendar.DATE, -3);
                calendar2.add(Calendar.DATE, 3);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
            case 6:
                calendar.add(Calendar.DATE, -4);
                calendar2.add(Calendar.DATE, 2);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
            case 7:
                calendar.add(Calendar.DATE, -5);
                calendar2.add(Calendar.DATE, 1);
                dowhat_date = dateFormat.format(calendar.getTime()) + " ~ " + dateFormat.format(calendar2.getTime());
                break;
        }

        DateFormat dateFormat2 = new SimpleDateFormat("MM");

        if(calendar.get(Calendar.WEEK_OF_MONTH) == 1){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 1주차";
        }else if(calendar.get(Calendar.WEEK_OF_MONTH) == 2){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 2주차";
        }else if(calendar.get(Calendar.WEEK_OF_MONTH) == 3){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 3주차";
        }else if(calendar.get(Calendar.WEEK_OF_MONTH) == 4){
            title_tv = dateFormat2.format(calendar.getTime()) + "월 4주차";
        }else{
            title_tv = dateFormat2.format(calendar.getTime()) + "월 5주차";
        }

        dowhat_trip_date.setText(title_tv + "  " + dowhat_date);
    }

    private class GetXMLTask1 extends AsyncTask<String, Void, Document>{

        @Override
        protected Document doInBackground(String... urls) {
            Document doc = null;
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML문서 빌더 객체를 생성
                doc = db.parse(new InputSource(url.openStream())); //XML문서를 파싱한다.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {
            List<Trip_view> trip_views = new ArrayList<Trip_view>();

            NodeList nodeList = doc.getElementsByTagName("item");

            for(int i = 0; i< nodeList.getLength(); i++) {
                Trip_view trip_view = new Trip_view();

                Node node = nodeList.item(i); //data엘리먼트 노드
                Element fstElmnt = (Element) node;

                NodeList titleList = fstElmnt.getElementsByTagName("title");
                Element subItem = (Element) titleList.item(0);
                if (subItem == null){
                    title = "주소정보없음";
                    overview = "정보없음";
                } else {
                    NodeList subElement1 = subItem.getChildNodes();
                    title = subElement1.item(0).getNodeValue();
                    overview = subElement1.item(0).getNodeValue();
                }

                NodeList addrList = fstElmnt.getElementsByTagName("addr1");
                subItem = (Element) addrList.item(0);
                if (subItem == null){
                    address = "주소정보없음";
                } else {
                    NodeList subElement2 = subItem.getChildNodes();
                    address = subElement2.item(0).getNodeValue();
                }

                NodeList telList = fstElmnt.getElementsByTagName("tel");
                subItem = (Element) telList.item(0);
                if (subItem == null) {
                    tel = "전화정보없음";
                } else {
                    NodeList subElement3 = subItem.getChildNodes();
                    tel = subElement3.item(0).getNodeValue();
                }

                NodeList imgList = fstElmnt.getElementsByTagName("firstimage");
                subItem = (Element) imgList.item(0);
                if (subItem == null) {
                    url = "http://placehold.it/300x200?text=No+Image";
                } else {
                    NodeList subElement4 = subItem.getChildNodes();
                    url = subElement4.item(0).getNodeValue();
                }

                trip_view.setNum(i+1+"");
                trip_view.setTitle(title);
                trip_view.setImgURL(url);
                trip_view.setInfo(overview);
                trip_view.setAddress(address);
                trip_view.setTel(tel);

                trip_views.add(trip_view);

            }

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

            recyclerview.setHasFixedSize(true);
            recyclerview.setAdapter(new MyTripAdapter(trip_views, R.layout.activity_trip_view));
            recyclerview.setLayoutManager(mLayoutManager);
            recyclerview.setItemAnimator(new DefaultItemAnimator());
            super.onPostExecute(doc);
        }
    }
}
