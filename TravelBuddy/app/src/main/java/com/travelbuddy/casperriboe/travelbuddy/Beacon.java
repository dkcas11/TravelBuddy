package com.travelbuddy.casperriboe.travelbuddy;

/**
 * Created by Casper on 22-04-2017.
 */

public class Beacon {

    private int major;
    private int minor;

    public Beacon(int major, int minor) {
        this.major = major;
        this.minor = minor;
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
            s = floor + area + ("" + minor).substring(1,2);
        } catch (Exception e) {
            s = "NULL";
        }

        return s;
    }
}
