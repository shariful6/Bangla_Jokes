package com.example.banglajokes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    RecyclerView recyclerView;

     List<ModelCategory> categories;

     AdapterCatergory adapterCatergory ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_id);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        categories = new ArrayList<>();

        categories.add(new ModelCategory("প্রেমিক-প্রেমিকা জোকস"));
        categories.add(new ModelCategory("শিক্ষনীয় জোকস"));
        categories.add(new ModelCategory("বলদ জোকস"));
        categories.add(new ModelCategory("বাবা-ছেলে জোকস"));
        categories.add(new ModelCategory("ব্বামী-স্ত্রী জোকস"));
        categories.add(new ModelCategory("দাদু-নাতি জোকস"));
        categories.add(new ModelCategory("ছাত্র-শিক্ষক জোকস"));
        categories.add(new ModelCategory("কৃপণ লোক জোকস"));
        categories.add(new ModelCategory("প্রাপ্ত বয়স্ক জোকস"));
        categories.add(new ModelCategory("পুলিশ-অপরাধী জোকস"));
        categories.add(new ModelCategory("A"));
        categories.add(new ModelCategory("B"));
        categories.add(new ModelCategory("C"));
        categories.add(new ModelCategory("D"));
        categories.add(new ModelCategory("E"));
        categories.add(new ModelCategory("F"));
        categories.add(new ModelCategory("G"));
        categories.add(new ModelCategory("H"));
        categories.add(new ModelCategory("I"));
        categories.add(new ModelCategory("J"));
        categories.add(new ModelCategory("K"));

        adapterCatergory = new AdapterCatergory(getApplicationContext(),categories);

        recyclerView.setAdapter(adapterCatergory);

    }

    //Menu section
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        MenuItem searchViewItem =menu.findItem(R.id.search_id);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");
        return true;
    }


    //Navigation drawer section
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "Nav Home", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.nav_gallery) {

            Toast.makeText(this, "Gallery", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.nav_slideshow) {
            Intent myIntent=new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String body="http://play.google.com/store/apps/details?id=com.shariful.generalknowledge";
            myIntent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(myIntent,"Share Using"));
            return true;

        }
      else if (id == R.id.nav_rateUs) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + getPackageName())));
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));

            }

            return true;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        List<ModelCategory> newList = new ArrayList();

        for (ModelCategory catergoryList : this.categories) {
            String cat = catergoryList.getCategory().toLowerCase();

            if (cat.contains(newText)) {
                newList.add(catergoryList);
            }
        }
        adapterCatergory.setFilter(newList);
        return false;
    }
}