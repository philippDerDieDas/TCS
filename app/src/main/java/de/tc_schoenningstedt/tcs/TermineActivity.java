package de.tc_schoenningstedt.tcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TermineActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView day, month, year;

    CalendarView cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int mothOfYear = c.get(Calendar.MONTH);

        String weekDay = null;
        if (Calendar.MONDAY == dayOfWeek) weekDay = "Montag";
        else if (Calendar.TUESDAY == dayOfWeek) weekDay = "Dienstag";
        else if (Calendar.WEDNESDAY == dayOfWeek) weekDay = "Mittwoch";
        else if (Calendar.THURSDAY == dayOfWeek) weekDay = "Donnerstag";
        else if (Calendar.FRIDAY == dayOfWeek) weekDay = "Freitag";
        else if (Calendar.SATURDAY == dayOfWeek) weekDay = "Samstag";
        else if (Calendar.SUNDAY == dayOfWeek) weekDay = "Sonntag";

        Calendar cal=Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        String month_name = month_date.format(cal.getTime());



        day = (TextView) findViewById(R.id.day);
        day.setText(weekDay);

        month = (TextView) findViewById(R.id.month);
        month.setText(month_name);

        cl = (CalendarView) findViewById(R.id.cl);

        



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_start) {
            startActivity(new Intent(this, StartActivity.class));
        } else if (id == R.id.nav_kontakt) {
            startActivity(new Intent(this, KontaktActivity.class));
        } else if (id == R.id.nav_termine) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
