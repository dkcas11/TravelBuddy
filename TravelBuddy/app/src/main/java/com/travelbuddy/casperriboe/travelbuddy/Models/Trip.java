package com.travelbuddy.casperriboe.travelbuddy.Models;

import java.util.ArrayList;
import java.util.Iterator;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Casper on 22-04-2017.
 */

public class Trip extends RealmObject {

    private RealmList<Beacon> beacons = new RealmList<>();
    private Beacon startBeacon = new Beacon();
    private Beacon endBeacon = new Beacon();
    private Double price = 0.0;

    /**
     * Creates an empty Trip (used by Realm).
     */
    public Trip() {
    }

    /**
     * Returns a formatted string that displays the price, start beacon and end beacon of the trip.
     * @return
     */
    @Override
    public String toString() {
        return price + " DKK: From " + startBeacon + " to " + endBeacon;
    }

    /**
     * Returns the beacons of the trip.
     * @return the beacons of the trip
     */
    public RealmList<Beacon> getBeacons() {
        return beacons;
    }

    /**
     * Returns the beacons of the trip converted to an ArrayList.
     * @return the beacons of the trip converted to an ArrayList.
     */
    public ArrayList<Beacon> getBeaconsAsArrayList() {
        Iterator i = beacons.iterator();
        ArrayList<Beacon> rBeacons = new ArrayList<>();

        while (i.hasNext()) {
            rBeacons.add((Beacon) i.next());
        }

        return rBeacons;
    }

    /**
     * Adds a beacon to the list of beacons.
     * @param beacon the beacon to add the list of beacons.
     */
    public void addBeacon(Beacon beacon) {
        beacons.add(beacon);
    }

    /**
     * Returns the start beacon of the trip.
     * @return the start beacon of the trip.
     */
    public Beacon getStartBeacon() {
        return startBeacon;
    }

    /**
     * Sets the start beacon of the trip.
     * @param startBeacon the start beacon of the trip.
     */
    public void setStartBeacon(Beacon startBeacon) {
        this.startBeacon = startBeacon;
    }

    /**
     * Returns the start beacon of the trip.
     * @return the start beacon of the trip.
     */
    public Beacon getEndBeacon() {
        return endBeacon;
    }

    /**
     * Sets the end beacon of the trip.
     * @param endBeacon the end beacon of the trip.
     */
    public void setEndBeacon(Beacon endBeacon) {
        this.endBeacon = endBeacon;

        Double price = 25.0;
        setPrice(price);
    }

    /**
     * Returns the price of the trip.
     * @return the price of the trip.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the trip.
     * @param price the price of the trip.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

}
