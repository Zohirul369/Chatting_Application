package com.example.chatting_application;

import static com.example.chatting_application.R.id.group_chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chatting_application.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {



    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sidemenu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();

            if (item_id==R.id.group_chat){
                Toast.makeText(this, "You click Group Chat", Toast.LENGTH_SHORT).show();
            }

            else if (item_id==R.id.setting){
            Toast.makeText(this, "You click setting", Toast.LENGTH_SHORT).show();
            }

            else if (item_id==R.id.logout){
                Toast.makeText(this, "You click Logout", Toast.LENGTH_SHORT).show();
            }

        return true;
    }

}