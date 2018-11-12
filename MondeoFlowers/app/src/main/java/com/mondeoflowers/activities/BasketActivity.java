package com.mondeoflowers.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mondeoflowers.Handlers.RecyclerAdapter;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    ArrayList<Article> articleList;


    RecyclerView recyclerView;
    SharedPreferences shref;
    SharedPreferences.Editor editor;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        shref= getSharedPreferences("shoppingCart", Context.MODE_PRIVATE);

        String response=shref.getString("shoppingList" , "");
        ArrayList<Article> articleList = gson.fromJson(response,
                new TypeToken<List<Article>>(){}.getType());

        if (articleList == null) {
            articleList = new ArrayList<>();
        }

        //basketList.add(new Article("Enkel", "Bloemetjes", 10, 4, "Some text", ""));

        double sum = 0;

        for (int i = 0; i == articleList.size(); i++){
            sum += articleList.get(i).getArticlePrice();
        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewBasket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerAdapter adapter = new RecyclerAdapter(BasketActivity.this, articleList);
        recyclerView.setAdapter(adapter);
    }



}
