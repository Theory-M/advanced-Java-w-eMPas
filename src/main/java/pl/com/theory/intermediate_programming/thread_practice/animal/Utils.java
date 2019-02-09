package pl.com.theory.intermediate_programming.thread_practice.animal;

public class Utils {

    private Utils(){
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public static long convertSecToMs(long timeIntervalInSec){
        return timeIntervalInSec * 1000;
    }
}
