package com.mondeoflowers.domains;


public class ShoppingCart {

    private  Article [] articles = new Article[99];

    public ShoppingCart(){};

    public  void AddArticle(Article article) {
        if (articles.length != 99){
            articles[articles.length] = article;
        }
    }





}
