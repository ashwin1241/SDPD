package com.sdpd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Word_Item.class}, version = 1)
public abstract class Word_Database extends RoomDatabase {
    public abstract Word_Dao word_dao();
}
