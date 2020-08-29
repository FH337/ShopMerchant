package com.bca.shopmerchant;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    WebView pay;
    String mdd = "http://192.168.1.100/pay.html";
    Button homebut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        homebut = findViewById(R.id.homebut);
        pay = findViewById(R.id.payweb);

        homebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(Payment.this,Homepage.class);
                startActivity(main);
                finish();
            }
        });

        pay.getSettings().setJavaScriptEnabled(true);
        pay.addJavascriptInterface(new Payment.WebAppInterfacePay(Payment.this), "Pay");
        pay.setWebViewClient(new WebViewClient());
        pay.loadUrl("file:///android_asset/pay.html");




    }




    public class WebAppInterfacePay {

        Context mContext;


        // Instantiate the interface and set the context

        WebAppInterfacePay(Context c) {
            mContext = c;
        }


        @JavascriptInterface
        public void movePayment() {

            Intent chnIntent = new Intent(Payment.this, PayActivity.class);
            startActivity(chnIntent);
            finish();


        }

    }
}
