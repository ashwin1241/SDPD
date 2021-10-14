package com.sdpd;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Word_Dao {

    @Query("SELECT * FROM Word_Item")
    List<Word_Item> getWords();

    @Insert
    void insert(Word_Item word_item);

    @Delete
    void delete(Word_Item word_item);

    @Update
    void update(List<Word_Item> items);

}
