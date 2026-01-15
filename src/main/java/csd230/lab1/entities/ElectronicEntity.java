package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ELECTRONIC")
public abstract class ElectronicEntity extends ProductEntity {

    private String serialNumber;
    private int quantity;

    public ElectronicEntity() {}

    public ElectronicEntity(String serialNumber, int quantity) {
        this.serialNumber = serialNumber;
        this.quantity = quantity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public void sellItem() {
        if(quantity > 0) {
            quantity--;
            System.out.println("Selling Electronic Item: " + serialNumber);
        } else {
            System.out.println("Item out of stock!");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}