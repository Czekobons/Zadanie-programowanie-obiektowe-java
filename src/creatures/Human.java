package creatures;

import devices.Car;
import devices.Device;

import java.util.*;

public class Human {
    final String firstName;
    final String lastName;
    public Device device;
    private Double salary;
    private Double lastSalary;
    public Double cash;

    private static final Integer DEFAULT_GARAGE_SIZE = 5;
    private static final Double DEFAULT_CASH = 1000.0;

    final Integer yearOfBirth;
    public Double weight;
    public Animal pet;
    private Date salaryCheckDate;
    public Car[] garage;
    public List<Car> garageSort = new ArrayList<>();
    Car car;
    public int garageSize;

    public Human(String firstName, String lastName, int yearOfBirth, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
        garage = new Car[DEFAULT_GARAGE_SIZE];
        cash = DEFAULT_CASH;
    }

    public Human(String firstName, String lastName, int yearOfBirth, Double salary, int garageSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
        this.garageSize = garageSize;
    }

    public Double getSalaryInfo() {

        if (lastSalary == null) {
            lastSalary = salary;
        }
        if (salaryCheckDate == null) {
            System.out.println("Your salary wasn't checked.");
        } else {
            System.out.println("Your salary was last check " + salaryCheckDate + " and it was worth " + lastSalary + ".");
        }
        System.out.println("You earn now " + salary + " every month.");
        Calendar calendar = Calendar.getInstance();
        salaryCheckDate = calendar.getTime();
        return salary;
    }
    public void sortCarsByYear() {
        for (Car car: garage) {
            if(car != null) {
                garageSort.add(car);
            }
        }
        Collections.sort(garageSort, new Comparator<Car>() {
            public int compare(Car car1, Car car2) {
                return car1.yearOfProduction - car2.yearOfProduction;
            }
        });
    }
    public void setSalary(Double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException();
        }
        lastSalary = salary;
        System.out.println("New data are sending to accounting system.");
        System.out.println("You need to take your annex to contract from Hania from HR as soon as possible.");
        System.out.println("Be aware that ZUS and US already know about your new salary, so please don't try to hide it.");
        this.salary = salary;
    }

    public Car getCar(Integer parkPlace) throws Exception {
        if (garage[parkPlace] == null) {
            throw new Exception("This car does nor exist.");
        }
        //return (Car) this.car;
        if (parkPlace >= 0 && parkPlace < garage.length) {
            System.out.println("la la la");
            return this.garage[parkPlace];
        } else {
            System.out.println("Value of parking place is wrong.");
        }
        return null;
    }

    public void setCar(Car car, int parkPlace) throws Exception {
        if (parkPlace > garage.length || parkPlace < 0) {
            throw new Exception("Value of parking place is wrong.");
        }
        if (car.value < cash) {
            System.out.println("Congratulation. You bought your car with cash.");
            car = car;
            this.garage[parkPlace] = car;
            car.owners.add(this);
        } else if (car.value / 12 < salary) {
            System.out.println("You bought your car but you will have to pay your debt.");
            car = car;
            this.garage[parkPlace] = car;
            car.owners.add(this);
        } else {
            System.out.println("You have to sigin in to univeristy and find new job or get a rise if you want to buy this car.");
        }
    }

    public String toString() {
        return firstName + " " + lastName + ", Year of Birth: " + yearOfBirth + ", Salary: " + salary;
    }

    public Double getCash() {
        return cash;
    }

    public Double carsValue() {
        Double carsValue = 0.0;
        for (Car car : this.garage) {
            if (car != null) {
                carsValue += car.value;
            }
        }
        return carsValue;
    }

    public void addCash(double amount) {
        this.cash += amount;
    }

    public boolean hasACar(Car car) {
        for (Car value : garage) {
            if (value == car) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFreeSpace() {
        for (Car car : garage) {
            if (car == null) {
                return true;
            }
        }
        return false;
    }

    public void addCar(Car car) {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == null) {
                garage[i] = car;
                return;
            }
        }
    }

    public void removeCar(Car car) {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i] == car) {
                garage[i] = null;
                return;
            }
        }
    }
}
