package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.LaptopEntity}
 */
public class Laptop extends Electronic {

    private String storageSize;

    public Laptop() {
        super();
    }
    public Laptop(String serialNumber, double price, int quantity, String storageSize) {
        super(serialNumber, price, quantity);
        this.storageSize = storageSize;
    }
    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter Storage Size:");
        this.storageSize = getInput("Unknown Storage Size");
    }
    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Storage Size [" + this.storageSize + "]:");
        this.storageSize = getInput(this.storageSize);
    }
    public String getStorageSize() {
        return storageSize;
    }
    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }
    @Override
    public String toString() {
        return "Laptop{storageSize='" + storageSize + "', " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(storageSize, laptop.storageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storageSize);
    }
}
