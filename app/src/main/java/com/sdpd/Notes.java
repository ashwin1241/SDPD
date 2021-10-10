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

import java.util.List;

public class Notes extends AppCompatActivity {

    private ImageButton add_note;
    private RecyclerView notes;
    private Note_Adatper adatper;
    private List<Note_Data> note_data;
    private Note_Database db;
    private Note_Dao note_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        getSupportActionBar().setTitle("Notes");

        add_note = findViewById(R.id.add_note);
        notes = findViewById(R.id.notes);

        class getdata extends AsyncTask<Void,Void,Void>
        {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                buildRecyclerView();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                db = Room.databaseBuilder(Notes.this,Note_Database.class,"Notes").build();
                note_dao = db.note_dao();
                note_data = note_dao.getAll();
                return null;
            }
        }

        getdata getdata = new getdata();
        getdata.execute();

        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes.this,AddNote.class);
                startActivity(intent);
            }
        });

    }

    private void buildRecyclerView()
    {
        adatper = new Note_Adatper(this,note_data);
        notes.setLayoutManager(new LinearLayoutManager(this));
        notes.setHasFixedSize(true);
        notes.setAdapter(adatper);
    }

}