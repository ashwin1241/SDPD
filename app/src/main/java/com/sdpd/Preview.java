package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Preview extends AppCompatActivity {

    private ImageView image_preview;
    private TextView title_preview;
    private TextView description_preview;
    private String title;
    private String description;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        getSupportActionBar().setHomeButtonEnabled(true);

        title = getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(title);
        description = getIntent().getStringExtra("description");
        image = getIntent().getIntExtra("image",0);

        image_preview = findViewById(R.id.image_preview);
        image_preview.setImageResource(image);
        title_preview = findViewById(R.id.title_preview);
        title_preview.setText(title);
        description_preview = findViewById(R.id.description_preview);
        description_preview.setText(description);

    }
}