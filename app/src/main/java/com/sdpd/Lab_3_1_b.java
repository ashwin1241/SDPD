package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Lab_3_1_b extends AppCompatActivity {

    private TextView usrnme;
    private TextView pswrd;
    private ImageView vis;
    private String u = "", p = "";
    private int i = 0;
    private Button next_lab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31b);
        getSupportActionBar().setTitle("Lab 3");
        getSupportActionBar().setHomeButtonEnabled(true);

        u+=getIntent().getStringExtra("username");
        p+=getIntent().getStringExtra("password");

        next_lab = findViewById(R.id.lab_3_2_proceed);
        next_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab_3_1_b.this, Lab_3_2.class);
                startActivity(intent);
            }
        });

        usrnme = findViewById(R.id.usrnme);
        usrnme.setText(u);
        pswrd = findViewById(R.id.pswrd);
        pswrd.setText(p);
        pswrd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        vis = findViewById(R.id.vis);
        vis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i%2!=0)
                {
                    pswrd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    pswrd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                i++;
            }
        });

    }
}