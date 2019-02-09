package pl.com.theory.intermediate_programming.thread_practice.notify;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyExample {

    public static void main(String[] args) {

//        Object o = new Object();
        Lock lock = new ReentrantLock();
        // tak wygladajacy kod bedzie czekal w nieskonczonosc,
        // chyba ze dodam mu timeout (o.wait(1000))
        // jednak kodowanie z czasem jest niebezpieczne
//        try {
//            System.out.println("Before");
//            synchronized (o) {
//                o.wait();
//            }
//            System.out.println("After");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Hip hip = new Hip(lock);
        Hop hop = new Hop(lock);

        Executor workers = Executors.newFixedThreadPool(2);

        workers.execute(hip);
        workers.execute(hop);

    }
}
