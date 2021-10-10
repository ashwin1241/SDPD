package com.sdpd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Note_Data implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "isCompleted")
    private boolean isCompleted;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "details")
    private String details;
    @ColumnInfo(name = "time")
    private String time;

    public Note_Data(boolean isCompleted, String title, String details, String time)
    {
        this.isCompleted = isCompleted;
        this.title = title;
        this.details = details;
        this.time = time;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
