package com.timbuchalka.calculator.ui.settings;

import static android.content.Context.MODE_PRIVATE;

import static com.timbuchalka.calculator.Utils.THEME_DEFAULT;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;
import com.timbuchalka.calculator.BackgroundColours;
import com.timbuchalka.calculator.MainActivity;
import com.timbuchalka.calculator.R;
import com.timbuchalka.calculator.Utils;
import com.timbuchalka.calculator.databinding.FragmentSettingsBinding;

import java.util.Objects;

public class SettingsFragment extends Fragment {

    private SettingsViewModel SettingsViewModel;
    private FragmentSettingsBinding binding;
    private static final String TAG = "SettingsFragment";
    boolean NightMode = false;
    SharedPreferences mSharedPreferences = null;
    boolean saveState = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSettings;
        SettingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        mSharedPreferences = getActivity().getSharedPreferences("night", 0);
        saveState = mSharedPreferences.getBoolean("night_mode", false);
        if (saveState) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            binding.switchNightmode.setChecked(true);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            binding.switchNightmode.setChecked(false);

        }

        binding.switchNightmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    binding.switchNightmode.setChecked(true);
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putBoolean("night_mode", true);
                    editor.apply();
                    requireActivity().recreate();

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    binding.switchNightmode.setChecked(false);
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putBoolean("night_mode", false);
                    editor.apply();
                    requireActivity().recreate();
                    if (saveState) {
                        Utils.changeToTheme(getActivity(), Utils.THEME_DEFAULT);
                    }
                }
            }
        });

        binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSharedPreferences = getActivity().getSharedPreferences("night", 0);
                Boolean saveState = mSharedPreferences.getBoolean("night_mode", true);
                if (saveState) {
                    Snackbar.make(v, "Background button cannot be clicked because, " + "\n you enabled darkmode.",
                            Snackbar.LENGTH_LONG)
                            .show();
                } else {

                    Intent intent = new Intent(getActivity(), BackgroundColours.class);
                    startActivity(intent);
                }
            }
        });

        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("saveState", saveState);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}