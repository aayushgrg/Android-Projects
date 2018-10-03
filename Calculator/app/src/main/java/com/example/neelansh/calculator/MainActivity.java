package com.example.neelansh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
double first,second, result;
boolean addition=false,subtract=false,multiplication=false,division=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt9=findViewById(R.id.bt9);
        Button bt8=findViewById(R.id.bt8);
        Button bt7=findViewById(R.id.bt7);
        Button bt6=findViewById(R.id.bt6);
        Button bt5=findViewById(R.id.bt5);
        Button bt4=findViewById(R.id.bt4);
        Button bt3=findViewById(R.id.bt3);
        Button bt2=findViewById(R.id.bt2);
        Button bt1=findViewById(R.id.bt1);
        Button bt0=findViewById(R.id.bt0);
        Button btdot=findViewById(R.id.btdot);
        Button btequal=findViewById(R.id.btequal);
        Button btdel=findViewById(R.id.btdel);
        Button btsub=findViewById(R.id.btsub);
        Button btadd=findViewById(R.id.btadd);
        Button btmulti=findViewById(R.id.btmulti);
        Button btdiv=findViewById(R.id.btdiv);
        final TextView textView=findViewById(R.id.textview);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
textView.append("0");

            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
textView.append("1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
textView.append("2");
            }
        });
    bt3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("3");
        }
    });
    bt4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("4");
        }
    });

    bt5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("5");
        }
    });
    bt6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("6");
        }
    });
    bt7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("7");
        }
    });

    bt8.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("8");
        }
    });

    bt9.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
textView.append("9");
        }
    });

     btadd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         try {
             first=Double.valueOf(textView.getText().toString());
         textView.setText(null);
             addition=true;
             subtract=false;
             multiplication=false;
             division=false;

         }catch (Exception r){}
         }
     });

     btdel.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             try{
                 String get=textView.getText().toString();

textView.setText(get.substring(0,get.length()-1));}
catch (Exception e){

}
         }
     });

     btdiv.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             try {
                 first = Double.valueOf(textView.getText().toString());
                 textView.setText(null);
                 addition = false;
                 subtract = false;
                 multiplication = false;
                 division = true;
             }catch (Exception e){}
         }
     });

     btdot.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
textView.append(".");
         }
     });

     btequal.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
         try{
             second = Double.valueOf(textView.getText().toString());


                 if (addition) {

                     result = first + second;
                     textView.setText("" + result);
                 } else if (subtract) {
                     result = first - second;
                     textView.setText("" + result);
                 } else if (multiplication) {
                     result = first * second;
                     textView.setText("" + result);
                 } else if (division) {
                     result = first / second;
                     textView.setText("" + result);
                 }}
                 catch (Exception e){}

         }});
     btmulti.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             try {
                 first = Double.valueOf(textView.getText().toString());

                 textView.setText(null);
                 addition = false;
                 subtract = false;
                 multiplication = true;
                 division = false;

             }catch (Exception r){}        }
     });

     btsub.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             try {
                 first = Double.valueOf(textView.getText().toString());
                 textView.setText(null);
                 addition = false;
                 subtract = true;
                 multiplication = false;
                 division = false;
             }catch (Exception e){}
         }
     });

     btdel.setOnLongClickListener(new View.OnLongClickListener() {
         @Override
         public boolean onLongClick(View v) {
         textView.setText(null);
             return true;

         }
     });






    }
}
