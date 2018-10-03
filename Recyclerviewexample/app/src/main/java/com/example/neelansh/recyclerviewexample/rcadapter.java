package com.example.neelansh.recyclerviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class rcadapter extends RecyclerView.Adapter<rcadapter.Rcholder> {
int[] ImageR;
String[] npR;
Context context;

    rcadapter(Context c,int[] b,String[]a) {
        this.ImageR=b;
        this.context=c;
    this.npR=a;

    }



    @NonNull
    @Override
    public Rcholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view= LayoutInflater.from(context).inflate(R.layout.foodcard,viewGroup,false);
        return new Rcholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rcholder h, int i) {
        h.imageView.setImageResource(ImageR[i]);
String[]  n=npR[i].split(":");
h.fname.setText(n[0]);
    h.fprice.setText(n[1]+"");

    }

    @Override
    public int getItemCount() {
        return ImageR.length;
    }

    class Rcholder extends RecyclerView.ViewHolder{
View card;
ImageView imageView;
TextView fname,fprice;
    public Rcholder(@NonNull View itemView) {
        super(itemView);
        card=itemView.findViewById(R.id.cv);
        imageView=itemView.findViewById(R.id.imageview);
        fname=itemView.findViewById(R.id.fname);
        fprice=itemView.findViewById(R.id.fprice);


    }


}




}
