package com.example.dell.wwe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button clickd;
   public static EditText data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickd = (Button) findViewById(R.id.button);
        data = (EditText) findViewById(R.id.tx_City);


        clickd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent details = new Intent(MainActivity.this, Details.class);
                startActivity(details);

                fetchData proc = new fetchData();
                proc.execute();

            }
        });

    }
}
