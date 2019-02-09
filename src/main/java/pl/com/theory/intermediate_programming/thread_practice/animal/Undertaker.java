package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.util.List;
import java.util.Objects;

// czy to potrzebne?
public class Undertaker implements Runnable {

    private final List<Animal> animals;
    private final long timeIntervalInMs;
    private final String name;

    public Undertaker(List<? extends Animal> animals, long timeIntervalInMs, String name){
        this.animals = (List<Animal>) Objects.requireNonNull(animals);
        this.timeIntervalInMs = timeIntervalInMs;
        this.name = Objects.requireNonNull(name);
    }
    @Override
    public void run() {

//        while (true){
//            animals.
//        }

    }
}
