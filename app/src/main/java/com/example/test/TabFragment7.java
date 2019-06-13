package com.example.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TabFragment7 extends Fragment {

    private View v;
    private Button button1;
    private Button button2;

    public static TabFragment7 newInstance(){
        TabFragment7 f = new TabFragment7();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment7() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment7, container, false);
        button1 = v.findViewById(R.id.button_cancel);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment1.newInstance());
            }
        });
        button2 = v.findViewById(R.id.button_zero);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity xxx = (MainActivity) getActivity();
                xxx.score = 0;
                xxx.score_rate=1;
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

