package com.travelbuddy.casperriboe.travelbuddy.ProfileSetup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.travelbuddy.casperriboe.travelbuddy.R;
import com.travelbuddy.casperriboe.travelbuddy.RealmManager;

/**
 * Created by Casper on 24/04/2017.
 */

public class ProfileSetupActivity extends AppCompatActivity {

    private EditText nameField;
    private Button enterButton;

    /**
     * The public constructor of the ProfileSetupActivity.
     * Currently does nothing.
     */
    public ProfileSetupActivity() {
    }

    /**
     * Creates a new view of of the activity.
     * @param savedInstanceState
     * @return the view of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_profile_setup);

        findUIElements();
    }

    /**
     * Override the back button to prevent the user to escape the initial setup.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        return super.onKeyDown(keyCode, event);
    }


    /**
     * Override the back button to prevent the user to escape the initial setup.
     */
    @Override
    public void onBackPressed() {
    }

    /**
     * Finds all UI Elements and connects them to the fragment's fields.
     */
    public void findUIElements() {
        nameField = (EditText) findViewById(R.id.NAMEFIELD);
        nameField.setHintTextColor(getResources().getColor(R.color.colorPrimary));
        enterButton = (Button) findViewById(R.id.ENTER);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                if (name.length() > 0) {
                    RealmManager.getInstance().createUser(name);
                    finish();
                }
            }
        });
    }

}
