package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.Room.MyDatabase;
import com.example.roomdatabase.Room.Student;

public class MainActivity extends AppCompatActivity {

    EditText firstName,secondName,className;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstName=findViewById(R.id.firstName);
        secondName=findViewById(R.id.secondName);
        className=findViewById(R.id.className);
        insert=findViewById(R.id.insert);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student (firstName.getText().toString()
                        ,secondName.getText().toString()
                ,className.getText().toString());

                MyDatabase myDatabase=
                        Room.databaseBuilder(MainActivity.this , MyDatabase.class ,"StudentDB")
                                .allowMainThreadQueries().build();
                myDatabase.dao().studentInsertion(student);

            }
        });
    }
}