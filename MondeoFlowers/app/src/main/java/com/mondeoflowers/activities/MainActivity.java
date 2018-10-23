package com.example.a11500107.sunshine;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mondeoflowers.R;


public class MainActivity extends AppCompatActivity {

    Button btnExample;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opt_menu, menu);

        return true;
    }

    TextView textExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnExample = (Button) findViewById(R.id.alphaButton);
        ;
        btnExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textExample.setText("Button clicked");
            }




        });

    }
}
