package com.example.user.lab41sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private ImageView imageViewProfile;
    private String title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = (TextView) findViewById(R.id.textViewName);
        imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onResume() {
        super.onResume();


        //TODO: Determine the user gender and display the correct profile image
        // imageView.setResource(R.drawable.file_name);
        //Display title, Mr. Ms.
        //gender.equal("1") is a male

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String my_edittext_name = mySharedPreferences.getString("display_name", getString(R.string.pref_default_display_name));

        String gender = mySharedPreferences.getString("gender_list", "-1");

        if (gender.equals("-1"))
        {
            title = "";
            imageViewProfile.setImageResource(R.drawable.profile);
        }
        else if(gender.equals("1"))
        {
            title = getString(R.string.male_title);
            imageViewProfile.setImageResource(R.drawable.male);
        }
        else
        {
            title = getString(R.string.female_title);
            imageViewProfile.setImageResource(R.drawable.female);
        }
        textViewName.setText(title + "" + my_edittext_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadPref()
    {
        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String my_edittext_name = mySharedPreferences.getString("display_name", getString(R.string.pref_default_display_name));

        String gender = mySharedPreferences.getString("gender_list", "-1");

        if (gender.equals("-1"))
        {
            title = "";
            imageViewProfile.setImageResource(R.drawable.profile);
        }
        else if(gender.equals("1"))
        {
            title = getString(R.string.male_title);
            imageViewProfile.setImageResource(R.drawable.male);
        }
        else
        {
            title = getString(R.string.female_title);
            imageViewProfile.setImageResource(R.drawable.female);
        }
        textViewName.setText(title + "" + my_edittext_name);
    }
}
