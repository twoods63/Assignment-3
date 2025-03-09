package com.assignment3;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Pokemon> myPokedex = new ArrayList<>();
    public void addToDex(Pokemon pokemon) {
        myPokedex.add(pokemon);
    }
   @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < myPokedex.size(); i++) {
            str += myPokedex.get(i).toString() + "\n";
        }
        return str;
    }
}
