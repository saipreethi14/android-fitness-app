package com.example.fitnessprojectandroid;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mfirebaseAuth;
    private FirebaseDatabase mfirebasedatabase;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;
    private Button loginButton;
    private Button createActButton;
    private EditText emailField;
    private EditText passwordField;
    private Button googlebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        loginButton = (Button) findViewById(R.id.loginbuttonEt);
        createActButton = (Button) findViewById(R.id.loginCreateAccount);
        emailField = (EditText) findViewById(R.id.loginEmaiEt);
        passwordField = (EditText) findViewById(R.id.loginPasswordEt);
        googlebutton = (Button) findViewById(R.id.googlebuttonid);

        mfirebaseAuth = FirebaseAuth.getInstance();
        mfirebasedatabase = FirebaseDatabase.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseuser = mfirebaseAuth.getCurrentUser();
                if(firebaseuser!= null){
                    startActivity(new Intent(MainActivity.this, HomePage.class));
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email = emailField.getText().toString();
                 String pwd = passwordField.getText().toString();

                if(email.isEmpty()){
                    emailField.setError("please provide email");
                    emailField.requestFocus();
                }else if(pwd.isEmpty()){
                    passwordField.setError("please provide Password");
                    passwordField.requestFocus();
                }else if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"fields are empty",
                            Toast.LENGTH_LONG).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mfirebaseAuth.signInWithEmailAndPassword(email,pwd)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(MainActivity.this,"LOgin Error,Palse Login In",Toast.LENGTH_LONG).show();
                                    }else{
                                        Intent in = new Intent(MainActivity.this,HomePage.class);
                                        startActivity(in);
                                    }
                                }
                            });
                }else{
                    Toast.makeText(MainActivity.this,"Error Occured !",Toast.LENGTH_LONG).show();

                }
            }
        });
        createActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
                finish();
            }
        });


    }
    @Override
    protected void onStart(){
        super.onStart();
        mfirebaseAuth.addAuthStateListener(mAuthListener);
    }

    private void moveToHomeActivity(FirebaseUser firebaseuser) {
        mfirebasedatabase.getReference().child(firebaseuser.getUid()).addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}
