package devices;

import creatures.Human;

public class Car extends Device{
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

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(seller.getCar() != this) {
            System.out.println("You can't sell car that you not own.");
        }
        else if(buyer.getCash() < price) {
            System.out.println("You don't have enough money to complete this transaction!");

        }
        else if(seller.equals(buyer)) {
            System.out.println("This transaction must be beetwen 2 diffrent persons.");
        }
        else {
            System.out.println("Transaction started...");
            buyer.addCash(-price);
            System.out.println("Transfering money...");
            seller.addCash(price);
            buyer.setCar(this);
            //seller.setCar(null);
            System.out.println("Transaction completed.");
        }
    }
}
