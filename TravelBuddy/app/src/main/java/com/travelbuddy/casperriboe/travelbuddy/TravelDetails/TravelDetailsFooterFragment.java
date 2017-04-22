package com.travelbuddy.casperriboe.travelbuddy.TravelDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.travelbuddy.casperriboe.travelbuddy.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.Profile.ProfileFooterFragment;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;
import com.travelbuddy.casperriboe.travelbuddy.Trip;

import java.util.ArrayList;

/**
 * Created by Casper on 21/04/2017.
 */

public class TravelDetailsFooterFragment extends Fragment {

    private ListView beaconListView;
    private ArrayAdapter<Beacon> beaconListViewAdapter;
    private ArrayList<Beacon> beaconList;
    private Beacon beacon;

    public TravelDetailsFooterFragment() {
    }

    public static TravelDetailsFooterFragment newInstance() {
        return new TravelDetailsFooterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_traveldetails_footer, container, false);

        beaconList = new ArrayList<>();
        Beacon beacon = new Beacon(5,1561);
        Trip trip = new Trip(beacon);
        beaconList.add(beacon);
        beaconList.add(beacon);
        beaconList.add(beacon);

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
