package com.example.lab07;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class KirbyFragment extends androidx.fragment.app.Fragment {
    int[] images = new int[]{R.drawable.carby, R.drawable.curby,
            R.drawable.beeg_kirby, R.drawable.kirby_road,R.drawable.kirby_background,R.drawable.kirby_costume,R.drawable.kirby_real_face};
    ImageView kirby;
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.kirby_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        kirby = view.findViewById(R.id.background);
        kirby.setScaleType(ImageView.ScaleType.FIT_XY);
        kirby.setImageResource(images[iKirby]);

    }
}