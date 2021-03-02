package com.example.debugapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.edit1);
        e2 = (EditText)findViewById(R.id.edit2);
        t1 = (TextView)findViewById(R.id.result);
    }

    public void onAdd(View view) {
        Log.i("MainActivity","Executed1");
        int a1 = Integer.parseInt(e1.getText().toString());
        Log.i("MainActivity","Executed2");
        int a2 = Integer.parseInt(e2.getText().toString());
        Log.i("MainActivity","Executed3");
        int result = a1 + a2;
        Log.i("MainActivity","Executed4");
        t1.setText(""+ result);
        Log.i("MainActivity","Executed5");
    }
}