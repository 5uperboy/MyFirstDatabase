package com.quizapp.myfirstdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText txt_name, txt_contact;
    Button btn_insert, btn_update, btn_delete, btn_view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_name = findViewById(R.id.txt_name);
        txt_contact = findViewById(R.id.txt_contact);

        btn_insert = findViewById(R.id.btn_insert);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        btn_view = findViewById(R.id.btn_view);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = txt_name.getText().toString();
                String contactTxt = txt_contact.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTxt, contactTxt);

                if (checkinsertdata == true){
                    Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Entry not Inserted!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}