package com.example.aslab4_task1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "MyLogs";
    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail, etResult;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.button);
        btnRead = findViewById(R.id.button2);
        btnClear = findViewById(R.id.button3);
        etName = findViewById(R.id.editTextTextPersonName2);
        etEmail = findViewById(R.id.editTextTextPersonName3);
        dbHelper = new DBHelper(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                break;
            }
            case R.id.button2: {
                break;
            }
            case R.id.button3: {

            }
        }
    }
}