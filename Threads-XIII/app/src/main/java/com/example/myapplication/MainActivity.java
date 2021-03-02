package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import android.os.Handler;
import android.os.Message;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
//    handler
    Handler handler = new Handler()
{
    @Override
    public void handleMessage(@NonNull Message msg) {
        TextView myText = (TextView) findViewById(R.id.myText);
        myText.setText("Button clicked!");

    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickmyButton(View view){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Long futureTime = System.currentTimeMillis()+10000;
                while (System.currentTimeMillis()<futureTime) {
                    //        Delay
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        } catch (Exception e) {

                        }
                    }
                    handler.sendEmptyMessage(0);
                }
            }
        };

        Thread myThread = new Thread();
        myThread.start();

//        System time
//        Long futureTime = System.currentTimeMillis()+10000;
//        while (System.currentTimeMillis()<futureTime) {
//            //        Delay
//            synchronized (this) {
//                try {
//                    wait(futureTime - System.currentTimeMillis());
//                } catch (Exception e) {
//
//                }
//            }
//        }
//            TextView myText = (TextView) findViewById(R.id.myText);
//            myText.setText("Button clicked!");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}