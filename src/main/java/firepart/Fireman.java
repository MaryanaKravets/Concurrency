package main.java.firepart;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Fireman extends Thread {

    private CyclicBarrier waitPoint;

    Fireman(CyclicBarrier waitPoint, String name) {
        this.setName(name);
        this.waitPoint = waitPoint;
        this.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Fireman " + Thread.currentThread().getName() + " is waiting for a alarm");
            waitPoint.await();
            Thread.sleep(200);
            System.out.println("Fireman " + Thread.currentThread().getName() + " is ready to fight fire");
        } catch (BrokenBarrierException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
    

