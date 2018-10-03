package com.example.neelansh.loginpage;



import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.neelansh.loginpage.R;

public class Main2Activity extends AppCompatActivity {
String[] data={"aayush","parul","garg","khandelwal","Shagun","kakkar"};
ListView listView;

    
    
    
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
listView=findViewById(R.id.listview);


//adapter
         ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_gallery_item,data);
       
       //settiing for set adapteer
         listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this,""+data[position],Toast.LENGTH_SHORT).show();
            }
        });
         
         
          }
}
