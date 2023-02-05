package devices;

import creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Phone extends Device{

    private static final Double DEFAULT_VERSION = 1.0;
    private static final String DEFAULT_SERVER_ADDRESS = "https://appstore.com";
    public double screenSize;
    public Integer storage;

    public Phone(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    public void turnOn() {
        System.out.println("I'm pushing the button.");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Waiting...");
        System.out.println("Phone is turned on.");
        isOn = true;
    }
    public void installAnApp(String appName) {
        this.installAnApp(appName, DEFAULT_VERSION);
    }
    public void installAnApp(String appName, Double version) {
        this.installAnApp(appName, version, DEFAULT_SERVER_ADDRESS);
    }
    public void installAnApp(String appName, Double version, String serverAddress) {
        try {
            URL url = new URL("https", serverAddress, appName + "="+ version);
            this.installAnApp(url);
        } catch (MalformedURLException e) {
            System.out.println("Nie udalo sie pobrac aplikacji "+appName);
            throw new RuntimeException(e);
        }
    }
    public void installAnApp(List<String> appName) {
        for(String appNames: appName) {
            this.installAnApp(appNames);
        }
    }
    public void installAnApp(URL url) {
        System.out.println("Chcecking connection...");
        System.out.println("Downloading file from "+ url.getHost());
        System.out.println("Unpacking file: "+url.getFile());
    }
}
