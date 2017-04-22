package com.travelbuddy.casperriboe.travelbuddy.TravelDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.travelbuddy.casperriboe.travelbuddy.R;

/**
 * Created by Casper on 21/04/2017.
 */

public class TravelDetailsHeaderFragment extends Fragment {

    TextView locationStartTextView;
    TextView locationEndTextView;
    TextView priceTextView;

    public TravelDetailsHeaderFragment() {
    }

    public static TravelDetailsHeaderFragment newInstance() {
        return new TravelDetailsHeaderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_traveldetails_header, container, false);

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

}
