package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lab_3_2 extends AppCompatActivity {

    private EditText site_url;
    private Button go_button;
    private String url;
    private Button next_lab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab32);
        getSupportActionBar().setTitle("Lab 3");
        getSupportActionBar().setHomeButtonEnabled(true);

        next_lab = findViewById(R.id.lab_4_proceed);
        next_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab_3_2.this, Lab_4.class);
                startActivity(intent);
            }
        });

        site_url = findViewById(R.id.site_url);
        go_button = findViewById(R.id.go_button);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = site_url.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if(!url.startsWith("www.")&&(!(url.startsWith("http://") || url.startsWith("https://"))))
                {
                    url = "https://www." + url;
                }
                if (!(url.startsWith("http://") || url.startsWith("https://")))
                {
                    url = "https://" + url;
                }
                intent.setData(Uri.parse(url));
                startActivity(Intent.createChooser(intent,"Open site with:"));
            }
        });

    }
}