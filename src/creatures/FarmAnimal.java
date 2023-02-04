package creatures;

import other.Edbile;

public class FarmAnimal extends Animal implements Edbile {

    boolean beEaten = false;
    public FarmAnimal(String species, Double weight) {
        super(species, weight);
    }

    @Override
    public boolean beEaten() {
        return beEaten;
    }
}
