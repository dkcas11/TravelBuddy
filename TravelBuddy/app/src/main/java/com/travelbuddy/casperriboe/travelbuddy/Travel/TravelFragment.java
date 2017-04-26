package com.travelbuddy.casperriboe.travelbuddy.Travel;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Casper on 20/04/2017.
 */

public class TravelFragment extends Fragment {

    private static final String UDID = "E3B54450-AB73-4D79-85D6-519EAF0F45D9"; //"8492E75F-4FD6-469D-B132-043FE94921D8"; Estimote UDID
    private BeaconManager beaconManager;
    private Region region;
    private Button checkinButton;
    private TextView locationNameTextView;
    private Boolean travelActive = false;
    private Beacon nearestBeacon = new Beacon(null, null, 0, 0, 0, 0);
    private Trip currentTrip;

    /**
     * The public constructor of the ProfileFooterFragment.
     * Currently does nothing.
     */
    public TravelFragment() {
    }

    /**
     * Returns a new instance of the TravelFragment.
     * @return the new instance of the TravelFragment.
     */
    public static TravelFragment newInstance() {
        return new TravelFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_travel, container, false);

        findUIElements(rootView);
        setUIStyles();
        startDiscovering();

        return rootView;
    }

    /**
     * Resumes the fragment and starts searching for beacons.
     */
    @Override
    public void onResume() {
        super.onResume();
        startDiscovering();
    }

    /**
     * Pauses the fragment and stops searching for beacons.
     */
    @Override
    public void onPause() {
        super.onPause();
        stopDiscovering();
    }

    /**
     * Finds all UI Elements and connects them to the fragment's fields.
     * @param view The view to connect to.
     */
    private void findUIElements(View view) {
        locationNameTextView = (TextView) view.findViewById(R.id.LOCATION_NAME);
        checkinButton = (Button) view.findViewById(R.id.CHECKIN_BUTTON);

        checkinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convert Estimote Beacon
                com.travelbuddy.casperriboe.travelbuddy.Models.Beacon b = new com.travelbuddy.casperriboe.travelbuddy.Models.Beacon();
                b.setMajor(nearestBeacon.getMajor());
                b.setMinor(nearestBeacon.getMinor());
                try {
                    if (!b.isValidBeacon()) {
                        showNoBeaconsDialog();
                        return;
                    }

                    if (!RealmManager.getInstance().userHasBalance()) {
                        showInvalidBalanceDialog();
                        return;
                    }

                    if (travelActive) {
                        travelActive = false;
                        checkinButton.setText("CHECK IN");

                        // End the current trip, add it to the user and reset currentTrip
                        currentTrip.setEndBeacon(b);
                        RealmManager.getInstance().addTrip(currentTrip);
                        currentTrip = null;
                    } else {
                        travelActive = true;
                        checkinButton.setText("CHECK OUT");

                        // Start a new trip and add the Beacon that was just converted
                        currentTrip = new Trip();
                        currentTrip.setStartBeacon(b);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    showNoBeaconsDialog();
                }
            }
        });
    }

    /**
     * Sets the style of UI elements in the view.
     */
    private void setUIStyles() {
        locationNameTextView.setText("Searching");
    }

    /**
     * Starts searching for beacons and updates the 'nearestBeacon' field
     * and view to display the name of the beacon.
     */
    private void startDiscovering() {
        SystemRequirementsChecker.checkWithDefaultDialogs(this.getActivity());
        beaconManager = new BeaconManager(this.getActivity());
        region = new Region("ITU", UUID.fromString(UDID), null, null);
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
                beaconManager.setRangingListener(new BeaconManager.RangingListener() {
                    @Override
                    public void onBeaconsDiscovered(Region region, List<Beacon> list) {
                        try {
                            nearestBeacon = list.get(0);
                            com.travelbuddy.casperriboe.travelbuddy.Models.Beacon b = new com.travelbuddy.casperriboe.travelbuddy.Models.Beacon();
                            b.setMajor(nearestBeacon.getMajor());
                            b.setMinor(nearestBeacon.getMinor());
                            locationNameTextView.setText(b.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            locationNameTextView.setText("Searching");
                        }
                    }
                });
            }
        });


    }

    /**
     * Stops searching for beacons.
     */
    private void stopDiscovering() {
        beaconManager.stopMonitoring(region);
    }

    /**
     * Shows a Dialog telling the user he/she has insufficient balance to start a trip.
     */
    private void showInvalidBalanceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Error");
        builder.setMessage("You don't have enough balance to start a trip.");

        // Set up the buttons
        builder.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }

    /**
     * Shows a dialog telling the user no beacons are in range.
     */
    private void showNoBeaconsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Error");
        builder.setMessage("No rooms in range. You cannot check in/out without a room.");

        // Set up the buttons
        builder.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }
}