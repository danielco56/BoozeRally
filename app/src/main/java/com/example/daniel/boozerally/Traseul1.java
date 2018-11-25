package com.example.daniel.boozerally;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

public class Traseul1 extends AppCompatActivity {

    private Button start, finish;
    private Chronometer cronos;
    private String[] timp = {"20 Mins","30 Mins","1 Hour","30 Mins","10 Mins"};
    private String[] Baruri = {"Moonshine", "Enigma", "Shto", "Che Guevara"};
    private String[] Bauturi = {"4xBeer","5xBeer | 4xBeer","3xTequila | 3xWhiskey","8xBere"};
    private CheckBox box;
    private ListView list;
    private int nr=0;
    private long lastpause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traseul1);

        start =  findViewById(R.id.start);
        cronos = findViewById(R.id.crono);
        finish = findViewById(R.id.finish);

        list = findViewById(R.id.lista);
        MyAdapter adapter = new MyAdapter(this, Baruri, Bauturi, box, timp);
        list.setAdapter(adapter);
        list.setSelector(android.R.color.transparent);
        list.setDivider(null);

        box = (CheckBox)findViewById(R.id.checkbox);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lastpause != 0){
                    cronos.setBase(cronos.getBase() + SystemClock.elapsedRealtime() - lastpause);
                }
                else{
                    cronos.setBase(SystemClock.elapsedRealtime());
                }
                cronos.start();
                start.setEnabled(false);
            }
        });



            finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cronos.stop();
                    finish.setEnabled(false);
                    Intent intent=  new Intent(Traseul1.this,Clasament.class);
                    startActivity(intent);

                }
            });

    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myBaruri[];
        String myBauturi[];
        CheckBox box;
        String timp[];

        MyAdapter(Context c, String[] baruri, String[] bauturi, CheckBox box, String[] timp){
            super(c,R.layout.row,R.id.bar, Baruri);
            this.context=c;
            this.myBaruri=baruri;
            this.timp = timp;
            this.myBauturi=bauturi;
        }

        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView mytimp = row.findViewById(R.id.timp);
            TextView myBar = row.findViewById(R.id.bar);
            TextView myBautura = row.findViewById(R.id.bauturi);

            mytimp.setText(timp[position]);
            myBar.setText(Baruri[position]);
            myBautura.setText(Bauturi[position]);

            return row;
        }
    }
}
