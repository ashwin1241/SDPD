package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Food_Categories extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> items0;
    private AdapterView.OnItemClickListener listener;
    private ArrayList<Data> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_categories);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Food categories");

        listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Food_Categories.this, Preview.class);
                intent.putExtra("title",foods.get(i).getTitle());
                intent.putExtra("description",foods.get(i).getDescription());
                intent.putExtra("image",foods.get(i).getImage());
                startActivity(intent);
            }
        };
        foods = new ArrayList<>();
        foods.add(new Data("Spicy patties with fresh lettuce and tomatoes in freshly baked buns topped with sesame seeds","Burger",R.drawable.burger));
        foods.add(new Data("Thin crust with extra cheese and exotic toppings","Pizza",R.drawable.pizza));
        foods.add(new Data("Freshly prepared dough with garlic seasoning baked to perfection","Garlic Bread",R.drawable.garlic_bread));
        items0 = new ArrayList<>();
        items0.add(foods.get(0).getTitle());
        items0.add(foods.get(1).getTitle());
        items0.add(foods.get(2).getTitle());
        ArrayAdapter<String> items1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items0);
        listView = findViewById(R.id.food_list);
        listView.setAdapter(items1);
        listView.setOnItemClickListener(listener);
    }
}