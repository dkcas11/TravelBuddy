package com.travelbuddy.casperriboe.travelbuddy;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Casper on 22-04-2017.
 */

public class Trip {

    private int identifier = 0;
    private ArrayList<Beacon> beacons = new ArrayList<Beacon>();
    private Beacon startBeacon = new Beacon(0, 0);
    private Beacon endBeacon = new Beacon(0, 0);
    private Double price = 0.0;

    public Trip(Beacon startBeacon) {
        this.startBeacon = startBeacon;
        this.beacons.add(startBeacon);
    }

    @Override
    public String toString() {
        return "From " + startBeacon + " to " + endBeacon + ". Price: " + price;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public ArrayList<Beacon> getBeacons() {
        return beacons;
    }

    public void setBeacons(ArrayList<Beacon> beacons) {
        this.beacons = beacons;
    }

    public Beacon getStartBeacon() {
        return startBeacon;
    }

    public void setStartBeacon(Beacon startBeacon) {
        this.startBeacon = startBeacon;
    }

    public Beacon getEndBeacon() {
        return endBeacon;
    }

    public void setEndBeacon(Beacon endBeacon) {
        this.endBeacon = endBeacon;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
