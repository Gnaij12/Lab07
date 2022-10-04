package com.example.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;
    KirbyFragment[] fragArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
        fragArray = new KirbyFragment[]{KirbyFragment.newInstance(0),KirbyFragment.newInstance(1),KirbyFragment.newInstance(2),
                KirbyFragment.newInstance(3),KirbyFragment.newInstance(4),KirbyFragment.newInstance(5),KirbyFragment.newInstance(6)};
        }
        KirbyFragment kirbyFrag = (KirbyFragment) getSupportFragmentManager().findFragmentByTag("Kirby1");
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
}