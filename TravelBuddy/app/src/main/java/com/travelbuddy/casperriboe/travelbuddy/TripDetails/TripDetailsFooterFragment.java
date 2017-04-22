package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.travelbuddy.casperriboe.travelbuddy.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.Trip;

import java.util.ArrayList;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsFooterFragment extends Fragment {

    private ListView beaconListView;
    private ArrayAdapter<Beacon> beaconListViewAdapter;
    private ArrayList<Beacon> beaconList;

    public TripDetailsFooterFragment() {
    }

    public static TripDetailsFooterFragment newInstance() {
        return new TripDetailsFooterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tripdetails_footer, container, false);
        System.out.println(getActivity());

        try {
            TripDetailsActivity activity = (TripDetailsActivity) getActivity();
            Trip tripFromActivity = activity.getTrip();
            beaconList = tripFromActivity.getBeacons();
        } catch (Exception e) {
            e.printStackTrace();
            getActivity().finish();
        }

        findUIElements(rootView);
        setUIStyles();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    private void findUIElements(View view) {
        beaconListView = (ListView) view.findViewById(R.id.BEACON_LIST);
        beaconListViewAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, beaconList);
        beaconListView.setAdapter(beaconListViewAdapter);
    }

    private void setUIStyles() {
    }

    private void updateUI() {
        beaconListViewAdapter.notifyDataSetChanged();
    }

}
