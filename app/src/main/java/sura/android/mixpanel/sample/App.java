package sura.android.mixpanel.sample;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import sura.android.mixpanel.sample.analytics.AnalyticsManager;

/**
 * Created by anandhar on 12/2/16.
 */

public class App extends Application {
    private ObjectGraph objectGraph;
    @Inject
    AnalyticsManager analyticsManager;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

        analyticsManager.trackAppOpenEvent();
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }
}
