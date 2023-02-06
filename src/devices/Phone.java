package devices;

import creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Phone extends Device{

    private static final Double DEFAULT_VERSION = 1.0;
    private static final String DEFAULT_SERVER_ADDRESS = "https://appstore.com";
    public double screenSize;
    public Integer storage;
    public List<Application> installedApps = new ArrayList<>();

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
    public void installPhoneApp(Human human, Application app) throws Exception {
        if(human.cash < app.price) {
            throw new Exception(human.firstName+" don't have enought money to buy this app.");
        }
        installedApps.add(app);
        human.addCash(-app.price);
        System.out.println("Installing "+app.name+" on your phone.");

    }
    public void showFreeApps() {
        System.out.print("Free apps: ");
        for (Application app:installedApps) {
            if(app.price == 0.0) {
                System.out.print(app.name+" ");
            }
        }
        System.out.println();
    }
    public Double valueOfAllApps() {
        Double valueOfAllApps = 0.0;
        for (Application app:installedApps) {
            valueOfAllApps += app.price;
        }
        return valueOfAllApps;
    }
    public void installedAppsAlphabet() {
        Collections.sort(installedApps, new Comparator<Application>() {
            public int compare(Application app1, Application app2) {
                return app1.name.compareTo(app2.name);
            }
        });
        System.out.print("List of all installed app sorted alphabeticly: ");
        for (Application app: installedApps) {
            System.out.print(app.name+" ");
        }
        System.out.println();
    }
    public void installedAppsPrice() {
        Collections.sort(installedApps, new Comparator<Application>() {
            public int compare(Application app1, Application app2) {
                return Double.compare(app1.price, app2.price);
            }
        });
        System.out.print("List of all installed app sorted by price: ");
        for (Application app: installedApps) {
            System.out.print(app.name+" ");
        }
        System.out.println();
    }

    public void isInstalled(Application app) {
        isInstalled(app.name);
    }
    public void isInstalled(String appName) {
        for (Application app:installedApps) {
            if(app.name.equals(appName)) {
                System.out.println("App "+app.name+" is installed.");
                return;
            }
        }
        System.out.println("App is not installed.");
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
