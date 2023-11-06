package com.example.chatting_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chatting_application.Model.User;
import com.example.chatting_application.databinding.ActivitySingUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SingUpActivity extends AppCompatActivity {

    ActivitySingUpBinding binding;
    private FirebaseAuth auth;

    FirebaseDatabase database;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();



        progressDialog = new ProgressDialog(SingUpActivity.this);
        progressDialog.setTitle("Create New Account");
        progressDialog.setMessage("Your Account are Creating");

        binding.singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.userName.getText().toString().isEmpty() && !binding.userEmail.getText().toString().isEmpty() && !binding.userPassword.getText().toString().isEmpty())
                {
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(binding.userEmail.getText().toString(), binding.userPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if(task.isSuccessful()){
                                User users = new User(binding.userName.getText().toString(), binding.userEmail.getText().toString(), binding.userPassword.getText().toString());
                                Toast.makeText(SingUpActivity.this, "SingUp Successful", Toast.LENGTH_SHORT).show();

                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("User").child(id).setValue(users);

                            }
                            else {
                                Toast.makeText(SingUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(SingUpActivity.this, "Fillup valid information", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUpActivity.this, SingInActivity.class);
                startActivity(intent);
            }
        });
    }
}