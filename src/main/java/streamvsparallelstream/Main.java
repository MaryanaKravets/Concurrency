package main.java.streamvsparallelstream;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        int[] array = new int[10_000_000];
        for (int i = 0; i < array.length; i++)
            array[i] = i;

        int b = Integer.MIN_VALUE;
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > b) b = array[i];
        }
        long end = System.currentTimeMillis();
        System.out.println("For loop: " + (end - start) + "ms");

        int r = Integer.MIN_VALUE;
        long start1 = System.currentTimeMillis();
        for (int i : list) {
            if (i > r) r = i;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("For-each on list: " + (end1 - start1) + "ms");
        long start2 = System.currentTimeMillis();
        list.stream().reduce(Integer.MIN_VALUE, Math::max);
        long end2 = System.currentTimeMillis();
        System.out.println("Stream: " + (end2 - start2) + "ms");
        long start3 = System.currentTimeMillis();
        list.parallelStream().reduce(Integer.MIN_VALUE, Math::max);
        long end3 = System.currentTimeMillis();
        System.out.println("Parallel stream: " + (end3 - start3) + "ms");
    }
}
