package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsActivity extends AppCompatActivity {

    public TripDetailsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_tripdetails);
    }

    public Trip getTrip() {
        int tripID = getIntent().getIntExtra("tripDetailsID", 0);
        return RealmManager.getTripByID(tripID);
    }

}
