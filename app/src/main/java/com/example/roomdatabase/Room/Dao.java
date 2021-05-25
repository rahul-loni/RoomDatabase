package com.example.roomdatabase.Room;


import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao {

@Insert
    public void studentInsertion(Student student);

    @Query("Select * from Student")
    List<Student> getStudent();

    @Query("Update Student set stuFirstName=:stuName where stuId=:stuID")
    void updatestu(String stuName , int stuID);

    @Query("Delete from Student Where stuID = :stuID")
    void delete(int stuID);

}
