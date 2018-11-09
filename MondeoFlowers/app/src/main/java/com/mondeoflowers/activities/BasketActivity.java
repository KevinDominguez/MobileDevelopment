package com.mondeoflowers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mondeoflowers.Handlers.RecyclerAdapter;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.util.List;

public class BasketActivity extends AppCompatActivity {

    List<Article> basketList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        RecyclerAdapter adapter = new RecyclerAdapter(BasketActivity.this, basketList);
        //recyclerView.setAdapter(adapter);
    }
}
