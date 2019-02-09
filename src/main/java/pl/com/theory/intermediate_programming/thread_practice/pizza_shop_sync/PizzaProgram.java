package pl.com.theory.intermediate_programming.thread_practice.pizza_shop_sync;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PizzaProgram {

    public static void main(String[] args) {

        // implementacja Queue jest na przyklad LinkedList
        Queue<Pizza> pizzas = new LinkedList<>();

        Lock lock = new ReentrantLock();

        // tworze obiekty operujace na 'pizzas'
        PizzaMaker pizzaMaker1 = new PizzaMaker(pizzas, lock);
        PizzaMaker pizzaMaker2 = new PizzaMaker(pizzas, lock);
        PizzaEater pizzaEater1 = new PizzaEater(pizzas, lock);
        PizzaEater pizzaEater2 = new PizzaEater(pizzas, lock);
        PizzaEater pizzaEater3 = new PizzaEater(pizzas, lock);
        PizzaEater pizzaEater4 = new PizzaEater(pizzas, lock);

        ExecutorService workers = Executors.newFixedThreadPool(6);

        workers.execute(pizzaMaker1);
        workers.execute(pizzaEater1);
        workers.execute(pizzaEater2);
        workers.execute(pizzaEater3);
        workers.execute(pizzaEater4);
        workers.execute(pizzaMaker2);

        workers.shutdown();

    }
}
