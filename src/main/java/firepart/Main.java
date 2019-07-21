package main.java.firepart;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Firemen at the work, and ready to work");
        CyclicBarrier barrier = new CyclicBarrier(4, new OneCall());
        new Fireman(barrier, "Jon");
        new Fireman(barrier, "Alex");
        new Fireman(barrier, "Olivia");
        new Fireman(barrier, "Jack");


    }
}
