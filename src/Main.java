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
        Car tesla2 = new Car("Tesla", "Model S", 2007, 50000.0);
        me.setCar(tesla2);
        me.getCar();

        me.getSalaryInfo();
        me.getSalaryInfo();
        me.setSalary(2000.0);
        me.setSalary(3000.0);
        me.getSalaryInfo();
    }
}