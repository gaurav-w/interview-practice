package com.company;

import java.util.function.Function;

abstract class Abc {

    void fun() {
        System.out.println("1");
    }

    abstract class Bca {

        void fun() {
            System.out.println("2");
        }
    }
}

class SystemExit {


    public Function<String, String> f() {
        System.out.print("f");
        return String::toUpperCase;
    }

    public static void main(String[] args) {
        SystemExit e = new SystemExit();

        // Stream.of("a", "b", "c").map(e.f()).to ;

//        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
//
//        Abc a = new Abc() {
//        void fun(){
//                System.out.println("hi");
//            }
//        };
//
//        Abc.Bca ab = a. new Bca() {
//            void fun(){
//                System.out.println("hi2");
//            }
//        };
//
//        a.fun();
//        ab.fun();
//
//        for (int i = 0; i < arr.length; i++)
//        {
//            if (arr[i] >= 5)
//            {
//                System.out.println("exit...");
//
//                // Terminate JVM
//                System.exit(-1);
//            }
//            else
//                System.out.println("arr["+i+"] = " +
//                        arr[i]);
//        }
//        System.out.println("End of Program");
    }
}
