package com.example.fitnessprojectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
    public Button exerciseb1;
    public Button bmib2;
    public Button coachb3;
    public Button dietb4;
    public Button aboutusb5;
    public  Button logout;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        exerciseb1 = (Button) findViewById(R.id.exercisebntid);
        bmib2 = (Button) findViewById(R.id.bmibtnid);
        coachb3 = (Button) findViewById(R.id.Coachbtnid);
        dietb4 = (Button) findViewById(R.id.dietbtnid);
        aboutusb5 = (Button) findViewById(R.id.ABoutbtnid);
        logout = (Button) findViewById(R.id.Logoutidbtn);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {

        }
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        exerciseb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this,ListExercise.class);
                startActivity(i);

            }
        });
        bmib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(HomePage.this,bmi.class);
                startActivity(j);
            }
        });
        coachb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this,findcoaches.class);
                startActivity(i);
            }
        });
        dietb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this,Threebutton.class);
                startActivity(i);
            }
        });
        aboutusb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomePage.this,Aboutus.class);
                startActivity(i);
            }
        });

        if(acct != null){ //sign in with google
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.Logoutidbtn:
                            signOut();
                            break;
                    }
                }
            });
        }else{
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    Intent i = new Intent(HomePage.this,MainActivity.class);
                    startActivity(i);
                }
            });
        }
    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(HomePage.this,"You signed out with Google",Toast.LENGTH_LONG).show();
                        Intent i = new Intent(HomePage.this,MainActivity.class);
                        startActivity(i);
                    }
                });
    }
}
