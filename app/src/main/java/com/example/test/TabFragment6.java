package com.example.test;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class TabFragment6 extends Fragment {

    private View v;
    private Button button1;
    private Button button_KH;
    private Button button_TWper;
    private Button button_CHper;
    private Button button_earth;
    private Button button_galaxy;
    private String job;
    private Handler handler = new Handler();


    public static TabFragment6 newInstance() {
        TabFragment6 f = new TabFragment6();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment6, container, false);
        //////////////////////////setButtonID///////////////////////////////////////////////////////
        button1 = v.findViewById(R.id.button_cancel);
        button_KH = v.findViewById(R.id.button);
        button_TWper = v.findViewById(R.id.button2);
        button_CHper = v.findViewById(R.id.button3);
        button_earth = v.findViewById(R.id.button4);
        button_galaxy = v.findViewById(R.id.button5);
        ////////////////////////////////////////////////////////////////////////////////////////////
        final MainActivity xxx = (MainActivity) getActivity();
        job = xxx.job;
        switch (job){

            case "職位: 無業" :
                break;

            case "職位: 北農總經理":
                break;

            case "職位: 高雄市長":
                button_KH.setEnabled(false);
                break;

            case "職位: 台灣總統":
                button_KH.setEnabled(false);
                button_TWper.setEnabled(false);
                break;

            case "職位: 中國總書記":
                button_KH.setEnabled(false);
                button_TWper.setEnabled(false);
                button_CHper.setEnabled(false);
                break;

            case "職位: 地球領導人":
                button_KH.setEnabled(false);
                button_TWper.setEnabled(false);
                button_CHper.setEnabled(false);
                button_earth.setEnabled(false);
                break;

            case "職位: 銀河系霸主":
                button_KH.setEnabled(false);
                button_CHper.setEnabled(false);
                button_earth.setEnabled(false);
                button_TWper.setEnabled(false);
                button_galaxy.setEnabled(false);
                break;



        }


        /////////////////////////////ButtonAction///////////////////////////////////////////////////
        button_KH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(xxx.job=="職位: 北農總經理" && xxx.score>=10000 && xxx.level>=2 && xxx.binbin==1 && xxx.LL==1){
                    xxx.job = "職位: 高雄市長";
                    xxx.job_text.setText(xxx.job);
                    xxx.hanalert(2);
                    button_KH.setEnabled(false);
                }
            }
        });


        button_TWper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(xxx.job=="職位: 高雄市長" && xxx.score>=30000 && xxx.level>=4 && xxx.TW==1) {
                    xxx.job = "職位: 台灣總統";
                    xxx.job_text.setText(xxx.job);
                    xxx.hanalert(3);
                    button_TWper.setEnabled(false);
                }
            }
        });


        button_CHper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(xxx.job=="職位: 台灣總統" && xxx.score>=50000 && xxx.level>=6 && xxx.inwen==1 && xxx.CH==1) {
                    xxx.job = "職位: 中國總書記";
                    xxx.job_text.setText(xxx.job);
                    button_CHper.setEnabled(false);
                }
            }
        });


        button_earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (xxx.job=="職位: 中國總書記" && xxx.score>=80000 && xxx.level>=8 && xxx.road==1) {
                    xxx.job = "職位: 地球領導人";
                    xxx.job_text.setText(xxx.job);
                    button_earth.setEnabled(false);
                }
            }
        });


        button_galaxy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(xxx.job=="職位: 地球領導人" && xxx.score>=100000 && xxx.level>=10 && xxx.Inf==1) {
                    xxx.job = "職位: 銀河系霸主";
                    xxx.job_text.setText(xxx.job);
                    button_galaxy.setEnabled(false);
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



    ///////////////////////////
}