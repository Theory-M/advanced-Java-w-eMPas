package pl.com.theory.intermediate_programming.thread_practice.pizza_shop_sync;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class PizzaEater implements Runnable{

    Queue<Pizza> pizzas;
    private final Lock lock;

    public PizzaEater(Queue<Pizza> pizzas, Lock lock) {
        this.pizzas = Objects.requireNonNull(pizzas);
        this.lock = lock;
    }

    // propozycja przy rozwiazywaniu Nulla...
    public synchronized void showPizzas1(){
        pizzas.forEach(pizza -> System.out.println(pizza));
    }
    // to samo ale troche inaczej wyglada, ale moge w srodku wskazac obiekt,
    // ktory synchronizuje
    public void showPizzas2(){
        synchronized (this) {
            pizzas.forEach(pizza -> System.out.println(pizza));
        }
    }
    @Override
    public void run() {
        // 2 sekundy
        // za pomoca LOCK
        while(true){
//            if (lock.tryLock()){
//                System.out.println(Thread.currentThread().getName() + " locked the opbject");
//                lock.unlock();
//            }else {
//                System.out.println(Thread.currentThread().getName() + " DID NOT lock the object.");
//            }
            // tak tez... :
            lock.lock();
            pizzas.forEach(System.out::println);
            if(!pizzas.isEmpty()){
                Pizza pizzaToEat = pizzas.poll();
                System.out.println("Consuming pizza");
                System.out.println("ingredients: " + pizzaToEat.getIngredients());
            } else{
                System.out.println("there's no pizza to eat");
            }
            lock.unlock();
        }


        // jeszcze nie to co chce:
//        synchronized (this)
        // w jeden sposob moge synchronizowac tak: na OBIEKCIE, ktorego to ma dotyczyc

//        while (true) {
//            synchronized (pizzas) {
//                pizzas.forEach(System.out::println);
//
//                if (!pizzas.isEmpty()) {
//                    Pizza pizzaToEat = pizzas.poll();
//                    System.out.println("consuming");
//                    System.out.println("ingredients: " + pizzaToEat.getIngredients());
//                }
//                // wstep do zabezpieczenia przed nullem:
//                // jak uzyje isEmpty, to najpierw sprawdza czy jest pizza, i jesli jest,
//                // to probuje wziac, ale w tym czasie inny watek moze juz te pizze zabrac
//                // i bedzie NULL i tak...
////            if(!pizzas.isEmpty()) {
////
//////                pizzas.forEach(pizza -> System.out.println("I see a pizza"));
////
////                Pizza pizzaToEat = pizzas.poll();
////            }
////                System.out.println("zjadlem, prosze jeszcze: " + pizzaToEat.getPizzaName());
//            }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//             //klamra zamykajaca if + isEmpty
//        }
    }
}

