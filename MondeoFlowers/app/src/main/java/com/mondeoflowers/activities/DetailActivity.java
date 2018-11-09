package com.mondeoflowers.activities;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mondeoflowers.R;

import java.io.File;

public class DetailActivity extends AppCompatActivity {


    private Button addToCartButton;
    private TextView nameText;
    private TextView idText;
    private TextView PriceText;
    private TextView descriptionText;
    private Bundle articleBundle;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


addToCartButton.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        
    }
});




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

        }

}