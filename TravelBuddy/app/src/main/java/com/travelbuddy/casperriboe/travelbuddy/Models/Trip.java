package com.travelbuddy.casperriboe.travelbuddy.Models;

import java.util.ArrayList;
import java.util.Iterator;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Casper on 22-04-2017.
 */

public class Trip extends RealmObject{

    @PrimaryKey private int identifier;
    private int userIdentifier;
    private RealmList<Beacon> beacons;
    private Beacon startBeacon;
    private Beacon endBeacon;
    private Double price;

    public Trip() {
    }

    public Trip(Beacon startBeacon) {
        setStartBeacon(startBeacon);
        setEndBeacon(startBeacon);
        addBeacon(startBeacon);
        setPrice(0.);
    }

    @Override
    public String toString() {
        return "From " + startBeacon + " to " + endBeacon + ". Price: " + price + " DKK";
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public RealmList<Beacon> getBeacons() {
        return beacons;
    }

    public ArrayList<Beacon> getBeaconsAsArrayList() {
        Iterator i = beacons.iterator();
        ArrayList<Beacon> rBeacons = new ArrayList<>();

        while (i.hasNext()) {
            rBeacons.add((Beacon) i.next());
        }

        return rBeacons;
    }

    public void setBeacons(RealmList<Beacon> beacons) {
        this.beacons = beacons;
    }

    public void addBeacon(Beacon beacon) {
        ensureBeacons();
        beacons.add(beacon);
    }

    public Beacon getStartBeacon() {
        return startBeacon;
    }

    public void setStartBeacon(Beacon startBeacon) {
        ensureBeacons();
        this.startBeacon = startBeacon;
    }

    public Beacon getEndBeacon() {
        ensureBeacons();
        return endBeacon;
    }

    public void setEndBeacon(Beacon endBeacon) {
        ensureBeacons();
        this.endBeacon = endBeacon;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void ensureBeacons() {
        if (beacons == null) {
            beacons = new RealmList<>();
        }
    }
}
