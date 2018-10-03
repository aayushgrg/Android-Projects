package com.example.neelansh.recyclerviewexample;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
Toolbar t1;
int [] image={R.drawable.cheeserolls,
              R.drawable.blueberrycakes,
              R.drawable.chocoroll,
        R.drawable.coffeebread,
        R.drawable.heartcookie,
        R.drawable.rasberrytoast,
        R.drawable.strawberrybun,
        R.drawable.whitechocopastry,
        R.drawable.starmuffin,
        R.drawable.chocospiral,
        R.drawable.pizza,
        R.drawable.sushi,
        R.drawable.springrolls,
        R.drawable.creampuffs,
        R.drawable.burger,};
String[]sp={"cheeseroll: $70","blueberrycakes: $130",
        "chocoroll: $70","coffeebread: $180",
        "heartcookie: $50","rasberrytoast: $110",
        "strawberrybun: $90","whitechocopastry: $210",
        "starmuffin: $70","chocospiral: $90",
        "pizza: $120","sushi: $30",
        "springrolls: $70","creampuffs: $140",
        "burger: $50",};
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   recyclerView=findViewById(R.id.rv);


   recyclerView.setLayoutManager(new GridLayoutManager(this,2));

   recyclerView.setAdapter(new rcadapter(MainActivity.this,image,sp));
    }


}
