package com.travelbuddy.casperriboe.travelbuddy;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Casper on 22-04-2017.
 */

public class RealmManager  {

    // The DB that others retrieve
    private static User user = new User("John Doe", 42.0, new ArrayList<Trip>());
    private static ArrayList<Trip> trips = new ArrayList<Trip>();

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        user = user;
    }

    public static Trip getTripByID(int id) {
        return new Trip(new Beacon(0,0));
    }

    public static ArrayList<Trip> getTrips() {
        return trips;
    }

    public static void setTrips(ArrayList<Trip> trips) {
        trips = trips;
    }
}
