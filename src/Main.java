import creatures.Animal;
import creatures.FarmAnimal;
import creatures.Human;
import creatures.Pet;
import devices.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Animal dog = new Pet("Terrier", 5.0);
        dog.feed();
        for(int i=0;i<4;i++) {
            dog.takeForWalk();
        }
        dog.feed();
        dog.takeForWalk();

        Car bmw = new Diesel("BMW", "X4", 2018, 100000.0, 600.0);
        Car bmw2 = new Diesel("BMW", "X4", 2018, 100000.0, 600.0);
        Car fiat = new LPG("Fiat", "125p", 2007, 50000.0, 500.0);
        Car tesla3 = new Electric("Tesla", "Model S", 2007, 50000.0, 450.0);
        Car kia = new LPG("Kia", "Sportage", 2016, 500000.0, 550.0);

        Human me = new Human("Patryk", "Nowak", 1980, 20000.0);
        Human elon = new Human("Elon", "Musk", 1970, 1000000000.0);

        me.cash = 3000000.0;
        me.setCar(bmw, 0);
        me.getCar(0);

        me.getSalaryInfo();
        me.getSalaryInfo();
        me.setSalary(2000.0);
        me.setSalary(3000.0);
        me.getSalaryInfo();

        System.out.println(bmw.equals(bmw2));
        System.out.println(dog);
        System.out.println(bmw+", "+bmw2);

        Phone onePlus = new Phone("OnePlus", " 7PRO", 2020, 3000.0);
        onePlus.turnOn();
        me.getCar(0).turnOn();
        me.setCar(tesla3, 1);

        Device phone = new Phone("Iphone", "X", 2017, 1000.0);
        elon.cash = 1000000.0;
        me.device = phone;
        phone.sell(me, elon, 1000.0);
        if(me.device != null) {
            System.out.println(me.device);
        }
        else {
            System.out.println("You dont have any device");
        }

        System.out.println("This is elon device: "+elon.device);
        System.out.println("this 1 = "+me.getCar(1));
        me.getCar(1).sell(me, elon, me.getCar(1).value);
        System.out.println(elon.getCar(0));
        onePlus.installAnApp("https://unsplash.com/photos/aqM730y624E/download?force=true");
        me.getCar(0).driveCar(200.0);
        me.getCar(0).refuel();
        System.out.println("Value of cars in you garage is equal to: "+me.carsValue());
        me.setCar(bmw2, 1);
        System.out.println("Value of cars in you garage is equal to: "+me.carsValue());
        me.setCar(fiat, 2);
        me.setCar(kia, 3);
        me.sortCarsByYear();
        System.out.println(me.garageSort);
    }
}