package com.sdpd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Note_Dao {

    @Query("SELECT * FROM Note_Data")
    List<Note_Data> getAll();

    @Insert
    void insert(Note_Data data);

    @Delete
    void delete(Note_Data data);

    @Update
    void update(Note_Data data);

}
