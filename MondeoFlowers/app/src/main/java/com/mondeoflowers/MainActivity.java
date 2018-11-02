package com.mondeoflowers;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.mondeoflowers.Fragments.AboutUsFragment;
import com.mondeoflowers.Fragments.BasketFragment;
import com.mondeoflowers.Fragments.CatalogFragment;
import com.mondeoflowers.Fragments.HomeFragment;
import com.mondeoflowers.Fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    Button btnExample;
    TextView textExample;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu, menu);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
        HomeFragment home = new HomeFragment();

        fragmentManager.beginTransaction().replace(R.id.fragment, home).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (item.getItemId()) {
            case R.id.homeMenu:
                setTitle("Home");
                HomeFragment home = new HomeFragment();

                fragmentManager.beginTransaction().replace(R.id.fragment, home).commit();
                break;
            case R.id.basketMenu:
                setTitle("basket");
                BasketFragment basket= new BasketFragment();

                fragmentManager.beginTransaction().replace(R.id.fragment, basket).commit();
                break;
            case R.id.aboutUsMenu:
                setTitle("aboutUs");
                AboutUsFragment aboutUs = new AboutUsFragment();

                fragmentManager.beginTransaction().replace(R.id.fragment, aboutUs).commit();
                break;
            case R.id.loginMenu:
                setTitle("Login");
                LoginFragment login = new LoginFragment();

                fragmentManager.beginTransaction().replace(R.id.fragment, login).commit();
                break;
            case R.id.catalogMenu:
                setTitle("Catalog");
                CatalogFragment catalog = new CatalogFragment();

                fragmentManager.beginTransaction().replace(R.id.fragment, catalog).commit();
                break;

        }

        return true;

    }
}
