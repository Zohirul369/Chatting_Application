package com.example.chatting_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GroupChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        getSupportActionBar().hide();
    }
}