package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdatabase.Room.MyDatabase;
import com.example.roomdatabase.Room.Student;

import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText firstName,secondName,className,updatename,updateid,deleteid;
    Button insert,read,update,delete;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firstName=findViewById(R.id.firstName);
        secondName=findViewById(R.id.secondName);
        className=findViewById(R.id.className);
        updatename=findViewById(R.id.updatename);
        updateid=findViewById(R.id.updateid);
        deleteid=findViewById(R.id.deleteID);

        insert=findViewById(R.id.insert);
        read=findViewById(R.id.read);
        update=findViewById(R.id.btnUpdate);
        delete=findViewById(R.id.btnDelete);


        SetUpDB();


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student (firstName.getText().toString()
                        ,secondName.getText().toString()
                ,className.getText().toString());


                myDatabase.dao().studentInsertion(student);

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              List<Student> stuData=myDatabase.dao().getStudent();
              for (int i=0;i<stuData.size();i++){
                  Log.d("STUDENT_DATA" , String.valueOf(stuData.get(i).getStuId() +": "+
                          stuData.get(i).getStuFirstName()+": "+ stuData.get(i).getStuLastName()+": "+
                          stuData.get(i).getStuClass()));
              }


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabase.dao().updatestu(updatename.getText().toString() ,
                        Integer.parseInt(updateid.getText().toString()));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDatabase.dao().delete(Integer.parseInt(deleteid.getText().toString()));
            }
        });

    }
    private void SetUpDB(){
         myDatabase= Room.databaseBuilder(MainActivity.this , MyDatabase.class ,"StudentDB")
                        .allowMainThreadQueries().build();
    }
}