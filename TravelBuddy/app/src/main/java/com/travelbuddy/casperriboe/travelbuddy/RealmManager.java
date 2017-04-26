package com.travelbuddy.casperriboe.travelbuddy;

import com.travelbuddy.casperriboe.travelbuddy.Models.Trip;
import com.travelbuddy.casperriboe.travelbuddy.Models.User;

import java.util.ArrayList;
import java.util.Iterator;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Casper on 22-04-2017.
 */

public class RealmManager  {


    private static RealmManager instance = null;
    private Realm realm;

    /**
     * Instantiates a new RealmManager if none exists yet.
     */
    protected RealmManager() {
        try{
            realm =  Realm.getDefaultInstance();
        }catch (Exception e){
            // Get a Realm instance for this thread
            RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
            realm = Realm.getInstance(config);
        }
    }

    /**
     * Returns the current singleton instance of the RealmManager.
     * @return the singleton instance of the RealmManager.
     */
    public static RealmManager getInstance() {
        if(instance == null) {
            instance = new RealmManager();
        }
        return instance;
    }

    /**
     * Checks to see if a user exists, i.e. valid.
     * @return whether or not a user exists.
     */
    public boolean userExists() {
        return !getUser().getName().equals("");
    }

    /**
     * Checks to see if a user has sufficient balance.
     * @return whether or not a user has sufficient balance.
     */
    public boolean userHasBalance() {
        return (getUser().getBalance() > 25.0);
    }

    /**
     * Creates a new user with an empty balance.
     * @param name the name of the new user to be created.
     */
    public void createUser(String name) {
        deleteUser();
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setName(name);
        user.setBalance(0.0);
        realm.commitTransaction();
    }

    /**
     * Deletes the current user.
     */
    public void deleteUser() {
        realm.beginTransaction();
        realm.delete(User.class);
        realm.commitTransaction();
    }

    /**
     * Retrieves the current user.
     * @return the current user.
     */
    public User getUser() {
        if (realm.where(User.class).findFirst() == null) {
            createUser("");
        }

        // Return the user object and not the Realm object
        return realm.where(User.class).findFirst();
    }

    /**
     * Adds a trip to the current user.
     * @param trip the trip to add to the current user.
     */
    public void addTrip(Trip trip) {
        realm.beginTransaction();
        getUser().addTrip(trip);
        realm.commitTransaction();

        removeBalance(trip.getPrice());
    }

    /**
     * Returns the current user's trips converted to an ArrayList.
     * @return the current user's trips converted to an ArrayList.
     */
    public ArrayList<Trip> getTripsAsArrayList() {
        Iterator i = getUser().getTrips().iterator();
        ArrayList<Trip> rTrips = new ArrayList<>();

        while (i.hasNext()) {
            rTrips.add((Trip) i.next());
        }

        return rTrips;
    }

    /**
     * Adds balance to the current user.
     * @param balance the balance to add to the user.
     */
    public void addBalance(Double balance) {
        realm.beginTransaction();
        getUser().setBalance(getUser().getBalance() + balance);
        realm.commitTransaction();
    }

    /**
     * Removes balance from the current user.
     * @param balance the balance to remove from the current user.
     */
    public void removeBalance(Double balance) {
        realm.beginTransaction();
        getUser().setBalance(getUser().getBalance() - balance);
        realm.commitTransaction();
    }

}
