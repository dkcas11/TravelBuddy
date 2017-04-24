package com.travelbuddy.casperriboe.travelbuddy.Models;

import java.lang.reflect.Array;
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

public class Trip extends RealmObject{

    @PrimaryKey private int identifier;
    private int userIdentifier;
    private RealmList<Beacon> beacons;
    private Beacon startBeacon;
    private Beacon endBeacon;
    private Double price;

    public Trip() {
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
        if (beacons == null) {
            beacons = new RealmList<>();
        }
        beacons.add(beacon);
    }

    public Beacon getStartBeacon() {
        return startBeacon;
    }

    public void setStartBeacon(Beacon startBeacon) {
        if (beacons == null) {
            beacons = new RealmList<>();
        }
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
