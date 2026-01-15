package csd230.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity @DiscriminatorValue("PHONE")
public class PhoneEntity extends ElectronicEntity {

    private String carrier;

    public PhoneEntity() {}

    public PhoneEntity(String serialNumber, int quantity, String carrier) {
        super(serialNumber, quantity);
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }


}