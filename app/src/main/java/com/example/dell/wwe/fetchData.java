package com.example.dell.wwe;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class fetchData extends AsyncTask<Void,Void,Void> {

String data = "";
String city = MainActivity.data.getText().toString();
String ddparsd = "";
String coord="";
String description="";
String tempera = "";
String iconid="";
URL icon;
String singledpa = "";
String gg = "";
String cty = "";
String sunrise = "";
String code = "";
String wind = "";
String presss = "";
String hum = "";
Date currentTime = Calendar.getInstance().getTime();
    public static final Calendar c = Calendar.getInstance();
    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
            "HH:mm");


    @Override
    protected Void doInBackground(Void... voids) {



        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+ city+"&appid=c2e506d0ce81d37f542d0e2a0237e468&units=metric");
            icon = new URL("http://openweathermap.org/img/w/"+iconid+".png");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = " ";

            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject jsonObject = new JSONObject(data);

            cty = jsonObject.getString("name");
            tempera = jsonObject.getJSONObject("main").getString("temp")+" °C";
            wind ="Wind:"+"\t\t\t\t\t\t\t"+"speed: "+ jsonObject.getJSONObject("wind").getString("speed")+"m/s ";
            code = jsonObject.getJSONObject("sys").getString("country");
            long sample = jsonObject.getJSONObject("sys").getLong("sunrise");
            c.setTimeInMillis(sample * 1000);
            sunrise = "Sunrise : "
                    + DATE_FORMATTER.format(c.getTime());


            presss = "Pressure:"+"\t\t\t\t\t"+jsonObject.getJSONObject("main").getString("pressure")+"hpa" ;
            hum = "Humidity: \t\t\t\t\t\t"+jsonObject.getJSONObject("main").getString("humidity")+"%";


         ////   gg  = "Humidity: \t"+jsonObject.getJSONObject("main").getString("humidity")
////
            //ddparsd += "   \n" + coord;

            JSONArray weatherArray = jsonObject.getJSONArray("weather");
            for (int i = 0; i < weatherArray.length(); i++) {
                JSONObject jo = weatherArray.getJSONObject(i);
                description = jo.getString("description");
                iconid = jo.getString("icon");
                //icon = jo.getString("icon");
            }
            ddparsd += "  \n" +" \n"+gg;
            singledpa += " \n"+coord+"C";

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Details.temm.setText(tempera);
        Details.t_.append(" "+cty+","+code);
        Details.cond.setText(description);
        Details.dat.setText("get at "+currentTime+"");
        Details.wind.setText(wind);
        Details.pres.setText(presss);
        Details.hum.setText(hum);
        Details.suR.setText(sunrise);

        ;


    }

}
