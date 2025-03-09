package com.assignment3;

public class Charmander extends Pokemon {
    public Charmander(int level) {
        super(level, 0.2);
    }
    public String toString() {
        return "A level " + getLevel() + " Charmander";
    }
}
