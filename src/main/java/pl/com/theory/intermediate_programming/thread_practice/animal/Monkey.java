package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Monkey extends Animal {
    protected Monkey(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }

    // metoda fabryczna:
    public static Monkey createMonkeyWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Monkey result = new Monkey(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "waterQuantity=" + waterQuantity +
                ", waterConsumptionPerCycle=" + waterConsumptionPerCycle +
                ", foodQuantity=" + foodQuantity +
                ", foodConsumptionPerCycle=" + foodConsumptionPerCycle +
                ", isAlive=" + isAlive +
                ", weight=" + weight +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }
    // ze wszystkimi parametrami
    public static Monkey createMonkeyWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                        BigInteger foodConsumptionPerCycle,
                                                        BigInteger foodQuantity,
                                                        BigInteger waterConsumptionPerCycle,
                                                        BigInteger waterQuantity){
        Monkey result = Monkey.createMonkeyWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
