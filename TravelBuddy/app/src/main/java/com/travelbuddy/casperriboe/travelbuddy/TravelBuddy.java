package com.travelbuddy.casperriboe.travelbuddy;

import android.app.Application;


import com.estimote.sdk.EstimoteSDK;

import io.realm.Realm;

/**
 * Created by Casper on 24/04/2017.
 */

public class TravelBuddy extends Application {

    /**
     * Initialises the Estimote SDK and the Realm database.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        //  To get your AppId and AppToken you need to create new application in Estimote Cloud.
        String appId = "casper2602-hotmail-com-s-y-8ph";
        String appToken = "bdd4a18599b436827c8af2b56c2e0baa";
        EstimoteSDK.initialize(this, appId, appToken);
        // Optional, debug logging.
        EstimoteSDK.enableDebugLogging(true);

        Realm.init(this);
    }

}
