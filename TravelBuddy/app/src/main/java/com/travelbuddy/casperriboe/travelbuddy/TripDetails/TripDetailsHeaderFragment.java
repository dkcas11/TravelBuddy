package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsHeaderFragment extends Fragment {

    private Trip trip;
    private TextView locationStartTextView;
    private TextView locationEndTextView;
    private TextView priceTextView;

    /**
     * The public constructor of the TripDetailsHeaderFragment.
     * Currently does nothing.
     */
    public TripDetailsHeaderFragment() {
    }

    /**
     * Creates a new view of of the fragment.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the view of the fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tripdetails_header, container, false);

        try {
            commonInit(rootView);
        } catch (Exception e) {
            e.printStackTrace();
            getActivity().finish();
        }

        return rootView;
    }

    /**
     * Resumes and updates the view.
     */
    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    /**
     * A common initialiser.
     * @param view the view to initialise from.
     */
    private void commonInit(View view) {
        TripDetailsActivity activity = (TripDetailsActivity) getActivity();
        trip = activity.getTrip();

        findUIElements(view);
    }

    /**
     * Finds all UI Elements and connects them to the fragment's fields.
     * @param view The view to connect to.
     */
    private void findUIElements(View view) {
        locationStartTextView = (TextView) view.findViewById(R.id.LOCATION_START);
        locationEndTextView = (TextView) view.findViewById(R.id.LOCATION_END);
        priceTextView = (TextView) view.findViewById(R.id.PRICE);
    }

    /**
     * Updates the UI elements.
     */
    private void updateUI() {
        locationStartTextView.setText("From " + trip.getStartBeacon().toString());
        locationEndTextView.setText("To " + trip.getEndBeacon().toString());
        priceTextView.setText(trip.getPrice() + " DKK");
    }

}
