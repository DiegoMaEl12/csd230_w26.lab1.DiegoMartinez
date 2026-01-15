package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.ElectronicEntity}
 */
public abstract class Electronic extends Product {

    private String serialNumber;
    private double price;
    private int quantity;

    public Electronic() {
    }

    public Electronic(String serialNumber, double price, int quantity) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void edit() {
        System.out.println("Edit Serial Number [" + this.serialNumber + "]:");
        this.serialNumber = getInput(this.serialNumber);
        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(this.price);
        System.out.println("Edit Quantity [" + this.quantity + "]:");
        this.quantity = getInput(this.quantity);
    }

    @Override
    public void initialize() {
        System.out.println("Enter Serial Number:");
        this.serialNumber = getInput("Unknown Serial Number");
        System.out.println("Enter Price:");
        this.price = getInput(0.0);
        System.out.println("Enter Quantity:");
        this.quantity = getInput(0);
    }

    @Override
    public void sellItem() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Selling Electronic Item: " + serialNumber);
        } else {
            System.out.println("Item out of stock!");
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "serialNumber='" + serialNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serialNumber);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
