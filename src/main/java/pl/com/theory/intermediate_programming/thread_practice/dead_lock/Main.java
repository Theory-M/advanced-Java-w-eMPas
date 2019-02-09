package pl.com.theory.intermediate_programming.thread_practice.dead_lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Queue<String> first = new LinkedList<>();
        Queue<String> second = new LinkedList<>();

        Copier copier = new Copier(first, second);
        // kolejnosc second first nie ma znaczenia... ? -- MA ZNACZENIE, bo moge zaglodzic watki:
//        Producer producer = new Producer(second, first, new Random());
        Producer producer = new Producer(first, second, new Random());
        // moge tez: FIRST, FIRST
//        Producer producer = new Producer(first, first, new Random());

        ExecutorService workers = Executors.newFixedThreadPool(2);

        workers.execute(copier);
        workers.execute(producer);

    }
}
