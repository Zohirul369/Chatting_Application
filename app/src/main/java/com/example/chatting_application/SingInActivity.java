package com.example.chatting_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chatting_application.databinding.ActivitySingInBinding;
import com.example.chatting_application.databinding.ActivitySingUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SingInActivity extends AppCompatActivity {

    ActivitySingInBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(SingInActivity.this);
        progressDialog.setTitle("Login ");
        progressDialog.setMessage("Login to your Account");

        binding.singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.userEmail.getText().toString().isEmpty() && !binding.userPassword.getText().toString().isEmpty())
                {
                    progressDialog.show();
                    auth.signInWithEmailAndPassword(binding.userEmail.getText().toString(), binding.userPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(SingInActivity.this,MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(SingInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                }
                else{
                    Toast.makeText(SingInActivity.this, "Fillup valid information", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.clickSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingInActivity.this, SingUpActivity.class);
                startActivity(intent);
            }
        });
        if (auth.getCurrentUser()!=null){
            Intent intent = new Intent(SingInActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
}