package com.timbuchalka.calculator;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.snackbar.Snackbar;
import com.timbuchalka.calculator.databinding.ActivityBackgroundColoursBinding;
import com.timbuchalka.calculator.databinding.ActivityMainBinding;
import com.timbuchalka.calculator.ui.calculator.CalculatorFragment;

public class BackgroundColours extends AppCompatActivity implements View.OnClickListener {
    ActivityBackgroundColoursBinding binding;
    private static final String TAG = "BackgroundColours";
    Boolean buttonEnabled = false, Blue = false, Red = false, Yellow = false, Green = false, LTGreen = false, Orange = false, Grey = false;

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
        binding.confirmBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Resources res = getResources();
        GradientDrawable gradientDrawable;

        switch (v.getId()) {
            case R.id.ib_Blue:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_blue_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Blue," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "Blue is clicked");
                break;

            case R.id.ib_Green:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_green_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Green," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "Green is clicked");
                break;

            case R.id.ib_Grey:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_grey_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Grey," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "Grey is clicked");
                break;

            case R.id.ib_LTGreen:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_ltgreen_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Light Green," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "LTGreen is clicked");
                break;

            case R.id.ib_Yellow:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_yellow_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Yellow," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "Yellow is clicked");
                break;

            case R.id.ib_Orange:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_orange_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Orange," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "Orange is clicked");
                break;

            case R.id.ib_Red:
                gradientDrawable = (GradientDrawable) ResourcesCompat.getDrawable(res, R.drawable.ellipse_red_50, null);
                gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
                binding.cLayout.setBackground(gradientDrawable);
                Snackbar.make(v, "Colour was set to Red," + "\n return to the Calculator section to see the colour.",
                        Snackbar.LENGTH_LONG)
                        .show();
                moveData(gradientDrawable);
                Log.d(TAG, "onClick: " + "Red is clicked");
                break;
        }
    }

    public void moveData(GradientDrawable gradientDrawable) {
        Intent intent = new Intent(BackgroundColours.this, CalculatorFragment.class);
        intent.putExtra("gradientDrawable_01", (Parcelable) gradientDrawable);
        startActivity(intent);
    }
}
