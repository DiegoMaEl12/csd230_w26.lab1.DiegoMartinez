package csd230.lab1.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity @DiscriminatorValue("DISCMAG")
public class DiscMagEntity extends MagazineEntity {
    private boolean hasDisc;

    public DiscMagEntity() {}

    public DiscMagEntity(String t, double p, int c, int o, LocalDateTime d, boolean h) { super(t, p, c, o, d); this.hasDisc = h; }

    public boolean isHasDisc() {
        return hasDisc;
    }

    public void setHasDisc(boolean h) {
        this.hasDisc = h;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DiscMagEntity that = (DiscMagEntity) o;
        return hasDisc == that.hasDisc;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hasDisc);
    }

    @Override
    public String toString() {
        return "DiscMagEntity{" +
                "hasDisc=" + hasDisc +
                '}' + super.toString();
    }
}
