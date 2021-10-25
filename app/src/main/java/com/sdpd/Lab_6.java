package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lab_6 extends AppCompatActivity {

    private ImageButton add_word;
    private RecyclerView recycler_view;
    private Word_Adapter word_adapter;
    private List<Word_Item> word_List;
    private Word_Database word_database;
    private Word_Dao word_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

        class loadData extends AsyncTask<Void,Void,Void>
        {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                buildRecyclerView();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                word_database = Room.databaseBuilder(Lab_6.this,Word_Database.class,"Words").build();
                word_dao = word_database.word_dao();
                word_List = word_dao.getWords();
                return null;
            }
        }
        new loadData().execute();

        add_word = findViewById(R.id.add_word);
        add_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab_6.this,AddWord.class);
                startActivity(intent);
            }
        });

    }

    private void buildRecyclerView()
    {
        Collections.sort(word_List, new Comparator<Word_Item>() {
            @Override
            public int compare(Word_Item word_item, Word_Item t1) {
                return word_item.getWord().trim().compareTo(t1.getWord().trim());
            }
        });

        recycler_view = findViewById(R.id.word_recycer_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        word_adapter = new Word_Adapter(this,word_List,word_database,word_dao);
        recycler_view.setHasFixedSize(true);
        recycler_view.setAdapter(word_adapter);

        word_adapter.setHandler(new Word_Adapter.ItemClickHandler() {
            @Override
            public void onItemdeleted(Word_Item item, int position) {
                class deleteWord extends AsyncTask<Void,Void,Void>
                {
                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                        buildRecyclerView();
                        Toast.makeText(Lab_6.this, "Word deleted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        word_dao.delete(item);
                        word_List = word_dao.getWords();
                        return null;
                    }
                }
                new deleteWord().execute();
            }
        });

    }

}