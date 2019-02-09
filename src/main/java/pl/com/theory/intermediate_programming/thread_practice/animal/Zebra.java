package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Zebra extends Animal {
    protected Zebra(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }
    // metoda fabryczna:
    public static Zebra createZebraWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Zebra result = new Zebra(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Zebra{" +
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
    public static Zebra createZebraWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                      BigInteger foodConsumptionPerCycle,
                                                      BigInteger foodQuantity,
                                                      BigInteger waterConsumptionPerCycle,
                                                      BigInteger waterQuantity){
        Zebra result = Zebra.createZebraWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
