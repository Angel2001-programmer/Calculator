package com.angelwitchell.calculator.ui.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.angelwitchell.calculator.AboutSection;
import com.angelwitchell.calculator.BackgroundColours;
import com.angelwitchell.calculator.MainActivity;
import com.angelwitchell.calculator.Utils;
import com.angelwitchell.calculator.databinding.FragmentSettingsBinding;
import com.google.android.material.snackbar.Snackbar;

public class SettingsFragment extends Fragment {

    SharedPreferences mSharedPreferences = null;
    boolean saveState = false;
    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.angelwitchell.calculator.ui.settings.SettingsViewModel settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        settingsViewModel.getText().observe(getViewLifecycleOwner(), s -> {
        });

        mSharedPreferences = requireActivity().getSharedPreferences("night", 0);
        saveState = mSharedPreferences.getBoolean("night_mode", false);
        if (saveState) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            binding.switchNightmode.setChecked(true);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            binding.switchNightmode.setChecked(false);

        }

        binding.switchNightmode.setOnCheckedChangeListener((buttonView, isChecked) -> {
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
                    Utils.changeToTheme(requireActivity(), Utils.THEME_DEFAULT);
                }
            }
        });

        binding.textView.setOnClickListener(v -> {
            mSharedPreferences = requireContext().getSharedPreferences("night", 0);
            boolean saveState = mSharedPreferences.getBoolean("night_mode", false);
            if (saveState) {
                Snackbar.make(v, "Background button cannot be clicked because, " + "\n you enabled darkmode.",
                        Snackbar.LENGTH_LONG)
                        .show();
            } else {

                Intent intent = new Intent(getActivity(), BackgroundColours.class);
                startActivity(intent);
            }
        });

        if (Build.VERSION.SDK_INT > 23) {
            binding.line2.setVisibility(View.VISIBLE);
            binding.textView.setVisibility(View.VISIBLE);
        } else {
            binding.line2.setVisibility(View.INVISIBLE);
            binding.textView.setVisibility(View.INVISIBLE);
        }

        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtra("saveState", saveState);

        binding.tvAbout.setOnClickListener(v -> {
            Intent intent1 = new Intent(getActivity(), AboutSection.class);
            startActivity(intent1);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}