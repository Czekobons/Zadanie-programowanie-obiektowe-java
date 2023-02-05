package devices;

import creatures.Human;
import other.Sellable;

public abstract class Device implements Sellable {
    public final String producer;
    public final String model;
    public final Integer yearOfProduction;
    public boolean isOn;

    public Double value;

    protected Device(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }
    abstract void turnOn();

    public String toString() {
        return producer+" "+model+", "+yearOfProduction;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        if(seller.device != this) {
            System.out.println("You can't sell device that you not own.");
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
            buyer.device = this;
            seller.device = null;
            System.out.println("Transaction completed.");
        }
    }
}