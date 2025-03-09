package com.assignment3;

public class Caterpie extends Pokemon {
    public Caterpie(int level) {
        super(level, 0.5);
    }
    public String toString() {
        return "A level " + getLevel() + " Caterpie";
    }
}
