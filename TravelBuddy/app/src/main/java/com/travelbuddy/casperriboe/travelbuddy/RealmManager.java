package com.travelbuddy.casperriboe.travelbuddy;

import com.travelbuddy.casperriboe.travelbuddy.Models.Beacon;
import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;
import com.travelbuddy.casperriboe.travelbuddy.Models.User;

import java.util.ArrayList;

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
        return new Trip(new Beacon(5,1561));
    }

    public static ArrayList<Trip> getTrips() {
        return trips;
    }

    public static void setTrips(ArrayList<Trip> trips) {
        trips = trips;
    }
}
