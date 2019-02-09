package pl.com.theory.intermediate_programming.thread_practice.singleton;

public class SecretSingleton {


    // LAZY STYLE SINGLETON lazySingleton
    // taki nie jest skuteczny przy wielowatkowosci, bo 1szy watek sprawdzi czy jest null, utworzy,
    // i tak samo pozostale watki:
    private static SecretSingleton instance;

    private SecretSingleton(){
        // empty
    }

    public static void otherMethod(){
        // niesynchronizowana metoda, kazdy moze ja wykonac
    }
    public static SecretSingleton getINSTANCE() {
        if (instance == null){
            synchronized (SecretSingleton.class) {
                if(null==instance){
                    instance = new SecretSingleton();
                }
            }
        }
        return instance;
    }
}
