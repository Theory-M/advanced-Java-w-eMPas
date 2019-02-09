package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.util.List;
import java.util.Objects;

public class StatKeeper implements Runnable {

    private static final String messagePattern =
            "\tNumber of all animals: [%d]\n" +
            "\t\tnumber of dead animals: [%d]\n" +
            "\t\tnumber of alive animals: [%d]\n";

    // liczba wszystkich zwietzat
//    private int NumberOfAnimals;
    private final List<Animal> animals;
    private final long timeIntervalInSec;
    // zyje
//    private boolean isAlive;
//    // martwe
//    private boolean isDead;
//    private BigInteger fedStat;

    public StatKeeper(List<? extends Animal> animals, long timeIntervalInSec) {
        // musze tez rzutowac
        this.animals = (List<Animal>) Objects.requireNonNull(animals);
        this.timeIntervalInSec = timeIntervalInSec;
//        this.isAlive = isAlive;
//        this.isDead = isDead;
//        this.fedStat = fedStat;
    }


    @Override
    public void run() {
        // wpuszczam do streama
        // tak tylko wypisze Alive
//        animals.stream().filter(Animal::isAlive).count();
        // jak chce tez nie Alive, to musze tak:

        while (true) {
            long allAnimalsNumber = animals.size();
            long numberOfAliveAnimals = animals.stream()
                    .filter(Animal::isAlive)
                    .count();
            long numberOfDead = allAnimalsNumber - numberOfAliveAnimals;
            System.out.println(String.format(messagePattern, allAnimalsNumber, numberOfDead, numberOfAliveAnimals));
            // inny sposob na dead:
            // animals.stream().filter(animal -> !animal.isAlive);
            // kiedys bedzie (not(Animal::isAlive))

            try {
                Thread.sleep(Utils.convertSecToMs(timeIntervalInSec));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
