package com.example.fitnessprojectandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;



public class My_Adapter extends RecyclerView.Adapter<My_Adapter.MyViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public My_Adapter(Context ct, String e1[], String e2[], int img[]){
        context = ct;
        data1 = e1;
        data2= e2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
        holder.myTxt1.setText(data1[position]);
        holder.myTxt2.setText(data2[position]);
        holder.myImg.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,descriptionActivity.class);
                intent.putExtra("data1",data1[holder.getAdapterPosition()]);
                intent.putExtra("data2",data2[holder.getAdapterPosition()]);
                intent.putExtra("myImage",images[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myTxt1, myTxt2;
        ImageView myImg;
        ConstraintLayout mainLayout;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTxt1 = itemView.findViewById(R.id.myText1);
            myTxt2 = itemView.findViewById(R.id.myText2);
            myImg = itemView.findViewById(R.id.myImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
