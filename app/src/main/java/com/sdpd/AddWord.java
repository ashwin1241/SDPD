package com.sdpd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class AddWord extends AppCompatActivity {

    private List<Word_Item> word_List;
    private Word_Database word_database;
    private Word_Dao word_dao;
    private Button addword;
    private EditText getword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        class loadData extends AsyncTask<Void,Void,Void>
        {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                word_database = Room.databaseBuilder(AddWord.this,Word_Database.class,"Words").build();
                word_dao = word_database.word_dao();
                word_List = word_dao.getWords();
                return null;
            }
        }
        new loadData().execute();

        getword = findViewById(R.id.getword);
        addword = findViewById(R.id.done);
        addword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class addWord extends AsyncTask<Void,Void,Void>
                {
                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                        Toast.makeText(AddWord.this, "Word added", Toast.LENGTH_SHORT).show();
                        finish();
                        Intent intent = new Intent(AddWord.this,Lab_6.class);
                        startActivity(intent);
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        word_dao.insert(new Word_Item(getword.getText().toString().trim()));
                        return null;
                    }
                }
                new addWord().execute();
            }
        });

    }
}