package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Wolf extends Animal {
    protected Wolf(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }

    // metoda fabryczna:
    public static Wolf createWolfWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Wolf result = new Wolf(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Wolf{" +
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
    public static Wolf createWolfWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                      BigInteger foodConsumptionPerCycle,
                                                      BigInteger foodQuantity,
                                                      BigInteger waterConsumptionPerCycle,
                                                      BigInteger waterQuantity){
        Wolf result = Wolf.createWolfWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
