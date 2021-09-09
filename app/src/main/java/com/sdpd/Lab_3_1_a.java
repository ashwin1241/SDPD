package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Lab_3_1_a extends AppCompatActivity {

    private Button login;
    private Button register;
    private EditText username;
    private EditText password;
    private ImageView passwordvisible;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab31a);
        getSupportActionBar().setTitle("Lab 3");
        getSupportActionBar().setHomeButtonEnabled(true);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lab_3_1_a.this, username.getText().toString().trim()+" registered successfully", Toast.LENGTH_SHORT).show();
            }
        });
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        password.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordvisible = findViewById(R.id.visible_password);
        passwordvisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i%2!=0)
                {
                    password.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else
                {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                password.setSelection(password.getText().length());
                i++;
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab_3_1_a.this,Lab_3_1_b.class);
                intent.putExtra("username",username.getText().toString().trim());
                intent.putExtra("password",password.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}