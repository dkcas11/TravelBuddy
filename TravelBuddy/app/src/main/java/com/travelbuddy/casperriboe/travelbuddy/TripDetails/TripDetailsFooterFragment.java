package com.travelbuddy.casperriboe.travelbuddy.TripDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.travelbuddy.casperriboe.travelbuddy.Models.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;

import java.util.ArrayList;

/**
 * Created by Casper on 21/04/2017.
 */

public class TripDetailsFooterFragment extends Fragment {

    private ListView beaconListView;
    private ArrayAdapter<Beacon> beaconListViewAdapter;
    private ArrayList<Beacon> beaconList;

    /**
     * The public constructor of the TripDetailsFooterFragment.
     * Currently does nothing.
     */
    public TripDetailsFooterFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_tripdetails_footer, container, false);
        System.out.println(getActivity());

        try {
            commonInit(rootView);
        } catch (Exception e) {
            e.printStackTrace();
            getActivity().finish();
        }

        return rootView;
    }

    /**
     * A common initialiser.
     * @param view the view to initialise from.
     */
    public void commonInit(View view) {
        TripDetailsActivity activity = (TripDetailsActivity) getActivity();
        Trip tripFromActivity = activity.getTrip();
        beaconList = tripFromActivity.getBeaconsAsArrayList();

        findUIElements(view);
    }

    /**
     * Resumes the view and updates the view.
     */
    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }

    /**
     * Finds all UI Elements and connects them to the fragment's fields.
     * @param view The view to connect to.
     */
    private void findUIElements(View view) {
        beaconListView = (ListView) view.findViewById(R.id.BEACON_LIST);
        beaconListViewAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, beaconList);
        beaconListView.setAdapter(beaconListViewAdapter);
    }

    /**
     * Updates the UI elements.
     */
    private void updateUI() {
        beaconListViewAdapter.notifyDataSetChanged();
    }

}
