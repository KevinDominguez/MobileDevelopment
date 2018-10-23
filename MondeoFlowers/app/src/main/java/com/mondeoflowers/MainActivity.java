package com.mondeoflowers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnExample;
    TextView textExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnExample = (Button) findViewById(R.id.startButton);
        textExample = (TextView) findViewById(R.id.mainTextView);
        btnExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textExample.setText("Button clicked");
            }
        });
    }
}
