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
    public final static int THEME_YellowStyles = 3;
    public final static int THEME_GreyStyles = 4;
    public final static int THEME_OrangeStyles = 5;
    public final static int THEME_GreenStyles = 6;
    public final static int THEME_LightGreenStyles = 7;
    public final static int THEME_PurpleStyles = 8;

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
            case THEME_YellowStyles:
                activity.setTheme(R.style.Theme_YellowStyle);
                break;
            case THEME_GreyStyles:
                activity.setTheme(R.style.Theme_GreyStyle);
                break;
            case THEME_OrangeStyles:
                activity.setTheme(R.style.Theme_OrangeStyle);
                break;
            case THEME_GreenStyles:
                activity.setTheme(R.style.Theme_GreenStyle);
                break;
            case THEME_LightGreenStyles:
                activity.setTheme(R.style.Theme_LightGreenStyle);
                break;
            case THEME_PurpleStyles:
                activity.setTheme(R.style.Theme_PurpleStyle);
                break;
        }
    }
}
