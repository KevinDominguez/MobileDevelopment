package com.mondeoflowers.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mondeoflowers.Fragments.AboutUsFragment;
import com.mondeoflowers.Fragments.BasketFragment;
import com.mondeoflowers.Fragments.HomeFragment;
import com.mondeoflowers.Fragments.RegisterFragment;
import com.mondeoflowers.Handlers.RecyclerAdapter;
import com.mondeoflowers.MainActivity;
import com.mondeoflowers.R;
import com.mondeoflowers.domains.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Catalog2Activity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(Catalog2Activity.this, MainActivity.class);
        startActivity(intent);

        switch (item.getItemId()) {
            case R.id.homeMenu:
                setTitle("Home");
                HomeFragment home = new HomeFragment();
                intent.putExtra("frgToLoad","home");
                startActivity(intent);
                break;
            case R.id.basketMenu:
                setTitle("Basket");
                BasketActivity basket = new BasketActivity();

                Intent intent2 = new Intent(Catalog2Activity.this, BasketActivity.class);
                startActivity(intent2);

                break;
            case R.id.aboutUsMenu:
                setTitle("aboutUs");
                AboutUsFragment aboutUs = new AboutUsFragment();
                intent.putExtra("frgToLoad","about");
                startActivity(intent);

                break;
            case R.id.loginMenu:
                setTitle("UserSettings");
                RegisterFragment register = new RegisterFragment();
                intent.putExtra("frgToLoad","register");
                startActivity(intent);

                break;
            case R.id.catalogMenu:

                break;

        }

        return true;

    }

    private static final String URL_PRODUCTS = "http://192.168.33.1/MyApi/Api.php";

    List<Article> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog2);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        new Thread(new Runnable() {
            public void run() {
                loadProducts();
            }
        }).start();

        //creating recyclerview adapter
        RecyclerAdapter adapter = new RecyclerAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    private void loadProducts() {

        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject article = array.getJSONObject(i);

                                //adding the product to product list
                                productList.add(new Article(
                                        article.getString("type"),
                                        article.getString("name"),
                                        article.getDouble("price"),
                                        article.getInt("Id"),
                                        article.getString("description"),
                                        article.getString("image")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            RecyclerAdapter adapter = new RecyclerAdapter(Catalog2Activity.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }






}
