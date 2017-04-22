package com.travelbuddy.casperriboe.travelbuddy.TravelDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travelbuddy.casperriboe.travelbuddy.R;

/**
 * Created by Casper on 21/04/2017.
 */

public class TravelDetailsFragment extends Fragment {

    public TravelDetailsFragment() {
    }

    public static TravelDetailsFragment newInstance() {
        return new TravelDetailsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_traveldetails, container, false);

        return rootView;
    }

}
