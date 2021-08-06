package com.timbuchalka.calculator;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.timbuchalka.calculator.databinding.ActivityBackgroundColoursBinding;
import com.timbuchalka.calculator.databinding.ActivityMainBinding;
import com.timbuchalka.calculator.ui.calculator.CalculatorFragment;

public class BackgroundColours extends AppCompatActivity implements View.OnClickListener {
    ActivityBackgroundColoursBinding binding;
    private static final String TAG = "BackgroundColours";
    Boolean Blue = false, Red = false, Yellow = false, Green = false, LTGreen = false, Orange = false, Grey = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBackgroundColoursBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.ibBlue.setOnClickListener(this);
        binding.ibGreen.setOnClickListener(this);
        binding.ibGrey.setOnClickListener(this);
        binding.ibLTGreen.setOnClickListener(this);
        binding.ibOrange.setOnClickListener(this);
        binding.ibRed.setOnClickListener(this);
        binding.ibYellow.setOnClickListener(this);
        binding.confirmBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_Blue:
                Blue = true;
                Snackbar.make(v, "Colour was set to Blue," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "Blue is clicked");
                break;

            case R.id.ib_Green:
                Green = true;
                Snackbar.make(v, "Colour was set to Green," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "Green is clicked");
                break;

            case R.id.ib_Grey:
                Grey = true;
                Snackbar.make(v, "Colour was set to Grey," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "Grey is clicked");
                break;

            case R.id.ib_LTGreen:
                LTGreen = true;
                Snackbar.make(v, "Colour was set to Light Green," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "LTGreen is clicked");
                break;

            case R.id.ib_Yellow:
                Yellow = true;
                Snackbar.make(v, "Colour was set to Yellow," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "Yellow is clicked");
                break;

            case R.id.ib_Orange:
                Orange = true;
                Snackbar.make(v, "Colour was set to Orange," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "Orange is clicked");
                break;

            case R.id.ib_Red:
                Red = true;
                Snackbar.make(v, "Colour was set to Red," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData();
                Log.d(TAG, "onClick: " + "Red is clicked");
                break;
        }
    }

    public void moveData() {
        Intent intent = new Intent(BackgroundColours.this, MainActivity.class);
        intent.putExtra("red", Red);
        intent.putExtra("blue", Blue);
        intent.putExtra("orange", Orange);
        intent.putExtra("yellow", Yellow);
        intent.putExtra("green", Green);
        intent.putExtra("grey", Grey);
        intent.putExtra("light green", LTGreen);
        startActivity(intent);
    }
}
