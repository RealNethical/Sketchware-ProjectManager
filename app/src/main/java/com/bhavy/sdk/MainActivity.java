package com.bhavy.sdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bhavy.projectmgr.MoreBlock;

public class MainActivity extends AppCompatActivity {
    private TextView textview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1 = (TextView) findViewById(R.id.textview1);
        try {
            Toast.makeText(getApplicationContext(), MoreBlock.list(), Toast.LENGTH_LONG).show();
            textview1.setText(MoreBlock.list());
        }catch (Exception e){
            textview1.setText(e.toString());
            message(e.toString());
        }
    }
    private void message(String e){
        Toast.makeText(getApplicationContext(),e,Toast.LENGTH_LONG).show();
    }
}