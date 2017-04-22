package com.travelbuddy.casperriboe.travelbuddy;

import java.util.ArrayList;

/**
 * Created by Casper on 22-04-2017.
 */

public class User {

    private String name = "";
    private Double balance = 0.0;
    private ArrayList<Trip> trips = new ArrayList<Trip>();

    public User(String name, Double balance, ArrayList<Trip> trips) {
        this.name = name;
        this.balance = balance;
        this.trips = trips;
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

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }
}
