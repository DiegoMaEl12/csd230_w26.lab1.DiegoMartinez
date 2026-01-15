package csd230.lab1.repositories;

import csd230.lab1.entities.DiscMagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscMagEntityRepository extends JpaRepository<DiscMagEntity, Long> {
    Optional<DiscMagEntity> findByTitle(String title);
    DiscMagEntity findByHasDiscTrue(boolean hasDisc);
    DiscMagEntity findByHasDiscFalse(boolean hasDisc);
}