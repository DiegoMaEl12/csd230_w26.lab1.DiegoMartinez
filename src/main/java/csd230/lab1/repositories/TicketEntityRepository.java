package csd230.lab1.repositories;

import csd230.lab1.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long> {
    Optional<TicketEntity> findById(long id);
    TicketEntity findByDescription(String description);
    TicketEntity findByPriceGreaterThan(double price);
    TicketEntity findByPriceLessThan(double price);
}