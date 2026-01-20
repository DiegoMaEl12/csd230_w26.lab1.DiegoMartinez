package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity @DiscriminatorValue("LAPTOP")
public class LaptopEntity extends ElectronicEntity {

    private String storageSize;

    public LaptopEntity() {}

    public LaptopEntity(String serialNumber, int quantity, String storageSize, double price) {
        super(serialNumber, quantity, price);
        this.storageSize = storageSize;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }

    @Override
    public String toString() {
        return "LaptopEntity{" +
                "storageSize='" + storageSize + '\'' +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LaptopEntity that = (LaptopEntity) o;
        return Objects.equals(storageSize, that.storageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(storageSize);
    }
}