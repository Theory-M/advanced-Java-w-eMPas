package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Eagle extends Animal {
    protected Eagle(BigDecimal weight, Sex sex) {
        super(weight, sex);
    }
    // metoda fabryczna:
    public static Eagle createEagleWithWeightAndSexAndName(BigDecimal weight, Sex sex, String name){
        Eagle result = new Eagle(weight, sex);
        return result;
    }

    @Override
    public String toString() {
        return "Eagle{" +
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
    public static Eagle createEagleWithAllPropertiesSet(BigDecimal weight, Sex sex, String name,
                                                      BigInteger foodConsumptionPerCycle,
                                                      BigInteger foodQuantity,
                                                      BigInteger waterConsumptionPerCycle,
                                                      BigInteger waterQuantity){
        Eagle result = Eagle.createEagleWithWeightAndSexAndName(weight, sex, name);
        result.setFoodQuantity(foodQuantity);
        result.setFoodConsumptionPerCycle(foodConsumptionPerCycle);
        result.setWaterQuantity(waterQuantity);
        result.setWaterConsumptionPerCycle(waterConsumptionPerCycle);
        return result;
    }
}
