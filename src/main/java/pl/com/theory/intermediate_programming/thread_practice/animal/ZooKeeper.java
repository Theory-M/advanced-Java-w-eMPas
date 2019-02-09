package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static pl.com.theory.intermediate_programming.thread_practice.animal.Utils.convertSecToMs;

// worker, bo sie z watkami laczy, wiec ma Runnable
public class ZooKeeper implements Runnable {

    // stale wartosci o jakie Workerzy zwiekszaja food i water
    private static BigInteger foodIncreaseLevel = BigInteger.valueOf(8);
    private static BigInteger waterIncreaseLevel = BigInteger.valueOf(5);
    // parametry
    private List<Animal> animals;
    private long timeIntervalInSec;
    private String name;

    // konstruktor
    public ZooKeeper(List<? extends Animal> animals, long timeIntervalInSec, String name){

        // musze rzutowac List Animal, bo jest w parametrach List<Animal>,
        // a chce moc dac Wolf, itp. Moglbym ustawic parametr jako "? extends",
        // ale w dalszych czesciach kodu musialbym znowu zmienic na rzutowanie
        this.animals = (List<Animal>) Objects.requireNonNull(animals);
        this.timeIntervalInSec = timeIntervalInSec;
        this.name = Objects.requireNonNull(name);
    }

    // ta nie musi byc static jesli nizej napisze this zamiast ZooKeeper
    private static void feedAndWaterAnimal(Animal animal) {
        animal.eatAndDrink(foodIncreaseLevel, waterIncreaseLevel);
    }

    @Override
    public void run() {
        while (true) {
            // najpierw zrobilem Lambde, a potem podpowiedz intelliJ na method reference
            // i nazwalem ja opisowo, tak zeby kod byl bardziej czytelny
            // jesli ZooKeeper zamienie na 'this', to powyzsza metoda nie musi byc 'static'
            // animals.forEach(animal -> animal.eatAndDrink(foodIncreaseLevel,waterIncreaseLevel));
            animals.forEach(ZooKeeper::feedAndWaterAnimal);
//        animals.forEach(this::feedAndWaterAnimal);
            try {
                // moge tez napisac Utils.convertSecToMs jesli nie zaimportuje statycznie klasy Utils
                Thread.sleep(convertSecToMs(timeIntervalInSec));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
