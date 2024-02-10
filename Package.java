public class Package {
    private double weight;
    private String destinationArea;
    private String destinationAddress;
    private String status;

    public Package(double weight, String destinationArea, String destinationAddress) {
        this.weight = weight;
        this.destinationArea = destinationArea;
        this.destinationAddress = destinationAddress;
        this.status = "At Warehouse"; 
    }

    public double getWeight() {
        return weight;
    }

    public String getDestinationArea() {
        return destinationArea;
    }

    public String getStatus() {
        return status;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDestinationArea(String destinationArea) {
        this.destinationArea = destinationArea;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
