package com.travelbuddy.casperriboe.travelbuddy.Models;

import io.realm.RealmObject;

/**
 * Created by Casper on 22-04-2017.
 */

public class Beacon extends RealmObject {

    private String errorMessage = "Searching";
    private int major = 0;
    private int minor = 0000;

    /**
     * Creates an empty Beacon (used by Realm).
     */
    public Beacon() {
    }

    /**
     * Formats the current minor and major to display a correct location based on the naming conventions by ITU.
     * @return the name of the location based on naming conventions by ITU.
     */
    @Override
    public String toString() {
        String s = "";
        String floor = "" + getMajor();
        String area = "";

        if (getMinor() >= 5000) {
            area = "E";
        } else if (getMinor() >= 4000) {
            area = "D";
        } else if (getMinor() >= 3000) {
            area = "C";
        } else if (getMinor() >= 2000) {
            area = "B";
        } else if (getMinor() >= 1000) {
            area = "A";
        }

        try {
            s = floor + area + ("" + getMinor()).substring(1,3);
        } catch (Exception e) {
            s = errorMessage;
        }

        return s;
    }

    /**
     * Returns the major of the beacon.
     * @return the major of the beacon.
     */
    public int getMajor() {
        return major;
    }

    /**
     * Sets the major of the beacon.
     * @param major the major of the beacon
     */
    public void setMajor(int major) {
        this.major = major;
    }

    /**
     * Returns the minor of the beacon.
     * @return the minor of the beacon.
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Sets the minor of the beacon.
     * @param minor the minor of the beacon.
     */
    public void setMinor(int minor) {
        this.minor = minor;
    }

    /**
     * Returns whether or not the beacon is a valid beacon used by ITU.
     * @return whether or not the beacon is a valid beacon used by ITU.
     */
    public boolean isValidBeacon() {
        return !toString().equals(errorMessage);
    }
}
