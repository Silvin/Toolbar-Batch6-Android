package com.icaboalo.toolbarexampledevfbatch6;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupToolbar();
        setupDrawer();

        replaceFragment(new Fragment1());

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }


    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        Fragment fragment = null;
                        switch (menuItem.getItemId()) {
                            case R.id.action_explore:
                                fragment = new Fragment1();
                                Toast.makeText(HomeActivity.this, R.string.action_explore, Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_people:
                                fragment = new Fragment2();
                                Toast.makeText(HomeActivity.this, R.string.action_people, Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_map:
                                fragment = new Fragment3();
                                Toast.makeText(HomeActivity.this, R.string.action_map, Toast.LENGTH_SHORT).show();
                                break;
                        }

                        replaceFragment(fragment);
                        drawerLayout.closeDrawers();

                        return false;
                    }
                });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contaiter, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_favorites:
                Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_location:
                Toast.makeText(this, "Localización", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
