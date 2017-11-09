package com.earl.rada.labexerno3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etData, etFilename;
    Button shared, internal, next;
    SharedPreferences.Editor editor;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = (EditText) findViewById(R.id.etData);
        etFilename = (EditText) findViewById(R.id.etFilename);
        shared = (Button) findViewById(R.id.shared);
        internal = (Button) findViewById(R.id.internal);
        next = (Button) findViewById(R.id.next);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(" ", MODE_PRIVATE);
        editor = preferences.edit();

    }

    public void sharedPreferences (View view) {

        editor.putString("data", etData.getText().toString());
        editor.putString("filename", etFilename.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data saved in Shared Preferences!", Toast.LENGTH_SHORT).show();


    }

    public void internalStorage (View view) {

        String data = etData.getText().toString();
        String filename = etFilename.getText().toString();


        try {
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(data.getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }


        Toast.makeText(this, "Data saved in Internal Storage!", Toast.LENGTH_SHORT).show();

    }

    public void saveInternalCache (View view) {

        String filename = etFilename.getText().toString();
        File folder = getCacheDir();
        File file = new File(folder, filename);
        FileOutputStream fos = null;
        String message = etData.getText().toString();
        Toast.makeText(this, "Successfully written to Internal Cache", Toast.LENGTH_SHORT).show();

    }

    public void saveExternalCache (View view) {
        String filename = etFilename.getText().toString();
        File folder = getExternalCacheDir();
        File file = new File(folder, filename);
        String message = etData.getText().toString();
        writeData(file, message);
        Toast.makeText(this, "Successfully written to External Cache", Toast.LENGTH_SHORT).show();

    }

    public void saveExternalStorage (View view) {
        String filename = etFilename.getText().toString();
        String data = etData.getText().toString();

        File folder = getExternalFilesDir(data);
        File file = new File(folder, filename);
        String message = etData.getText().toString();
        writeData(file, message);
        Toast.makeText(this, "Successfully written to External Storage", Toast.LENGTH_SHORT).show();
    }

    public void saveExternalPublic (View view) {
        String filename = etFilename.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, filename);
        String message = etData.getText().toString();
        writeData(file, message);
        Toast.makeText(this, "Successfully written to External Public", Toast.LENGTH_SHORT).show();
    }

    private void writeData (File file, String message) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    public void submit (View view) {

        Intent intent = new Intent(this, Second_Activity.class);
        etFilename = findViewById(R.id.etFilename);
        String name = etFilename.getText().toString();

        intent.putExtra("filename", name);
        startActivity(intent);



    }
}