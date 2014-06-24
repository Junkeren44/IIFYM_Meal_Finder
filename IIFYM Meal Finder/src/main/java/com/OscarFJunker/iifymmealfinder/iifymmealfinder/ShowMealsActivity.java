package com.OscarFJunker.iifymmealfinder.iifymmealfinder;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//Code written by Oscar F. Junker, as of 2014





public class ShowMealsActivity extends ActionBarActivity {


    //Delcaring variables
    int calories;
    int protein;
    int carbs;
    int fat;
    int fiber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_meals);


        Intent intent = getIntent();


        //Set's Up sharedPrefences, and retrieves the Resturant data
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        String resturantChoice = sp.getString("your_String_key", "ERROR, COULD NOT GET YOUR CHOSEN RESTURANT DATA");

        //retrieves the int's the user inputed, from sharedprefences
        calories = sp.getInt("calories", 0);
        protein = sp.getInt("protein", 0);
        carbs = sp.getInt("carbs", 0);
        fat = sp.getInt("fat", 0);
        fiber = sp.getInt("fiber", 0);


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_meals, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
