package sura.android.mixpanel.sample.analytics;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anandhar on 11/6/16.
 */

@Module(
        complete = false,
        library = true
)
public class AnalyticsModule {
    @Provides
    @Singleton
    public AnalyticsManager provideAnalyticsManager(Application app) {
        return new MPAnalyticsManagerImpl(app);
    }
}
