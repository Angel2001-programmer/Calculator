package com.timbuchalka.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.timbuchalka.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
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

    private String append2;
    private double num1;
    private double num2;

    Boolean Addition = false, Subtraction = false, Multiplication = false, Division = false;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btn0.setOnClickListener(this);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn7.setOnClickListener(this);
        binding.btn8.setOnClickListener(this);
        binding.btn9.setOnClickListener(this);
        binding.btnDot.setOnClickListener(this);
        binding.btnAC.setOnClickListener(this);

        binding.btnAdd.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnMultiply.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String append1 = binding.tvResults.getText().toString();

        switch (v.getId()) {
            case R.id.btn0:
                binding.tvResults.append("0");
                break;
            case R.id.btn1:
                binding.tvResults.append("1");
                break;
            case R.id.btn2:
                binding.tvResults.append("2");
                break;
            case R.id.btn3:
                binding.tvResults.append("3");
                break;
            case R.id.btn4:
                binding.tvResults.append("4");
                break;
            case R.id.btn5:
                binding.tvResults.append("5");
                break;
            case R.id.btn6:
                binding.tvResults.append("6");
                break;
            case R.id.btn7:
                binding.tvResults.append("7");
                break;
            case R.id.btn8:
                binding.tvResults.append("8");
                break;
            case R.id.btn9:
                binding.tvResults.append("9");
                break;
            case R.id.btnDot:
                binding.tvResults.append(".");
                break;
            case R.id.btnAC:
                binding.tvResults.setText("");
                append2 = "";
                Snackbar.make(v, "Calculator is reset.",
                        Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.btnAdd:
                num1 = Double.parseDouble(append1);
                binding.tvResults.setText("");
                Addition = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnMinus:
                num1 = Double.parseDouble(append1);
                binding.tvResults.setText("");
                Subtraction = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnMultiply:
                num1 = Double.parseDouble(append1);
                binding.tvResults.setText("");
                Multiplication = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnDivide:
                num1 = Float.parseFloat(append1);
                binding.tvResults.setText("");
                Division = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnEquals:
                append2 = binding.tvResults.getText().toString();
                num2 = Double.parseDouble(append2);
                Log.d(TAG, "Value2: " + append2);
                calLogic();
                break;

            default:
                Log.d(TAG, "onClick: button is not vaild");
                Snackbar.make(v, "Please reset button and redo calculation.",
                        Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    private void calLogic() {
        double sum;
        if (Addition) {
            sum = num1 += num2;
            String result = String.valueOf(sum);
            binding.tvResults.setText(result);
            Log.d(TAG, "Value2: " + result);
            Addition = false;
            Log.d(TAG, "calLogic: Addition " + false);

            if (sum == (int) sum) {
                int integer = (int) Math.round(Float.parseFloat(result));
                Log.d(TAG, "is even: " + integer);
                binding.tvResults.setText(String.valueOf(integer));
            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
            }

        } else if (Subtraction) {
            sum = num1 -= num2;
            String result = String.valueOf(sum);
            binding.tvResults.setText(result);
            Log.d(TAG, "Value2: " + result);
            Subtraction = false;
            Log.d(TAG, "calLogic: Subtraction " + false);

            if (sum == (int) sum) {
                int integer = (int) Math.round(Float.parseFloat(result));
                Log.d(TAG, "is even: " + integer);
                binding.tvResults.setText(String.valueOf(integer));
            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
            }

        } else if (Multiplication) {
            sum = num1 *= num2;
            String result = String.valueOf(sum);
            Log.d(TAG, "Value2: " + result);
            Multiplication = false;
            Log.d(TAG, "calLogic: Multiplication " + false);

            if (sum == (int) sum) {
                int integer = (int) Math.round(Float.parseFloat(result));
                Log.d(TAG, "is even: " + integer);
                binding.tvResults.setText(String.valueOf(integer));
            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
            }

        } else if (Division) {
            num2 = Float.parseFloat(append2);
            sum = num1 / num2;
            String result = String.valueOf(sum);
            Log.d(TAG, "Value2: " + result);
            Division = false;
            Log.d(TAG, "calLogic: Division " + false);

            if (sum == (int) sum) {
                int integer = (int) Math.round(Float.parseFloat(result));
                Log.d(TAG, "is even: " + integer);
                binding.tvResults.setText(String.valueOf(integer));
            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
            }
        }
    }
}