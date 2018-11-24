package com.example.daniel.boozerally;

import java.util.ArrayList;

public class Grup {

    private String nume;
    private ArrayList<String> membrii=new ArrayList<>();

    public Grup(String nume, ArrayList<String> membrii) {
        this.nume = nume;
        this.membrii = membrii;
    }

    public String getNume() {
        return nume;
    }

    public ArrayList<String> getMembrii() {
        return membrii;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setMembrii(ArrayList<String> membrii) {
        this.membrii = membrii;
    }
}
