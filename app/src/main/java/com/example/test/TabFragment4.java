package com.example.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TabFragment4 extends Fragment {

    private View v;
    private Button button1;
    private Button button;
    private Button button2;
    private Button button3;

    public static TabFragment4 newInstance(){
        TabFragment4 f = new TabFragment4();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment4() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment4, container, false);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xxx.lunchthirdAct(1);/////////////文本1///////////
            }
        });
        ////英文////
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xxx.lunchthirdAct(2);/////////////文本2///////////
            }
        });
        ////國唱///
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xxx.lunchthirdAct(3);///////////文本3//////////////
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

