package com.unannoying.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.unannoying.app.databinding.ActivityLoginBinding;

/**
 * Created by amutha_c on 30,July,2023
 */
public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding = null;

    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       binding.loginBtn.setOnClickListener(view -> {
           Intent intent = new Intent(LoginActivity.this, MainActivity.class);
           startActivity(intent);
       });

       binding.register.setOnClickListener(view -> {
           Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
           startActivity(intent);
       });

    }
}
