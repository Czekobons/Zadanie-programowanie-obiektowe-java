package creatures;

import other.Feedable;
import other.Sellable;

public abstract class Animal implements Sellable, Feedable {
    final String species;
    private Double weight;
    final public Integer DEFAULT_FOOD_WEIGHT = 2;

    public Animal(String species, Double weight) {
        this.species = species;
        this.weight = weight;
    }
    public void feed(int foodWeight) {
        if(weight > 0) {
            weight+=foodWeight;
            System.out.println("Thanks for food.");
        }
        else {
            System.out.println("Good job that you remember about it but it is a little bit too late.");
        }
    }
    public void feed() {
        feed(DEFAULT_FOOD_WEIGHT);
    }
    public void takeForWalk() {
        if(weight > 2) {
            weight-=2;
            System.out.println("Nice walk, thanks.");
        } else if (weight >0 && weight <= 2) {
            weight-=2;
            System.out.println("First feed me than take me for walk. I'm logging out from this world.");
            if(weight < 0) {
                weight = 0.0;
            }
        } else  {
            System.out.println("You are crazy, I'm already dead!");
        }
    }
    public String toString() {
        return species+" weight "+weight+".";
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {

    }
}
