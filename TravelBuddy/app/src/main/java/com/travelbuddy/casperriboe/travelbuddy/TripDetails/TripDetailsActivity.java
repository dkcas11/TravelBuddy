package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsActivity extends AppCompatActivity {

    /**
     * The public constructor of the TripDetailsActivity.
     * Currently does nothing.
     */
    public TripDetailsActivity() {
    }

    /**
     * Creates a new view of of the activity.
     * @param savedInstanceState
     * @return the view of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.fragment_tripdetails);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /**
     * Returns the trip selected from the trip list in the ProfileFragmentFooter.
     * @return the trip selected from the trip list in the ProfileFragmentFooter.
     */
    public Trip getTrip() {
        int tripID = getIntent().getIntExtra("tripDetailsID", 0);
        try {
            return RealmManager.getInstance().getTripsAsArrayList().get(tripID);
        } catch (Exception e) {
            e.printStackTrace();
            return new Trip();
        }
    }

}
