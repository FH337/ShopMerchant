package com.bca.shopmerchant;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;


public class About extends Fragment {

    TextView urlabout;
    Button rfrsh;
    String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)   {

       /* if (getArguments() != null) {
             url = getArguments().getString("abouturl");
        }*/

        Homepage activity = (Homepage) getActivity();
        final String url = activity.getAboutUrl();


        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
         final WebView aboutweb = v.findViewById(R.id.aboutweb);
        aboutweb.getSettings().setJavaScriptEnabled(true);
        aboutweb.setWebViewClient(new WebViewClient());
        aboutweb.loadUrl(url);

        urlabout = (TextView) v.findViewById(R.id.urlabout);
        rfrsh = (Button)v   .findViewById(R.id.rfrsabout);
        rfrsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutweb.loadUrl(url);
            }
        });


       urlabout.setText(url);





       return v;


    }


}
