package com.example.neelansh.firebasedatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button button;
ListView listView;
List<model> data;
EditText editText;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
button=findViewById(R.id.button);
editText=findViewById(R.id.editext);
listView=findViewById(R.id.list);
data=new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
myRef=database.getReference("user");
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       String uidf=myRef.push().getKey();
       myRef.child(uidf).setValue(new model(uidf,editText.getText().toString(),"25","a+","good"));

        /* myRef.push().setValue(editText.getText().toString());
        Toast.makeText(MainActivity.this,"User added",Toast.LENGTH_SHORT).show();*/


    }
});

myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot df:dataSnapshot.getChildren()){
            data.add(df.getValue(model.class));
            //data.add(df.getValue(model.class));
        }
      List<String > f=new ArrayList<>();
        for (model a:data){
            f.add(a.name+"|"+a.age+"|"+a.healthstatus);

        }


            ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_checked,data);
        listView.setAdapter(adapter);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
     // Write a message to the database


    }


}
