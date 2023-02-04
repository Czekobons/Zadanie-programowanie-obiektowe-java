package devices;

public class Electric extends Car{
    private Double DEFAULT_RANGE = 450.0;

    public Electric(String producer, String model, Integer yearOfProduction, Double value, Double maxRange) {
        super(producer, model, yearOfProduction, value, maxRange);
        range = DEFAULT_RANGE;
    }

    @Override
    public void refuel() {
        if(range >= maxRange) {
            System.out.println("Batteries are already fully charged.");

        }
        else {
            System.out.println("Connecting power to car....");
            System.out.println("Charging...");
            System.out.println("Full battery capacity");
            range = maxRange;
        }
    }
}
