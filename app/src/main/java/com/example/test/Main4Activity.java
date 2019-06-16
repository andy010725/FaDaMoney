package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    TextView text1say;
    TextView title_view;
    public static final String EXTRA_REPLY =
            "com.example.android.extra.third";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        text1say = findViewById(R.id.text1say);
        title_view = findViewById(R.id.texttitle);

        }


    public void backtomain(View view) {
        Intent replyIntent = new Intent();
        String reply = "成功";
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}
