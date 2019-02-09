package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Elephant extends Animal{
    protected Elephant(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }

    // metoda fabryczna:
    public static Elephant createElephantWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Elephant result = new Elephant(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Elephant{" +
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
    public static Elephant createElephantWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                        BigInteger foodConsumptionPerCycle,
                                                        BigInteger foodQuantity,
                                                        BigInteger waterConsumptionPerCycle,
                                                        BigInteger waterQuantity){
        Elephant result = Elephant.createElephantWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
