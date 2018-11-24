package com.example.daniel.boozerally;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

public class hartile extends AppCompatActivity {
    private Button start;
    private Chronometer cronos;
    String[] Baruri = {"Studio 26","Booha","Niko","Living pub","Infinity"};
    String[] Bauturi = {"2 shoturi absint, o bere", "300ml de coniac", "500ml de vin","200ml de votca, o bere","100ml Unirea"};

    ListView list;
    private long lastpause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hartile);

        start =  findViewById(R.id.start);
        cronos = findViewById(R.id.crono);

        list = findViewById(R.id.lista);
        MyAdapter adapter = new MyAdapter(this, Baruri, Bauturi);
        list.setAdapter(adapter);


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


    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String myBaruri[];
        String myBauturi[];

        MyAdapter(Context c, String[] baruri, String[] bauturi){
            super(c,R.layout.row,R.id.bar, Baruri);
            this.context=c;
            this.myBaruri=baruri;
            this.myBauturi=bauturi;
        }

        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myBar = row.findViewById(R.id.bar);
            TextView myBautura = row.findViewById(R.id.bauturi);

            myBar.setText(Baruri[position]);
            myBautura.setText(Bauturi[position]);
            return row;
        }
    }

}
