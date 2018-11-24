package com.example.daniel.boozerally;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UIGrup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uigrup);
        Groups grup=new Groups();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grup.grupNou.getMembrii());
        ListView listView = (ListView) findViewById(R.id.listaP);
        listView.setAdapter(adapter);

        TextView tv=(TextView)findViewById(R.id.denumire);
        tv.setText(grup.grupNou.getNume());

    }
}
