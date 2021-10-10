package com.sdpd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note_Data.class},version = 1)
public abstract class Note_Database extends RoomDatabase {
    public abstract Note_Dao note_dao();
}
