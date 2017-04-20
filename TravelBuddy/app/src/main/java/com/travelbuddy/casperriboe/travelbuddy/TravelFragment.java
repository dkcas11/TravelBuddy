package com.travelbuddy.casperriboe.travelbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Casper on 20/04/2017.
 */

public class TravelFragment extends Fragment {
    public TravelFragment() {
    }

    public static TravelFragment newInstance() {
        return new TravelFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_travel, container, false);

        return rootView;
    }
}