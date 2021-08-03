package com.timbuchalka.calculator.ui.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.timbuchalka.calculator.R;
import com.timbuchalka.calculator.databinding.FragmentCalulatorBinding;
import com.timbuchalka.calculator.Calculation;

public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private CalculatorViewModel calculatorViewModel;
    private FragmentCalulatorBinding binding;

    private String append2;
    private double num1;
    private double num2;
    String calculation1, calculation2;
    //    String result;
    double sum;
    DatabaseReference reference;
    Calculation mCalculation;

    Boolean Addition = false, AdditionEqual = false, Subtraction = false, Multiplication = false, Division = false, Closed = false;
    private static final String TAG = "MainActivity";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculatorViewModel =
                new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalulatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        calculatorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

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

        reference = FirebaseDatabase.getInstance().getReference().child("Calculation");

        mCalculation =new Calculation();
        onResume();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        String append1 = binding.tvResults.getText().toString();
        if(append1 == null){
            Log.d(TAG, "onClick: button is not vaild");
            Snackbar.make(v, "Please reset button and redo calculation.",
                    Snackbar.LENGTH_SHORT).show();
            return;
        }

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
                append2 = null;
                calculation1 = null;
                calculation2 = null;
                Snackbar.make(v, "Calculator is reset.",
                        Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.btnAdd:

                num1 = Double.parseDouble(append1);
                calculation1 = append1;
                binding.tvResults.setText("");
                Addition = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnMinus:
                num1 = Double.parseDouble(append1);
                calculation1 = append1;
                binding.tvResults.setText("");
                Subtraction = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnMultiply:
                num1 = Double.parseDouble(append1);
                calculation1 = append1;
                binding.tvResults.setText("");
                Multiplication = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnDivide:
                num1 = Float.parseFloat(append1);
                calculation1 = append1;
                binding.tvResults.setText("");
                Division = true;
                Log.d(TAG, "Value1: " + append1);
                break;

            case R.id.btnEquals:

                append2 = binding.tvResults.getText().toString();
                num2 = Double.parseDouble(append2);
                calculation2 = append2;
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
            Log.d(TAG, "calLogic: Subtraction " + false);

            if (sum == (int) sum) {
                int integer = (int) Math.round(Float.parseFloat(result));
                Log.d(TAG, "is even: " + integer);
                binding.tvResults.setText(String.valueOf(integer));
                String calculation = calculation1 + " + " + calculation2 + " = " + integer;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");

            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
                String calculation = calculation1 + " + " + calculation2 + " = " + result;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
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
                String calculation = calculation1 + " - " + calculation2 + " = " + integer;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
                String calculation = calculation1 + " - " + calculation2 + " = " + result;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
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
                String calculation = calculation1 + " X " + calculation2 + " = " + integer;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
            } else {
                Log.d(TAG, "is old: " + result);
                binding.tvResults.setText(result);
                String calculation = calculation1 + " X " + calculation2 + " = " + result;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
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
                String calculation = calculation1 + " ÷ " + calculation2 + " = " + integer;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
            } else {
                Log.d(TAG, "is odd: " + result);
                binding.tvResults.setText(result);
                String calculation = calculation1 + " ÷ " + calculation2 + " = " + result;
                Log.d(TAG, "Calculation: " + calculation);

                mCalculation.setValue0(calculation);
                reference.push().setValue(mCalculation);
                Log.d(TAG, "Database: " + CalculatorFragment.this + "data inserted successfully");
                onPause();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: called");
        reference = FirebaseDatabase.getInstance().getReference("Calculation");
        reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d(TAG, "onComplete: " + "Database: data is removed.");
                } else {
                    Log.d(TAG, "onComplete: " + "Database: failed to delete data.");

                }
            }
        });
    }
}