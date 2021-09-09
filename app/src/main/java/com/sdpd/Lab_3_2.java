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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab32);
        getSupportActionBar().setTitle("Lab 3");
        getSupportActionBar().setHomeButtonEnabled(true);

        site_url = findViewById(R.id.site_url);
        go_button = findViewById(R.id.go_button);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = site_url.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if(!url.startsWith("www."))
                {
                    url = "https://www." + url;
                }
                if (!(url.startsWith("http://") || url.startsWith("https://")))
                {
                    url = "https://" + url;
                }
                if (!url.endsWith(".com"))
                {
                    url += ".com";
                }
                intent.setData(Uri.parse(url));
                startActivity(Intent.createChooser(intent,"Open site with:"));
            }
        });

    }
}