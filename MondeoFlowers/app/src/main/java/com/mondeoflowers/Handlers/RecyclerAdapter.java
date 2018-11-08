package com.mondeoflowers.Handlers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mondeoflowers.Fragments.CatalogFragment;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    private List<Article> productList;

    public RecyclerAdapter(CatalogFragment mCtx, List<Article> productList) {
        //this.mCtx = mCtx;
        this.productList = productList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Article article = productList.get(i);

        myViewHolder.textViewTitle.setText(article.getArticleName());
        myViewHolder.textViewShortDesc.setText(article.getDiscription());
        myViewHolder.textViewPrice.setText(String.valueOf(article.getArticlePrice()));


        ContextCompat.getDrawable(mCtx, R.drawable.common_full_open_on_phone);
        //myViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable());

    }


    @Override
    public int getItemCount() {
        return 0;
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
