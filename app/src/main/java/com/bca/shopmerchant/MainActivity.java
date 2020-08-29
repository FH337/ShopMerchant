package com.bca.shopmerchant;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText url1;
    EditText url2;
    Button load;
    String urlshop;
    String urlabout;
    TextView cek1;
    TextView cek2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        final String toast = "Check your URL";


        url1 = (EditText) findViewById(R.id.url1);
        url2 = (EditText) findViewById(R.id.url2);
        load = (Button) findViewById(R.id.load);


         urlshop =  url1.getText().toString().toLowerCase();
         urlabout = url2.getText().toString().toLowerCase();

        Pattern p1 = Pattern.compile("http:\\/\\/|https:\\/\\/");
        final Matcher m1 = p1.matcher(url1.getText().toString().toLowerCase());
        final Matcher m2 = p1.matcher(url2.getText().toString().toLowerCase());





        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*   if(m1.find()&& m2.find()){

                    load.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent main = new Intent(MainActivity.this, Homepage.class);
                            main.putExtra("urlshop",url1.getText().toString().toLowerCase());
                            main.putExtra("urlabout",url2.getText().toString().toLowerCase());
                            startActivity(main);
                            finish();
                        }
                    });


                }
                else
                {
                    Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
                }*/




                Intent main = new Intent(MainActivity.this, Homepage.class);
                main.putExtra("urlshop",url1.getText().toString().toLowerCase());
                main.putExtra("urlabout",url2.getText().toString().toLowerCase());
                startActivity(main);
                finish();
            }
        });
    }

}
