package com.example.test;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TabFragment5 extends Fragment {

    private View v;
    private Button button1;
    private Button button_LL;
    private Button button_TW;
    private Button button_CH;
    private Button button_Road;
    private Button button_Inf;
    private Button button_cute;
    private String job;
    private Handler handler = new Handler();


    public static TabFragment5 newInstance() {
        TabFragment5 f = new TabFragment5();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment5, container, false);
        //////////////////////////setButtonID///////////////////////////////////////////////////////
        button1 = v.findViewById(R.id.button_cancel);
        button_LL = v.findViewById(R.id.button);
        button_TW = v.findViewById(R.id.button2);
        button_CH = v.findViewById(R.id.button3);
        button_Road = v.findViewById(R.id.button4);
        button_Inf = v.findViewById(R.id.button5);
        button_cute = v.findViewById(R.id.button6);
        ////////////////////////////////////////////////////////////////////////////////////////////
        final MainActivity xxx = (MainActivity) getActivity();
        //////////////////////////////////////////////////////////////////////////////////////////////
        /////初始設定/////
        if (xxx.LL == 1) {
            button_LL.setEnabled(false);
        } else {
            button_LL.setEnabled(true);
        }
        if (xxx.TW == 1) {
            button_TW.setEnabled(false);
        } else {
            button_TW.setEnabled(true);
        }
        if (xxx.CH == 1) {
            button_CH.setEnabled(false);
        } else {
            button_CH.setEnabled(true);
        }
        if (xxx.road == 1) {
            button_Road.setEnabled(false);
        } else {
            button_Road.setEnabled(true);
        }
        if (xxx.Inf == 1) {
            button_Inf.setEnabled(false);
        } else {
            button_Inf.setEnabled(true);
        }
        if (xxx.cute == 1) {
            button_cute.setEnabled(false);
        } else {
            button_cute.setEnabled(true);
        }
        /////////////////////////////////////////////////

        /////////////////////////ButtonAction///////////////////////////////////////////////////////

        /////////////////////////滷肉飯/////////////////////////////////////////////////////////////
        button_LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score >= 40000) {
                    xxx.score -= 40000;
                    xxx.LL = 1;
                    button_LL.setEnabled(false);
                }
            }
        });
        /////////////////////////////////台灣價值//////////////////////////////////////////////////

        button_TW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score >= 10000) {
                    xxx.score -= 10000;
                    xxx.TW = 1;
                    button_TW.setEnabled(false);
                }
            }
        });
        ///////////////////////////////五星旗///////////////////////////////////////////////////////

        button_CH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score >= 30000) {
                    xxx.score -= 30000;
                    xxx.CH = 1;
                    button_CH.setEnabled(false);
                }
            }
        });

        ///////////////////////////////////一帶一路////////////////////////////////////////////////
        button_Road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score >= 50000) {
                    xxx.score -= 50000;
                    xxx.road = 1;
                    button_Road.setEnabled(false);
                }
            }
        });

        /////////////////////////////////無限手套//////////////////////////////////
        button_Inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score >= 100000) {
                    xxx.score -= 100000;
                    xxx.Inf = 1;
                    button_Inf.setEnabled(false);
                }
            }
        });

        ///////////////////////////////公仔/////////////////////////////////////////////////////////
        button_cute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xxx.score >= 8000) {
                    xxx.score -= 8000;
                    xxx.cute = 1;
                    button_cute.setEnabled(false);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changefragmet(TabFragment1.newInstance());
            }
        });
        return v;
        ////////////////////////////////////////////////////////////////////////////////////////////
    }

    private void changefragmet(android.support.v4.app.Fragment f) {
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment, f);
        transaction.commitNowAllowingStateLoss();
    }
}