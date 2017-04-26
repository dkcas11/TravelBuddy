package com.travelbuddy.casperriboe.travelbuddy.Profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.travelbuddy.casperriboe.travelbuddy.R;

import java.util.List;

/**
 * Created by Casper on 21/04/2017.
 */

public class ProfileFragment extends Fragment {

    /**
     * The public constructor of the ProfileFragment.
     * Currently does nothing.
     */
    public ProfileFragment() {
    }

    /**
     * Returns a new instance of the ProfileFragment.
     * @return the new instance of the ProfileFragment.
     */
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    /**
     * Creates a new view of of the fragment.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the view of the fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        return rootView;
    }

    /**
     * Invalidate child fragments.
     */
    public void invalidate() {
        List<Fragment> fragmentList = getChildFragmentManager().getFragments();
        if (!fragmentList.isEmpty()) {
            for (Fragment fragment : fragmentList) {
                fragment.onResume();
            }
        }
    }

}
