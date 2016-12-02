package sura.android.mixpanel.sample;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import sura.android.mixpanel.sample.analytics.AnalyticsModule;

/**
 * Created by anandhar on 12/2/16.
 */

@Module(
        injects = {
                App.class
        },
        includes = {
                AnalyticsModule.class,
        }
)
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public Application provideApplication() {
        return this.app;
    }
}
