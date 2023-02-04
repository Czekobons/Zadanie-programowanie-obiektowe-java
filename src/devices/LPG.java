package devices;

public class LPG extends Car{

    private Double DEFAULT_RANGE = 550.0;
    public LPG(String producer, String model, Integer yearOfProduction, Double value, Double maxRange) {
        super(producer, model, yearOfProduction, value, maxRange);
        range = DEFAULT_RANGE;
    }

    @Override
    public void refuel() {
        if(range >= maxRange) {
            System.out.println("Gas tank is full.");
        }
        else {
            System.out.println("Connecting gas to car....");
            System.out.println("Loading gas...");
            System.out.println("Gas tank is full.");
            range = maxRange;
        }
    }
}
