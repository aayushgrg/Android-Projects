package com.example.neelansh.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button pre,next;
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* pre = findViewById(R.id.pre);
        next = findViewById(R.id.next);*/
        viewPager=findViewById(R.id.viewpager);

pager p=new pager(getSupportFragmentManager());
p.addfragment(first.getInstance());
p.addfragment(second.newInstance());

        viewPager.setAdapter(p);

















/*

        final FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        pre.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
             Fragment sec=first.getInstance();
             ft.replace(R.id.frame,sec);
             ft.commit();

         }
     });

        next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            Fragment see=second.newInstance();
            ft.replace(R.id.frame,see);
            ft.commit();
        }
    });
*/



    }
    }
