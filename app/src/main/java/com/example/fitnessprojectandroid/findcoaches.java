package com.example.fitnessprojectandroid;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class findcoaches extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Coach> datalist;
    FirebaseFirestore db;
    CoachAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findcoaches);

        rv = (RecyclerView) findViewById(R.id.rvid);
        rv.setLayoutManager(new LinearLayoutManager(this));
        datalist = new ArrayList<>();
        adapter = new CoachAdapter(datalist,findcoaches.this);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(findcoaches.this, DividerItemDecoration.VERTICAL));

        db = FirebaseFirestore.getInstance();
        db.collection("coach").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list){
                            Coach obj = d.toObject(Coach.class);
                            datalist.add(obj);
                        }
                        //adapter
                        adapter.notifyDataSetChanged();

                    }
                });



    }
}
