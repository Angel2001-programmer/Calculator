package com.timbuchalka.calculator;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_RED_STYLES = 1;
    public final static int THEME_BLUE_STYLES = 2;
    public final static int THEME_YELLOW_STYLES = 3;
    public final static int THEME_GREY_STYLES = 4;
    public final static int THEME_ORANGE_STYLES = 5;
    public final static int THEME_GREEN_STYLES = 6;
    public final static int THEME_LIGHT_GREEN_STYLES = 7;
    public final static int THEME_PURPLE_STYLES = 8;
    public final static int THEME_DARKMODE = 9;

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
            case THEME_RED_STYLES:
                activity.setTheme(R.style.Theme_RedStyle);
                break;
            case THEME_BLUE_STYLES:
                activity.setTheme(R.style.Theme_BlueStyle);
                break;
            case THEME_YELLOW_STYLES:
                activity.setTheme(R.style.Theme_YellowStyle);
                break;
            case THEME_GREY_STYLES:
                activity.setTheme(R.style.Theme_GreyStyle);
                break;
            case THEME_ORANGE_STYLES:
                activity.setTheme(R.style.Theme_OrangeStyle);
                break;
            case THEME_GREEN_STYLES:
                activity.setTheme(R.style.Theme_GreenStyle);
                break;
            case THEME_LIGHT_GREEN_STYLES:
                activity.setTheme(R.style.Theme_LightGreenStyle);
                break;
            case THEME_PURPLE_STYLES:
                activity.setTheme(R.style.Theme_PurpleStyle);
                break;
            case THEME_DARKMODE:
                activity.setTheme(R.style.Theme_MyApplication);
                break;
        }
    }
}
