package devices;

import creatures.Human;

public abstract class Car extends Device{

    public String color;
    public Double power;
    public Double maxRange;
    public Double range;

    public Car(String producer, String model, Integer yearOfProduction, Double value, Double maxRange)
    {
        super(producer, model, yearOfProduction, value);
        this.maxRange = maxRange;
    }
    public void driveCar(Double distance) {
        if (distance > range) {
            System.out.println("Refuel your car if you want to make this trip.");
            System.out.println("Range left " + range + " km.");

        } else {
            range -= distance;
            System.out.println("It was nice trip.");
            System.out.println("Range left " + range + " km.");
        }
    }
    public abstract void refuel();

    @Override
    public void turnOn() {
        System.out.println("I turn the key.");
        System.out.println("Enigine is running now.");
        isOn = true;
    }

    public String toString() {
        return producer+" "+model+", Produced in: "+yearOfProduction+" cost "+value;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if (!seller.hasACar(this)) {
            throw new Exception("Sprzedawca nie ma auta");
        }
        if (!buyer.hasFreeSpace()) {
            throw new Exception("You can't sell car that you not own.");
        }
        if (buyer.cash < price) {
            throw new Exception("You don't have enough money to complete this transaction!");
        }
        System.out.println("Transaction started...");
        buyer.addCar(this);
        seller.removeCar(this);
        buyer.cash -= price;
        System.out.println("Transfering money...");
        seller.cash += price;
        System.out.println("Transaction completed.");
    }
}
