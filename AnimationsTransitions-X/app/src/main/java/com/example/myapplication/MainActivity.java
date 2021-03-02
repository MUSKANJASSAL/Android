package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.transition.TransitionManager;

import android.view.MotionEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Reference
        myLayout = (ViewGroup) findViewById(R.id.myLayout);

//        Listener
        myLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener()
                {
                    public boolean onTouch(View v, MotionEvent event)
                    {
                        moveButton();
                        return true;
                    }
                }
        );
    }

    public void moveButton()
    {
//        Delay
        TransitionManager.beginDelayedTransition(myLayout);
//            Reference to Button
        View myButton = findViewById(R.id.myButton);
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        myButton.setLayoutParams(positionRules);
//        Another Animation -> Expanding the button to grow
        ViewGroup.LayoutParams sizeRules = myButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        myButton.setLayoutParams(sizeRules);
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