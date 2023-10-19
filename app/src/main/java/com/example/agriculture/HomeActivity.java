package com.example.agriculture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.agriculture.fragments.HomeFragment;
import com.example.agriculture.fragments.LogoutFragment;
import com.example.agriculture.fragments.NotificationFragment;
import com.example.agriculture.fragments.aboutFragment;
import com.example.agriculture.fragments.ideaFragment;
import com.example.agriculture.fragments.profileFragment;
import com.example.agriculture.fragments.searchFragment;
import com.example.agriculture.fragments.settingFragment;
import com.example.agriculture.fragments.shareFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navigationView = findViewById(R.id.navigation_drawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.ideas){
                    openFragment(new ideaFragment());
                }
                else if(itemId == R.id.notification){
                    openFragment(new NotificationFragment());
                }
                else if(itemId == R.id.search){
                    openFragment(new searchFragment());
                }
                else if (itemId == R.id.profile) {
                    openFragment(new profileFragment());
                }
                return false;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        openFragment(new HomeFragment());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(new HomeFragment());
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            openFragment(new HomeFragment());
        }
        else if (itemId == R.id.nav_share) {
            openFragment(new shareFragment());
        }
        else if (itemId == R.id.nav_logout) {
            Toast.makeText(HomeActivity.this, "logout", Toast.LENGTH_SHORT).show();
            openFragment(new LogoutFragment());
        }
        else if (itemId == R.id.nav_about) {
            openFragment(new aboutFragment());
        }
        else if (itemId == R.id.nav_settings) {
            openFragment(new settingFragment());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private  void openFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
}