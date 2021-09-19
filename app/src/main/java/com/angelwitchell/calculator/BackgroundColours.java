package com.angelwitchell.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.angelwitchell.calculator.databinding.ActivityBackgroundColoursBinding;
import com.google.android.material.snackbar.Snackbar;

public class BackgroundColours extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "BCFragment";
    ActivityBackgroundColoursBinding binding;
    boolean Blue = false, Red = false, Yellow = false, Green = false, LTGreen = false,
            Orange = false, Grey = false, Purple = false, original = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBackgroundColoursBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        Utils.onActivityCreateSetTheme(this);
        setContentView(view);

        Red = getIntent().getBooleanExtra("red", false);

        binding.ibBlue.setOnClickListener(this);
        binding.ibPurple.setOnClickListener(this);
        binding.ibGreen.setOnClickListener(this);
        binding.ibGrey.setOnClickListener(this);
        binding.ibLTGreen.setOnClickListener(this);
        binding.ibOrange.setOnClickListener(this);
        binding.ibRed.setOnClickListener(this);
        binding.ibYellow.setOnClickListener(this);
        binding.confirmBTN.setOnClickListener(this);
        binding.resetBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ib_Blue:

                Blue = true;
                Red = false;
                Green = false;
                Orange = false;
                Yellow = false;
                Grey = false;
                LTGreen = false;
                Purple = false;
                original = false;

                Snackbar.make(v, "Colour blue was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Blue + "Blue is clicked");

                break;

            case R.id.ib_Green:

                Green = true;
                Blue = false;
                Red = false;
                Orange = false;
                Yellow = false;
                Grey = false;
                LTGreen = false;
                Purple = false;
                original = false;
                Snackbar.make(v, "Colour green was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Green + "Green is clicked");

                break;

            case R.id.ib_Grey:

                Grey = true;
                Blue = false;
                Red = false;
                Green = false;
                Orange = false;
                Yellow = false;
                LTGreen = false;
                Purple = false;
                original = false;
                Snackbar.make(v, "Colour grey was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Grey + "Grey is clicked");

                break;

            case R.id.ib_LTGreen:

                LTGreen = true;
                Blue = false;
                Red = false;
                Green = false;
                Orange = false;
                Yellow = false;
                Grey = false;
                Purple = false;
                original = false;
                Snackbar.make(v, "Colour light green was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + LTGreen + "LTGreen is clicked");

                break;

            case R.id.ib_Yellow:
                Yellow = true;
                Blue = false;
                Red = false;
                Green = false;
                Orange = false;
                Grey = false;
                LTGreen = false;
                Purple = false;
                original = false;
                Snackbar.make(v, "Colour yellow was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Yellow + "Yellow is clicked");

                break;

            case R.id.ib_Orange:

                Orange = true;
                Blue = false;
                Red = false;
                Green = false;
                Yellow = false;
                Grey = false;
                LTGreen = false;
                Purple = false;
                original = false;
                Snackbar.make(v, "Colour orange was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Orange + "Orange is clicked");

                break;

            case R.id.ib_Red:

                Red = true;
                Blue = false;
                Green = false;
                Orange = false;
                Yellow = false;
                Grey = false;
                LTGreen = false;
                Purple = false;
                original = false;
                Snackbar.make(v, "Colour red was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Red + "Red is clicked");

                break;

            case R.id.ib_Purple:
                Purple = true;
                Blue = false;
                Red = false;
                Green = false;
                Orange = false;
                Yellow = false;
                Grey = false;
                LTGreen = false;
                original = false;
                Snackbar.make(v, "Colour purple was selected, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                Log.d(TAG, "onClick: " + Purple + "purple is clicked");

                break;

            case R.id.confirm_BTN:
                moveData();

                break;

            case R.id.reset_BTN:
                Snackbar.make(v, "Colour was reset to original, " + "\n to continue press the confirm button",
                        Snackbar.LENGTH_LONG)
                        .show();
                original = true;
                Red = false;
                Blue = false;
                Green = false;
                Orange = false;
                Yellow = false;
                Grey = false;
                LTGreen = false;
                Purple = false;
                Log.d(TAG, "onClick: " + original + "reset is pressed");

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
        intent.putExtra("purple", Purple);
        intent.putExtra("white", original);
        startActivity(intent);
    }
}
