package com.mondeoflowers.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Tasks;
import com.mondeoflowers.Handlers.ObjectSerializer;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DetailActivity extends AppCompatActivity {



    private Button addToCartButton;
    private TextView nameText;
    private TextView idText;
    private TextView PriceText;
    private TextView descriptionText;
    private Bundle articleBundle;
    private ImageView image;
    private List<Article> articleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);







        articleBundle = new Bundle();
        articleBundle = getIntent().getExtras();




        nameText = (TextView) findViewById(R.id.textViewArticleName);
        nameText.setText(articleBundle.getString("ArticleName"));
      /*  idText = (EditText) findViewById(R.id.textViewArticleId);
        idText.setText(String.valueOf(articleBundle.getInt("ArticleId")));*/
        PriceText = (TextView) findViewById(R.id.textViewArticlePrice);
        PriceText.setText(String.valueOf(articleBundle.getDouble("ArticlePrice")));
        descriptionText = (TextView) findViewById(R.id.textViewArticleDescription);
        descriptionText.setText(articleBundle.getString("ArticleDescription"));
        image =(ImageView) findViewById(R.id.imageView);
        Glide.with(this).load(articleBundle.getString("ArticleImage")).into(image);


        //btnRegister = (Button) getActivity().findViewById(R.id.buttonRegister);
        //btnRegister.setOnClickListener(new View.OnClickListener() {
        addToCartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){



                Article newArticle = new Article(
                        articleBundle.getString("ArticleName"),
                        articleBundle.getDouble("ArticlePrice"),
                        articleBundle.getString("ArticleDiscription"),
                        articleBundle.getString("ArticleImage"),
                        articleBundle.getInt("ArticleId"));


            }
        });
        }
    public void addTask(Article a) {
        if (null == articleList) {
            articleList = new ArrayList<Article>();
        }
        articleList.add(a);

        // save the task list to preference
        SharedPreferences prefs = getSharedPreferences("ShoppingList", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        try {
            editor.putString("List", ObjectSerializer.serialize(articleList));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.commit();
    }
}