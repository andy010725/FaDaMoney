package com.example.test;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Long startTime;
    private Handler handler = new Handler();
    public int score = 0;
    public int exp = 0;
    public int time = 0;
    public int score_rate = 1; // 跳錢的倍率
    public int stop = 0;
    public int level = 1;
    public int levelpoint = 0;
    public int fadamoney = 100;
    public int sec = 1000;
    public String job = "職位: 無業";
    TextView Socre_text;
    TextView job_text;
    TextView text_saying;
    ImageView image;
    TextView textlevel;
    public int exaggerate = 1;
    public int blame = 1;
    public int charm = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        Socre_text = findViewById(R.id.score);
        textlevel = findViewById(R.id.textlevel);
        job_text = findViewById(R.id.textjob);
        text_saying = findViewById(R.id.text_saying);
        ////////////讀取儲存變數///////////////////
        SharedPreferences settings = getSharedPreferences("myPre", 0);
        final SharedPreferences.Editor editor = settings.edit();
        score = settings.getInt("score", score);
        score_rate = settings.getInt("score_rate", score_rate);
        level = settings.getInt("level", level);
        exp = settings.getInt("exp", exp);
        job = settings.getString("job", job);
        levelpoint = settings.getInt("levelpoint",levelpoint);
        exaggerate = settings.getInt("exaggerate",exaggerate);
        blame = settings.getInt("blame",blame);
        charm = settings.getInt("charm",charm);
        fadamoney = settings.getInt("fadamoney",fadamoney);
        sec = settings.getInt("sec",sec);
        //////////初始設定//////////////////////
        textlevel.setText("等級: " + Integer.toString(level));
        update(score);
        job_text.setText(job);
        ////////////開始計時的線呈///////////////
        new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 1;
                stop = 0;
                while (a > 0) {
                    try {
                        Thread.sleep(sec);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    score = score + score_rate;
                    exp = exp + score_rate;
                    time++;
                    editor.putInt("score", score).commit();
                    editor.putInt("exp", exp).commit();
                    editor.putInt("score_rate", score_rate).commit();
                    editor.putInt("level",level).commit();
                    editor.putInt("levelpoint",levelpoint).commit();
                    editor.putInt("exaggerate",exaggerate).commit();
                    editor.putInt("blame",blame).commit();
                    editor.putInt("charm",charm).commit();
                    editor.putInt("fadamoney",fadamoney);
                    editor.putInt("sec",sec);
                    Log.v("test", "count is:" + score);
                    //////////////需要去改變mainActivity時要用handler//////////////
                    handler.post(new Runnable() {
                        public void run() {
                            update(score);
                            //////////動作更新///////////////////
                            if (stop == 0) {
                                if (time % 2 == 0) {
                                    updateMove(1);
                                } else {
                                    updateMove(2);
                                }
                                text_saying.setVisibility(View.INVISIBLE);
                            } else {
                                image.setImageResource(R.drawable.hanzon3);
                                text_saying.setVisibility(View.VISIBLE);
                                stop = 0;
                            }

                            ///////////判斷升等////////////////
                            Log.v("asd",Integer.toString(level));
                            switch (level) {
                                case 1:
                                    if (exp > 1000) {
                                        level = 2;
                                        levelpoint +=1;
                                        textlevel.setText("等級: " + Integer.toString(level));
                                        job = "職位: 北農總經理";
                                        job_text.setText(job);
                                    } else {
                                        editor.putInt("score",score).commit();
                                        editor.putInt("score_rate",score_rate).commit();
                                        editor.putInt("exp",exp).commit();
                                        editor.putInt("level", level).commit();
                                        editor.putString("job", job).commit();
                                        editor.putInt("levelpoint",levelpoint).commit();
                                        editor.putInt("fadamoney",fadamoney).commit();
                                        editor.putInt("sec",sec).commit();

                                    } break; ///被罷免後要存檔//
                                case 2:
                                    if (exp > 2000) {
                                        level = 3;
                                        levelpoint +=1;
                                        editor.putInt("level", level).commit();
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }break;
                                case 3:
                                    if (exp > 3000) {
                                        level = 4;
                                        levelpoint +=1;
                                        editor.putInt("level", level).commit();
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }break;
                                case 4:
                                    if (exp > 4000) {
                                        level = 5;
                                        levelpoint +=1;
                                        editor.putInt("level", level).commit();
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }
                                case 5:
                                    if (exp > 5000) {
                                        level = 6;
                                        levelpoint +=1;
                                        editor.putInt("level", level).commit();
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }break;
                            }
                        }
                    });
                }
            }
        }).start();

    }

    /////////////////以上是mainActivity/////////////////////////////
    public void update(int i) {
        Socre_text.setText("聲勢 : " + Integer.toString(i)+"    +"+Integer.toString(score_rate)+"/秒");
    }

    public void updateMove(int i) {
        if (i == 1) {
            image.setImageResource(R.drawable.hanzon);
        } else {
            image.setImageResource(R.drawable.hanzon2);
        }
    }

}
