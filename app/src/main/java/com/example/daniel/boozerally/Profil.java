package com.example.daniel.boozerally;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profil extends AppCompatActivity {
    private Button trasee,grupe,clasamentt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        trasee = (Button)findViewById(R.id.Trasee);
        grupe = (Button)findViewById(R.id.grupe);
        clasamentt = (Button) findViewById(R.id.clasament);

        trasee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Profil.this,Trasee.class);
                startActivity(intent1);
            }
        });

        grupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Profil.this,Groups.class);
                startActivity(intent2);
            }
        });

        clasamentt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Profil.this,Clasament.class);
                startActivity(intent3);
            }
        });
    }
}
