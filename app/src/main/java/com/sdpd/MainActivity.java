package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView surprisemf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surprisemf = findViewById(R.id.smf);
        surprisemf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surprisemf.setText("Surprise motherfucker!");
                surprisemf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        surprisemf.setText("Fuck you!");
                    }
                });
            }
        });

    }
}