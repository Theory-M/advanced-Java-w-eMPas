package pl.com.theory.intermediate_programming.thread_practice.notify;

import java.util.concurrent.locks.Lock;

public class Hip implements Runnable {

    // moze byc na zwyklym Object, nie lock "private final Object o;"
    private final Lock lock;

    public Hip(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock) {
                lock.notifyAll();
                System.out.println("HiP");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
