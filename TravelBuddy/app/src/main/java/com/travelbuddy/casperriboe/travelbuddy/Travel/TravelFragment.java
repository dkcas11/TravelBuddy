package com.travelbuddy.casperriboe.travelbuddy.Travel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.travelbuddy.casperriboe.travelbuddy.Models.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.R;

/**
 * Created by Casper on 20/04/2017.
 */

public class TravelFragment extends Fragment {

    private Button checkinButton;
    private TextView locationNameTextView;

    private Boolean travelActive = false;

    public TravelFragment() {
    }

    public static TravelFragment newInstance() {
        return new TravelFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_travel, container, false);

        findUIElements(rootView);
        setUIStyles();

        return rootView;
    }

    private void findUIElements(View view) {
        locationNameTextView = (TextView) view.findViewById(R.id.LOCATION_NAME);
        checkinButton = (Button) view.findViewById(R.id.CHECKIN_BUTTON);
        checkinButton.setBackgroundResource(R.color.flatui_emerald);
        checkinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                travelActive = !travelActive;
                if (travelActive) {
                    System.out.println("Switching to red");
                    checkinButton.setBackgroundResource(R.color.flatui_pomegranate);
                } else {
                    System.out.println("Switching to green");
                    checkinButton.setBackgroundResource(R.color.flatui_emerald);
                }
            }
        });
    }

    private void setUIStyles() {
        locationNameTextView.setText("" + new Beacon(5, 1561));
    }
}