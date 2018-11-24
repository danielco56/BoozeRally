package com.example.daniel.boozerally;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity  {
        private Button mBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mBtn1 = (Button) findViewById(R.id.harti);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHartile();
            }
        });
    }

    private void openHartile() {
        Intent intent = new Intent(this, hartile.class);
        startActivity(intent);
    }
}
