package main.java.firepart;

public class OneCall extends Thread {
    @Override
    public void run() {
        System.out.println("ALARM!");
    }
}
