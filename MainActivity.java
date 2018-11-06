package com.example.jsveras.exercnavigationview;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        }
                        else {
                            menuItem.setChecked(true);
                        }
                        drawerLayout.closeDrawers();
                        if (menuItem.getItemId() == R.id.action_settings) {
                            Fragmento01 fragment = new Fragmento01();
                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.frag_container, fragment).commit();
                            return true;
                        }
                        return false;
                    }
                });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout,
                        R.string.openDrawer, R.string.closeDrawer) {
                };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
