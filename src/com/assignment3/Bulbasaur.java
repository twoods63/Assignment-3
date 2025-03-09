package com.assignment3;

public class Bulbasaur extends Pokemon {
    public Bulbasaur(int level) {
        super(level, 0.2);
    }
    public String toString() {
        return "A level " + getLevel() + " Bulbasaur";
    }
}
