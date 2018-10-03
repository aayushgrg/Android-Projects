package com.example.neelansh.voicerecorder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
Button play,record,stop,pause;
MediaRecorder mr;
MediaPlayer mediaPlayer;
String output;
String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.N){
    if (checkpermission()){

    }else {
        String[] per={Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO};
        requestPermissions(per,1000);

    }
        }


play=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        record=findViewById(R.id.record);
pause=findViewById(R.id.pause);
    play.setEnabled(false);
    stop.setEnabled(false);
    /* mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mr.setOutputFile(output);
*/
   final File dir= new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/lrecord/");
      if (!dir.exists()) {
          dir.mkdir();
      }
stop.setEnabled(false);
play.setEnabled(false);
        mr= new MediaRecorder();
mediaPlayer=new MediaPlayer();
   record.setOnClickListener(new View.OnClickListener() {

       @Override
       public void onClick(View v) {
            path=dir.getAbsolutePath()+"/"+ UUID.randomUUID()+".mp3";
            recordersetup(path);

           try {
               mr.prepare();
               mr.start();
           } catch (IOException e) {
               e.printStackTrace();
           }


/*record.setEnabled(false);
stop.setEnabled(true);*/
           Toast.makeText(getApplicationContext(),"Recording started",Toast.LENGTH_SHORT).show();


       }
   });
stop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        record.setEnabled(true);
        stop.setEnabled(true);
        play.setEnabled(true);
        if (mr != null){
            mr.stop();
            mr.release();
        }
        if (mediaPlayer!= null) {
        mediaPlayer.stop();
        mediaPlayer.release();
        }
        Toast.makeText(getApplicationContext(),"Audio recorded successfully",Toast.LENGTH_SHORT).show();
        }


    });
    /*play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MediaPlayer md=new MediaPlayer();
            try {
                md.setDataSource(output);
        md.prepare();
        md.start();
        Toast.makeText(getApplicationContext(),"play",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    });
pause.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
*/
    }
 public void recordersetup(String output){

    mr.setAudioSource(MediaRecorder.AudioSource.MIC);
    mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
    mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
    mr.setOutputFile(output);


  }

public boolean checkpermission(){
        boolean is=false;
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
        is=true;
    }
    if (checkSelfPermission(Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_GRANTED){
        is=true;
    }else {is=false;}
}else{

}
    return is;
}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  if(requestCode==1000){
      if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED ){
          Toast.makeText(this,"all permission ARE ACCEPETED ",Toast.LENGTH_SHORT).show();
      }else {
          finish();
      }
  }

    }
}

