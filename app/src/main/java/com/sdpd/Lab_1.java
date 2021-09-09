package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab_1 extends AppCompatActivity {

    private Button next_lab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        getSupportActionBar().setTitle("Lab 1");

        next_lab = findViewById(R.id.lab_2_proceed);
        next_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab_1.this,Lab_2.class);
                startActivity(intent);
            }
        });
    }
}