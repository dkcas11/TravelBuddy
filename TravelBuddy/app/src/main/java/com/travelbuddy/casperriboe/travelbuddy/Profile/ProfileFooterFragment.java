package com.travelbuddy.casperriboe.travelbuddy.Profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.travelbuddy.casperriboe.travelbuddy.Models.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;
import com.travelbuddy.casperriboe.travelbuddy.TripDetails.TripDetailsActivity;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;

import java.util.ArrayList;

/**
 * Created by Casper on 21/04/2017.
 */

public class ProfileFooterFragment extends Fragment {

    private ListView tripsListView;
    private ArrayAdapter<Trip> tripsListViewAdapter;
    private ArrayList<Trip> tripList;

    public ProfileFooterFragment() {
    }

    public static ProfileFooterFragment newInstance() {
        return new ProfileFooterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_footer, container, false);

        tripList = RealmManager.getTrips();
        Trip trip = new Trip(new Beacon(0,0));
        tripList.add(trip);
        tripList.add(trip);
        tripList.add(trip);

        findUIElements(rootView);
        setUIStyles();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        fetchTrips();
        updateUI();
    }

    private void findUIElements(View view) {
        tripsListView = (ListView) view.findViewById(R.id.TRIP_LIST);
        tripsListViewAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, tripList);
        tripsListView.setAdapter(tripsListViewAdapter);

        tripsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Trip trip = tripList.get(position);

                Activity curActivity = getActivity();

                Intent newIntent = new Intent(curActivity, TripDetailsActivity.class);
                newIntent.putExtra("tripID", trip.getIdentifier());
                curActivity.startActivity(newIntent);
            }
        });
    }

    private void setUIStyles() {
    }

    private void updateUI() {
        tripList = RealmManager.getTrips();
        tripsListViewAdapter.notifyDataSetChanged();
    }

    private void fetchTrips() {
        tripList = RealmManager.getTrips();
    }

}
