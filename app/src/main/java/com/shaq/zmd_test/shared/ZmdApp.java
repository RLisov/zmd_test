package com.shaq.zmd_test.shared;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ZmdApp extends Application {

    public static ZmdApp get(Context context) {
        return (ZmdApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(getApplicationContext());
        // create your Realm configuration
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("_metadata.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
