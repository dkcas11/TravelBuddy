package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;
import com.travelbuddy.casperriboe.travelbuddy.Trip;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsActivity extends AppCompatActivity {

    private Trip trip;

    public TripDetailsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int tripID = getIntent().getIntExtra("tripID", 0);
        trip = RealmManager.getTripByID(tripID);

        setContentView(R.layout.fragment_tripdetails);
    }

    public Trip getTrip() {
        return trip;
    }

}
