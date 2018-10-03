package com.example.neelansh.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button button;
Button button2;
TextView textView;
int table=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 button=findViewById(R.id.button);
 textView=findViewById(R.id.textView);
button2=findViewById(R.id.button2);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
     textView.setText(null);
            for (int i = 1; i <= 10; i++) {

                textView.append( "\n"+table+" x " +i+"="+ i*table);

            }
            table--;
        }});

    button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
textView.setText(null);
                    for (int y = 1; y <= 10; y++) {
                        textView.append("\n"+ table + " x "+ y+"=" + y * table);

                    }
                    table++;
                }

    });


        }}


