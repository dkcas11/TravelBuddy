package com.travelbuddy.casperriboe.travelbuddy.Profile;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private Button balanceButton;

    private User user = new User();

    /**
     * The public constructor of the ProfileHeaderFragment.
     * Currently does nothing.
     */
    public ProfileHeaderFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_profile_header, container, false);

        fetchUser();
        findUIElements(rootView);
        setUIStyles();

        return rootView;
    }

    /**
     * Resumes the fragment and invalidates the view.
     */
    @Override
    public void onResume() {
        super.onResume();

        invalidate();
    }

    /**
     * Retrieves the current data in the database and updates the view.
     */
    public void invalidate() {
        fetchUser();
        updateUI();
        System.out.println("PROFILE HEADER WAS INVALIDATED");
    }

    /**
     * Finds all UI Elements and connects them to the fragment's fields.
     * @param view The view to connect to.
     */
    private void findUIElements(View view) {
        userImageView = (ImageView) view.findViewById(R.id.PROFILE_IMAGE);
        nameTextView = (TextView) view.findViewById(R.id.PROFILE_NAME);
        balanceTextView = (TextView) view.findViewById(R.id.BALANCE);
        balanceButton = (Button) view.findViewById(R.id.ADD_MONEY);
        balanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBalanceDialog();
            }
        });
    }

    /**
     * Sets the styles of the UI elements.
     */
    private void setUIStyles() {
        userImageView.setImageResource(R.drawable.user_icon);
        balanceButton.setText("Add Money");
    }

    /**
     * Updates the view.
     */
    private void updateUI() {
        nameTextView.setText(user.getName());
        balanceTextView.setText("Balance: " + user.getBalance() + " DKK");
    }

    /**
     * Retrieves the current user in the database.
     */
    private void fetchUser() {
        user = RealmManager.getInstance().getUser();
    }

    /**
     * Presents a Dialog to add balance to the current user.
     */
    private void addBalanceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("Add Money");

        // Set up the input
        final EditText input = new EditText(this.getContext());
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RealmManager.getInstance().addBalance(Double.parseDouble(input.getText().toString()));
                updateUI();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

}
