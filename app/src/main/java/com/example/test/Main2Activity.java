package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text1say;
    TextView title;
    ImageView image;
    Button button1;
    Button button2;
    public static final String EXTRA_REPLY =
            "com.example.android.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1say = findViewById(R.id.text1say);
        title = findViewById(R.id.texttitle);
        image = findViewById(R.id.imageView10);
        button1 = findViewById(R.id.choose1);
        button2 = findViewById(R.id.choose2);
        Intent intent = getIntent();
        ///////////////判斷要做什麼動作的變數///////////////////
        String movement_variable = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);/////////////////*****//////////////////
        /////////////////////////////////////////////////////////
        switch(movement_variable){
            case"0":
                title.setText("新聞媒體抹黑");
                text1say.setText("過去曾是流氓\n在議會裡動粗\n還花天酒地\n對這樣的不實指控\n你怎麼回應?");
                image.setImageResource(R.drawable.bannon);
                button1.setText("欺騙大眾說沒有");
                button2.setText("承認過錯");
                break;
            case"1":
                title.setText(R.string.title_encounter1);
                text1say.setText(R.string.encounter1);
                image.setImageResource(R.drawable.bannon);
                button1.setText("促使菜價上升");
                button2.setText("促使菜價下跌");
                break;
            case"2":
                title.setText(R.string.title_encounter2);
                text1say.setText(R.string.encounter2);
                image.setImageResource(R.drawable.chiagi);
                button1.setText("不予理會");
                button2.setText("打他，像當初打阿扁一樣");
                break;
            case"3":
                title.setText(R.string.title_encounter3);
                text1say.setText(R.string.encounter3);
                image.setImageResource(R.drawable.gwenchuan);
                button1.setText("反悔，說自己可能不會做滿");
                button2.setText("堅持謊言");
                break;
        }
    }

    public void backtomain(View view) {
        Intent replyIntent = new Intent();
        String reply = "成功";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
