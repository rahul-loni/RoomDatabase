package com.example.roomdatabase.Room;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version =1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
public abstract Dao dao();
}
