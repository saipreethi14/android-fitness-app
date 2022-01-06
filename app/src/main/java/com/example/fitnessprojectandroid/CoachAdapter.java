package com.example.fitnessprojectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.lang.System.load;

public class CoachAdapter  extends RecyclerView.Adapter<CoachAdapter.myviewholder> {
    ArrayList<Coach> datalist;
    private Context mcontext;

    public CoachAdapter(ArrayList<Coach> datalist, Context mcontext) {
        this.datalist = datalist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coachrow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
    Picasso.with(mcontext).load(datalist.get(position).getImage()).fit().centerCrop().into(holder.img);
    holder.name.setText(datalist.get(position).getName());
        holder.age.setText(datalist.get(position).getAge());
        holder.proficient.setText(datalist.get(position).getProficient());
        holder.mailid.setText(datalist.get(position).getEmailID());

    }


    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
            ImageView img;
            TextView age,name,proficient,mailid;

            public myviewholder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.imageid);
                name = itemView.findViewById(R.id.nameid);
                age = itemView.findViewById(R.id.ageid);
                proficient = itemView.findViewById(R.id.proficientid);
                mailid = itemView.findViewById(R.id.mailid);
            }
        }
}
