// Java program to demonstrate
// the working of LinkedHashMap

import java.util.LinkedHashMap;

class LinkedHMP {

    public static void main(String args[]) {
        // Initialization of a LinkedHashMap
        // using Generics
        LinkedHashMap<Integer, String> hm
                = new LinkedHashMap<Integer, String>(4, 0.5f, true);

        // Inserting the Elements
        hm.put(3, "Geeks");
        hm.put(2, "Geeks");
        hm.put(1, "Geeks");

        System.out.println(hm);

        hm.put(2, "Geeks");

        System.out.println(hm);
    }
}
