package com.timbuchalka.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.Snackbar;
import com.timbuchalka.calculator.databinding.ActivityMain2Binding;
import com.timbuchalka.calculator.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

     /*
    1. View binding the buttons together, do not use findviewbyid because it will take up too much CPU resources. X
    2. Remember when button is pressed to put an output in the TextField whenever that is a number or symbol. X
    3. Ensure to create another method to do the logic side of the app. X
    4. Set textview to a limit of 6 digits.
    5. When 10.0 setText to 10. X
    6. Fix division. X
    7. Configure AndroidManifest to handle orientation changes. X
    8. Create database.
    9. Create two options for the user to click one called calculator and the other called database. X
    10. Don't forget to have fun making this project :) X
    11. Remember to design the app.
     */

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_calculator, R.id.navigation_History)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
}