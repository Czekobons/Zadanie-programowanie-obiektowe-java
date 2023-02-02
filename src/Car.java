public class Car {
    final String producer;
    final String model;
    Integer yearOfProduction;
    Double value;
    public String color;
    public Double power;

    public Car(String producer, String model, Integer yearOfProduction, Double value)
    {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }
}
