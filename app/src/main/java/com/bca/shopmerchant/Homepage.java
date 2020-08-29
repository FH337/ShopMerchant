package com.bca.shopmerchant;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;
    Button home;
    String urlshop;
    String linkabout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        urlshop = getIntent().getExtras().getString("urlshop");
        linkabout = getIntent().getExtras().getString("urlabout");

        home = findViewById(R.id.button4);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(Homepage.this,MainActivity.class);
                startActivity(main);


            }
        });





        sectionsPageAdapter   = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        SetupViewPager(viewPager);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    public String getAboutUrl() {
        return linkabout;
    }

    public String getShopUrl() {
        return urlshop;
    }

    private void SetupViewPager(ViewPager viewPager){



        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Shop(),"SHOP");
        adapter.addFragment(new Inbox(),"INBOX");
        adapter.addFragment(new About(),"ABOUT");

        viewPager.setAdapter(adapter);
    }
}