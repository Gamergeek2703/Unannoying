package com.unannoying.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.unannoying.app.databinding.ActivityLoginBinding;
import com.unannoying.app.databinding.ActivityRegisterBinding;

/**
 * Created by amutha_c on 30,July,2023
 */
public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.login.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });


    }
}
