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
    private ArrayList<Trip>tripList = new ArrayList<>();

    /**
     * The public constructor of the ProfileFooterFragment.
     * Currently does nothing.
     */
    public ProfileFooterFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_profile_footer, container, false);

        fetchTrips();
        findUIElements(rootView);
        setUserVisibleHint(true);

        return rootView;
    }

    /**
     * Resumes the fragment and invalidates the view.
     */
    @Override
    public void onResume() {
        super.onResume();

        invalidate();
    }

    /**
     * Finds all UI Elements and connects them to the fragment's fields.
     * @param view The view to connect to.
     */
    private void findUIElements(View view) {
        tripsListView = (ListView) view.findViewById(R.id.TRIP_LIST);
        tripsListViewAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, tripList);
        tripsListView.setAdapter(tripsListViewAdapter);

        tripsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Activity curActivity = getActivity();

                Intent newIntent = new Intent(curActivity, TripDetailsActivity.class);
                newIntent.putExtra("tripDetailsID", position);
                curActivity.startActivity(newIntent);
            }
        });
    }

    /**
     * Retrieves the current data in the database and updates the view.
     */
    public void invalidate() {
        fetchTrips();
        updateUI();
        System.out.println("PROFILE FOOTER WAS INVALIDATED");
    }

    /**
     * Updates the view.
     */
    private void updateUI() {
        // For some reason notifyDataChanged doesn't work, so a new adapter is just created instead.
        tripsListViewAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, tripList);
        tripsListView.setAdapter(tripsListViewAdapter);
    }

    /**
     * Updates the data to the current data in the database.
     */
    private void fetchTrips() {
        tripList = RealmManager.getInstance().getTripsAsArrayList();
    }
}
