package com.timbuchalka.calculator.ui.settings;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.timbuchalka.calculator.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private SettingsViewModel SettingsViewModel;
    private FragmentSettingsBinding binding;
    private static final String TAG = "SettingsFragment";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSettings;

        binding.switchNightmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d(TAG, "onCheckedChanged: " + isChecked + "Button enabled");
                } else {
                    Log.d(TAG, "onCheckedChanged: " + isChecked + "Button disabled");
                }
            }
        });

        return root;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}