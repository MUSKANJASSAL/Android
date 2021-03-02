package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends Activity {

    private workout_expert expert = new workout_expert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        TextView workout = (TextView)findViewById(R.id.text_view);
        Spinner workout_type = (Spinner)findViewById(R.id.type);
        String workouts = String.valueOf(workout_type.getSelectedItem());
        //workout.setText(workouts);
        List <String> workoutList = expert.getworkouts(workouts);
        StringBuilder workoutsformatted = new StringBuilder();
        for (String work : workoutList) {
            workoutsformatted.append(work).append('\n');
        }
        workout.setText(workoutsformatted);

    }
}