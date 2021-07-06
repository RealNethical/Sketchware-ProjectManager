package com.bhavy.sdk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bhavy.projectmgr.ProjectManager;
public class MainActivity extends AppCompatActivity {
    private TextView textview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview1 = (TextView) findViewById(R.id.textview1);
        try {
            Toast.makeText(getApplicationContext(), ProjectManager.Projects(), Toast.LENGTH_LONG).show();
        }catch (Exception e){
            textview1.setText(e.toString());
        }
    }
}