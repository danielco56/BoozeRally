package com.example.daniel.boozerally;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        ListView mListView = (ListView) findViewById(R.id.listView);

        Grup g1=new Grup("Camera 201","3");
        Grup g2=new Grup("Camera 205","4");

        ArrayList<Grup> listaGrupuri=new ArrayList<>();
        listaGrupuri.add(g1);
        listaGrupuri.add(g2);

        ListAdapter adapter = new ListAdapter(this, R.layout.adapter_view_layout, listaGrupuri);
        mListView.setAdapter(adapter);
    }
}
