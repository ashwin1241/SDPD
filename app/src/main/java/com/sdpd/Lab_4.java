package com.sdpd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lab_4 extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> items0;
    private AdapterView.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        getSupportActionBar().setTitle("Lab 4");
        getSupportActionBar().setHomeButtonEnabled(true);

        listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:startActivity(new Intent(Lab_4.this, Drinks_Categories.class));
                    break;
                    case 1:startActivity(new Intent(Lab_4.this, Food_Categories.class));
                    break;
                    case 2:startActivity(new Intent(Lab_4.this, Locations.class));
                    break;
                }
            }
        };

        items0 = new ArrayList<>();
        listView = findViewById(R.id.main_list);
        ArrayAdapter<String> items1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items0);
        items0.add("Drinks");
        items0.add("Food");
        items0.add("Stores");
        items1.notifyDataSetChanged();
        listView.setAdapter(items1);
        listView.setOnItemClickListener(listener);

    }
}