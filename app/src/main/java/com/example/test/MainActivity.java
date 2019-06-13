package com.example.test;

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
    public int score2 = 0;
    public int stop = 0;
    TextView mSocre;
    ImageView image;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        mSocre = findViewById(R.id.score);

        SharedPreferences settings = getSharedPreferences("myPre", 0);
        final SharedPreferences.Editor editor = settings.edit();

        score = settings.getInt("score",score);



        new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 1;
                stop = 0;
                while (a > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    score++;
                    score2++;
                    editor.putInt("score",score).commit();
                    Log.v("test", "count is:" + score);
                    handler.post(new Runnable() {
                        public void run() {
                            update(score);
                            if (stop == 0) {
                                if (score2 % 2 == 0) {
                                    updateMove(1);
                                } else {
                                    updateMove(2);
                                }
                            }
                            else {
                                image.setImageResource(R.drawable.fadamoney);
                                stop=0;
                            }
                        }
                    });
                }
            }
        }).start();




    }
    /////////////////以上是mainActivity/////////////////////////////
    public void update(int i) {
        mSocre.setText("聲勢 : "+Integer.toString(i));
    }
    public void updateMove(int i) {
        if (i==1){
            image.setImageResource(R.drawable.bird);
        }
        else {
            image.setImageResource(R.drawable.bird2);
        }
    }
    public void FaDaMoney(View view) {

        score = score +1000;
        stop = 1;
    }

}
