package com.example.test;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TabFragment1 extends Fragment {
    private View v;
    private Button button1;

    public static TabFragment1 newInstance(){
        TabFragment1 f = new TabFragment1();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.tab_fragment1, container, false);
         button1 = v.findViewById(R.id.button_row11);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                    changefragmet(TabFragment2.newInstance());
             }
         });
         return v;
    }
    private void changefragmet(android.support.v4.app.Fragment f){
    android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment4,f);
    transaction.commitNowAllowingStateLoss();
    }
}
