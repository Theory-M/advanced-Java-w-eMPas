package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.util.List;
import java.util.Objects;

public class Consumption implements Runnable {

    private final List<Animal> animals;
    private final long timeIntervalInMs;

    public Consumption(List<? extends Animal> animals, long timeIntervalInMs){
        this.animals = (List<Animal>) Objects.requireNonNull(animals);
        this.timeIntervalInMs = timeIntervalInMs;
    }

    @Override
    public void run() {
        while (true){

            animals
                    .forEach(Animal::consumeCalories);

            try {
                Thread.sleep(Utils.convertSecToMs(timeIntervalInMs));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
