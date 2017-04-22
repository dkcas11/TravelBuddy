package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.Trip;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsHeaderFragment extends Fragment {

    private Trip trip;
    private TextView locationStartTextView;
    private TextView locationEndTextView;
    private TextView priceTextView;

    public TripDetailsHeaderFragment() {
    }

    public static TripDetailsHeaderFragment newInstance() {
        return new TripDetailsHeaderFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tripdetails_header, container, false);

        try {
            TripDetailsActivity activity = (TripDetailsActivity) getActivity();
            trip = activity.getTrip();
        } catch (Exception e) {
            e.printStackTrace();
            getActivity().finish();
        }

        findUIElements(rootView);
        setUIStyles();

        return rootView;
    }

    private void findUIElements(View view) {
        locationStartTextView = (TextView) view.findViewById(R.id.LOCATION_START);
        locationEndTextView = (TextView) view.findViewById(R.id.LOCATION_END);
        priceTextView = (TextView) view.findViewById(R.id.PRICE);
    }

    private void setUIStyles() {
    }

    private void updateUI() {
        locationStartTextView.setText("From " + trip.getStartBeacon().toString());
        locationEndTextView.setText("To: " + trip.getEndBeacon().toString());
        priceTextView.setText("Price: " + trip.getPrice() + "DKK");
    }

}
