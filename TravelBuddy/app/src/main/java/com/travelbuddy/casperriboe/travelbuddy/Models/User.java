package com.travelbuddy.casperriboe.travelbuddy.Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
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
        return trips;
    }

    public ArrayList<Trip> getTripsAsArrayList() {
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
        if (trips == null) {
            trips = new RealmList<>();
        }
        trips.add(trip);
    }
}
