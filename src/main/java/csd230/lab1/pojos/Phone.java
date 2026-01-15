package csd230.lab1.pojos;

import java.util.Objects;

/**
 * DTO for {@link csd230.lab1.entities.PhoneEntity}
 */
public class Phone extends Electronic {

    private String carrier;

    public Phone() {
        super();
    }

    public Phone(String serialNumber, double price, int quantity, String carrier) {
        super(serialNumber, price, quantity);
        this.carrier = carrier;
    }

    @Override
    public void initialize() {
        super.initialize();
        System.out.println("Enter Carrier:");
        this.carrier = getInput("Unknown Carrier");
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Carrier [" + this.carrier + "]:");
        this.carrier = getInput(this.carrier);
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Phone{carrier='" + carrier + "', " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(carrier, phone.carrier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carrier);
    }
}
