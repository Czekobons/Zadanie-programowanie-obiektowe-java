package devices;

public class Phone extends Device{

    public double screenSize;
    public Integer storage;

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("I'm pushing the button.");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Phone is turned on.");
        isOn = true;
    }
}
