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

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;
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

        googlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomePage.class));
                finish();
            }
        });
        mAuthListener = firebaseAuth -> {

            FirebaseUser mUsers = firebaseAuth.getCurrentUser();

            if (mUser != null) {
                Toast.makeText(MainActivity.this, "Signed In", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, HomePage.class));
                finish();
            } else {
                Toast.makeText(MainActivity.this, "Not Signed In", Toast.LENGTH_LONG).show();
            }


        };
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(mAuthListener);

        createActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
                finish();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(emailField.getText().toString())
                        && !TextUtils.isEmpty(passwordField.getText().toString())) {

                    String email = emailField.getText().toString();
                    String pwd = passwordField.getText().toString();

                    login(email, pwd);


                } else {

                }
            }
        });


    }

    private void openAtivity2() {
        Intent intent = new Intent(this,DietPage.class);
        startActivity(intent);
    }

    private void login(String email, String pwd) {

        mAuth.signInWithEmailAndPassword(email, pwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //Yay!! We're in!
                            Toast.makeText(MainActivity.this, "Signed in", Toast.LENGTH_LONG)
                                    .show();

                            startActivity(new Intent(MainActivity.this, HomePage.class));
                            finish();
                        } else {
                            // Not it!
                        }

                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.action_signout) {

            mAuth.signOut();

        }

        return super.onOptionsItemSelected(item);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }
}
