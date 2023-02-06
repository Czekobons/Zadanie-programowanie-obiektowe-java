package devices;

public class Application {
    public String name;
    public Double version;
    public Double price;

    public final Double DEFAULT_VERSION = 1.0;
    public final Double DEFAULT_PRICE = 0.0;

    public Application(String name, Double version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }
    public Application(String name) {
        this.name =  name;
        version = DEFAULT_VERSION;
        price = DEFAULT_PRICE;
    }
}
