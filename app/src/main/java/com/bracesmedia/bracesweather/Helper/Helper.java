package com.bracesmedia.bracesweather.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jagadish on 1/11/2018.
 */

public class Helper {
    static String stream = null;

    public Helper(){

    }
    public String getHTTPData(String urlString){
        try {
            URL url= new URL(urlString);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            //Check response is 200 OK
            if(httpURLConnection.getResponseCode()==200)
            {
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder stringBuilder=new StringBuilder();
                String line;
                while((line =bufferedReader.readLine())!=null)
                    stringBuilder.append(line);
                stream = stringBuilder.toString();
                httpURLConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
