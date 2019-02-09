package pl.com.theory.intermediate_programming.thread_practice.animal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Optional;

// abstrakcyjna
public abstract class Animal {


    // dostep tylko z tych klas, wiec protected
    protected BigInteger waterQuantity; // BigInteger to klasa, wiec zeby wykonywac operacje trzeba uzyc metod + not Optional
    protected BigInteger waterConsumptionPerCycle; // not Optional
    // oprocz tego, int, double itp -- sa niedokladne
    protected BigInteger foodQuantity; // not Optional
    protected BigInteger foodConsumptionPerCycle; // not Optional
    protected boolean isAlive; // not Optional
    protected BigDecimal weight; // req + not Optional
    // plec ENUMem
    protected Sex sex; // req + not Optional
    protected String name; // Optional -- inny getter -- Optional.ofNullable(name)
    // nizej jest walidator generyczny

    // robie Constructor tylko z polami wymaganymi:
    protected Animal(BigDecimal weight, Sex sex) {
        // i automatycznie ma isAlive true
        isAlive = true;

        // requiredNonNul
        this.weight = Objects.requireNonNull(weight, "param [weight] cannot be null!!!");
        // mozna tez tak, ale Mariusz mowi ze jak wyzej jest lepiej, troche
        Objects.requireNonNull(this.sex = sex, "param [sex] cannot be null!!!");

    }

    // to co chce dodac BigInty sie inaczej dodaje
    public void eatAndDrink(BigInteger foodIncreaseQuantity, BigInteger waterIncreaseQuantity){
        if (isAlive) {
            foodQuantity = foodQuantity.add(foodIncreaseQuantity);
            waterQuantity = waterQuantity.add(waterIncreaseQuantity);
        }
    }

    public void consumeCalories(){
        if (isAlive){
            foodQuantity = foodQuantity.subtract(foodConsumptionPerCycle);
            waterQuantity = waterQuantity.add(waterConsumptionPerCycle);
        }

        // ustawianie ze zwierze jest martwe, jesli nie ma jedzenia
        if (foodQuantity.intValue() <= 0 || waterQuantity.intValue()<=0){
            setAlive(false);
        }

    }

    public BigInteger getWaterQuantity() {
        return waterQuantity;
    }

    public BigInteger getWaterConsumptionPerCycle() {
        return waterConsumptionPerCycle;
    }

    public BigInteger getFoodQuantity() {
        return foodQuantity;
    }

    public BigInteger getFoodConsumptionPerCycle() {
        return foodConsumptionPerCycle;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public Sex getSex() {
        return sex;
    }

    //Opcjonalne imie
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    // Walidator generyczny dla parametrow
    private <T>T validate (T value, String failMessage){
        if (null == value)
            throw new NullPointerException(failMessage);
        return value;
    }

    @Override
    public String toString() {
        return "Animal{" +
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

    // SETTERY  z walidacja -- sex i name, nie potrzebuja setterow, bo nie beda zmienialne
    public void setWaterQuantity(BigInteger waterQuantity) {
        this.waterQuantity = validate(waterQuantity, "[foodQuantity] cannot be null");
    }

    public void setWaterConsumptionPerCycle(BigInteger waterConsumptionPerCycle) {
        this.waterConsumptionPerCycle = validate(waterConsumptionPerCycle, "[waterConsumptionPerCycleCannotBeNull");
    }

    public void setFoodQuantity(BigInteger foodQuantity) {
        this.foodQuantity = validate(foodQuantity, "cannot be nulle");
    }

    public void setFoodConsumptionPerCycle(BigInteger foodConsumptionPerCycle) {
        this.foodConsumptionPerCycle = validate(foodConsumptionPerCycle, "canont be nu");
    }

    public void setAlive(boolean alive) {
        isAlive = validate(alive, "cannotbe null");
    }

    public void setWeight(BigDecimal weight) {
        this.weight = validate(weight, "cannot be null");
    }
}
