package com.travelbuddy.casperriboe.travelbuddy;

import com.travelbuddy.casperriboe.travelbuddy.Models.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;
import com.travelbuddy.casperriboe.travelbuddy.Models.User;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by Casper on 22-04-2017.
 */

public class RealmManager  {

    public static User getUser() {
        // Create a new user
        User user = new User();
        user.setName("John Doe");
        user.setBalance(42.0);

        // Create a new trip
        Trip trip = new Trip();
        trip.setIdentifier(0);

        // Create a start, middle and end beacon
        Beacon sBeacon = new Beacon();
        sBeacon.setMajor(5);
        sBeacon.setMinor(1561);

        Beacon mBeacon = new Beacon();
        mBeacon.setMajor(4);
        mBeacon.setMinor(4181);

        Beacon eBeacon = new Beacon();
        eBeacon.setMajor(3);
        eBeacon.setMinor(3121);

        // Add the beacons to the trip
        trip.setStartBeacon(sBeacon);
        trip.addBeacon(mBeacon);
        trip.setEndBeacon(eBeacon);
        trip.setPrice(420.0);

        user.addtrip(trip);

        return user;

        /*
        RealmResults<User> results = Realm.getDefaultInstance().where(User.class).findAll();
        try {
            if (!results.isEmpty()) {
                return results.first();
            } else {
                throw(new NullPointerException());
            }
        } catch (Exception e) {
            User user = new User();
            setUser(user);
            return user;
        }*/
    }

    public static void setUser(User user) {
        final User finalUser = user;
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.createObject(User.class);
                user.setName(finalUser.getName());
                user.setBalance(finalUser.getBalance());
                user.setTrips(finalUser.getTrips());
            }
        });

    }

    public static Trip getTripByID(int id) {
        return new Trip();
    }

    public static ArrayList<Trip> getTrips() {
        try {
            return getUser().getTripsAsArrayList();
        } catch (Exception e) {
            return new ArrayList<Trip>();
        }
    }

    public static void setTrips(ArrayList<Trip> trips) {
        trips = trips;
    }
}
