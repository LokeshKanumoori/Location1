package com.lokeshlabs.location1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCurrentLocationUpdates();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.select_fragment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_location1:
                getCurrentLocationUpdates();
                break;
            case R.id.menu_location2:
                getLastKnownLocation();
                break;
            case R.id.menu_activity_recognition:
                getActivityRecognition();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getCurrentLocationUpdates() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Location1())
                .commit();
    }

    private void getLastKnownLocation() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new Location2())
                .commit();
    }

    private void getActivityRecognition() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ActivityRecognition())
                .commit();
    }
}
