package com.company;

public class MultiThread implements Runnable {

    String name;

    MultiThread(String name1) {
        this.name = name1;
    }

    public static void main(String[] args) {
        new Thread(new MultiThread("gaurav")).start();
        new Thread(new MultiThread("w")).start();
    }

    public synchronized void message(int n) {
        System.out.println(name + n);
    }

    @Override
    public void run() {
        message(1);
        message(2);
    }
}
