package com.mondeoflowers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */


public class CatalogFragment extends Fragment {

    //a list to store all the products
    List<Article> productList;

    //the recyclerview
    RecyclerView recyclerView;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog, container, false);
    }

    public CatalogFragment(){

    }



}
