package devices;

import creatures.Human;

import java.util.Date;

public class Transactions {
    public Human buyer;
    public Human seller;
    public Double price;
    public Date dateOfTransaction;

    public Transactions(Human buyer, Human seller, Double price, Date dateOfTransaction) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.dateOfTransaction = dateOfTransaction;
    }

}
