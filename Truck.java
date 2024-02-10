import java.util.Stack;

public class Truck {
    private int maxCapacity;
    private double maxWeight;
    private String areaServed;
    private String location;
    private Stack<Package> packages;
    private double currentWeight;

    public Truck(int maxCapacity, double maxWeight, String areaServed, String location) {
        this.maxCapacity = maxCapacity;
        this.maxWeight = maxWeight;
        this.areaServed = areaServed;
        this.location = location;
        this.packages = new Stack<>();
        this.currentWeight = 0;
    }

    public boolean loadPackage(Package pkg) {
        if (currentWeight + pkg.getWeight() <= maxWeight && packages.size() < maxCapacity) {
            packages.push(pkg);
            currentWeight += pkg.getWeight();
            pkg.setStatus("Loaded");
            return true;
        }
        return false;
    }

    public Package unloadPackage() {
        if (!packages.isEmpty()) {
            Package pkg = packages.pop();
            currentWeight -= pkg.getWeight();
            pkg.setStatus("Delivered");
            System.out.println("Package delivered to " + pkg.getDestinationAddress());
            return pkg;
        }
        return null;
    }

    public String getNextLocation() {
        if (!packages.isEmpty()) {
            return packages.peek().getDestinationAddress();
        }
        return "No packages in " + areaServed;
    }

    public int getPackageCount() {
        return packages.size();
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public String getAreaServed() {
        return areaServed;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
