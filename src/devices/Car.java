package devices;

import creatures.Human;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class Car extends Device{

    public String color;
    public Double power;
    public Double maxRange;
    public Double range;
    public List<Human> owners = new ArrayList<>();
    public List<Transactions> carTransactions = new ArrayList<>();

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
    public Boolean hadOwner() {
        if(owners.isEmpty()) {
            return false;
        }
        return true;
    }
    public Boolean checkTransactionBetween(Human seller, Human buyer) {
        for (Transactions transactions:carTransactions) {
            if(transactions != null) {
                if(transactions.seller.equals(seller) &&transactions.buyer.equals(buyer)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void numberOfTrans() {
        System.out.println("This car was on sell this many times: "+carTransactions.size());
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
        if(!seller.equals(owners.get(owners.size() - 1))) {
            throw new Exception("Seller is not last owner of the car, this car is stolen!");
        }
        System.out.println("Transaction started...");
        buyer.addCar(this);
        seller.removeCar(this);
        owners.add(buyer);
        buyer.cash -= price;
        System.out.println("Transfering money...");
        seller.cash += price;
        System.out.println("Transaction completed.");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        carTransactions.add(new Transactions(buyer, seller, price,date));
    }
}
