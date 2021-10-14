package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;


class Drink implements Comparable {
    public String name;

    public int compareTo(Object o) {
        return 0;
    }
}

public class CardBoard {
    Short story = 200;

    CardBoard go(CardBoard cb) {
        cb = null;
        return cb;
    }

    public static void parse(String str) {
//        try {
//            float f = Float.parseFloat(str);
//        } catch (NumberFormatException nfe) {
//            f = 0;
//        } finally {
//            System.out.println(f);
//        }
        Float p = new Float(2.23f);
        if (p < 3) {

        }
    }
    // public static void main(String[] args) {
    //     parse("invalid");
    //}

    public static void main(String[] args) {


        CardBoard c1 = new CardBoard();
        CardBoard c2 = new CardBoard();
        CardBoard c3 = c1.go(c2);
        c1 = null;


        ArrayList<String> strings = new ArrayList<String>();
        strings.add("aAaA");
        strings.add("AaA");
        strings.add("aAa");
        strings.add("AAaa");
        Collections.sort(strings);
        for (String s : strings) {
            System.out.print(s + " ");
        }


        Drink one = new Drink();
        Drink two = new Drink();
        one.name = "Coffee";
        two.name = "Tea";
        TreeSet set = new TreeSet();
        set.add(one);
        set.add(two);


//doStuff
    }
}


