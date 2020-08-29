package com.bca.shopmerchant;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PayoldFragment extends Fragment {
    Context context = this.getContext();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_payold, container, false);
        Button pay = v.findViewById(R.id.paybut);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentcontainer,new PayFragment());
                ft.commit();



            }
        });
        FragmentTransaction ft1 = getFragmentManager().beginTransaction();
        ft1.remove(this);
        return v;
    }

}
