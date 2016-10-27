package net.kbh.dd;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLeft, drawerRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerRight = (DrawerLayout) findViewById(R.id.drawerRight);
        drawerLeft = (DrawerLayout) findViewById(R.id.drawerLeft);
        ActionBarDrawerToggle toggleLeft = new ActionBarDrawerToggle(
                this, drawerLeft, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLeft.setDrawerListener(toggleLeft);
        toggleLeft.syncState();

        NavigationView naviLeft = (NavigationView) findViewById(R.id.naviLeft);
        naviLeft.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLeft.isDrawerOpen(GravityCompat.START)) { drawerLeft.closeDrawer(GravityCompat.START); }
        else {
            if (drawerRight.isDrawerOpen(GravityCompat.START)) { drawerRight.closeDrawer(GravityCompat.START); }
            else super.onBackPressed();
        }
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
        if (id == R.id.action_toggle) {
            if (drawerRight.isDrawerOpen(GravityCompat.END)) { drawerRight.closeDrawer(GravityCompat.END); }
            else {
                if (drawerLeft.isDrawerOpen(GravityCompat.START)) { drawerLeft.closeDrawer(GravityCompat.START); }
                drawerRight.openDrawer(GravityCompat.END);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawerLeft = (DrawerLayout) findViewById(R.id.drawerLeft);
        drawerLeft.closeDrawer(GravityCompat.START);
        return true;
    }
}
