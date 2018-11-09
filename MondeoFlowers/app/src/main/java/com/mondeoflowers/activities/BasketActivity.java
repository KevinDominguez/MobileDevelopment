package com.mondeoflowers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mondeoflowers.Handlers.RecyclerAdapter;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.util.ArrayList;
import java.util.List;

public class BasketActivity extends AppCompatActivity {

    List<Article> basketList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        basketList = new ArrayList<>();

        basketList.add(new Article("Enkel", "Bloemetjes", 10, 4, "Some text", ""));

        double sum = 0;

        for (int i = 0; i == basketList.size(); i++){
            sum += basketList.get(i).getArticlePrice();
        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewBasket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerAdapter adapter = new RecyclerAdapter(BasketActivity.this, basketList);
        recyclerView.setAdapter(adapter);
    }

    public void onCreate() {
        super.onCreate();
        if (null == currentTasks) {
            currentTasks = new ArrayList<task>();
        }

        // load tasks from preference
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);

        try {
            currentTasks = (ArrayList<task>) ObjectSerializer.deserialize(prefs.getString(TASKS, ObjectSerializer.serialize(new ArrayList<task>())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
