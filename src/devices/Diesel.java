package devices;

public class Diesel extends Car{

    private Double DEFAULT_RANGE = 600.0;
    public Diesel(String producer, String model, Integer yearOfProduction, Double value, Double maxRange) {
        super(producer, model, yearOfProduction, value, maxRange);
        range = DEFAULT_RANGE;
    }

    @Override
    public void refuel() {
        if(range >= maxRange) {
            System.out.println("Fuel tank is full.");
        }
        else {
            System.out.println("Connecting diesel to car....");
            System.out.println("Refueling car...");
            System.out.println("Fuel tank is full");
            range = maxRange;
        }
    }
}
