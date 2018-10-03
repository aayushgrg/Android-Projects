package com.example.neelansh.loginpage;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
   TextView textView;
Techniques[] techniques;
LinearLayout lp;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    lp=findViewById(R.id.lp);
textView=findViewById(R.id.textView);
    YoYo.with(Techniques.FadeIn).duration(3000).playOn(textView);
YoYo.with(Techniques.Tada).duration(3000).playOn(textView);
Thread th=new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            Intent i=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(i);
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
th.start();
YoYo.with(Techniques.FadeIn).duration(2000).withListener(new Animator.AnimatorListener() {
    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
YoYo.with(Techniques.Hinge).duration(1800).playOn(textView);
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
});



/*
lp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try{
         YoYo.with(techniques[i]).duration(3000).playOn(lp);
         YoYo.with(techniques[i]).duration(3000).playOn(lp);
            Toast.makeText(MainActivity.this,"the name is"+techniques[i].name(),Toast.LENGTH_SHORT).show();
            i++;
        }catch(Exception e) {
            i = 0;
        }
*/



    }
}





































