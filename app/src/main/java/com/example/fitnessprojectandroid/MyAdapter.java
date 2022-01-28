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

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[],data2[];
  int images[];
  Context context;

    public MyAdapter(Context ct, String[] s1, String[] s2, int[] imag){
     context = ct;
     data1 = s1;
     data2 = s2;
     images = imag;

    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
         View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) { // put data
        holder.myText1.setText(data1[position]); //data1[0] name
        holder.myText2.setText(data2[position]); //data2[0] description
        holder.myImage.setImageResource(images[position]); //images[0] image
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Fooddescription.class);
                intent.putExtra("data1",data1[holder.getAdapterPosition()]);
                intent.putExtra("data2",data2[holder.getAdapterPosition()]);
                intent.putExtra("myImage",images[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
//hello
        return images.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1,myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.myText1);
            myText2 = itemView.findViewById(R.id.myText2);
            myImage = itemView.findViewById(R.id.myImageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
