package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text1say;
    public static final String EXTRA_REPLY =
            "com.example.android.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1say = findViewById(R.id.text1say);
        Intent intent = getIntent();
        ///////////////判斷要做什麼動作的變數///////////////////
        String movement_variable = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);/////////////////*****//////////////////
        /////////////////////////////////////////////////////////
        switch(movement_variable){
            case"1":
                text1say.setText("現在所要進行"+movement_variable);
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
