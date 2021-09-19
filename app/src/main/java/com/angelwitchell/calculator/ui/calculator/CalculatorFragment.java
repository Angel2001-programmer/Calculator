package com.angelwitchell.calculator.ui.calculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelwitchell.calculator.Calculation;
import com.angelwitchell.calculator.DatabaseHelper;
import com.angelwitchell.calculator.R;
import com.angelwitchell.calculator.Utils;
import com.angelwitchell.calculator.databinding.FragmentCalulatorBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Number number;
    int integer, buttonTap;
    DatabaseHelper mDatabaseHelper;
    Calculation mCalculation;
    Boolean Addition = false, Subtraction = false, Multiplication = false, Division = false;
    private FragmentCalulatorBinding binding;
    private String calculation1;
    private String calculation2;
    private String yourFormattedString;
    private double num1, num2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Utils.onActivityCreateSetTheme(requireActivity());
        CalculatorViewModel calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalulatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCalculator;
        calculatorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

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

        assert getParentFragment() != null;
        mDatabaseHelper = new DatabaseHelper(getParentFragment().getContext());
        mCalculation = new Calculation();

        binding.editTextResults.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.editTextResults.removeTextChangedListener(this);

                try {
                    String givenString = s.toString();
                    Long long_Val;
                    if (givenString.contains(",")) {
                        givenString = givenString.replaceAll(",", "");
                    }
                    long_Val = Long.parseLong(givenString);
                    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                    String formattedString = decimalFormat.format(long_Val);
                    binding.editTextResults.setText(formattedString);

                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                binding.editTextResults.addTextChangedListener(this);
                // TODO Auto-generated method stub
            }
        });

        binding.editTextResults.setCursorVisible(false);
        binding.editTextResults.setFocusableInTouchMode(false);
        binding.editTextResults.setFocusable(false);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        String append1 = binding.editTextResults.getText().toString();

        switch (v.getId()) {
            case R.id.btn0:
                binding.editTextResults.append("0");
                break;
            case R.id.btn1:
                binding.editTextResults.append("1");
                break;
            case R.id.btn2:
                binding.editTextResults.append("2");
                break;
            case R.id.btn3:
                binding.editTextResults.append("3");
                break;
            case R.id.btn4:
                binding.editTextResults.append("4");
                break;
            case R.id.btn5:
                binding.editTextResults.append("5");
                break;
            case R.id.btn6:
                binding.editTextResults.append("6");
                break;
            case R.id.btn7:
                binding.editTextResults.append("7");
                break;
            case R.id.btn8:
                binding.editTextResults.append("8");
                break;
            case R.id.btn9:
                binding.editTextResults.append("9");
                break;
            case R.id.btnDot:
                if (append1.matches("")) {
                    binding.editTextResults.append("0.");
                } else {
                    binding.editTextResults.append(".");
                }

                break;
            case R.id.btnAC:
                binding.editTextResults.setText("");
                String append2;
                calculation1 = null;
                calculation2 = null;
                binding.btnAdd.setEnabled(true);
                binding.btnMinus.setEnabled(true);
                binding.btnDivide.setEnabled(true);
                binding.btnMultiply.setEnabled(true);

                Snackbar.make(v, "Calculator is reset.",
                        Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.btnAdd:
                if (buttonTap == 0) {
                    buttonTap = 2;
                    getNumberFromText(append1);
                    Addition = true;
                    Log.d(TAG, "Value1: " + append1);
                } else if (buttonTap == 2) {
                    buttonTap = 0;
                    append2 = binding.editTextResults.getText().toString();
                    try {
                        num2 = Float.parseFloat(getDoubleFromString1(append2) + "");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    calculation2 = append2;
                    Log.d(TAG, "Value2: " + append2);
                    calLogic();
                }
                break;

            case R.id.btnMinus:
                if (buttonTap == 0) {
                    buttonTap = 2;
                    getNumberFromText(append1);
                    Subtraction = true;
                    Log.d(TAG, "Value1: " + append1);
                } else if (buttonTap == 2) {
                    buttonTap = 0;
                    append2 = binding.editTextResults.getText().toString();
                    try {
                        num2 = Float.parseFloat(getDoubleFromString1(append2) + "");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    calculation2 = append2;
                    Log.d(TAG, "Value2: " + append2);
                    calLogic();
                }
                break;

            case R.id.btnMultiply:
                if (buttonTap == 0) {
                    buttonTap = 2;
                    getNumberFromText(append1);
                    Multiplication = true;
                    Log.d(TAG, "Value1: " + append1);
                } else if (buttonTap == 2) {
                    buttonTap = 0;
                    append2 = binding.editTextResults.getText().toString();
                    try {
                        num2 = Float.parseFloat(getDoubleFromString1(append2) + "");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    calculation2 = append2;
                    Log.d(TAG, "Value2: " + append2);
                    calLogic();
                }

                break;

            case R.id.btnDivide:
                if (buttonTap == 0) {
                    buttonTap = 2;
                    getNumberFromText(append1);
                    Division = true;
                    Log.d(TAG, "Value1: " + append1);
                } else if (buttonTap == 2) {
                    buttonTap = 0;
                    append2 = binding.editTextResults.getText().toString();
                    try {
                        num2 = Float.parseFloat(getDoubleFromString1(append2) + "");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    calculation2 = append2;
                    Log.d(TAG, "Value2: " + append2);
                    calLogic();
                }
                break;

            case R.id.btnEquals:
                if (append1.isEmpty()) {
                    binding.editTextResults.setText("0");
                }

                append2 = binding.editTextResults.getText().toString();
                try {
                    num2 = Float.parseFloat(getDoubleFromString1(append2) + "");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                calculation2 = append2;
                Log.d(TAG, "Value2: " + append2);
                calLogic();
                break;

            default:
                Log.d(TAG, "onClick: button is not valid");
                Snackbar.make(v, "Please reset button and redo calculation.",
                        Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    private void calLogic() {
        double sum;
        String result;
        if (Addition) {
            sum = num1 += num2;
            result = String.valueOf(sum);
            convertNumber(result);
            Addition = false;
            Log.d(TAG, "calLogic: Subtraction " + false);

            if (sum == (int) sum) {
                checkInteger(result, sum);
                String calculation = calculation1 + " + " + calculation2 + " = " + yourFormattedString;
                database(calculation);

            } else {
                setText(result);
                String calculation = calculation1 + " + " + calculation2 + " = " + result;
                database(calculation);

            }

        } else if (Subtraction) {
            sum = num1 -= num2;
            result = String.valueOf(sum);
            convertNumber(result);
            Subtraction = false;
            Log.d(TAG, "calLogic: Subtraction " + false);

            if (sum == (int) sum) {
                checkInteger(result, sum);
                String calculation = calculation1 + " - " + calculation2 + " = " + yourFormattedString;
                database(calculation);
            } else {
                setText(result);
                String calculation = calculation1 + " - " + calculation2 + " = " + result;
                database(calculation);
            }

        } else if (Multiplication) {
            sum = num1 *= num2;
            result = String.valueOf(sum);
            convertNumber(result);
            Multiplication = false;
            Log.d(TAG, "calLogic: Multiplication " + false);

            if (sum == (int) sum) {
                checkInteger(result, sum);
                String calculation = calculation1 + " X " + calculation2 + " = " + yourFormattedString;
                database(calculation);
            } else {
                setText(result);
                String calculation = calculation1 + " X " + calculation2 + " = " + result;
                database(calculation);
            }

        } else if (Division) {
            sum = num1 / num2;
            result = String.valueOf(sum);
            convertNumber(result);
            Division = false;
            Log.d(TAG, "calLogic: Division " + false);

            if (sum == (int) sum) {
                checkInteger(result, sum);
                String calculation = calculation1 + " ÷ " + calculation2 + " = " + yourFormattedString;
                database(calculation);
            } else {
                setText(result);
                String calculation = calculation1 + " ÷ " + calculation2 + " = " + result;
                database(calculation);
                onPause();
            }
        }
    }

    private double getDoubleFromString1(String append2) throws ParseException {
        String new_value1 = append2.replace(",", "");
        NumberFormat formatException = NumberFormat.getInstance(Locale.getDefault());
        number = formatException.parse(new_value1);
        assert number != null;
        return number.doubleValue();
    }

    private double getDoubleFromString2(String result) throws ParseException {
        String new_value2 = result.replace(",", "");
        NumberFormat formatException = NumberFormat.getInstance(Locale.getDefault());
        number = formatException.parse(new_value2);
        assert number != null;
        return number.doubleValue();
    }

    public void getNumberFromText(String append1) {
        try {
            num1 = Float.parseFloat(getDoubleFromString1(append1) + "");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calculation1 = append1;
        binding.editTextResults.setText("");
    }

    public void convertNumber(String result) {
        Log.d(TAG, "Value2: " + result);
        try {
            double realNumber = getDoubleFromString2(result);
            Log.d(TAG, "Value2: " + realNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setText(String result) {
        Log.d(TAG, "is odd: " + result);
        binding.editTextResults.setText(result);
    }

    public void checkInteger(String result, double sum) {
        DecimalFormat format = new DecimalFormat("###,###,###");
        yourFormattedString = format.format(sum);

        integer = (int) Math.round(Float.parseFloat(result));
        Log.d(TAG, "is even: " + yourFormattedString);
        binding.editTextResults.setText(String.valueOf(integer));
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData) {
            Log.d(TAG, "AddData: " + "Data Successfully Inserted!");
        } else {
            Log.d(TAG, "AddData: " + "Something went wrong");
        }
    }

    public void database(String calculation) {
        mCalculation.setname(calculation);
        if (calculation.length() != 0) {
            AddData(calculation);
        } else {
            Log.d(TAG, "database: " + "Textfield is empty");
        }

        Log.d(TAG, "Calculation: " + calculation);
    }
}