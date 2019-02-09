package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooProgram {

    public static void main(String[] args) {

        Random random = new Random();
//        char c = (char) random.nextInt(255);

        List<Wolf> wolves = Arrays.asList(
                Wolf.createWolfWithAllPropertiesSet(
                        BigDecimal.valueOf(5 + random.nextInt(255)),
                        Sex.MALE,
                        "Dingo",
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255))
                ),
                Wolf.createWolfWithAllPropertiesSet(
                        BigDecimal.valueOf(random.nextInt(255)),
                        Sex.MALE,
                        "Rex",
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255))
                ),
                Wolf.createWolfWithAllPropertiesSet(
                        BigDecimal.valueOf(random.nextInt(255)),
                        Sex.MALE,
                        "Azor",
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255))
                ),
                Wolf.createWolfWithAllPropertiesSet(
                        BigDecimal.valueOf(random.nextInt(255)),
                        Sex.MALE,
                        "Zuper",
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255))
                ),
                Wolf.createWolfWithAllPropertiesSet(
                        BigDecimal.valueOf(random.nextInt(255)),
                        Sex.MALE,
                        "Dawaj",
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255)),
                        BigInteger.valueOf(random.nextInt(255))
                ));

        ZooKeeper johnny = new ZooKeeper(wolves,1 + random.nextInt(10), "Johnny");
        ZooKeeper steve = new ZooKeeper(wolves,10 + random.nextInt(10), "Stevie");

        StatKeeper statKeeper = new StatKeeper(wolves, 5);
        Consumption consumption = new Consumption(wolves, 1+ random.nextInt(5));

        // 1st way: mniej skuteczny, bo w niektorych przypadkach trzeba by robic zbyt duzo obiektow, petli...
        // a te Thread sa bardzo kosztownymi obiektami w obszarze zasobow
        Thread johnniesThread = new Thread(johnny);
        Thread stevesThread = new Thread(steve);
        Thread consumptionThread = new Thread(consumption);
        Thread statThread = new Thread(statKeeper);

        johnniesThread.start();
        stevesThread.start();
        consumptionThread.start();
        statThread.start();

        // watek mozna wystartowac tylko raz -- to mi da IllegalThreadStateException:
        // statThread.start();

        // 2nd way
        ExecutorService workers = Executors.newFixedThreadPool(4);

        workers.execute(johnny);
        workers.execute(steve);
        workers.execute(statKeeper);
        workers.execute(consumption);







//        // DYGRESJA o IMMUTABLE
//        BigInteger one = BigInteger.valueOf(1);
//        one.add(BigInteger.valueOf(2));
//        // one jest dalej 1
//        System.out.println(one);
//        // jak chce rzeczywiscie  dodac 2 do one, to musze napisac
//        one = one.add(BigInteger.valueOf(2));
//        System.out.println(one);
//
//        // podobnie tutaj
//        String ala = "Ala";
//        String b = ala + "ma";
//        System.out.println(ala);


    }
}
