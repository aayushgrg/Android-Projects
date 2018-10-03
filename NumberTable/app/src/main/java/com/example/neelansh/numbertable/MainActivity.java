package com.example.neelansh.numbertable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
Button button;
TextView textView;
EditText editText;
Button button2;
int y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
button=findViewById(R.id.button);
textView=findViewById(R.id.textView);
editText=findViewById(R.id.editText);
button2=findViewById(R.id.button2);

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String input=editText.getText().toString();
        y=Integer.parseInt(input);
        for (int i = 1; i <= 10; i++) {


            textView.append( "\n"+y+" x " +i+"="+ y*i);
button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        textView.setText(null);


    }
});

        }
}

});

    }}

