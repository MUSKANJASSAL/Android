package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(
//                Callback method
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        TextView myText = (TextView) findViewById(R.id.myText);
                        myText.setText("Button clicked");
                    }
                }
        );
        myButton.setOnLongClickListener(
//                Callback method
                new Button.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view) {
                        TextView myText = (TextView) findViewById(R.id.myText);
                        myText.setText("Long Button pressed");
                        return true;
                    }
                }
        );
    }
}