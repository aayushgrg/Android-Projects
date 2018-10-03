package com.example.neelansh.drumpad;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
String TAG="MainActivity";
Button one,two,three,four,five,six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


   one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
one.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        playmusic(v);
    }
});
two.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        playmusic(v);
    }
});
three.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        playmusic(v);
    }
});
four.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        playmusic(v);
    }
});
five.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        playmusic(v);
    }
});

six.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        playmusic(v);
    }
});


    }
    public void playmusic(View view){

        int id=view.getId();
        Log.d(TAG,"playmusic:nameId"+id);
        String nameId=view.getResources().getResourceEntryName(id);
        Log.d(TAG,"playmusic: nameId"+nameId);
        int musicid=getResources().getIdentifier(nameId,"raw","com.example.neelansh.drumpad");
        MediaPlayer md=MediaPlayer.create(this,musicid);
        md.start();

    }



    

}


