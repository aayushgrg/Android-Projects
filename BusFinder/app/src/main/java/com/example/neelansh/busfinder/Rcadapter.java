package com.example.neelansh.busfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Rcadapter extends RecyclerView.Adapter<Rcadapter.RcViewholder>{
List<String> datal;
Context context;

Rcadapter(List<String>data, Context con){
    datal=new ArrayList<>();
    datal=data;
    context=con;

}
    @NonNull
    @Override
    public Rcadapter.RcViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view= LayoutInflater.from(context).inflate(R.layout.recycler,viewGroup,false);

    return new RcViewholder(view);


}

    @Override
    public void onBindViewHolder(@NonNull RcViewholder hc, int i) {
        String[] singledata=datal.get(i).split(":");
        hc.name.setText(singledata[0]);
        if(singledata[1].equalsIgnoreCase("L")){
            hc.type.setText("Low floor");
            hc.im.setText("L");
        }else
        {
            hc.type.setText("Mini Bus");
            hc.im.setText("M");
        }

    }




    @Override
    public int getItemCount() {
        return datal.size();
    }



    public class RcViewholder extends RecyclerView.ViewHolder {
TextView type,name,im;
        public RcViewholder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.name);
            type=itemView.findViewById(R.id.type);
            im=itemView.findViewById(R.id.im);
        }
    }
}
