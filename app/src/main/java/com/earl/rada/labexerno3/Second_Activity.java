package com.earl.rada.labexerno3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Second_Activity extends AppCompatActivity {

    TextView displayOne;
    Button loadShared, loadInternal, back;
    SharedPreferences preferences;
    FileInputStream fis;
    FileOutputStream fos;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayOne = (TextView) findViewById(R.id.displayOne);
        loadShared = (Button) findViewById(R.id.loadShared);
        loadInternal = (Button) findViewById(R.id.loadInternal);
        back = (Button) findViewById(R.id.back);
        preferences = getApplication().getSharedPreferences(" ", MODE_PRIVATE);

    }

    public void sharedPreferences (View view) {
        String data = preferences.getString("data", "");
        displayOne.setText("Data is '" + data + "' in Shared Preferences");


    }

    public void internalStorage (View view) {
        StringBuffer buffer = new StringBuffer();

        String file_name = getIntent().getStringExtra("filename");

        int read = 0;

        try {
            fis = openFileInput(file_name);
            while ((read = fis.read()) != -1) {
                buffer.append((char)read);

            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        displayOne.setText("Data is '" + buffer.toString() + "' in Internal Storage");


    }

    public void loadInternalCache (View view) {

        StringBuffer buffer = new StringBuffer();

        String file_name = getIntent().getStringExtra("filename");

        int read = 0;

        try {
            fis = openFileInput(file_name);
            while ((read = fis.read()) != -1) {
                buffer.append((char)read);

            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        displayOne.setText("Data is '" + buffer.toString() + "' in Internal Cache");

    }

    public void loadExternalCache (View view) {

        StringBuffer buffer = new StringBuffer();
        String file_name = getIntent().getStringExtra("filename");

        int read = 0;

        try {
            fis = openFileInput(file_name);
            while ((read = fis.read()) != -1) {
                buffer.append((char)read);

            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        displayOne.setText("Data is '" + buffer.toString() + "' in External Cache");


    }

    public void loadExternalStorage (View view) {

        StringBuffer buffer = new StringBuffer();
        String file_name = getIntent().getStringExtra("filename");

        int read = 0;

        try {
            fis = openFileInput(file_name);
            while ((read = fis.read()) != -1) {
                buffer.append((char)read);

            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        displayOne.setText("Data is '" + buffer.toString() + "' in External Storage");


    }

    public void loadExternalPublic (View view) {

        StringBuffer buffer = new StringBuffer();
        String file_name = getIntent().getStringExtra("filename");

        int read = 0;

        try {
            fis = openFileInput(file_name);
            while ((read = fis.read()) != -1) {
                buffer.append((char)read);

            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        displayOne.setText("Data is '" + buffer.toString() + "' in External Public Storage");


    }

    public void back (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}