package com.example.lab07;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;
    KirbyFragment[] fragArray;
    DrawerLayout mDrawer;
    Toolbar toolbar;
    NavigationView nvDrawer;
    ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
        fragArray = new KirbyFragment[]{KirbyFragment.newInstance(0),KirbyFragment.newInstance(1),KirbyFragment.newInstance(2),
                KirbyFragment.newInstance(3),KirbyFragment.newInstance(4),KirbyFragment.newInstance(5),KirbyFragment.newInstance(6)};
        }
//        KirbyFragment kirbyFrag = (KirbyFragment) getSupportFragmentManager().findFragmentByTag("Kirby1");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setUpDrawerContent(nvDrawer);

    }
    protected void displayFragment(int iKirby) {
        ft = getSupportFragmentManager().beginTransaction();
        if (fragArray[iKirby].isAdded()) {
            ft.show(fragArray[iKirby]);
        }else {
            ft.add(R.id.placeholder,fragArray[iKirby],"" + iKirby);
        }
        for (int i = 0;i<fragArray.length;i++) {
            if (i != iKirby) {
                if (fragArray[i].isAdded()) {ft.hide(fragArray[i]); }
            }
        }
//        ft.replace(R.id.placeholder,new KirbyFragment(),"Kirby1");
//        ft.addToBackStack("kirb1");
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setUpDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                }
        );
    }
    public void selectDrawerItem(MenuItem menuItem) {
        KirbyFragment fragment = null;
        switch(menuItem.getItemId()) {
            case R.id.firstFrag:
                displayFragment(0);
                break;
            case R.id.secondFrag:
                displayFragment(1);
                break;
            case R.id.thirdFrag:
                displayFragment(2);
                break;
            case R.id.fourthFrag:
                displayFragment(3);
                break;
            case R.id.fifthFrag:
                displayFragment(4);
                break;
            case R.id.sixthFrag:
                displayFragment(5);
                break;
            case R.id.seventhFrag:
                displayFragment(6);
                break;
        }
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }
}