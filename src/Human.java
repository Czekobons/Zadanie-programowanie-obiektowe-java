import java.util.Calendar;
import java.util.Date;

public class Human {
    final String firstName;
    final String lastName;
    private Double salary;
    private Double lastSalary;
    final Integer yearOfBirth;
    public Double weight;
    public Animal pet;
    public Car car;
    private Date salaryCheckDate;

    public Human(String firstName, String lastName, int yearOfBirth, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
    }
    public Double getSalaryInfo() {

        if(lastSalary == null) {
            lastSalary = salary;
        }
        if(salaryCheckDate == null) {
            System.out.println("Your salary wasn't checked.");
        }
        else {
            System.out.println("Your salary was last check " + salaryCheckDate+ " and it was worth "+lastSalary+".");
        }
        System.out.println("You earn now "+salary+" every month.");
        Calendar calendar = Calendar.getInstance();
        salaryCheckDate = calendar.getTime();
        return salary;
    }
    public void setSalary(Double salary) {
        if(salary < 0) {
            throw new IllegalArgumentException();
        }
        lastSalary = salary;
        System.out.println("New data are sending to accounting system.");
        System.out.println("You need to take your annex to contract from Hania from HR as soon as possible.");
        System.out.println("Be aware that ZUS and US already know about your new salary, so please don't try to hide it.");
        this.salary = salary;
    }
}
