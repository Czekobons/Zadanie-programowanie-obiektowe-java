package devices;

public abstract class Device {
    public final String producer;
    public final String model;
    public final Integer yearOfProduction;
    public boolean isOn;

    protected Device(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }
    abstract void turnOn();

    public String toString() {
        return producer+" "+model+", "+yearOfProduction;
    }
}