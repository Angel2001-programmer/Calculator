package com.timbuchalka.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.timbuchalka.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    boolean Red, Blue, Green, Orange, Yellow, Grey, LTGreen, Purple, original, saveState;
    SharedPreferences mSharedPreferences = null;

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
        saveState = getIntent().getBooleanExtra("saveState", false);

        mSharedPreferences = getSharedPreferences("night", 0);
        Boolean saveState = mSharedPreferences.getBoolean("night_mode", false);
        if (saveState) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        if (Red) {
            Utils.changeToTheme(this, Utils.THEME_RED_STYLES);
        } else if (Blue) {
            Utils.changeToTheme(this, Utils.THEME_BLUE_STYLES);

        } else if (Green) {
            Utils.changeToTheme(this, Utils.THEME_GREEN_STYLES);

        } else if (Orange) {
            Utils.changeToTheme(this, Utils.THEME_ORANGE_STYLES);

        } else if (Yellow) {
            Utils.changeToTheme(this, Utils.THEME_YELLOW_STYLES);

        } else if (Grey) {
            Utils.changeToTheme(this, Utils.THEME_GREY_STYLES);

        } else if (LTGreen) {
            Utils.changeToTheme(this, Utils.THEME_LIGHT_GREEN_STYLES);

        } else if (Purple) {
            Utils.changeToTheme(this, Utils.THEME_PURPLE_STYLES);

        } else if (original) {
            Utils.changeToTheme(this, Utils.THEME_DEFAULT);
        }

    }
}



