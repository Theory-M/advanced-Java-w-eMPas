package pl.com.theory.intermediate_programming.thread_practice.notify;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

public class Hop implements Runnable {

    private final Object o;

    public Hop(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        while(true){
            synchronized (o) {
                o.notifyAll();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hOOOp");
            }
        }
    }
}
