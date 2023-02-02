public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("Terrier", 5.0);
        dog.feed();
        for(int i=0;i<4;i++) {
            dog.takeForWalk();
        }
        dog.feed();
        dog.takeForWalk();

        Car tesla = new Car("Tesla", "Model 3", 2018);
        Human me = new Human("Patryk", "Nowak", 1980);
        me.car = new Car("Tesla", "Model S", 2007);
    }
}