package com.sdpd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNote extends AppCompatActivity {

    private EditText title;
    private EditText details;
    private EditText time;
    private Button update_note;
    private Button delete_note;
    private CheckBox checkBox;
    private Note_Database db;
    private Note_Dao note_dao;
    private Note_Data data;
    private boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);
        getSupportActionBar().setTitle("Update note");

        class getdata extends AsyncTask<Void,Void,Void>
        {
            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                db = Room.databaseBuilder(UpdateNote.this,Note_Database.class,"Notes").build();
                note_dao = db.note_dao();
                return null;
            }
        }

        getdata getdata = new getdata();
        getdata.execute();

        data = (Note_Data) getIntent().getSerializableExtra("data1241");
        title = findViewById(R.id.note_title_edt);
        details = findViewById(R.id.note_details_edt);
        time = findViewById(R.id.note_time_edt);
        checkBox = findViewById(R.id.mark_as_done);
        if(checkBox.isChecked()==true)
            status = true;
        else
            status = false;
        update_note = findViewById(R.id.update_note_button);
        update_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class update extends AsyncTask<Void,Void,Void>
                {

                    @Override
                    protected Void doInBackground(Void... voids) {
                        data.setCompleted(status);
                        data.setTitle(title.getText().toString().trim());
                        data.setDetails(details.getText().toString().trim());
                        data.setTime(time.getText().toString().trim());
                        note_dao.update(data);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void unused) {
                        super.onPostExecute(unused);
                        Toast.makeText(UpdateNote.this, "Note Updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateNote.this,Notes.class);
                        startActivity(intent);
                    }
                }
                update update = new update();
                update.execute();
            }
        });
        delete_note = findViewById(R.id.delete_note_button);
        delete_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateNote.this);
                builder.setTitle("Delete note")
                .setMessage("Are you sure you want to delete this note?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        class delete extends AsyncTask<Void,Void,Void>
                        {

                            @Override
                            protected Void doInBackground(Void... voids) {
                                note_dao.delete(data);
                                return null;
                            }

                            @Override
                            protected void onPostExecute(Void unused) {
                                super.onPostExecute(unused);
                                Toast.makeText(UpdateNote.this, "Note Deleted", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UpdateNote.this,Notes.class);
                                startActivity(intent);
                            }
                        }
                        delete delete = new delete();
                        delete.execute();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
            }
        });

    }
}