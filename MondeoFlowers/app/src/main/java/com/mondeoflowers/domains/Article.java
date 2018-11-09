package com.mondeoflowers.domains;

public class Article {

    private int articleID;
    private String articleType;
    private String articleName;
    private double articlePrice;
    private int quantity;
    private String discription;
    private String image;

    public Article( String articleType, String articleName, double articlePrice, int quantity, String discription, String Image) {
        this.articleType = articleType;
        this.articleName = articleName;
        this.articlePrice = articlePrice;
        this.quantity = quantity;
        this.discription = discription;
        this.image = Image;
    }

    public Article(String articleName, double articlePrice,String discription, String Image, int id) {
        this.articleName = articleName;
        this.articlePrice = articlePrice;
        this.discription = discription;
        this.image = Image;
        this.articleID = id;
    }

    public String getImage(){ return image; }

    public void setImage(String image) {
        this.image = image;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public double getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(double articlePrice) {
        this.articlePrice = articlePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}

