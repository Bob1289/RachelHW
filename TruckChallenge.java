public class TruckChallenge {
    public static void main(String[] args) {
        TruckFleet warehouse = new TruckFleet();

        // Create trucks
        warehouse.addTruck(new Truck(15, 200, "Freehold", "Warehouse"));
        warehouse.addTruck(new Truck(7, 100, "Manalapan", "Warehouse"));
        warehouse.addTruck(new Truck(2, 75, "Colts Neck", "Warehouse"));
        warehouse.addTruck(new Truck(25, 300, "Howell", "Warehouse"));
        warehouse.addTruck(new Truck(21, 250, "Marlboro", "Warehouse"));

        // Create packages
        warehouse.addPackage(new Package(20, "Manalapan", "101 Road St"));
        warehouse.addPackage(new Package(100, "Manalapan", "300 Street Rd"));
        warehouse.addPackage(new Package(150, "Freehold", "32 Avenue Rd"));
        warehouse.addPackage(new Package(10, "Freehold", "1 Main St"));
        warehouse.addPackage(new Package(15, "Freehold", "15 Temple Rd"));
        warehouse.addPackage(new Package(16, "Freehold", "3 My Rd"));
        warehouse.addPackage(new Package(1, "Marlboro", "4 Goldstein Way"));
        warehouse.addPackage(new Package(15, "Marlboro", "15 Goldstein Way"));
        warehouse.addPackage(new Package(35, "Freehold", "53 CompSci Ct"));
        warehouse.addPackage(new Package(54, "Marlboro", "32 ColtsNeck Rd"));

        warehouse.test();

        // What is truck1’s next location?
        System.out.println("What is truck1’s next location? " + warehouse.searchForTruck("Freehold").getNextLocation());
        // What is truck2’s next location?
        System.out.println("What is truck2’s next location? " + warehouse.searchForTruck("Manalapan").getNextLocation());
        // What is truck3’s next location?
        System.out.println("What is truck3’s next location? " + warehouse.searchForTruck("Colts Neck").getNextLocation());
        // What is truck4’s next location?
        System.out.println("What is truck4’s next location? " + warehouse.searchForTruck("Howell").getNextLocation());
        // What is truck5’s next location?
        System.out.println("What is truck5’s next location? " + warehouse.searchForTruck("Marlboro").getNextLocation());

        System.out.println("-----------------");

        // Continuously until all trucks are empty:
        while (warehouse.searchForTruck("Freehold").getPackageCount() > 0) {
            warehouse.declarePackageAsDelivered(warehouse.searchForTruck("Freehold").unloadPackage());
            

            System.out.println("What is truck1’s next location? " + warehouse.searchForTruck("Freehold").getNextLocation());
        }
        while (warehouse.searchForTruck("Manalapan").getPackageCount() > 0) {
            warehouse.declarePackageAsDelivered(warehouse.searchForTruck("Manalapan").unloadPackage());
            
            System.out.println("What is truck2’s next location? " + warehouse.searchForTruck("Manalapan").getNextLocation());
        }
        while (warehouse.searchForTruck("Colts Neck").getPackageCount() > 0) {
            warehouse.declarePackageAsDelivered(warehouse.searchForTruck("Colts Neck").unloadPackage());

            System.out.println("What is truck3’s next location? " + warehouse.searchForTruck("Colts Neck").getNextLocation());
        }
        while (warehouse.searchForTruck("Howell").getPackageCount() > 0) {
            warehouse.declarePackageAsDelivered(warehouse.searchForTruck("Howell").unloadPackage());

            System.out.println("What is truck4’s next location? " + warehouse.searchForTruck("Howell").getNextLocation());
        }
        while (warehouse.searchForTruck("Marlboro").getPackageCount() > 0) {
            warehouse.declarePackageAsDelivered(warehouse.searchForTruck("Marlboro").unloadPackage());

            System.out.println("What is truck5’s next location? " + warehouse.searchForTruck("Marlboro").getNextLocation());
        }

        warehouse.test();

        // Return all trucks to the warehouse
        warehouse.declareTruckAsReturned(warehouse.searchForTruck("Freehold"));
        warehouse.declareTruckAsReturned(warehouse.searchForTruck("Manalapan"));
        warehouse.declareTruckAsReturned(warehouse.searchForTruck("Colts Neck"));
        warehouse.declareTruckAsReturned(warehouse.searchForTruck("Howell"));
        warehouse.declareTruckAsReturned(warehouse.searchForTruck("Marlboro"));

        warehouse.test();
    }
}
