package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab_2 extends AppCompatActivity {

    private TextView primary_display;
    private TextView result;
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button dec;
    private Button equ;
    private Button clr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        getSupportActionBar().setTitle("Lab 2");
        getSupportActionBar().setHomeButtonEnabled(true);

        primary_display = findViewById(R.id.primary_display);
        clr = findViewById(R.id.clr);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText("");
            }
        });
        b0 = findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"0");
            }
        });
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"1");
            }
        });
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"2");
            }
        });
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"3");
            }
        });
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"4");
            }
        });
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"5");
            }
        });
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"6");
            }
        });
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"7");
            }
        });
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"8");
            }
        });
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"9");
            }
        });
        add = findViewById(R.id.b_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"\n+\n");
            }
        });
        mul = findViewById(R.id.b_mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"\nx\n");
            }
        });
        div = findViewById(R.id.b_div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"\n/\n");
            }
        });
        sub = findViewById(R.id.b_sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+"\n-\n");
            }
        });
        dec = findViewById(R.id.b_dec);
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primary_display.setText(primary_display.getText()+".");
            }
        });
        equ = findViewById(R.id.b_equ);
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}