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

public class ThxActivity extends AppCompatActivity {
    WebView thx;
    String thx1 = "http://192.168.1.100/thanks.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thx);
        thx = findViewById(R.id.thxweb);
        thx.getSettings().setJavaScriptEnabled(true);
        thx.addJavascriptInterface(new ThxActivity.WebAppInterfaceThx(  ThxActivity.this), "backhome");
        thx.setWebViewClient(new WebViewClient());
        thx.loadUrl("file:///android_asset/thanks.html");

        Button home = findViewById(R.id.homebut);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(ThxActivity.this,Homepage.class);
                startActivity(main);
                finish();
            }
        });

    }

    public class WebAppInterfaceThx {

        Context mContext;


        // Instantiate the interface and set the context

        WebAppInterfaceThx(Context c) {
            mContext = c;
        }



        @JavascriptInterface
        public void intentHome() {
            Intent toHome = new Intent(ThxActivity.this,Homepage.class);
            startActivity(toHome);
            finish();
        }

    }
}
