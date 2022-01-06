package com.example.fitnessprojectandroid;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private Button createAccountBtn;
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mfirebaseDatabase;
    private StorageReference mFirebaseStorage;
    private FirebaseAuth mfirebaseAuth;
    private Button signinbtn;
    private ProgressDialog mProgressDialog;
    private Uri resultUri = null;
    private final static int GALLERY_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccountactivity);



        mProgressDialog = new ProgressDialog(this);
        signinbtn = (Button) findViewById(R.id.signinbtn);
        firstName = (EditText) findViewById(R.id.firstNameAct);
        lastName = (EditText) findViewById(R.id.lastNameAct);
        email = (EditText) findViewById(R.id.emailAct);
        password = (EditText) findViewById(R.id.passwordAct);
        createAccountBtn = (Button) findViewById(R.id.createAccoutAct);

        mfirebaseAuth = FirebaseAuth.getInstance();
        mfirebaseDatabase = FirebaseDatabase.getInstance();

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname = firstName.getText().toString();
                final String lname = lastName.getText().toString();
                final String mail = email.getText().toString();
                final String pwd = password.getText().toString();

                if(fname.isEmpty()){
                    firstName.setError("please provide First name");
                    firstName.requestFocus();
                }else if(lname.isEmpty()){
                    lastName.setError("please provide First name");
                    firstName.requestFocus();
                }else if(mail.isEmpty()){
                  email.setError("please provide email");
                    email.requestFocus();
                }else if(pwd.isEmpty()){
                    password.setError("please provide Password");
                    password.requestFocus();
                }else if(!(mail.isEmpty() && pwd.isEmpty())){
                    mfirebaseAuth.createUserWithEmailAndPassword(mail,pwd)
                            .addOnCompleteListener(CreateAccountActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(CreateAccountActivity.this,"Sign up Unseccussful.please try ag",Toast.LENGTH_SHORT).show();;
                                    }else{

                                                Intent intent = new Intent(CreateAccountActivity.this,HomePage.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                    }
                                }
                            });
                }else {
                    Toast.makeText(CreateAccountActivity.this,"Error Occured",Toast.LENGTH_SHORT).show();
                }
            }
        });

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreateAccountActivity.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });


//        createAccountBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Account Created succussful",Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(CreateAccountActivity.this,MainActivity.class);
//                startActivity(i);
//            }
//        });
    }




    }

