package com.example.dell.wwe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    public static TextView details;
    public  static  TextView t_;
    public  static  TextView temm;
    public  static  TextView cond;
    public  static  TextView dat;
    public  static  TextView wind;
    public  static  TextView pres;
    public  static  TextView hum;
    public static TextView suR;
    public static TextView suS;
    public static TextView coord;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        details = (TextView)findViewById(R.id.info);
        t_ = (TextView) findViewById(R.id.t_title);
        temm= (TextView) findViewById(R.id.tmp);
        cond= (TextView) findViewById(R.id.cond);
        dat = (TextView)findViewById(R.id.datte);
        wind = (TextView) findViewById(R.id.tx_Wind);
        pres = (TextView)findViewById(R.id.txPress);
        hum = (TextView)findViewById(R.id.txHum);
        suR = (TextView)findViewById(R.id.txSunR);
        suS = (TextView)findViewById(R.id.txSunS);
        coord = (TextView)findViewById(R.id.txCoords);


    }
}
