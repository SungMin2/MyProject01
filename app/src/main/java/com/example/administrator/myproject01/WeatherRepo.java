package com.example.administrator.myproject01;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherRepo {

    @SerializedName("weather")
    @Expose
    Weather weather;

    public class Weather {

        @SerializedName("forecast6days")
        @Expose
        public List<Forecast6day> forecast6days = new ArrayList<>();

        public List<Forecast6day> getForecast6days() {
            return forecast6days;
        }


        public class Forecast6day {

            @SerializedName("grid")
            @Expose
            Grid grid;
            @SerializedName("sky")
            @Expose
            Sky sky;
            @SerializedName("temperature")
            @Expose
            Temperature temperature;
            @SerializedName("timeRelease")
            @Expose
            String timeRelease;

            public Grid getGrid() {
                return grid;
            }

            public Sky getSky() {
                return sky;
            }

            public Temperature getTemperature() {
                return temperature;
            }

            public String getTimeRelease() {
                return timeRelease;
            }

            public class Grid {

                @SerializedName("city")
                @Expose
                String city;
                @SerializedName("county")
                @Expose
                String county;
                @SerializedName("village")
                @Expose
                String village;

                public String getCity() {
                    return city+" "+county+" "+village;
                }
            }

            public class Sky {
                @SerializedName("pmCode2day")
                @Expose
                String pmCode2day;
                @SerializedName("pmCode3day")
                @Expose
                String pmCode3day;
                @SerializedName("pmCode4day")
                @Expose
                String pmCode4day;
                @SerializedName("pmCode5day")
                @Expose
                String pmCode5day;
                @SerializedName("pmCode6day")
                @Expose
                String pmCode6day;
                @SerializedName("pmCode7day")
                @Expose
                String pmCode7day;
                @SerializedName("pmCode8day")
                @Expose
                String pmCode8day;

                public String getSkycode(int i){
                    if(i == 0) {
                        return pmCode2day;
                    }else if(i == 1){
                        return pmCode3day;
                    }else if(i == 2){
                        return pmCode4day;
                    }else if(i == 3){
                        return pmCode5day;
                    }else if(i == 4){
                        return pmCode6day;
                    }else if(i == 5){
                        return pmCode7day;
                    }else{
                        return pmCode8day;
                    }
                }
            }

            public class Temperature {

                @SerializedName("tmin2day")
                @Expose
                String tmin2day;
                @SerializedName("tmax2day")
                @Expose
                String tmax2day;
                @SerializedName("tmin3day")
                @Expose
                String tmin3day;
                @SerializedName("tmax3day")
                @Expose
                String tmax3day;
                @SerializedName("tmin4day")
                @Expose
                String tmin4day;
                @SerializedName("tmax4day")
                @Expose
                String tmax4day;
                @SerializedName("tmin5day")
                @Expose
                String tmin5day;
                @SerializedName("tmax5day")
                @Expose
                String tmax5day;
                @SerializedName("tmin6day")
                @Expose
                String tmin6day;
                @SerializedName("tmax6day")
                @Expose
                String tmax6day;
                @SerializedName("tmin7day")
                @Expose
                String tmin7day;
                @SerializedName("tmax7day")
                @Expose
                String tmax7day;
                @SerializedName("tmin8day")
                @Expose
                String tmin8day;
                @SerializedName("tmax8day")
                @Expose
                String tmax8day;

                public String getTemp(int i){
                    if(i == 0){
                        return tmin2day + " / " + tmax2day;
                    }else if(i == 1){
                        return tmin3day + " / " + tmax3day;
                    }else if(i == 2){
                        return tmin4day + " / " + tmax4day;
                    }else if(i == 3){
                        return tmin5day + " / " + tmax5day;
                    }else if(i == 4){
                        return tmin6day + " / " + tmax6day;
                    }else if(i == 5){
                        return tmin7day + " / " + tmax7day;
                    }else{
                        return tmin8day + " / " + tmax8day;
                    }
                }
            }
        }
    }
    public Weather getWeather() {
        return weather;
    }

}
