package com.example.fragmentinsidefragmentpractice;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragmentinsidefragmentpractice.fragment.Cart;
import com.example.fragmentinsidefragmentpractice.fragment.DashBoard;
import com.example.fragmentinsidefragmentpractice.fragment.HomeFragment;
import com.example.fragmentinsidefragmentpractice.fragment.WishList;
import com.example.fragmentinsidefragmentpractice.util.UseUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
//This is main method.
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout fragment;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if you want to off screen screen short in your app just write the below line
        //but i want to comment the line now cause for the line my pc screen share does't work
//         so...
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);//screen short off code

        setContentView(R.layout.activity_main);
        this.setTitle("Evaly");
        findAllView();
        repleaseFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//for toggle
        navbar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "wow it is works", Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });
     }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//for navigationDrawer
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void repleaseFragment(Fragment fragment) {
        FragmentTransaction fm;
        fm = getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(UseUtil.changeFragmentAnimation1st,UseUtil.changeFragmentAnimation2nd,UseUtil.changeFragmentAnimation3rd,UseUtil.changeFragmentAnimation4th)
                .replace(R.id.fragment, fragment).addToBackStack(null);
        fm.commit();
    }

    private void findAllView() {
        fragment = findViewById(R.id.fragment);
        bottomNavigationView = findViewById(R.id.navigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navbar = (NavigationView) findViewById(R.id.navBar);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                repleaseFragment(new HomeFragment());
                return true;
            case R.id.wishList:
                repleaseFragment(new WishList());
                return true;
            case R.id.cart:
                repleaseFragment(new Cart());
                return true;
            case R.id.dashBoard:
                repleaseFragment(new DashBoard());
                return true;
        }
        return false;
    }
}
