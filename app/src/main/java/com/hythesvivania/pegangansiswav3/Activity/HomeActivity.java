package com.hythesvivania.pegangansiswav3.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hythesvivania.pegangansiswav3.Fragment.DetailFragment.DetailFragment;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentCreatePR;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentCreateUlangan;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentGuru;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentJadwal;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentPR;
import com.hythesvivania.pegangansiswav3.Fragment.FragmentUlangan;
import com.hythesvivania.pegangansiswav3.R;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private static String TAG_FRAGMENT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setLogo(R.mipmap.ic_ps_merah);
        }


        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.main_container, new FragmentPR()).commit();


     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                fragment = new FragmentCreatePR();
                loadFragment(fragment);


            }
        });*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (count == 0) {
            super.onBackPressed();
        } else if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

            getFragmentManager().popBackStack();
        }
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_PR) {
            fragment = new FragmentPR();
            loadFragment(fragment);
        } else if (id == R.id.nav_Ulangan) {
            fragment = new FragmentUlangan();
            loadFragment(fragment);
        } else if (id == R.id.nav_Jadwal) {
            fragment = new FragmentJadwal();
            loadFragment(fragment);

        } else if (id == R.id.nav_Guru) {
            fragment = new FragmentGuru();
            loadFragment(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, fragment, TAG_FRAGMENT);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void goFragmentCreatePR(View view) {

        fragment = new FragmentCreatePR();
        loadFragment(fragment);

    }

    public void goFragmentCreateUlangan(View view) {
        fragment = new FragmentCreateUlangan();
        loadFragment(fragment);
    }

    public void goFragmentDetail(View view) {
        fragment = new DetailFragment();
        loadFragment(fragment);
    }
}
