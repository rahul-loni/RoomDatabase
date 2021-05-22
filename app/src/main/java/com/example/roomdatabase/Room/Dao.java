package com.example.roomdatabase.Room;


import androidx.room.Insert;

@androidx.room.Dao
public interface Dao {

@Insert
    public void studentInsertion(Student student);
}
