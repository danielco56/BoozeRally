package com.example.daniel.boozerally;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UIGrup extends AppCompatActivity {
    private Button trackB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uigrup);
        Groups grup = new Groups();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grup.grupNou.getMembrii());
        ListView listView = (ListView) findViewById(R.id.listaP);
        listView.setAdapter(adapter);

        TextView tv = (TextView) findViewById(R.id.denumire);
        tv.setText(grup.grupNou.getNume());

        trackB=(Button)findViewById(R.id.trackB);

        trackB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(UIGrup.this, Trasee.class);
                startActivity(log);
            }
        });

    }
}
