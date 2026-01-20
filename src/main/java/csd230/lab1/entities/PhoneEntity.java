package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity @DiscriminatorValue("PHONE")
public class PhoneEntity extends ElectronicEntity {

    private String carrier;

    public PhoneEntity() {}

    public PhoneEntity(String serialNumber, int quantity, String carrier, double price) {
        super(serialNumber, quantity, price);
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "PhoneEntity{" +
                "carrier='" + carrier + '\'' +
                '}' + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhoneEntity that = (PhoneEntity) o;
        return Objects.equals(carrier, that.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carrier);
    }
}