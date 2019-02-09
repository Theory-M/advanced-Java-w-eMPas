package pl.com.theory.intermediate_programming.thread_practice.pizza_shop_sync;

public class Pizza {

    String pizzaName;
    String ingredients;

    public Pizza(String pizzaname, String ingredients) {
        this.pizzaName = pizzaname;
        this.ingredients = ingredients;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaName = pizzaname;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
