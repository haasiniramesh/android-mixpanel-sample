package sura.android.mixpanel.sample.pref;

import android.content.Context;

import static sura.android.mixpanel.sample.pref.SharedPrefsUtils.getIntegerPreference;

/**
 * Created by anandhar on 12/2/16.
 */

public class MPPreferenceUtils {
    private static final String KEY_APP_OPEN_COUNT = "app_open_count";

    public static int getAppOpenAcount(Context context) {
        return getIntegerPreference(context, KEY_APP_OPEN_COUNT, 0);
    }

    public static void incrementAppOpenCount(Context context) {
        int count = SharedPrefsUtils.getIntegerPreference(context, KEY_APP_OPEN_COUNT, 0);

        SharedPrefsUtils.setIntegerPreference(context, KEY_APP_OPEN_COUNT, count++);
    }

}
