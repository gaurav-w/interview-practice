package com.company;

import java.util.HashSet;

public class Group extends HashSet<Person> {
    public static void main(String[] args) {
        Group g = new Group();
        g.add(new Person("Hans"));
        g.add(new Person("Lotte"));
        g.add(new Person("Jane"));
        g.add(new Person("Hans"));
        g.add(new Person("Jane"));
        System.out.println("Total: " + g.size());
    }
//    public boolean add(Object o) {
//        System.out.println("Adding: " + o);
//        return super.add(o);
//    }
}

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}