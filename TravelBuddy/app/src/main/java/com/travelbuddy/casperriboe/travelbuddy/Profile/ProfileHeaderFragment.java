package com.travelbuddy.casperriboe.travelbuddy.Profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;
import com.travelbuddy.casperriboe.travelbuddy.Models.User;

/**
 * Created by Casper on 21/04/2017.
 */

public class ProfileHeaderFragment extends Fragment {

    private ImageView userImageView;
    private TextView nameTextView;
    private TextView balanceTextView;

    private User user = new User("John Doe", 42.0, null);

    public ProfileHeaderFragment() {
    }

    public static ProfileHeaderFragment newInstance() {
        return new ProfileHeaderFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        fetchUser();
        updateUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_header, container, false);

        findUIElements(rootView);
        setUIStyles();

        return rootView;
    }

    private void findUIElements(View view) {
        userImageView = (ImageView) view.findViewById(R.id.PROFILE_IMAGE);
        nameTextView = (TextView) view.findViewById(R.id.PROFILE_NAME);
        balanceTextView = (TextView) view.findViewById(R.id.BALANCE);
    }

    private void setUIStyles() {
        userImageView.setImageResource(R.drawable.user_icon);
    }

    private void updateUI() {
        nameTextView.setText(user.getName());
        balanceTextView.setText("Balance: " + user.getBalance());
    }

    private void fetchUser() {
        user = RealmManager.getUser();
    }

}
