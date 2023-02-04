package devices;

public class Car extends Device{
    Integer yearOfProduction;
    public Double value;
    public String color;
    public Double power;

    public Car(String producer, String model, Integer yearOfProduction, Double value)
    {
        super(producer, model, yearOfProduction);
        this.value = value;
    }

    @Override
    public void turnOn() {
        System.out.println("I turn the key.");
        System.out.println("Enigine is running now.");
        isOn = true;
    }

    public String toString() {
        return producer+" "+model+", Produced in: "+yearOfProduction+" cost "+value;
    }
}
