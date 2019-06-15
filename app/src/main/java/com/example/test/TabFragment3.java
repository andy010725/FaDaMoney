package com.example.test;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class TabFragment3 extends Fragment {

    private View v;
    private Button button1;
    private Button button;
    private Button button2;
    private Button button3;

    public static TabFragment3 newInstance(){
        TabFragment3 f = new TabFragment3();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment3, container, false);
        final MainActivity xxx = (MainActivity) getActivity();

        button1 = v.findViewById(R.id.button_cancel);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment1.newInstance());
            }
        });
        button = v.findViewById(R.id.button);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);
        /////初始設定/////
        if (xxx.binbin==1){
            button.setEnabled(false);
        }else {
            button.setEnabled(true);
        }
        if (xxx.inwen==1){
            button2.setEnabled(false);
        }else {
            button2.setEnabled(true);
        }
        if (xxx.gwochun==1){
            button3.setEnabled(false);
        }else {
            button3.setEnabled(true);
        }
        ////冰冰姐/////
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(xxx.score>10000){
                    xxx.score = xxx.score-10000;
                    xxx.binbin = 1;
                    button.setEnabled(false);
                    xxx.suport1.setVisibility(View.VISIBLE);
                    /////////////////////////////////////////////////////
                    xxx.score_rate +=1000;
                }
            }
        });
        ////英文////
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score > 230000) {
                    xxx.score = xxx.score - 230000;
                    xxx.inwen = 1;
                    button2.setEnabled(false);
                    xxx.suport2.setVisibility(View.VISIBLE);
                    //////////////////////////////////////////////////////////////
                    xxx.fadamoney +=10000;
                }
            }
        });
        ////國唱///
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score > 9999999) {
                    xxx.score = xxx.score - 9999999;
                    xxx.gwochun = 1;
                    button3.setEnabled(false);
                    xxx.suport3.setVisibility(View.VISIBLE);
                    /////////////////////////////////////////////////////////
                    xxx.fadamoney -= 200;
                }
            }
        });
        return v;
    }
    private void changefragmet(android.support.v4.app.Fragment f){
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment,f);
        transaction.commitNowAllowingStateLoss();
    }
}

