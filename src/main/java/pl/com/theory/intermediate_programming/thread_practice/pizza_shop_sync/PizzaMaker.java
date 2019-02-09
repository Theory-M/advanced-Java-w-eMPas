package pl.com.theory.intermediate_programming.thread_practice.pizza_shop_sync;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PizzaMaker implements Runnable {

    private Queue<Pizza> pizzas;
    private final Lock lock;

    public PizzaMaker(Queue<Pizza> pizzas, Lock lock){
        this.pizzas = Objects.requireNonNull(pizzas);
        this.lock = lock;
    }

    @Override
    public void run() {
        // co 1 sekunde
        // za pomoca LOCK:
        Pizza newPizza = new Pizza("A","Ser");
        System.out.println("prepping: ");
        lock.lock();
        pizzas.offer(newPizza);
        lock.unlock();

//            while (true) {
//                // taka synchronizacja dalej nie jest idealna, co intelliJ podpowiada...
//                synchronized (pizzas) {
////            Pizza newPizza = new Pizza("vesuvio", "grzyby");
////
////            System.out.println("preparing new pizza: " + newPizza);
////            pizzas.offer(newPizza);
//
////            System.out.println("Preparing new pizza: ");
//
//                    pizzas.offer(new Pizza("margharita", "ser, sos"));
//                }
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                       e.printStackTrace();
//                    }
//
//            }
    }
}
