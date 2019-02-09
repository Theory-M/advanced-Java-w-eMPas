package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Lion extends Animal {
    protected Lion(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }

    // metoda fabryczna:
    public static Lion createLionWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Lion result = new Lion(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Lion{" +
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
    public static Lion createLionWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                        BigInteger foodConsumptionPerCycle,
                                                        BigInteger foodQuantity,
                                                        BigInteger waterConsumptionPerCycle,
                                                        BigInteger waterQuantity){
        Lion result = Lion.createLionWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
