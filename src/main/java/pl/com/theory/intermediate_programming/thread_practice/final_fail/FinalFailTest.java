package pl.com.theory.intermediate_programming.thread_practice.final_fail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FinalFailTest {

    public static void main(String[] args) {

        Object lock1 = new Object();
//        Object lock2 = new Object();

        FinalFail job1 = new FinalFail(lock1);
        FinalFail job2 = new FinalFail(lock1);

        ExecutorService workers = Executors.newFixedThreadPool(4);

        // beda sie wykonywali po kolei, bo synchronizuje na 1 obiekcie:
        workers.execute(job1);
        workers.execute(job2);
        workers.execute(job1);
        workers.execute(job2);
        workers.execute(job1);

        // teraz beda 2 na raz
        FinalFail job3 = new FinalFail(new Object());
        workers.execute(job3);
    }
}
