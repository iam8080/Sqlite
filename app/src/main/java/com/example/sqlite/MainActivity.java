package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Pass ;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        Name = (EditText) findViewById(R.id.edit_text);
        Pass = (EditText) findViewById(R.id.edit_pass);
        Button button = (Button) findViewById(R.id.btn);
        if(Name.getText().toString().isEmpty() && Pass.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Username and Password is Empty!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Login Sucess", Toast.LENGTH_SHORT).show();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             boolean check =   db.insertData(Name.getText().toString(),Pass.getText().toString());
             if (check==true)
             {
                 Toast.makeText(MainActivity.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
             }
             else
             {
                 Toast.makeText(MainActivity.this, "No Data Insert", Toast.LENGTH_SHORT).show();
             }
            }
        });
    }
}