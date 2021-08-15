package com.timbuchalka.calculator;

import android.app.Activity;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.timbuchalka.calculator.ui.calculator.CalculatorFragment;

public class Utils {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_RedStyles = 1;
    public final static int THEME_BlueStyles = 2;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.Theme_Calculator);
                break;
            case THEME_RedStyles:
                activity.setTheme(R.style.Theme_RedStyle);
                break;
            case THEME_BlueStyles:
                activity.setTheme(R.style.Theme_BlueStyle);
                break;
        }
    }
}
