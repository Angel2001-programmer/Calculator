package com.timbuchalka.calculator;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.timbuchalka.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    boolean Red, Blue, Green, Orange, Yellow, Grey, LTGreen, Purple, original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_calculator, R.id.navigation_history, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Red = getIntent().getBooleanExtra("red", false);
        Blue = getIntent().getBooleanExtra("blue", false);
        Green = getIntent().getBooleanExtra("green", false);
        Orange = getIntent().getBooleanExtra("orange", false);
        Yellow = getIntent().getBooleanExtra("yellow", false);
        Grey = getIntent().getBooleanExtra("grey", false);
        LTGreen = getIntent().getBooleanExtra("light green", false);
        Purple = getIntent().getBooleanExtra("purple", false);
        original = getIntent().getBooleanExtra("white", false);

        if (Red) {
            binding.background.setBackgroundResource(R.drawable.red);
        } else if (Blue) {
            binding.background.setBackgroundResource(R.drawable.blue);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (Green) {
            binding.background.setBackgroundResource(R.drawable.green);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (Orange) {
            binding.background.setBackgroundResource(R.drawable.redorange);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (Yellow) {
            binding.background.setBackgroundResource(R.drawable.yellow);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (Grey) {
            binding.background.setBackgroundResource(R.drawable.grey);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (LTGreen) {
            binding.background.setBackgroundResource(R.drawable.lightgreen);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (Purple) {
            binding.background.setBackgroundResource(R.drawable.purple);
//            Red = false;
//            Blue = false;
//            Green = false;
//            Orange = false;
//            Yellow = false;
//            Grey = false;
//            LTGreen = false;
//            Purple = false;
        } else if (original) {
            binding.background.setBackgroundResource(R.color.white);
        }


//        binding.background.setBackground(gradientDrawable);
    }
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        onCreate(savedInstanceState);
//    }
}