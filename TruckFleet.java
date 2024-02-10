import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TruckFleet {
    private List<Truck> trucks;
    private HashMap<String, List<Package>> packageStorage;

    public TruckFleet() {
        this.trucks = new ArrayList<>();
        this.packageStorage = new HashMap<>();
    }

    public void addTruck(Truck truck) {
        trucks.add(truck);
    }

    public void addPackage(Package pkg) {
        List<Package> packagesInArea = packageStorage.getOrDefault(pkg.getDestinationArea(), new ArrayList<>());
        packagesInArea.add(pkg);
        packageStorage.put(pkg.getDestinationArea(), packagesInArea);

        for (Truck truck : trucks) {
            if (truck.getAreaServed().equals(pkg.getDestinationArea()) && truck.getLocation().equals("Warehouse")) {
                if (truck.loadPackage(pkg)) {
                    return; // Package loaded
                }
            }
        }
    }

    public Package searchForPackage(String address) {
        for (List<Package> packages : packageStorage.values()) {
            for (Package pkg : packages) {
                if (pkg.getDestinationAddress().equals(address)) {
                    return pkg;
                }
            }
        }
        return null;
    }

    public Truck searchForTruck(String areaServed) {
        for (Truck truck : trucks) {
            if (truck.getAreaServed().equals(areaServed)) {
                return truck;
            }
        }
        return null; 
    }

    public void declarePackageAsDelivered(Package pkg) {
        pkg.setStatus("Delivered");
    }

    public void declareTruckAsReturned(Truck truck) {
        truck.setLocation("Warehouse");
        List<Package> areaPackages = packageStorage.get(truck.getAreaServed());
        if (areaPackages != null) {
            areaPackages.removeIf(truck::loadPackage);
        }
    }

    public String test() {
        return null;
    }

}
