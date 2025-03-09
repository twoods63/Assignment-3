package com.assignment3;

import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static Pokemon spawn() {
        Pokemon p;
        Random ran = new Random();
        int level = ran.nextInt(21);
        int type = ran.nextInt(4);
        if (type == 1) {
            p = new Bulbasaur(level);
        } else if (type == 2) {
            p = new Charmander(level);
        } else {
            p = new Caterpie(level);
        }
        System.out.println("You encounter " + p);
            return p;
        }
        public static float throwBall() {
            String ball, berry, isCurveBall;
            float ballMultiplier, berryMultiplier, curveMultiplier;
            System.out.println("What type of ball do you wish to use? (Poke, Great, Ultra)");
            ball = sc.nextLine();

            if (ball.equalsIgnoreCase("Poke")) {
                ballMultiplier = 1.0f;
            } else if (ball.equalsIgnoreCase("Great")) {
                ballMultiplier = 1.5f;
            } else {
                ballMultiplier = 2.0f;
            }
            System.out.println("What berry do you wish to use? (None, Razz, SilverPinap, GoldenRazz)");
            berry = sc.nextLine();
            if (berry.equalsIgnoreCase("Razz")) {
                berryMultiplier = 1.5f;
            } else if (berry.equalsIgnoreCase("SilverPinap")) {
                berryMultiplier = 1.8f;
            } else if (berry.equalsIgnoreCase("GoldenRazz")) {
                berryMultiplier = 2.5f;
            } else {
                berryMultiplier = 1.0f;
            }
            System.out.println("Is this a curveball? (Yes or No)");
            isCurveBall = sc.nextLine();
            if (isCurveBall.equalsIgnoreCase("Yes")) {
                curveMultiplier = 1.7f;
            } else {
                curveMultiplier = 1.0f;
            }
            return ballMultiplier * berryMultiplier * curveMultiplier;
        }
        public static void main (String[] args) {
            Pokedex myDex = new Pokedex();
            Pokemon pokemon;

            float multiplier, catchProbability;
            float cpm = 0.49985844f;
            boolean caught;
            String response;

            do {
                pokemon = spawn();
                caught = false;
                do {
                    multiplier = throwBall();
                    catchProbability = (float)(1 - Math.pow((1 - pokemon.getBaseCatchRate() / (2 * cpm)), multiplier));
                    float value = (float)Math.random();
                    if (value < catchProbability) {
                        caught = true;
                        System.out.println(pokemon + " Caught!");
                        myDex.addToDex(pokemon);
                    } else {
                        System.out.println("Oops, " + pokemon + " jumped out, try again!");
                    }
                } while (!caught);
                System.out.println("Continue Catching Pokemon? (Y/N)");
                response = sc.nextLine();
            } while (response.equalsIgnoreCase("Y"));
            System.out.println("You have the following pokemon: ");
            System.out.println(myDex);
        }
}