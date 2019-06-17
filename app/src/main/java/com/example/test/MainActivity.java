package com.example.test;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android";
    public static final String EXTRA_SCORE =
            "com.example.android_score";
    public static final int TEXT_REQUEST = 1;
    private Long startTime;
    private Handler handler = new Handler();
    public int score = 0;
    public int score_from_2 = 0;
    public int exp = 0;
    public int time = 0;
    public int score_rate = 1; // 跳錢的倍率
    public int level = 1;
    public int levelpoint = 0;
    public int fadamoney = 100;
    public int sec = 1000;
    int background=1;
    public String job = "職位: 無業";
    TextView Socre_text;
    TextView job_text;
    TextView text_saying;
    TextView score_persec;
    ImageView image;
    ImageView suport1;
    ImageView suport2;
    ImageView suport3;
    ImageView suport4;
    ImageView littleback1;
    ImageView littleback2;
    ImageView littleback3;
    ImageView littleback4;
    ImageView littleback5;
    ImageView littleback6;
    TextView textlevel;
    TextView special;
    TextView background_view;
    TextView exp_view;
    ProgressBar maxexp_view;
    ///////能力值變數///////////////
    public int exaggerate = 1;
    public int blame = 1;
    public int charm = 1;
    ///////站台變數//////////////////
    public int binbin = 0;
    public int inwen = 0;
    public int gwochun = 0;
    public int gwenchun = 0;
    //////////////////////////////////////
    public int LL = 0;
    public int TW = 0;
    public int CH = 0;
    public int road = 0;
    public int Inf = 0;
    public int cute = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        Socre_text = findViewById(R.id.score);
        textlevel = findViewById(R.id.textlevel);
        job_text = findViewById(R.id.textjob);
        text_saying = findViewById(R.id.text_saying);
        score_persec = findViewById(R.id.score_persec);
        suport1 = findViewById(R.id.suport1);
        suport2 = findViewById(R.id.suport2);
        suport3 = findViewById(R.id.suport3);
        suport4 = findViewById(R.id.suport4);
        special = findViewById(R.id.special);
        littleback1 = findViewById(R.id.imageView11);
        littleback2 = findViewById(R.id.imageView12);
        littleback3 = findViewById(R.id.imageView13);
        littleback4 = findViewById(R.id.imageView14);
        littleback5 = findViewById(R.id.imageView15);
        littleback6 = findViewById(R.id.imageView18);
        exp_view =findViewById(R.id.textView16);
        background_view = findViewById(R.id.background_mid);
        maxexp_view = findViewById(R.id.progressBar2);
        ////////////讀取儲存變數///////////////////
        SharedPreferences settings = getSharedPreferences("myPre", 0);
        final SharedPreferences.Editor editor = settings.edit();
        loading(settings);
        //////////初始設定//////////////////////
        textlevel.setText("等級: " + Integer.toString(level));
        if (level==10){
            textlevel.setText("等級: MAX");
        }
        update(score);
        job_text.setText(job);
        ////經驗///
        maxexp_view.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        maxexp_view.setMax(1000);
        switch (level){
            case 2 :
                maxexp_view.setMin(1000);
                maxexp_view.setMax(10000);
                break;
            case 3 :
                maxexp_view.setMin(10000);
                maxexp_view.setMax(60000);
                break;
            case 4 :
                maxexp_view.setMin(60000);
                maxexp_view.setMax(600000);
                break;
            case 5 :
                maxexp_view.setMin(60000);
                maxexp_view.setMax(600000);
                break;
            case 6 :
                maxexp_view.setMin(3000000);
                maxexp_view.setMax(8000000);
                break;
            case 7 :
                maxexp_view.setMin(8000000);
                maxexp_view.setMax(20000000);
                break;
            case 8 :
                maxexp_view.setMin(20000000);
                maxexp_view.setMax(40000000);
                break;
            case 9 :
                maxexp_view.setMin(40000000);
                maxexp_view.setMax(70000000);
                break;
        }
        //站台部分///
        if (binbin == 1) {
            suport1.setVisibility(View.VISIBLE);
        }
        if (inwen == 1) {
            suport2.setVisibility(View.VISIBLE);
        }
        if (gwochun == 1) {
            suport3.setVisibility(View.VISIBLE);
        }
        if (gwenchun == 1) {
            suport4.setVisibility(View.VISIBLE);
        }
        if (LL == 1) {
            setlittleBack(1);
        }
        if (TW == 1) {
            setlittleBack(2);
        }
        if (CH == 1) {
            setlittleBack(3);
        }
        if (road == 1) {
            setlittleBack(4);
        }
        if (Inf == 1) {
            setlittleBack(5);
        }
        if (cute == 1) {
            setlittleBack(6);
        }
        setBack(background);
        ////////////開始計時的線呈///////////////
        new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 1;
                while (a > 0) {
                    try {
                        Thread.sleep(sec);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    score = score + score_rate;
                    exp = exp + score_rate;
                    time++;
                    saveing(editor); ///////////存檔//////////////
                    Log.v("test", "count is:" + score);
                    //////////////需要去改變mainActivity時要用handler//////////////
                    handler.post(new Runnable() {
                        public void run() {
                            update(score);
                            //////////動作更新///////////////////
                            if (time % 2 == 0) {
                                updateMove(1);
                            } else {
                                updateMove(2);
                            }
                            text_saying.setVisibility(View.INVISIBLE);
                            special.setVisibility(View.INVISIBLE);

                            maxexp_view.setProgress(exp);
                            ///////////判斷升等////////////////
                            Log.v("level", Integer.toString(level));
                            Log.v("bin",Integer.toString(binbin));
                            switch (level) {
                                case 1:
                                    if (exp > 1000) {
                                        level = 2;
                                        levelpoint += 1;
                                        textlevel.setText("等級: " + Integer.toString(level));
                                        maxexp_view.setMin(1000);
                                        maxexp_view.setMax(10000);
                                        //maxexp_view.setText("升等所需經驗: "+ "10000");
                                        job = "職位: 北農總經理";
                                        job_text.setText(job);
                                        lunchSecondAct(1);
                                        hanalert(1);
                                    }
                                    break;
                                case 2:
                                    if (exp > 10000) {
                                        level = 3;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(10000);
                                        maxexp_view.setMax(60000);
                                        //maxexp_view.setText("升等所需經驗: "+ "60000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }
                                    break;
                                case 3:
                                    if (exp > 60000) {
                                        level = 4;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(60000);
                                        maxexp_view.setMax(600000);
                                        //maxexp_view.setText("升等所需經驗: "+ "600000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                        lunchSecondAct(2);
                                    }
                                    break;
                                case 4:
                                    if (exp > 600000) {
                                        level = 5;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(600000);
                                        maxexp_view.setMax(3000000);
                                        //maxexp_view.setText("升等所需經驗: "+ "3000000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                        lunchSecondAct(3);
                                    }
                                case 5:
                                    if (exp > 3000000) {
                                        level = 6;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(3000000);
                                        maxexp_view.setMax(8000000);
                                        //maxexp_view.setText("升等所需經驗: "+ "8000000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }
                                    break;
                                case 6:
                                    if (exp > 8000000) {
                                        level = 7;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(8000000);
                                        maxexp_view.setMax(20000000);
                                        //maxexp_view.setText("升等所需經驗: "+ "20000000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                        lunchSecondAct(0);
                                    }
                                    break;
                                case 7:
                                    if (exp > 20000000) {
                                        level = 8;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(20000000);
                                        maxexp_view.setMax(40000000);
                                        //maxexp_view.setText("升等所需經驗: "+ "50000000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                        lunchSecondAct(4);
                                    }
                                    break;
                                case 8:
                                    if (exp > 40000000) {
                                        level = 9;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        maxexp_view.setMin(40000000);
                                        maxexp_view.setMax(70000000);
                                        //maxexp_view.setText("升等所需經驗: "+ "150000000");
                                        textlevel.setText("等級: " + Integer.toString(level));
                                    }
                                    break;
                                case 9:
                                    if (exp > 70000000) {
                                        level = 10;
                                        levelpoint += 1;
                                        editor.putInt("level", level).commit();
                                        //maxexp_view.setText("MAX");
                                        textlevel.setText("等級: MAX");
                                    }
                                    break;
                            }
                        }
                    });
                }
            }
        }).start();

    }

    /////////////////以上是mainActivity/////////////////////////////
    public void update(int i) {
        Socre_text.setText("聲望 : " + Integer.toString(i));
        score_persec.setText("+"+Integer.toString(score_rate) + "/單位時間");
        //exp_view.setText("經驗值"+Integer.toString(exp));
    }

    public void updateMove(int i) {
        if (i == 1) {
            ///國瑜///
            image.setImageResource(R.drawable.hanzon);
            ///冰冰///
            suport1.setImageResource(R.drawable.whitecold);
            ///英文///
            suport2.setImageResource(R.drawable.inwen);
            ///國昌///
            suport3.setImageResource(R.drawable.aban);
        } else {
            ///國瑜///
            image.setImageResource(R.drawable.hanzon2);
            ///冰冰///
            suport1.setImageResource(R.drawable.whitecold2);
            ///英文///
            suport2.setImageResource(R.drawable.inwen2);
            ///國昌///
            suport3.setImageResource(R.drawable.aban2);
        }
    }
    /////存檔/////
    public void saveing(SharedPreferences.Editor editor){
        editor.putInt("score", score).commit();
        editor.putInt("exp", exp).commit();
        editor.putInt("sec", sec);
        editor.putInt("score_rate", score_rate).commit();
        editor.putInt("level", level).commit();
        editor.putString("job", job).commit();
        editor.putInt("levelpoint", levelpoint).commit();
        editor.putInt("exaggerate", exaggerate).commit();
        editor.putInt("blame", blame).commit();
        editor.putInt("charm", charm).commit();
        editor.putInt("fadamoney", fadamoney);
        editor.putInt("binbin", binbin);
        editor.putInt("inwen",inwen );
        editor.putInt("gwochun",gwochun );
        editor.putInt("gwenchun",gwenchun );
        editor.putInt("LL",LL);
        editor.putInt("TW",TW);
        editor.putInt("CH",CH);
        editor.putInt("Road",road);
        editor.putInt("Inf",Inf);
        editor.putInt("cute",cute);
        editor.putInt("background",background);
    }
    /////讀檔//////
    public void loading(SharedPreferences settings){
        score = settings.getInt("score", score);
        score_rate = settings.getInt("score_rate", score_rate);
        level = settings.getInt("level", level);
        exp = settings.getInt("exp", exp);
        sec = settings.getInt("sec", sec);
        job = settings.getString("job", job);
        levelpoint = settings.getInt("levelpoint", levelpoint);
        fadamoney = settings.getInt("fadamoney", fadamoney);
        /////能力值////////////
        exaggerate = settings.getInt("exaggerate", exaggerate);
        blame = settings.getInt("blame", blame);
        charm = settings.getInt("charm", charm);
        ///////站台/////////////
        binbin = settings.getInt("binbin",binbin );
        inwen= settings.getInt("inwen",inwen );
        gwochun= settings.getInt("gwochun",gwochun );
        gwenchun= settings.getInt("gwenchun",gwenchun );
        ////////道具/////////
        LL = settings.getInt("LL",LL);
        TW = settings.getInt("TW",TW);
        CH = settings.getInt("CH",CH);
        road = settings.getInt("Road",road);
        Inf = settings.getInt("Inf",Inf);
        cute = settings.getInt("cute",cute);
        background = settings.getInt("background ",background);
    }
    /////遭遇事件/////
    public void lunchSecondAct(int i){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(i));
        intent.putExtra(EXTRA_SCORE, score);
        startActivityForResult(intent,TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("result_2", Integer.toString(resultCode));
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {

                score_from_2 = data.getIntExtra(Main2Activity.EXTRA_REPLY, 0);
                score = score+score_from_2;
                if (score_from_2==60000){
                    gwenchun=1;
                    suport4.setVisibility(View.VISIBLE);
                }
                }
                if (score_from_2==-60000){
                    gwenchun=1;
                    suport4.setVisibility(View.VISIBLE);
                }
        }
    }
    ////韓語錄劇情/////
    public void lunchthirdAct(int i){
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(i));
        startActivity(intent);
    }
    ///////破關///////
    public void lunchfinalAct(int i){
        Intent intent = new Intent(this, Main4Activity.class);
        intent.putExtra(EXTRA_MESSAGE, Integer.toString(i));
        startActivity(intent);
    }
    ///////韓語綠通知/////////////////////////////////
    public void hanalert(int i){
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        ////SetTitleAndMessage////
        myAlertBuilder.setTitle("韓語錄");
        myAlertBuilder.setMessage("您獲得新的韓語綠");
        // Add the dialog buttons.
        myAlertBuilder.setPositiveButton("OK", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                    }
                });
        //
        myAlertBuilder.show();
        // Create and show the AlertDialog.
    }
    ///////////////設置背景////////////////////
    public void setBack(int i){
        switch (i){
            case 1:
                background_view.setBackgroundDrawable(getResources().getDrawable(R.drawable.taipei));
                break;
            case 2:
                background_view.setBackgroundDrawable(getResources().getDrawable(R.drawable.kaoshion));
                break;
            case 3:
                background_view.setBackgroundDrawable(getResources().getDrawable(R.drawable.earth));
                break;
                /////////////追加總統府//////////////
            case 4:
                background_view.setBackgroundDrawable(getResources().getDrawable(R.drawable.presidentialoffice));
                break;
                /////////紫禁城////////
            case 5:
                background_view.setBackgroundDrawable(getResources().getDrawable(R.drawable.chinacity));
                break;

        }
    }
    public void setlittleBack(int i) {
        switch (i) {
            case 1:
                littleback1.setVisibility(View.VISIBLE);
                break;
            case 2:
                littleback2.setVisibility(View.VISIBLE);
                break;
            case 3:
                littleback3.setVisibility(View.VISIBLE);
                break;
            case 4:
                littleback4.setVisibility(View.VISIBLE);
                break;
            case 5:
                littleback5.setVisibility(View.VISIBLE);
                break;
            case 6:
                littleback6.setVisibility(View.VISIBLE);
                break;
        }
    }

    ////////////////////////////////
    public void jobalert(int i){
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        ////SetTitleAndMessage////
        switch (i){
            case 0:
                myAlertBuilder.setTitle("恭喜您成為高雄市長");
                myAlertBuilder.setMessage("獲得發大財能力增加1萬");
                break;
            case 1:
                myAlertBuilder.setTitle("恭喜您台灣總統成為");
                myAlertBuilder.setMessage("獲得每秒增加聲望量1萬");
                break;
            case 2:
                myAlertBuilder.setTitle("恭喜您成為中國總書記");
                myAlertBuilder.setMessage("獲得發大財能力增加10萬");
                break;
            case 3:
                myAlertBuilder.setTitle("恭喜您地球領導人成為");
                myAlertBuilder.setMessage("獲得每秒增加聲望量10萬");
                break;
            case 4:
                myAlertBuilder.setTitle("恭喜您銀河系霸主成為");
                myAlertBuilder.setMessage("獲得發大財能力增加100萬");
        }
        // Add the dialog buttons.
        myAlertBuilder.setPositiveButton("OK", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                    }
                });
        //
        myAlertBuilder.show();
        // Create and show the AlertDialog.
    }

}
