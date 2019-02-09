package pl.com.theory.intermediate_programming.thread_practice.dead_lock;

import java.util.Queue;

// gosciu do kopiowania danych
public class Copier implements Runnable{

    // dwie kolejki
    private final Queue<String> source;
    private final Queue<String> destination;

    public Copier(Queue<String> source, Queue<String> destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (source) {
                synchronized (destination) {
                    // zabezpieczenie przed NULLem
                    if(!source.isEmpty()) {
                        String data = source.poll();
                        System.out.println("Copying item to another queue");
                        // z source dodajemy do destination: KOPIOWANIE
                        destination.offer(data);
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
