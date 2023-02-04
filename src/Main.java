import creatures.Animal;
import creatures.Human;
import devices.Car;
import devices.Device;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("Terrier", 5.0);
        dog.feed();
        for(int i=0;i<4;i++) {
            dog.takeForWalk();
        }
        dog.feed();
        dog.takeForWalk();

        Car tesla = new Car("Tesla", "Model 3", 2018, 100000.0);
        Human me = new Human("Patryk", "Nowak", 1980, 20000.0);
        Human elon = new Human("Elon", "Musk", 1970, 1000000000.0);
        Car tesla2 = new Car("Tesla", "Model S", 2007, 50000.0);
        me.setCar(tesla2);
        me.getCar();

        me.getSalaryInfo();
        me.getSalaryInfo();
        me.setSalary(2000.0);
        me.setSalary(3000.0);
        me.getSalaryInfo();
        Car tesla3 = new Car("Tesla", "Model S", 2007, 50000.0);
        System.out.println(tesla2.equals(tesla3));
        System.out.println(dog);
        System.out.println(tesla2+", "+tesla3);

        Phone onePlus = new Phone("OnePlus", " 7PRO", 2020);
        onePlus.turnOn();
        me.getCar().turnOn();

        Device phone = new Phone("Iphone", "X", 2017);
        me.cash = 100.0;
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
        me.getCar().sell(me, elon, me.getCar().value);
        System.out.println(elon.getCar());


    }
}