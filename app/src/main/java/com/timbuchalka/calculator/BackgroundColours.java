package com.timbuchalka.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.timbuchalka.calculator.databinding.ActivityBackgroundColoursBinding;
import com.timbuchalka.calculator.databinding.ActivityMainBinding;

public class BackgroundColours extends AppCompatActivity implements View.OnClickListener {
    ActivityBackgroundColoursBinding binding;
    private static final String TAG = "BackgroundColours";
    Boolean buttonEnabled = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityBackgroundColoursBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_background_colours);
        View view = binding.getRoot();
        setContentView(view);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        binding.ibBlue.setOnClickListener(this);
        binding.ibGreen.setOnClickListener(this);
        binding.ibGrey.setOnClickListener(this);
        binding.ibLTGreen.setOnClickListener(this);
        binding.ibOrange.setOnClickListener(this);
        binding.ibRed.setOnClickListener(this);
        binding.ibYellow.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_Blue:
                Log.d(TAG, "onClick: " + "Blue is clicked");

                break;
            case R.id.ib_Green:
                Log.d(TAG, "onClick: " + "Green is clicked");
                break;
            case R.id.ib_Grey:
                Log.d(TAG, "onClick: " + "Grey is clicked");
                break;
            case R.id.ib_LTGreen:
                Log.d(TAG, "onClick: " + "LTGreen is clicked");
                break;
            case R.id.ib_Yellow:
                Log.d(TAG, "onClick: " + "Yellow is clicked");
                break;
            case R.id.ib_Orange:
                Log.d(TAG, "onClick: " + "Orange is clicked");
                break;
            case R.id.ib_Red:
                Log.d(TAG, "onClick: " + "Red is clicked");
                break;
        }
    }
}
