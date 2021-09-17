package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Drinks_Categories extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> items0;
    private AdapterView.OnItemClickListener listener;
    private ArrayList<Data> drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_categories);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Drink categories");

        listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Drinks_Categories.this, Preview.class);
                intent.putExtra("title",drinks.get(i).getTitle());
                intent.putExtra("description",drinks.get(i).getDescription());
                intent.putExtra("image",drinks.get(i).getImage());
                startActivity(intent);
            }
        };
        drinks = new ArrayList<>();
        drinks.add(new Data("A couple of espresso shots with steamed milk","Latte",R.drawable.latte));
        drinks.add(new Data("Espresso, hot milk, and a steamed milk foam","Cappuccino",R.drawable.cappuccino));
        drinks.add(new Data("Highest quality beans roasted and brewed fresh","Filter",R.drawable.filter));
        items0 = new ArrayList<>();
        items0.add(drinks.get(0).getTitle());
        items0.add(drinks.get(1).getTitle());
        items0.add(drinks.get(2).getTitle());
        ArrayAdapter<String> items1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items0);
        listView = findViewById(R.id.drink_list);
        listView.setAdapter(items1);
        listView.setOnItemClickListener(listener);
    }
}