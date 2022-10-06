package com.example.lab07;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class KirbyFragment extends androidx.fragment.app.Fragment {
    int[] images = new int[]{R.drawable.carby, R.drawable.curby,
            R.drawable.beeg_kirby, R.drawable.kirby_road,R.drawable.kirby_background,R.drawable.kirby_costume,R.drawable.kirby_real_face};
    int iKirby;
    public static KirbyFragment newInstance(int iKirby) {
        KirbyFragment kirbyFrag = new KirbyFragment();
        Bundle args = new Bundle();
        args.putInt("iKirby",iKirby);
        kirbyFrag.setArguments(args);
        return kirbyFrag;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iKirby = getArguments().getInt("iKirby",0);

    }
}