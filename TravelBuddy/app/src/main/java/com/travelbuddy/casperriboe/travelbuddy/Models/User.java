package com.travelbuddy.casperriboe.travelbuddy.Models;

import java.util.ArrayList;
import java.util.Iterator;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Casper on 22-04-2017.
 */

public class User extends RealmObject {

    @PrimaryKey
    private int identifier;
    private String name;
    private Double balance;
    private RealmList<Trip> trips;

    public User () {
    }

    public User(String name) {
        setName(name);
        setBalance(0.);
        ensureTrips();
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public RealmList<Trip> getTrips() {
        ensureTrips();
        return trips;
    }

    public ArrayList<Trip> getTripsAsArrayList() {
        ensureTrips();
        Iterator i = trips.iterator();
        ArrayList<Trip> rTrips = new ArrayList<>();

        while (i.hasNext()) {
            rTrips.add((Trip) i.next());
        }

        return rTrips;
    }

    public void setTrips(RealmList<Trip> trips) {
        this.trips = trips;
    }

    public void addtrip(Trip trip) {
        ensureTrips();
        trips.add(trip);
    }

    public void ensureTrips() {
        if (trips == null) {
            trips = new RealmList<>();
        }
    }
}
