package com.example.lab07;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class KirbyFragment extends Fragment {
    int[] images = new int[]{R.drawable.carby, R.drawable.curby,
            R.drawable.beegKirby, R.drawable.KirbyRoadSmall,R.drawable.kirbyBackground,R.drawable.kirbyCostume,R.drawable.kirbyRealFace};
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