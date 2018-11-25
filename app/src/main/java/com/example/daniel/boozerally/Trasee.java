package com.example.daniel.boozerally;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Trasee extends AppCompatActivity {

    private ImageView traseu0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasee);

        traseu0 = (ImageView)findViewById(R.id.imagineTraseu0);


        traseu0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trasee.this,hartile.class);
                startActivity(intent);
            }
        });




    }
}