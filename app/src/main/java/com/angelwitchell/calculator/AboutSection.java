package com.angelwitchell.calculator;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.angelwitchell.calculator.databinding.AboutsectionlayoutBinding;
import com.intuit.sdp.BuildConfig;

public class AboutSection extends AppCompatActivity {

    String versionName = BuildConfig.VERSION_NAME;
    private AboutsectionlayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AboutsectionlayoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.aboutVersion.setText(R.string.about_app + versionName);
    }
}
