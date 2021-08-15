package com.timbuchalka.calculator;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.timbuchalka.calculator.databinding.ActivityMainBinding;
import com.timbuchalka.calculator.ui.calculator.CalculatorFragment;

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
            Utils.changeToTheme(this, Utils.THEME_RedStyles);

        } else if (Blue) {
            Utils.changeToTheme(this, Utils.THEME_BlueStyles);

        } else if (Green) {
            Utils.changeToTheme(this, Utils.THEME_GreenStyles);

        } else if (Orange) {
            Utils.changeToTheme(this, Utils.THEME_OrangeStyles);

        } else if (Yellow) {
            Utils.changeToTheme(this, Utils.THEME_YellowStyles);

        } else if (Grey) {
            Utils.changeToTheme(this, Utils.THEME_GreyStyles);

        } else if (LTGreen) {
            Utils.changeToTheme(this, Utils.THEME_LightGreenStyles);

        } else if (Purple) {
            Utils.changeToTheme(this, Utils.THEME_PurpleStyles);

        } else if (original) {
            Utils.changeToTheme(this, Utils.THEME_DEFAULT);
        }
    }
}
