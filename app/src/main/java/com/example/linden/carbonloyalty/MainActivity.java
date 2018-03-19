package com.example.linden.carbonloyalty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.support.v4.view.GravityCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // All of this is necessary for the navigation bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        // Settings up a click listener
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        // Checks which button was clicked in the navigation menu ONLY
                        switch(menuItem.getItemId()){
                            case R.id.nav_settings:
                                toSettings();       // Sends you to the settings page when clicking on settings
                                return true;
                            case R.id.nav_help:
                                return true;
                        }

                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();

                        return true;
                    }

                }
        );

    }

    // Might not even be necessary
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.nav_settings:
                toSettings();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toNetPromoter(View view){
        Intent intent = new Intent(this, NetPromoter.class);
        startActivity(intent);
    }

    public void toSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}