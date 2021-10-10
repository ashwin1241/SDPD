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

public class AddNote extends AppCompatActivity {

    private EditText title;
    private EditText details;
    private EditText time;
    private Button add_note;
    private Note_Database db;
    private Note_Dao note_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        class getdata extends AsyncTask<Void,Void,Void>
        {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                db = Room.databaseBuilder(AddNote.this,Note_Database.class,"Notes").build();
                note_dao = db.note_dao();
                return null;
            }
        }

        getdata getdata = new getdata();
        getdata.execute();

        title = findViewById(R.id.note_title_et);
        details = findViewById(R.id.note_details_et);
        time = findViewById(R.id.note_time_et);
        add_note = findViewById(R.id.add_note_button);
        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class add extends AsyncTask<Void,Void,Void>
                {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        note_dao.insert(new Note_Data(false,title.getText().toString().trim(),details.getText().toString().trim(),time.getText().toString().trim()));
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                        finish();
                        Intent intent = new Intent(AddNote.this,Notes.class);
                        startActivity(intent);
                        Toast.makeText(AddNote.this, "Note Added", Toast.LENGTH_SHORT).show();
                    }
                }
                add add = new add();
                add.execute();
            }
        });

    }
}