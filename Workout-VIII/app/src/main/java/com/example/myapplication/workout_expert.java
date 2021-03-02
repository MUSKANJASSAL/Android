package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

//Choose workout plan depending upon body part chosen

public class workout_expert {

    List <String> getworkouts (String type)
    {
        List <String> workout = new ArrayList<>();
        if(type.equals("Chest"))
        {
            workout.add("Benchpress");
            workout.add("Cable Flyes");
        }
        else if(type.equals("Triceps"))
        {
            workout.add("Tricep Ext");
            workout.add("Pushdown");
        }
        else if(type.equals("Shoulder"))
        {
            workout.add("Shoulder Press");
        }
        else if(type.equals("Biceps"))
        {
            workout.add("Biceps Curls");
        }
        return workout;
    }
}
