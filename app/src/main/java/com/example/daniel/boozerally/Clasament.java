package com.example.daniel.boozerally;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Clasament extends AppCompatActivity {

    private String nume[] ={"Black Hats","PoliHack"};
    private String puncte[] = {"43 Puncte","6 Puncte"};
    private String time[]={"30:50","00:10"};
    private int poza[]={R.drawable.crowntwo,R.drawable.greycrown};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasament);

        list = findViewById(R.id.clasamentList);

        MyAdapter adapter = new MyAdapter(this, nume,poza,time,puncte);
        list.setAdapter(adapter);
        list.setSelector(android.R.color.transparent);
        list.setDivider(null);

    }



    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myName[];
        String myPuncte[];
        String myTime[];
        int myPoza[];

        MyAdapter(Context c, String[] nume,int[] poza, String[] timp,String[] puncte)
        {
            super(c,R.layout.adapter_clasament,R.id.numeEchipa,nume);
            this.context=c;
            this.myName=nume;
            this.myPoza=poza;
            this.myTime=timp;
            this.myPuncte=puncte;

        }

        @NonNull
        @Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View adapter = layoutInflater.inflate(R.layout.adapter_clasament,parent,false);
            ImageView poza = adapter.findViewById(R.id.poza);
            TextView nume = adapter.findViewById(R.id.numeEchipa);
            TextView timp = adapter.findViewById(R.id.timpEchipa);
            TextView puncte = adapter.findViewById(R.id.puncteEhipa);

            poza.setImageResource(myPoza[position]);
            nume.setText(myName[position]);
            timp.setText(myTime[position]);
            puncte.setText(myPuncte[position]);

            return adapter;
        }
    }


}
