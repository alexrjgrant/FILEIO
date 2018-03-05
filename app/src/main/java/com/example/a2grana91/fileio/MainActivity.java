package com.example.a2grana91.fileio;

import android.app.AlertDialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.*;

import android.widget.EditText;

import static com.example.a2grana91.fileio.R.id.tb;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String INFO;
        EditText et = (EditText)findViewById(R.id.tb);
        INFO = et.getText().toString();

        if(item.getItemId() == R.id.save)
        {
            try
            {
                PrintWriter pw = new PrintWriter( new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tb.txt"));

                pw.println(INFO);

                pw.close();
            }
            catch(IOException e)
            {
                new AlertDialog.Builder(this).setMessage("ERROR: " + e).setPositiveButton("OK", null).show();
            }

            return true;
        }
        if(item.getItemId() == R.id.load)
        {


            return true;
        }
        return false;
    }
}
