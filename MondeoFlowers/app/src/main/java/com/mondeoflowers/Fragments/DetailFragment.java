package com.mondeoflowers.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mondeoflowers.R;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_catalog2, container, false);

        Bundle bundle = getArguments();

        String item = "";

        if(bundle != null){
            item = getArguments().getString("item");
        }



        return view;
    }
}
