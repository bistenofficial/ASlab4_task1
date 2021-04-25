package com.example.aslab4_task1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
        ContentValues cv = new ContentValues();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.button: {
                Log.d(LOG_TAG, "---Insert in my table---");
                cv.put("name", name);
                cv.put("email", email);
                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "---ROW inserted---,ID = " + rowID);
                break;
            }
            case R.id.button2: {
                Log.d(LOG_TAG, "---Rows in mytable---");
                Cursor c = db.query("mytable", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = c.getColumnIndex("email");
                    do {
                        Log.d(LOG_TAG, "ID = " + c.getInt(idColIndex) + " name =" + c.getString(nameColIndex) + " email = " + c.getString(emailColIndex));
                    } while (c.moveToNext());

                } else
                    Log.d(LOG_TAG, "0 ROWS");
                c.close();
                break;
            }
            case R.id.button3: {
                Log.d(LOG_TAG, "---Clear mytable---");
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;

            }
        }
    }
}