package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Locations extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> items0;
    private AdapterView.OnItemClickListener listener;
    private ArrayList<Data> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Store locations");

        listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Locations.this, Preview.class);
                intent.putExtra("title", locations.get(i).getTitle());
                intent.putExtra("description", locations.get(i).getDescription());
                intent.putExtra("image", locations.get(i).getImage());
                startActivity(intent);
            }
        };
        locations = new ArrayList<>();
        locations.add(new Data("Tower 2, 10th Floor, Indiabulls Financial, Elphinstone Road, Lower Parel, Mumbai - 400013","Mumbai",R.drawable.mumbai));
        locations.add(new Data("Connaught Place - A Block, Hamilton House, New Delhi, DL 110001","Delhi",R.drawable.delhi));
        locations.add(new Data("Road No. 92, near Apollo Hospital, MLA Colony, Jubilee Hills, Hyderabad, Telangana 500034","Hyderabad",R.drawable.hyderabad));
        items0 = new ArrayList<>();
        items0.add(locations.get(0).getTitle());
        items0.add(locations.get(1).getTitle());
        items0.add(locations.get(2).getTitle());
        ArrayAdapter<String> items1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items0);
        listView = findViewById(R.id.location_list);
        listView.setAdapter(items1);
        listView.setOnItemClickListener(listener);
    }
}