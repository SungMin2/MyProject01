package com.example.administrator.myproject01;

public class Weather_view {

    String temp;
    String date;
    int img;

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getTemp() {
        return temp;
    }
    public void setTemp(String temp) {
        this.temp = temp;
    }
    public int getImg(){
        return img;
    }
    public void setImg(String skyCode){
        if(skyCode.equals("SKY_W01")){
            img = R.drawable.w_clear;
        }else if(skyCode.equals("SKY_W02")){
            img = R.drawable.w_cloud_a;
        }else if(skyCode.equals("SKY_W03")){
            img = R.drawable.w_cloud_b;
        }else if(skyCode.equals("SKY_W04")){
            img = R.drawable.w_cloud_c;
        }else if(skyCode.equals("SKY_W07")){
            img = R.drawable.w_rain_a;
        }else if(skyCode.equals("SKY_W09")){
            img = R.drawable.w_rain_b;
        }else if(skyCode.equals("SKY_W10")){
            img = R.drawable.w_rain_d;
        }else if(skyCode.equals("SKY_W11")){
            img = R.drawable.w_rain_e;
        }else if(skyCode.equals("SKY_W12")){
            img = R.drawable.w_snow_b;
        }else if(skyCode.equals("SKY_W13")){
            img = R.drawable.w_snow_c;
        }
    }
}