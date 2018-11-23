package com.example.daniel.boozerally;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button registerB;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        registerB = (Button) findViewById(R.id.registerButton);
        register = (TextView) findViewById(R.id.back);
        mAuth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
    }

    private void Register()
    {
        if(TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString()))
        {
            Toast.makeText(Register.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                               @Override
                                               public void onComplete(@NonNull Task<AuthResult> task) {
                                                   if(task.isSuccessful())
                                                   {
                                                       Intent log=new Intent(Register.this, Login.class);
                                                       startActivity(log);
                                                   }
                                                   else
                                                   {
                                                       Toast.makeText(Register.this,"Please try again!",Toast.LENGTH_SHORT).show();
                                                   }
                                               }

                                           }
                    );

        }}



}
