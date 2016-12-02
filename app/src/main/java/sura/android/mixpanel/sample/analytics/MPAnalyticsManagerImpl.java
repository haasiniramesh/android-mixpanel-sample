package sura.android.mixpanel.sample.analytics;

import android.app.Application;
import android.util.Log;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

import sura.android.mixpanel.sample.pref.MPPreferenceUtils;

import static sura.android.mixpanel.sample.analytics.MixpanelConfig.MIXPANEL_TOKEN;

/**
 * Created by anandhar on 11/6/16.
 */

public class MPAnalyticsManagerImpl implements AnalyticsManager {
    private static final String TAG = MPAnalyticsManagerImpl.class.getSimpleName();
    private static final String COUNT_FOREGROUND = "# of App Opened";
    private static final String KEY_FIRST_VISIT = "First Visit";
    private static final String APP_OPEN = "App Open";

    private Application app;
    private MixpanelAPI mMixpanelAPI;

    public MPAnalyticsManagerImpl(Application app) {
        this.app = app;
        this.mMixpanelAPI = MixpanelAPI.getInstance(app, MIXPANEL_TOKEN);
    }

    @Override
    public void trackAppOpenEvent() {
        JSONObject prop = null;
        int appOpenCount = MPPreferenceUtils.getAppOpenAcount(app) + 1;
        try {
            prop = new JSONObject();
            prop.put(COUNT_FOREGROUND, appOpenCount);
            if (appOpenCount == 1) {
                prop.put(KEY_FIRST_VISIT, true);
            } else {
                prop.put(KEY_FIRST_VISIT, false);
            }
        } catch (JSONException e) {
            Log.e(TAG, "registerAppEnter app super property failed !!!", e);
        }

        mMixpanelAPI.registerSuperProperties(prop);

        mMixpanelAPI.track(APP_OPEN, prop);

        MPPreferenceUtils.incrementAppOpenCount(app);
    }
}
