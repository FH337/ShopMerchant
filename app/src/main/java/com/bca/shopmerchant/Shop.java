package com.bca.shopmerchant;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Shop extends Fragment {
    TextView shopurl;
    Button shoprfrsh;
    Payment payment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Homepage activity = (Homepage) getActivity();
        final String url = activity.getShopUrl();

        payment = new Payment();


        View v = inflater.inflate(R.layout.fragment_shop, container, false);

        final WebView shopweb = v.findViewById(R.id.shopweb);
        shopweb.getSettings().setJavaScriptEnabled(true);
        shopweb.addJavascriptInterface(new Shop.WebAppInterfaceShop(getActivity()), "Shop");
        shopweb.setWebViewClient(new WebViewClient());
        shopweb.loadUrl(url);

        shopurl = (TextView) v.findViewById(R.id.shopurl);
        shoprfrsh = (Button) v.findViewById(R.id.shoprfr);
        shopurl.setText(url);

        shoprfrsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopweb.loadUrl(url);
            }
        });


        return v;

    }

    public class WebAppInterfaceShop {

        Context mContext;


        // Instantiate the interface and set the context

        WebAppInterfaceShop(Context c) {
            mContext = c;
        }


        @JavascriptInterface
        public void moveShop() {

            Intent shoptopay = new Intent(getActivity().getApplication(), Payment.class);
            startActivity(shoptopay);


        }
    }
}




