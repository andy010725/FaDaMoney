package com.example.test;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


public class TabFragment1 extends Fragment {
    private View v;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;

    public static TabFragment1 newInstance() {
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

        /////能力值///////
        button1 = v.findViewById(R.id.button_row11);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment2.newInstance());

            }
        });
        /////韓語錄////////
        button2 = v.findViewById(R.id.button_row12);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment3.newInstance());
            }
        });
        ///////站台///////
        button3 = v.findViewById(R.id.button_row13);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment4.newInstance());
            }
        });
        /////發大財按鈕///////
        button4 = v.findViewById(R.id.button_row21);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity xxx = (MainActivity) getActivity();
                xxx.score = xxx.score + xxx.fadamoney;
                xxx.exp = xxx.exp + xxx.fadamoney;
                xxx.image.setImageResource(R.drawable.fadamoney);
            }
        });
        ///////收購///////
        button5 = v.findViewById(R.id.button_row31);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment5.newInstance());
            }
        });
        ///////競選///////
        button6 = v.findViewById(R.id.button_row32);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment6.newInstance());
            }
        });
        /////付費選項///////
        button7 = v.findViewById(R.id.button_row33);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment7.newInstance());
            }
        });
        return v;
    }

    private void changefragmet(android.support.v4.app.Fragment f) {
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment, f);
        transaction.commitNowAllowingStateLoss();
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);

    }
}
