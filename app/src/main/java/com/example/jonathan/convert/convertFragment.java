package com.example.jonathan.convert;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class convertFragment extends Fragment {

    public convertFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_convert, container, false);

        Button distanceButton = (Button) view.findViewById(R.id.distanceButton);
        distanceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment distanceFrag = new DistanceFragment();
                pushFragment(distanceFrag);
            }
        });

        Button weightButton = (Button) view.findViewById(R.id.weightButton);
        weightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment weightFrag = new WeightFragment();
                pushFragment(weightFrag);
            }
        });

        return view;
    }
    public void pushFragment(Fragment f){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainActivity, f);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
