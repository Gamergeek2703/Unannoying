package com.unannoying.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsContact extends AppCompatActivity {

    TextView cancel, done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_contact);

        cancel = findViewById(R.id.cancel);

        done = findViewById(R.id.done);

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(SettingsContact.this, SettingsFragment.class);
                startActivity(intent);

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(SettingsContact.this, SettingsFragment.class);
                startActivity(intent);

            }
        });
    }
}