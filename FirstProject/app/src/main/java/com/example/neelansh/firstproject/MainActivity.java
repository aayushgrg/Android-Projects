package com.example.neelansh.firstproject;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button bt;
TextView tv;

String arr[]={"Ayush","Rohan","shagun","neelansh","INSANE"};

int i=0;
    final Random random=new Random();

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

bt=findViewById(R.id.Tap);
tv=findViewById(R.id.tv);


       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tv.setText(arr[random.nextInt(5)]);
          bt.setBackgroundColor(getResources().getColor(R.color.colorAccent));


           }
       });




    }



}
