package main.java.service;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Inside: " + Thread.currentThread().getName());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<String> task = () -> {
            System.out.println("Execute task inside: " + Thread.currentThread().getName());
            return Service.start();
        };
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            Future result = executorService.submit(task);
            System.out.println(" The Result of your request: " + result.get());
        }
        executorService.shutdown();
    }
}

