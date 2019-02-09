package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ostrich extends Animal {
    protected Ostrich(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }

    // metoda fabryczna:
    public static Ostrich createOstrichWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Ostrich result = new Ostrich(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Ostrich{" +
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
    public static Ostrich createOstrichWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                        BigInteger foodConsumptionPerCycle,
                                                        BigInteger foodQuantity,
                                                        BigInteger waterConsumptionPerCycle,
                                                        BigInteger waterQuantity){
        Ostrich result = Ostrich.createOstrichWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
