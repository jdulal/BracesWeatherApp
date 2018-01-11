package com.bracesmedia.bracesweather.Common;

import android.support.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jagadish on 1/11/2018.
 */

public class Common {
    public static String API_KEY="40801500d6b12d5ed0c72fcdc20b4525";
    public static String API_LINK="http://api.openweathermap.org/data/2.5/weather";

    @NonNull
    public static String apiRequest (String lat, String lng){
        StringBuilder sb= new StringBuilder(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric", lat, lng, API_KEY));
        return sb.toString();
    }

    public static String unixTimeStampToDateTime(double unixTimeStamp){
        DateFormat dateFormat= new SimpleDateFormat("HH:mm");
        Date date=new Date();
        date.setTime((long)unixTimeStamp*1000);
        return  dateFormat.format(date);
    }

    public static String getImages(String icon){
        return String.format("http://openweathermap.org/img/w/%s.png", icon);
    }

    public static String getDateNow(){
        DateFormat dateFormat=new SimpleDateFormat("dd MMM yyyy HH:mm");
        Date date =new Date();
        return dateFormat.format(date);
    }
}
