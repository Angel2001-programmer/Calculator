package com.timbuchalka.calculator;

import static java.security.AccessController.getContext;

import android.app.Activity;
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
        Utils.onActivityCreateSetTheme(this);
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
//            if (Build.VERSION.SDK_INT >= 21) {
//                Window window = getWindow();
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                window.setStatusBarColor(Color.parseColor("#5B0E0E"));
            Utils.changeToTheme(this, Utils.THEME_RedStyles);

//            }
//
//            binding.background.setBackgroundResource(R.drawable.red);
//            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#811414")));
        } else if (Blue) {
//            if (Build.VERSION.SDK_INT >= 21) {
//                Window window = getWindow();
//                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                window.setStatusBarColor(Color.parseColor("#135CA5"));
//            }
//            binding.background.setBackgroundResource(R.drawable.blue);
//            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1976d2")));
            Utils.changeToTheme(this, Utils.THEME_BlueStyles);

        } else if (Green) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(Color.parseColor("#164B19"));
            }
            binding.background.setBackgroundResource(R.drawable.green);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1b5e20")));

        } else if (Orange) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(Color.parseColor("#B95B08"));
            }

            binding.background.setBackgroundResource(R.drawable.redorange);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f57f17")));

        } else if (Yellow) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(Color.parseColor("#c49000"));
            }
            binding.background.setBackgroundResource(R.drawable.yellow);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fbc02d")));

        } else if (Grey) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(Color.parseColor("#36464E"));
            }
            binding.background.setBackgroundResource(R.drawable.grey);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#455a64")));

        } else if (LTGreen) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(Color.parseColor("#275117"));
            }
            binding.background.setBackgroundResource(R.drawable.lightgreen);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33691e")));

        } else if (Purple) {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.setStatusBarColor(Color.parseColor("#4A136C"));
            }
            binding.background.setBackgroundResource(R.drawable.purple);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6a1b9a")));

        } else if (original) {
            binding.background.setBackgroundResource(0);
        }
    }
}
