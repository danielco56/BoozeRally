package com.example.daniel.boozerally;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Groups extends AppCompatActivity {
    Register reg;
    int i;
    public static Grup grupNou;
    private ArrayList<String> numePersoane=new ArrayList<String>();

    private EditText denumire;
    private Button   save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_groups);
        reg = new Register();


        denumire=(EditText)findViewById(R.id.denGrup);
        save=(Button)findViewById(R.id.addButton);


        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reg.Users);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Groups.this, reg.Users.get(position) + "Adaugat",Toast.LENGTH_LONG).show();
                numePersoane.add(reg.Users.get(position));

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 grupNou=new Grup(denumire.getText().toString(),numePersoane);
                Intent intent= new Intent(Groups.this, UIGrup.class);
                startActivity(intent);
            }
        });
    }
}
