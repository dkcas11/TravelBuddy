package com.travelbuddy.casperriboe.travelbuddy.Models;

import io.realm.RealmObject;

/**
 * Created by Casper on 22-04-2017.
 */

public class Beacon extends RealmObject {

    private int major;
    private int minor;

    public Beacon() {
    }

    public Beacon(int major, int minor) {
        setMajor(major);
        setMinor(minor);
    }

    @Override
    public String toString() {
        String s = "";
        String floor = "" + major;
        String area = "";

        if (minor >= 5000) {
            area = "E";
        } else if (minor >= 4000) {
            area = "D";
        } else if (minor >= 3000) {
            area = "C";
        } else if (minor >= 2000) {
            area = "B";
        } else if (minor >= 1000) {
            area = "A";
        }

        try {
            s = floor + area + ("" + minor).substring(1,3);
        } catch (Exception e) {
            s = "NULL";
        }

        return s;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }
}
