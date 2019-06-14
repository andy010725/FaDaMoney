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
import android.widget.TextView;


public class TabFragment2 extends Fragment {

    private View v;
    private Button button1;
    private ImageButton button_exaggerate;
    private ImageButton button_blame;
    private ImageButton button_charm;
    private TextView textview_exaggerate;
    private TextView textview_blame;
    private TextView textview_charm;
    private TextView textview_lvpoint;

    public static TabFragment2 newInstance(){
        TabFragment2 f = new TabFragment2();
        Bundle arg = new Bundle();
        f.setArguments(arg);
        return f;
    }

    public TabFragment2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment2, container, false);
        button1 = v.findViewById(R.id.button_cancel);
        button_exaggerate = v.findViewById(R.id.button_exaggerate);
        button_blame = v.findViewById(R.id.button_blame);
        button_charm = v.findViewById(R.id.button_charm);
        textview_exaggerate = v.findViewById(R.id.textView_exaggerate);
        textview_blame = v.findViewById(R.id.textView_blame);
        textview_charm = v.findViewById(R.id.textView_charm);
        textview_lvpoint = v.findViewById(R.id.textView_LV);
        MainActivity xxx = (MainActivity) getActivity();
        textview_exaggerate.setText(Integer.toString(xxx.exaggerate));
        textview_blame.setText(Integer.toString(xxx.blame));
        textview_charm.setText(Integer.toString(xxx.charm));
        textview_lvpoint.setText("技能點:"+Integer.toString(xxx.levelpoint));

        if (xxx.levelpoint<=0){
            button_exaggerate.setEnabled(false);
            button_blame.setEnabled(false);
            button_charm.setEnabled(false);
        }
        if (xxx.exaggerate==4){
            button_exaggerate.setEnabled(false);
        }
        if (xxx.blame==4){
            button_blame.setEnabled(false);
        }
        if (xxx.charm==4){
            button_charm.setEnabled(false);
        }

        button_exaggerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity xxx = (MainActivity) getActivity();
                if (xxx.exaggerate==3){
                    button_exaggerate.setEnabled(false);
                }
                xxx.exaggerate +=1;
                textview_exaggerate.setText(Integer.toString(xxx.exaggerate));
                xxx.levelpoint -=1;
                textview_lvpoint.setText("技能點:"+ Integer.toString(xxx.levelpoint));

                switch (xxx.exaggerate) {

                    case 2:
                        xxx.score_rate = 100;
                        break;
                    case 3:
                        xxx.score_rate = 1000;
                        break;
                    case 4:
                        xxx.score_rate = 5000;
                        break;
                }





                if (xxx.levelpoint<=0){
                    button_exaggerate.setEnabled(false);
                    button_blame.setEnabled(false);
                    button_charm.setEnabled(false);
                }
            }
        });
        button_blame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity xxx = (MainActivity) getActivity();
                if (xxx.blame==3){
                    button_blame.setEnabled(false);
                }
                xxx.blame +=1;
                textview_blame.setText(Integer.toString(xxx.blame));
                xxx.levelpoint -=1;
                textview_lvpoint.setText("技能點:"+Integer.toString(xxx.levelpoint));


                switch (xxx.blame) {

                    case 2:
                        xxx.fadamoney = 500;
                        break;
                    case 3:
                        xxx.fadamoney = 1000;
                        break;
                    case 4:
                        xxx.fadamoney = 5000;
                        break;
                }




                if (xxx.levelpoint<=0){
                    button_exaggerate.setEnabled(false);
                    button_blame.setEnabled(false);
                    button_charm.setEnabled(false);
                }
            }
        });
        button_charm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity xxx = (MainActivity) getActivity();
                if (xxx.charm==3){
                    button_charm.setEnabled(false);
                }
                xxx.charm +=1;
                textview_charm.setText(Integer.toString(xxx.charm));
                xxx.levelpoint -=1;
                textview_lvpoint.setText("技能點:"+Integer.toString(xxx.levelpoint));



                switch (xxx.charm) {

                    case 2:
                        xxx.sec = 700;
                        break;
                    case 3:
                        xxx.sec = 600;
                        break;
                    case 4:
                        xxx.sec = 500;
                        break;
                }






                if (xxx.levelpoint<=0){
                    button_exaggerate.setEnabled(false);
                    button_blame.setEnabled(false);
                    button_charm.setEnabled(false);
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





    }
    private void changefragmet(android.support.v4.app.Fragment f){
        android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment,f);
        transaction.commitNowAllowingStateLoss();
    }
}