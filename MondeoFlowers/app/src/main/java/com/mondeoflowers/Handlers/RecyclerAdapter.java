package com.mondeoflowers.Handlers;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mondeoflowers.Fragments.AboutUsFragment;
import com.mondeoflowers.MainActivity;
import com.mondeoflowers.R;
import com.mondeoflowers.activities.DetailActivity;
import com.mondeoflowers.domains.Article;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    private List<Article> productList;

    public RecyclerAdapter(Context mCtx, List<Article> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        final Article article = productList.get(i);

        Glide.with(mCtx)
                .load(article.getImage())
                .into(myViewHolder.imageView);

        myViewHolder.textViewTitle.setText(article.getArticleName());
        myViewHolder.textViewShortDesc.setText(article.getDiscription());
        myViewHolder.textViewPrice.setText(String.valueOf(String.valueOf(article.getArticlePrice())));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mCtx, DetailActivity.class);
                Bundle info = new Bundle();
                info.putString("ArticleName", article.getArticleName());
                info.putString("ArticleDescription", article.getDiscription());
                info.putString("ArticleImage", article.getImage());
                info.putDouble("ArticlePrice", article.getArticlePrice());
                info.putInt("ArticleId", article.getArticleID());
                intent.putExtras(info);
                mCtx.startActivity(intent);

                //Toast.makeText(mCtx, "card view Here we come", Toast.LENGTH_SHORT).show();

            }
        });




    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);




        }





    }


}
