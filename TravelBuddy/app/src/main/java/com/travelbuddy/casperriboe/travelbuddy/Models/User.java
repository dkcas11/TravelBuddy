package com.travelbuddy.casperriboe.travelbuddy.Models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Casper on 22-04-2017.
 */

public class User extends RealmObject {

    private String name = "";
    private Double balance = 0.0;
    private RealmList<Trip> trips = new RealmList<>();

    /**
     * Creates an empty User (used by Realm).
     */
    public User () {
    }

    /**
     * Returns the name of the user.
     * @return the name of the user.
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Returns the name of the user.
     * @return the name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the balance of the user.
     * @return the balance of the user.
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the user.
     * @param balance the balance of the user.
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * The trips of the user.
     * @return the trips of the user.
     */
    public RealmList<Trip> getTrips() {
        return trips;
    }

    /**
     * Sets the trips of the user.
     * @param trips the trips of the user.
     */
    public void setTrips(RealmList<Trip> trips) {
        this.trips = trips;
    }

    /**
     * Adds a trip to the trips list.
     * @param trip the trip to add to the trip list.
     */
    public void addTrip(Trip trip) {
        trips.add(trip);
    }
}
