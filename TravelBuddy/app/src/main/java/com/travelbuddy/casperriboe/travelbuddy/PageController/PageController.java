package com.travelbuddy.casperriboe.travelbuddy.PageController;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.estimote.coresdk.common.config.EstimoteSDK;
import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.travelbuddy.casperriboe.travelbuddy.Profile.ProfileFragment;
import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.Travel.TravelFragment;

public class PageController extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page_controller);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //  To get your AppId and AppToken you need to create new application in Estimote Cloud.
        String appId = "casper2602-hotmail-com-s-y-8ph";
        String appToken = "bdd4a18599b436827c8af2b56c2e0baa";
        EstimoteSDK.initialize(getBaseContext(), appId, appToken);
        // Optional, debug logging.
        EstimoteSDK.enableDebugLogging(true);

        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            switch (position) {
                case 0:
                    return TravelFragment.newInstance();
                case 1:
                    return ProfileFragment.newInstance();
            }
            return TravelFragment.newInstance();
        }

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
}
