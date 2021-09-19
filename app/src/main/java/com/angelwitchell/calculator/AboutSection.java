package com.angelwitchell.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.angelwitchell.calculator.databinding.AboutsectionlayoutBinding;
import com.intuit.sdp.BuildConfig;

public class AboutSection extends AppCompatActivity {

    String versionName = BuildConfig.VERSION_NAME;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.angelwitchell.calculator.databinding.AboutsectionlayoutBinding binding = AboutsectionlayoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.aboutVersion.setText(getString(R.string.versionNumber) + " " + versionName);
    }
}
