package com.OscarFJunker.iifymmealfinder.iifymmealfinder;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//Code written by Oscar F. Junker, as of 2014


public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {

    //Declaring all those Seekbars, TextViews and the input the user inputs
    private SeekBar calorieSeekBar;
    private TextView calorieTextView;
    public int calories;

    private SeekBar proteinSeekBar;
    private TextView proteinTextView;
    public int protein;

    private SeekBar carbSeekBar;
    private TextView carbTextView;
    public int carbs;

    private SeekBar fatSeekBar;
    private TextView fatTextView;
    public int fat;

    private SeekBar fiberSeekBar;
    private TextView fiberTextView;
    public int fiber;

    private Spinner resturantSpinner;

    public String resturantChoice;
    public static int resturantFile = 0;

    public String userChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        resturantSpinner = (Spinner) findViewById(R.id.resturantSpinner);
         // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.resturant_arrays, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // Apply the adapter to the spinner
        resturantSpinner.setAdapter(adapter);


        //Calories
        calorieSeekBar = (SeekBar) findViewById(R.id.barCalories);
        calorieSeekBar.setOnSeekBarChangeListener(this);
        calorieTextView = (TextView) findViewById(R.id.textCalories);


        //Protein
        proteinSeekBar = (SeekBar) findViewById(R.id.barProtein);
        proteinSeekBar.setOnSeekBarChangeListener(this);
        proteinTextView = (TextView) findViewById(R.id.textProtein);

        //Carbs
        carbSeekBar = (SeekBar) findViewById(R.id.barCarbs);
        carbSeekBar.setOnSeekBarChangeListener(this);
        carbTextView = (TextView) findViewById(R.id.textCarbs);

        //Fat
        fatSeekBar = (SeekBar) findViewById(R.id.barFat);
        fatSeekBar.setOnSeekBarChangeListener(this);
        fatTextView = (TextView) findViewById(R.id.textFat);

        //Fiber
        fiberSeekBar = (SeekBar) findViewById(R.id.barFiber);
        fiberSeekBar.setOnSeekBarChangeListener(this);
        fiberTextView = (TextView) findViewById(R.id.textFiber);

        resturantSpinner.setOnItemSelectedListener(this);



    }



    @Override
    public void onProgressChanged(SeekBar bar, int progress,
                                  boolean fromUser) {
        // TODO Auto-generated method stub

        //switch statement that switches(get it?) between the diffent seekbars, and stores their progress in a variable and showcases it in a textView
        switch (bar.getId()){

            case R.id.barCalories:
                calories = progress;
                calorieTextView.setText(""+calories);

                break;

            case R.id.barProtein:
                protein = progress;
                proteinTextView.setText(""+protein);
                break;

            case R.id.barCarbs:
                carbs = progress;
                carbTextView.setText(""+carbs);
                break;

            case R.id.barFat:
                fat = progress;
                fatTextView.setText(""+fat);
                break;

            case R.id.barFiber:
                fiber = progress;
                fiberTextView.setText(""+fiber);
                break;

        }

    }




    // Intent for other activity and the Sharedprefences that puts the input into sharedPrefences so other activies can use it.
    public void showMeals(View view){

        Intent intent = new Intent(this, ShowMealsActivity.class);

        Bundle bundle = new Bundle();

       bundle.putString("key", resturantChoice);
       intent.putExtras(bundle);
        startActivity(intent);

        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("calories", calories);
        editor.putInt("protein", protein);
        editor.putInt("carbs", carbs);
        editor.putInt("fat", fat);
        editor.putInt("fiber", fiber);
        editor.commit();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String userChoice = resturantSpinner.getSelectedItem().toString();
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("your_String_key", userChoice);
        editor.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
