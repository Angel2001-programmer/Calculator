package com.timbuchalka.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.timbuchalka.calculator.databinding.ActivityBackgroundColoursBinding;
import com.timbuchalka.calculator.databinding.ActivityMainBinding;

public class BackgroundColours extends AppCompatActivity {
    ActivityBackgroundColoursBinding binding;
    private static final String TAG = "BackgroundColours";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityBackgroundColoursBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_background_colours);
        View view = binding.getRoot();
        setContentView(view);

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        binding.confirmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.imgv_pattle_blue:
                        Log.d(TAG, "Blue pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_grey:
                        Log.d(TAG, "Grey pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_green:
                        Log.d(TAG, "Green pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_red:
                        Log.d(TAG, "Red pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_orange:
                        Log.d(TAG, "Orange pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_yellow:
                        Log.d(TAG, "Yellow pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_purple:
                        Log.d(TAG, "Purple pattle: " + "was clicked.");
                        break;

                    case R.id.imgv_pattle_ltgreen:
                        Log.d(TAG, "light Green pattle: " + "was clicked.");
                        break;
                }
            }
        });

    }

}
