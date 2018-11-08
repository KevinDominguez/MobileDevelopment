package com.mondeoflowers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mondeoflowers.Handlers.RecyclerAdapter;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.util.ArrayList;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_catalog);

        //getting the recyclerview from xml
        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Article(
                        "flower",
                        "Gele tulpen",
                        7,
                        8,
                        "Yellow"));


        productList.add(
                new Article(
                        "flower",
                        "Random bloemen",
                        5,
                        4,
                        "iets van info"));


        productList.add(
                new Article(
                        "flower",
                        "Rode rozen",
                        5,
                        4,
                        "red roses"));

        //creating recyclerview adapter
        RecyclerAdapter adapter = new RecyclerAdapter(this, productList);
        //RecyclerAdapter adapter = new RecyclerAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }




}
