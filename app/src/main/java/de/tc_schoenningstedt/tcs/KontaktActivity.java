package de.tc_schoenningstedt.tcs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class KontaktActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private List<Person> persons;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontakt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "tennis@tc-schoenningstedt.de", null));
                startActivity(Intent.createChooser(intent, "Email senden"));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();




    }
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Nils Digel", "01522/860 979 8", R.drawable.nils, "Vorstandsvorsitzender", "nils.digel@tc-schoenningstedt.de"));
        persons.add(new Person("Nicole Fleckenstein", "0174/999 849 8 ", R.drawable.nicole, "1. Stellvertreterin", "nicole.fleckenstein@tc-schoenningstedt.de"));
        persons.add(new Person("Christoph Wegmann", "040/219 946 31", R.drawable.christoph, "2. Stellvertreter", "christoph.wegmann@tc-schoenningstedt.de"));
        persons.add(new Person("Nils Koslowski", "0160/913 112 08", R.drawable.nils2, "Kassenwart", "nils.koslowski@tc-schoenningstedt.de"));
        persons.add(new Person("Stephan Ludwig", "0171/574 559 5", R.drawable.stephan, "Sportwart", "stephan.ludwig@tc-schoenningstedt.de"));
        persons.add(new Person("Frauke Bothmann", "0176/485 536", R.drawable.frauke, "Schriftwartin", "stephan.ludwig@tc-schoenningstedt.de"));
        persons.add(new Person("Andreas Mathiessen", "01577/528 242 1", R.drawable.andreas, "Haus- und Platzwart", "andreas.matthiessen@tc-schoenningstedt.de"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
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

        } else if (id == R.id.nav_termine) {
            startActivity(new Intent(this, TermineActivity.class));
        } else if (id == R.id.nav_map) {
            startActivity(new Intent(this, MapActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
