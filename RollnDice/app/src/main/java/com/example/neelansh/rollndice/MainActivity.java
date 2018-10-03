package com.example.neelansh.rollndice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button button;
TextView textView;
ImageView imageView;
    final Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    textView=findViewById(R.id.textView);
    button=findViewById(R.id.button);
    imageView=findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int str=random.nextInt((6)+1);
                switch (str){
                    case 1:
                        imageView.setImageResource(R.drawable.img1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.img2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.img3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.img4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.img5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.img6);
                        break;


                }

            }
        });



    }
}
