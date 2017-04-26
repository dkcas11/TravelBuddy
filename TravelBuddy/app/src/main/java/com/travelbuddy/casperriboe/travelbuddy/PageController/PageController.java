package com.travelbuddy.casperriboe.travelbuddy.PageController;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.estimote.sdk.SystemRequirementsChecker;
import com.travelbuddy.casperriboe.travelbuddy.Profile.ProfileFragment;
import com.travelbuddy.casperriboe.travelbuddy.ProfileSetup.ProfileSetupActivity;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;
import com.travelbuddy.casperriboe.travelbuddy.Travel.TravelFragment;

public class PageController extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    /**
     * Instantiates the app, creates the PageView and sets up the TravelFragment and ProfileFragment pages.
     * If no user exists, a the ProfileSetupActivity is created and shown
     * @param savedInstanceState the savedInstanceState of the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page_controller);

        // Set up the ViewPager with the sections adapter.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                invalidatePageFragments();
            }

            @Override
            public void onPageSelected(int position) {
                invalidatePageFragments();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        if (!RealmManager.getInstance().userExists()) {
            this.startActivity(new Intent(this, ProfileSetupActivity.class));
        }
    }

    /**
     * Invalidates the page fragments and updates the views.
     * Checks to see if the requirements are met to use search for Beacons using Bluetooth.
     */
    @Override
    protected void onResume() {
        super.onResume();

        invalidatePageFragments();
        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

    /**
     * The Sections Pager Adapter that controls the Fragments for each page.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        /**
         * Sets up the fragments given the Fragment Manger.
         * @param fm The Fragment Manager to setup fragments with.
         */
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Returns the total number of pages in the PageView.
         * @return the total number of pages in the PageView.
         */
        @Override
        public int getCount() {
            return 2;
        }

        /**
         * Returns the item for each position in the PageView.
         * @param position the position to retrieve a view from.
         * @return the view for the given position argument.
         */
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return TravelFragment.newInstance();
                case 1:
                    return ProfileFragment.newInstance();
            }
            return TravelFragment.newInstance();
        }

        /**
         * Returns the title to use for each page in the PageView.
         * @param position the position to retrieve a title from.
         * @return the title for the given position argument.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Travel";
                case 1:
                    return "Profile";
            }
            return "";
        }
    }

    /**
     * Invalidates the fragments in the PageView forcing them to update it's views.
     */
    public void invalidatePageFragments() {
        Fragment page = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.container + ":" + mViewPager.getCurrentItem());
        if (1 == mViewPager.getCurrentItem() && null != page) {
            System.out.println("FOUND FRAGMENT - WILL INVALIDATE");
            ((ProfileFragment) page).invalidate();
        } else {
            System.out.println("NO FRAGMENTS FOUND");
        }
    }
}
